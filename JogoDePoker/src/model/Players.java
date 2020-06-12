package model;
public class Players{
    public int stack; // numero de fichas que ele possui
    public String nome; // nome do jogado
    public boolean bigBlind; // marca se ele é big blid nessa mão
    public boolean smallBlind;// marca se ele é small blid nessa mão


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

    public Players() {
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isBigBlind() {
        return bigBlind;
    }

    public void setBigBlind(boolean bigBlind) {
        this.bigBlind = bigBlind;
    }

    public boolean isSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(boolean smallBlind) {
        this.smallBlind = smallBlind;
    }
    
}