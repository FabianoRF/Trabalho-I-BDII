package main;

import java.util.ArrayList;
import java.util.Random;

public class MesaDePoker {
    private int numeroDeInscritos;
    private ArrayList<Players> playersNoCampeonato = new ArrayList<>();
    private int valorDoBB, valorDoSB;
    private int tamanhoDoPote; // numero de fichas do pote e tamanho do big blind e small blind no momento
    // variavel que armazena o valor co 2bet
    private int valorAposta;
    ArrayList<Players> playersNaMesa = new ArrayList<>();

    public MesaDePoker() {
        numeroDeInscritos = 9;
        valorDoBB = 20;
        valorDoSB = 10;
    }

    public MesaDePoker(int numeroDeInscritos, int valorDoBB, int valorDoSB, ArrayList<Players> playersNaMesa) {
        this.numeroDeInscritos = numeroDeInscritos;
        this.valorDoBB = valorDoBB;
        this.valorDoSB = valorDoSB;
        this.playersNaMesa = playersNaMesa;
    }

    public MesaDePoker(int numeroDeInscritos, int valorDoBB, int valorDoSB) {
        this.numeroDeInscritos = numeroDeInscritos;
        this.valorDoBB = valorDoBB;
        this.valorDoSB = valorDoSB;
    }

    public ArrayList<Players> getPlayersNaMesa() {
        return playersNaMesa;
    }

    public void setPlayersNaMesa(ArrayList<Players> playersNaMesa) {
        this.playersNaMesa = playersNaMesa;
    }

    public void rodadeDeMesa(){ // essa função sera responsável por simular uma mão de poker
        //pegarTodosParticipantes();
        //encherMesa();
        gerarParticipates();
        while (playersNaMesa.size() > 1) {
            maoDePoker();
        }
        imprimirJogadores(playersNaMesa);
        playersNoCampeonato.add(playersNaMesa.get(0));
        playersNaMesa.clear();
        //imprimirJogadores(playersNoCampeonato);
    }

    public void maoDePoker(){
        int i, j;
        for (i = 0; i < playersNaMesa.size(); i++) { // for executa ate rodar a mesa por completo (o primeiro cara ser big brind 2ª vez)
            valorAposta = 0; // o valor da aposta tem que ser zerado a cada mão
            tamanhoDoPote = valorDoBB + valorDoSB;
            habilitaBlinds(i); // tira o stack dos blinds
            ArrayList<Integer> listaDeApostadores = new ArrayList<>(); /* essa lista armazena o indice de todos os jodadores que
            entrão na mão (indices da players na mesa), para que depois seja atribuida de forma aleatória quem venceu
            a mão */
            for (j = playersNaMesa.size() - 1; j >= 0; j--) { /* vai analizar quis jogadores vão entrar na mão, o
                primeiro a falar (2bet), ditará o tamanho das apostas e os outros jogadore poderam apenas dar call*/
                Random random = new Random();
                int limiteDaApos;
                int r = random.nextInt(100);
                limiteDaApos = definirLimitesDeApostas();
                // é sorteado o valor da aposta, sendo que o r tem que ser de 25, para dar mais realidade ao VPIP
                if (valorAposta == 0) { // verifica se não há apostas previas, pois caso hajá os jogaores não poderam dar 3bet
                    if (r < 25) {
                        fazerAposta(j, limiteDaApos, listaDeApostadores);
                    }
                } else if (r < 25) { // caso hajá apostas os outros players podem apenas dar call
                    if (playersNaMesa.get(j).stack > 0) { // verifica se o jogador tem stack efetiva
                        darCall(j);
                        listaDeApostadores.add(j);
                    }
                }
            }
            determinarVencedorDaMao(i, listaDeApostadores);
            //System.out.println(listaDeApostadores + " " + tamanhoDoPote);
            // limpeza do small e big
            limparBlinds(i);
            // remove os jogadores sem stack (jogadores eliminados)
            removerPlayerSemStack();
        }
        // teste: mostra o stack dos players, bem como se o pote continua com o mesmo numero de fichas
        imprimirJogadores(playersNaMesa);
    }

    private void imprimirJogadores(ArrayList<Players> players) {
        System.out.println();
        for (Players p : players) {
            System.out.printf("Nome: %s, Stack: %d\n", p.nome, p.stack);
        }
    }


    private void removerPlayerSemStack() {
        for (int k = 0; k < playersNaMesa.size(); k++) {
            int aux = 0;
            if (playersNaMesa.get(k).stack == 0) {
                playersNaMesa.remove(k);
            } else if (playersNaMesa.get(k).stack < 0) {
                aux = playersNaMesa.get(k).stack;
                playersNaMesa.remove(k);
            }
            playersNaMesa.get(0).stack += aux;
        }
    }

    private void limparBlinds(int i) {
        if (i < playersNaMesa.size() - 1) {
            playersNaMesa.get(i).smallBlind = false;
            playersNaMesa.get(i + 1).bigBlind = false;
        } else {
            playersNaMesa.get(i).smallBlind = false;
            playersNaMesa.get(0).bigBlind = false;
        }
    }

    private void determinarVencedorDaMao(int i, ArrayList<Integer> listaDeApostadores) {
        if (listaDeApostadores.size() > 0) { // verifica se ouve apostas na mão
            int r = new Random().nextInt(listaDeApostadores.size()); // sorteia um valor dentre o numero de jagadores da mão
            playersNaMesa.get(listaDeApostadores.get(r)).stack += tamanhoDoPote;
        } else {  // caso não tenha ocorrido aposta o pote vai para o big blind
            if (i < playersNaMesa.size() - 1) {
                playersNaMesa.get(i + 1).stack += tamanhoDoPote;
            } else {
                playersNaMesa.get(0).stack += tamanhoDoPote;
            }
        }
    }

    private void darCall(int j) {
        if (valorAposta <= playersNaMesa.get(j).stack) { // verifica se player tem stack para dar call
            // a condição verifica se o player esta em uma das blinds ou, porque quem esta nas blinds
            // tem o valor da aposta descontado do valor que já pagou nas blinds
            if (playersNaMesa.get(j).bigBlind) {
                playersNaMesa.get(j).stack -= valorAposta - valorDoBB;
                tamanhoDoPote += valorAposta - valorDoBB;
            } else if (playersNaMesa.get(j).smallBlind) {
                playersNaMesa.get(j).stack -= valorAposta - valorDoSB;
                tamanhoDoPote += valorAposta - valorDoSB;
            } else {
                playersNaMesa.get(j).stack -= valorAposta;
                tamanhoDoPote += valorAposta;
            }
        } else { // caso não tenha stack, o jogador deve ir all - in
            tamanhoDoPote += playersNaMesa.get(j).stack;
            playersNaMesa.get(j).stack = 0;
        }
    }

    private void fazerAposta(int j, int limiteDaApos, ArrayList<Integer> listaDeApostadores) {
        Random random = new Random();
        if (playersNaMesa.get(j).stack > 0 && playersNaMesa.get(j).stack > valorDoBB) { // verifica que o jogador tem stack efetiva
            // o valor minimo de aposta, deve ser de 1 Big Blind, e no maximo um all in
            valorAposta = valorDoBB + random.nextInt(limiteDaApos);
            playersNaMesa.get(j).stack -= valorAposta; // desconta aposta do stack
            tamanhoDoPote += valorAposta; // almenta o tamanhoDoPote
            listaDeApostadores.add(j); // adiciona o indice do jogador na lista
        }
    }

    private int definirLimitesDeApostas() {
        if (playersNoCampeonato.size() >= numeroDeInscritos / 9){
            return 50 * valorDoBB - valorDoBB;
        }else if (playersNaMesa.size() >= numeroDeInscritos /81){
            return  200 * valorDoBB - valorDoBB;
        } else {
            return 500 * valorDoBB - valorDoBB;
        }
    }

    private void habilitaBlinds(int i) {
        if (i < playersNaMesa.size() - 1) { // verifica se o small blind esta no final da mesa (caso isso ocorra o jogo pode estourar a lista)
            // tanto if quanto else retirão valor do stack dos blinds  abilitão os atributos de blind
            playersNaMesa.get(i).stack -= valorDoSB;
            playersNaMesa.get(i + 1).stack -= valorDoBB;
            playersNaMesa.get(i).smallBlind = true;
            playersNaMesa.get(i + 1).bigBlind = true;
        } else {
            playersNaMesa.get(i).stack -= valorDoSB;
            playersNaMesa.get(0).stack -= valorDoBB;
            playersNaMesa.get(i).smallBlind = true;
            playersNaMesa.get(0).bigBlind = true;
        }
    }

    private void pegarTodosParticipantes() {
        for(int i = 0; i < numeroDeInscritos; i++){
            playersNoCampeonato.add(new Players("player" + (i + 1), 30000));
        }
    }

    private void gerarParticipates() {
        for(int i = 0; i < numeroDeInscritos; i++){
            playersNaMesa.add(new Players("player" + (i + 1), 30000));
        }
    }

    private void encherMesa() {
        playersNaMesa.clear();
        int i, j, c = 0;
        for (i = 0; i < 9; i++){
            if (i < playersNoCampeonato.size()){
                playersNaMesa.add(playersNoCampeonato.get(i));
                c++;
            }
            else {
                break;
            }
        }
        for (j = 0; j < c; j++){
            playersNoCampeonato.remove(0);
        }
    }

}
