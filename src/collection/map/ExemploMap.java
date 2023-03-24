package collection.map;

import java.util.*;

/**Carros
 * molelo (chave) e consumo (valor)*/
public class ExemploMap {
    public static void main(String[] args) {
        //é preciso passar o tipo das chaves na criação do objeto
        Map<String, Double> carrosPopulares = new HashMap<>();
        carrosPopulares.put("gol", 14.4);
        carrosPopulares.put("uno", 15.6);
        carrosPopulares.put("mobi", 16.1);
        carrosPopulares.put("hb20", 14.5);
        carrosPopulares.put("kwid", 15.6);
        carrosPopulares.put("Ka", 11.5);

        System.out.println(carrosPopulares.toString());

        //modificar consumo do gol para 15.2: utiliza-se o mesmo metodo PUT() pois como não
        //há chave duplicada, ele sobrescreve.
        carrosPopulares.put("gol", 16.1);
        System.out.println(carrosPopulares.toString());

        //verificar se existe a chave informada
        System.out.println("Tucson esta? " + carrosPopulares.containsKey("tucson"));
        System.out.println("uno esta? " + carrosPopulares.containsKey("uno"));

        //exibir consumo uno. Precisa passa valor da chave para receber valor dado
        System.out.println("Consumo: "+ carrosPopulares.get("uno"));

        //Map não possui exibição de elementos de indice especifico

        //exibir todas as chaves
        System.out.println(carrosPopulares.keySet());

        //exibir todos os valores das chaves
        System.out.println(carrosPopulares.values());

        //valor da maior chave: utiliza-se Collections
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        System.out.println(consumoMaisEficiente);

        /**Carros com maior autonomia de consumo*/
        //Preciso trabalhar com a chave e o valor de formas separadas mas com alguma conexao
        // utiliza-se interface Entry e interface Set
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry: entries) {
            if(entry.getValue().equals(consumoMaisEficiente)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo + Eficiente: " + modeloMaisEficiente +
                        " - "+ consumoMaisEficiente);
            }
        }

        /**Carros com menor autonomia de consumo*/
        //utilizando Entry ainda
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        System.out.println(consumoMenosEficiente); //hb 20 com 14.5 é menos eficiente
        Set<Map.Entry<String, Double>> entries1 = carrosPopulares.entrySet();
        String modeloMenosEficiente = "";

        for (Map.Entry<String, Double> entry : entries1) {
            if(entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo - Eficiente: " + modeloMenosEficiente +" - "+ consumoMenosEficiente);
            }
        }

        //Somar valores das chaves - utilizando Set junto com iterator

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        System.out.println("\n--------");
        while (iterator.hasNext()){
            soma+= iterator.next();
            System.out.println(soma);
        }
        System.out.println("Soma chaves: " + soma);

        //media dos valores das chaves
        System.out.println("media das chaves: " + soma/carrosPopulares.size());

        //remover carros com consumo igual a 15.4
        System.out.println(carrosPopulares);// antes da exclusão
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        Double soma1 = 0d;
        System.out.println("\n--------");
        while (iterator1.hasNext()){
            if(iterator1.next() == 15.6)
                iterator1.remove();
        }
        System.out.println(carrosPopulares); //depois da exclusão


        //exibir na ordem em que foram inseridos - utiliza-se a implementação
        //LinkedHashMap
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>();
        carrosPopulares1.put("gol", 14.4);
        carrosPopulares1.put("uno", 15.6);
        carrosPopulares1.put("mobi", 16.1);
        carrosPopulares1.put("hb20", 14.5);
        carrosPopulares1.put("kwid", 15.6);
        carrosPopulares1.put("ka", 11.5);

        System.out.println(carrosPopulares1);

        //ordenar as chaves com TreeMap
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        //apagar todas as chaves e verifique se o conjunto esta vazio
        carrosPopulares.clear();
        System.out.println("Vazio? " + carrosPopulares.isEmpty());

















    }


}
