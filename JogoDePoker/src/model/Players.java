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
}