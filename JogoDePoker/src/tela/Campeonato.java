package tela;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MesaDePoker;
import model.Players;
import redis.clients.jedis.Jedis;
import java.util.List;


public class Campeonato implements Runnable{
         
    private ArrayList<Players> playersNaMesaAtual= new ArrayList<>();
    public MesaDePoker mesa;
    public int id;//identificador de mesa
    
    private final Jedis jedis = new Jedis("localhost");
    
    private List<String> listaMesa1;
    private List<String> listaMesa2;
    private List<String> listaMesa3;
    private List<String> listaMesa4;
    private List<String> listaMesa5;
    
    
    
    public Campeonato(MesaDePoker mesa, int id) {
        this.mesa = mesa;
        this.id=id;
    }
    
    //metodo executado quando se chama a thread
    @Override
    public void run() {
           
       if(mesa.getPlayersNaMesa().isEmpty())
            mesa.gerarParticipates();
        
        while (mesa.getPlayersNaMesa().size() > 1) {
            mesa.rotacaoDeBlinds();
            mesa.imprimirJogadores(mesa.playersNaMesa, this.id);
            
            this.guardaNoBanco();
            this.buscaDoBanco();
           
            this.aguardar(200); //aguardando 0.2s para cada rodada
        }    
  
        
        mesa.getPlayersNoCampeonato().add(mesa.playersNaMesa.get(0));
        mesa.getPlayersNaMesa().clear();
    }
       
    
    public void guardaNoBanco(){//guarda os dados no banco de acordo a mesa
       int i;

        switch(id){//Jogando no banco
            case 1:{
                for (i = 0; i <mesa.playersNaMesa.size(); i++) {
                    jedis.lpush("lista1" ,mesa.playersNaMesa.get(i).nomeStack);
                }
                listaMesa1 = jedis.lrange("lista1", 0, mesa.playersNaMesa.size()-1);
                break;
            }

            case 2:{
                for (i = 0; i < mesa.playersNaMesa.size(); i++) {
                    jedis.lpush("lista2" , mesa.playersNaMesa.get(i).nomeStack);
                }
                listaMesa2=jedis.lrange("lista2", 0, mesa.playersNaMesa.size()-1);
                break;
            }

            case 3:{
                for (i = 0; i < mesa.playersNaMesa.size(); i++) {
                    jedis.lpush("lista3" , mesa.playersNaMesa.get(i).nomeStack);
                }
                listaMesa3=jedis.lrange("lista3", 0, mesa.playersNaMesa.size()-1);
                break;
            } 
            case 4:{
                for (i = 0; i < mesa.playersNaMesa.size(); i++) {
                    jedis.lpush("lista4" , mesa.playersNaMesa.get(i).nomeStack);
                }
                listaMesa4=jedis.lrange("lista4", 0, mesa.playersNaMesa.size()-1);
                break;
            }

            case 5:{   
                for (i = 0; i < mesa.playersNaMesa.size(); i++) {
                    jedis.lpush("lista5" , mesa.playersNaMesa.get(i).nomeStack);
                } 
                listaMesa5=jedis.lrange("lista5", 0, mesa.playersNaMesa.size()-1);
                break;
            }
        }
           
        
    }
        
    
    public void buscaDoBanco(){//completar aqui
        
        String array[];  
        int i;
        
        playersNaMesaAtual.clear();//limpa para ser add dnv
        switch(id){
            case 1:{
                for (i = 0; i < listaMesa1.size(); i++) {
                    array = listaMesa1.get(i).split(",");
                    playersNaMesaAtual.add(new Players(array[0], Integer.parseInt(array[1])));
                }
                break;
            }
            
            case 2:{
                for (i = 0; i < listaMesa2.size(); i++) {
                    array = listaMesa2.get(i).split(",");
                    playersNaMesaAtual.add(new Players(array[0], Integer.parseInt(array[1])));
                }
                break;
            }
            
            case 3:{
                for (i = 0; i < listaMesa3.size(); i++) {
                    array = listaMesa3.get(i).split(",");
                    playersNaMesaAtual.add(new Players(array[0], Integer.parseInt(array[1])));
                }
                break;
            }
            
            case 4:{
                for (i = 0; i < listaMesa4.size(); i++) {
                    array = listaMesa4.get(i).split(",");
                    playersNaMesaAtual.add(new Players(array[0], Integer.parseInt(array[1])));
                }
                break;
            }
            
            case 5:{
                for (i = 0; i < listaMesa5.size(); i++) {
                    array = listaMesa5.get(i).split(",");
                    playersNaMesaAtual.add(new Players(array[0], Integer.parseInt(array[1])));
   
                }
                break;
            }
        }

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

    private String toString(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
