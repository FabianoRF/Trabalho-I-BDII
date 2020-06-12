
package tela;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MesaDePoker;
import model.Players;


public class Campeonato implements Runnable{
        
    private ArrayList<Players> playersNaMesaAtual= new ArrayList<>();
    
    public MesaDePoker mesa;
    int id;

    public Campeonato(MesaDePoker mesa, int id) {
        this.mesa = mesa;
        this.id=id;
    }
    
    
   
    @Override
    public void run() {
       if(mesa.getPlayersNaMesa().isEmpty())
            mesa.gerarParticipates();
        
        while (mesa.getPlayersNaMesa().size() > 1) {
            mesa.rotacaoDeBlinds();
            mesa.imprimirJogadores(mesa.playersNaMesa, this.id);
            this.copiaPlayers(mesa.playersNaMesa);
           
            
            //aguardando um segundo
            this.aguardar(200);

        }
       
        
        
        System.out.println("Valor do players na mesaa   "+ mesa.getPlayersNaMesa());
       // mesa.imprimirJogadores(mesa.playersNaMesa, this.id);//imprime o player ganhador
        mesa.getPlayersNoCampeonato().add(mesa.playersNaMesa.get(0));
        mesa.getPlayersNaMesa().clear();
    }
       
       
    public MesaDePoker getMesa() {
        return mesa;
    }

    public void setMesa(MesaDePoker mesa) {
        this.mesa = mesa;
    }
   
            
    public void aguardar(int time){
        
        try {
            new Thread().sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Campeonato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void copiaPlayers(ArrayList playersNaMesa){
        this.playersNaMesaAtual = (ArrayList<Players>) playersNaMesa.clone();
    }

    public ArrayList<Players> getPlayersNaMesaAtual() {
        return playersNaMesaAtual;
    }

    public void setPlayersNaMesaAtual(ArrayList<Players> playersNaMesaAtual) {
        this.playersNaMesaAtual = playersNaMesaAtual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    
}
