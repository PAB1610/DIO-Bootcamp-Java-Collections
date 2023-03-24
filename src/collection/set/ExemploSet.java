package collection.set;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d));
        notas.add(3.6);

        //visualização é em ordem aleatória e elementos repitidos não são aceitos
        // O numero 7 só apareceu uma vez.
        System.out.println(notas.toString());

        //Set não implementa posições, portanto não é possível fazer qualquer tipo de
        // //busca ou manipulação de elementos utilizando posicionamentos.
        //não é possivel substituir valores

        //verificar se a nota 5.0 está no conjunto
        System.out.println("Nota 5.0 presente? "+ notas.contains(5d));

        //exibir menor e maior nota (é igual a feita em List
        System.out.println("Menor nota: "+ Collections.min(notas));
        System.out.println("Maior nota: "+ Collections.max(notas));

        //somar as notas
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;

        while (iterator.hasNext()){
            Double auxiliar = iterator.next();
            soma+= auxiliar;
        }
        System.out.println("Soma notas: " + soma);

        //média
        System.out.println("Soma notas: " + soma/ notas.size());

        //remover nota 0.0
        notas.remove(0.0);
        System.out.println("Remover nota 0: "+ notas);

        //remover notas menores que 7 da lista
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double auxiliar = iterator1.next();
            if(auxiliar < 7)
                iterator1.remove();
        }
        System.out.println("Notas >= 7: "+ notas);

        //para imprimir lista Set. É preciso utilizar LinkedSet ela também não aceita
        //valores repetidos
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d));
        notas2.add(3.6);
        System.out.println("Ordem Lista 2: " + notas2);

        //para organizar os elementos é preciso utilizar TREESET
        Set<Double> notas3 = new TreeSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d));
        notas2.add(3.6);
        System.out.println("Exibir na ordem natural: "+notas3);

        //apagar o conjunto
        notas.clear();
        System.out.println("Vazio? "+notas.isEmpty());



    }


   }

