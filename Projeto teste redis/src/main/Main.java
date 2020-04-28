package main;

import redis.clients.jedis.Jedis;

public class Main {

    public static void main(String[] args) {

        try {
            Jedis jedis=new Jedis("localhost");
            System.out.println("Connection Susccessful");
            //System.out.println("Server Info " + jedis.info());//pega informações do servidor
            jedis.set("chave", "valor x");
            String v;
            v=jedis.get("chave");
            System.out.println("O valor da chave é: " + v);

        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
