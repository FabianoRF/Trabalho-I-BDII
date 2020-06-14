package main;

import redis.clients.jedis.Jedis;
import java.util.List;


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
            List<String> lista1=jedis.lrange("lista1", 0, 3);

            System.out.println(lista1.get(3));

            for (int i=0;i<lista1.size();i++){
                System.out.println("Imprimindo lista: " + lista1.get(i));
            }

            //colocando uma lista
            jedis.lpush("lista1", "Jõa2o");
            jedis.lpush("lista1", "mari22a");
            jedis.lpush("lista1", "Lea23");

            lista1=jedis.lrange("lista1", 0, 2);

           // System.out.println(lista1.get(3));

            for (int i=0;i<lista1.size();i++){
                System.out.println("Imprimindo lista segunda: " + lista1.get(i));
            }




        }catch(Exception e) {
            System.out.println(e);
        }
        MesaDePoker mesaDePoker = new MesaDePoker();

     //  mesaDePoker.loopDeRotacaoDasBlinds();
        //maoDePoker();
    }


}