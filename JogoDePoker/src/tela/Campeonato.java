
package tela;


import model.MesaDePoker;


public class Campeonato implements Runnable{
    
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
        }
        
        System.out.println("Valor do players na mesaa   "+ mesa.getPlayersNaMesa());
       // mesa.imprimirJogadores(mesa.playersNaMesa, this.id);
        mesa.getPlayersNoCampeonato().add(mesa.playersNaMesa.get(0));
        mesa.getPlayersNaMesa().clear();
    }
       
       
    public MesaDePoker getMesa() {
        return mesa;
    }

    public void setMesa(MesaDePoker mesa) {
        this.mesa = mesa;
    }
   
            

   
    
}
