package main;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        try {
            Jedis jedis=new Jedis("localhost");
            System.out.println("Connection Susccessful");
            //System.out.println("Server Info " + jedis.info());//pega informações do servidor

            //colocando apenas uma chave e um valor
            jedis.set("chave", "valor x");
            String v;
            v=jedis.get("chave");
            System.out.println("O valor da chave é: " + v);
            System.out.println("\n\n");

            //colocando uma lista
            jedis.lpush("lista1", "Jõao");
            jedis.lpush("lista1", "maria");
            jedis.lpush("lista1", "Leao");
            jedis.lpush("lista1", "laranja");
            List<String> lista1=jedis.lrange("lista1", 0, 4);

            for (int i=0;i<lista1.size();i++){
                System.out.println("Imprimindo lista: " + lista1.get(i));
            }




        }catch(Exception e) {
            System.out.println(e);
        }
        maoDePoker();
    }

    public static void maoDePoker(){ // essa função sera responsável por simular uma mão de poker
        ArrayList<Players> playersNaMesa = new ArrayList<>();
        encherMesa(playersNaMesa);
        int i, j, tamanhoDoPote, valorDoBB = 20, valorDoSB = 10; // numero de fichas do pote e tamanho do big blind e small blind no momento
        int valorAposta; // variavel que armazena o valor co 2bet
        while (playersNaMesa.size() > 1) {
            for (i = 0; i < playersNaMesa.size() - 1; i++) { // for executa ate rodar a mesa por completo (o primeiro cara ser big brind 2ª vez)
                valorAposta = 0; // o valor da aposta tem que ser zerado a cada mão
                tamanhoDoPote = valorDoBB + valorDoSB;
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
                ArrayList<Integer> listaDeApostadores = new ArrayList<>(); /* essa lista armazena o indice de todos os jodadores que
            entrão na mão (indices da players na mesa), para que depois seja atribuida de forma aleatória quem venceu
            a mão */
                for (j = playersNaMesa.size() - 1; j >= 0; j--) { /* vai analizar quis jogadores vão entrar na mão, o
                primeiro a falar (2bet), ditará o tamanho das apostas e os outros jogadore poderam apenas dar call*/
                    Random random = new Random();
                    int r = random.nextInt(100);
                    // é sorteado o valor da aposta, sendo que o r tem que ser de 25, para dar mais realidade ao VPIP
                    if (valorAposta == 0) { // verifica se não há apostas previas, pois caso hajá os jodaores não poderam
                        // dar 3bet
                        if (r < 25) {
                            if (playersNaMesa.get(j).stack > 0 && playersNaMesa.get(j).stack > valorDoBB) { // verifica que o jogador tem stack efetiva
                                // o valor minimo de aposta, deve ser de 1 Big Blind, e no maximo um all in
                                valorAposta = valorDoBB + random.nextInt(playersNaMesa.get(j).stack - valorDoBB + 1);
                                playersNaMesa.get(j).stack -= valorAposta; // desconta aposta do stack
                                tamanhoDoPote += valorAposta; // almenta o tamanhoDoPote
                                listaDeApostadores.add(j); // adiciona o indice do jogador na lista
                            }
                        }
                    } else if (r < 25) { // caso hajá apostas os outros players podem apenas dar call
                        if (playersNaMesa.get(j).stack > 0) { // verifica se o jogador tem stack efetiva
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
                            listaDeApostadores.add(j);
                        }
                    }
                }
                if (listaDeApostadores.size() > 0) { // verifica se ouve apostas na mão
                    int r = new Random().nextInt(listaDeApostadores.size()); // soretia um valor dentre o numero de jagadores da mão
                    playersNaMesa.get(listaDeApostadores.get(r)).stack += tamanhoDoPote;
                } else {  // caso não tenha ocorrido aposta o pote vai para o big blind
                    if (i < playersNaMesa.size() - 1) {
                        playersNaMesa.get(i + 1).stack += tamanhoDoPote;
                    } else {
                        playersNaMesa.get(0).stack += tamanhoDoPote;
                    }
                }
                System.out.println(listaDeApostadores + " " + tamanhoDoPote);
                // limpeza do small e big
                if (i < playersNaMesa.size() - 1) {
                    playersNaMesa.get(i).smallBlind = false;
                    playersNaMesa.get(i + 1).bigBlind = false;
                } else {
                    playersNaMesa.get(i).smallBlind = false;
                    playersNaMesa.get(0).bigBlind = false;
                }
                // remove os jogadores sem stack (jogadores eliminados)
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
            // teste: mostra o stack dos players, bem como se o pote continua com o mesmo numero de fichas
            System.out.println();
            int c = 0;
            for (Players paoDeQueijo : playersNaMesa) {
                System.out.print(paoDeQueijo.stack + "\t");
                c += paoDeQueijo.stack;
            }
            System.out.println(c);
        }
        System.out.println(playersNaMesa.get(0).nome);
    }

    private static void encherMesa(ArrayList<Players> playersNaMesa) {
        playersNaMesa.add(new Players("player1", 3000));
        playersNaMesa.add(new Players("player2", 3000));
        playersNaMesa.add(new Players("player3", 3000));
        playersNaMesa.add(new Players("player4", 3000));
        playersNaMesa.add(new Players("player5", 3000));
        playersNaMesa.add(new Players("player6", 3000));
        playersNaMesa.add(new Players("player7", 3000));
        playersNaMesa.add(new Players("player8", 3000));
        playersNaMesa.add(new Players("player9", 3000));
    }

    public static class Players{
        private String nome;  // nome do jogador
        private int stack; // numero de fichas que ele possui
        private boolean smallBlind; // marca se ele é small blid nessa mão
        private boolean bigBlind; // marca se ele é big blid nessa mão

        public Players(String nome, int stack) {
            this.nome = nome;
            this.stack = stack;
            this.smallBlind = false;
            this.bigBlind = false;
        }

        @Override
        public String toString() {
            return "Players{" +
                    "nome='" + nome + '\'' +
                    ", stack=" + stack +
                    '}';
        }
    }
}