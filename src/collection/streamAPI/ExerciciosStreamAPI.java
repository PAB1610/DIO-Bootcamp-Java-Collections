package collection.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {


        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Lista: ");

        //imprimir elementos utilizando stream() que possui 3 elementos:
        // Consumer: Interface Funcional --(new Consumer--
        //Operação primaria/ intermediária, tipo: --<String>--
        //Operação final: metodo que a interface cria: ---accept---
       /** numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s + " ");
            }
        });*/

        //utilizando uma expressao lambda
       /** numerosAleatorios.stream().forEach(s -> System.out.print(s + " "));*/

        //utilizando ---reference method---
        numerosAleatorios.stream().forEach(System.out::println);

        //Colocar os 5 primeiros numeros dentro de um SET
        //Imprimiu apenas 4 numero porque o Set nao aceita valores repitidos.
        System.out.println("--1--");
        numerosAleatorios.stream().limit(5)
                .collect(Collectors.toSet()).forEach(System.out::println);


        System.out.println("--numeros inteiros--");

        //transformar uma lista de Strings em lista de numeros inteiros
        //utilizando Funcional Interface
    /**   numerosAleatorios.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                });*/

        //transformar uma lista de Strings em lista de numeros inteiros
        //utilizando expressao lambda
     /** numerosAleatorios.stream().map(auxiliar -> Integer.parseInt(auxiliar))
               .collect(Collectors.toList()).forEach(System.out::println);*/

        //transformar uma lista de Strings em lista de numeros inteiros
        //utilizando reference method
       /** numerosAleatorios.stream().map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);*/


        //pegar os numeros pares maiores que 2 e colocar em uma lista
        //utilizando Interface Funccional
      /**  List<Integer> listaPares = numerosAleatorios.stream().map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if (i % 2 == 0 && i > 2)
                            return true;
                        else
                            return false;
                    }
                }).collect(Collectors.toList());*/


        //pegar os numeros pares maiores que 2 e colocar em uma lista
        //utilizando expressao lambda
        List<Integer> listaPares = numerosAleatorios.stream().map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2)).collect(Collectors.toList());

        System.out.println("Pares > 2: " + listaPares);

        //mostrar a média dos numeros
        //utilizando Interface Funccional
        numerosAleatorios.stream().mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String s) {
                return Integer.parseInt(s);
            }
        });

        //mostrar a média dos numeros
        //utilizando expressoes lambda
        numerosAleatorios.stream().mapToInt(s -> Integer.parseInt(s));

        //mostrar a média dos numeros
        System.out.print("media: ");
        numerosAleatorios.stream().mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);


        //remover numeros impares
        //1. converter lista de string e numeros inteiros
        //2. fazer a remoção
        List<Integer> listaInteiros = numerosAleatorios.stream().map(Integer::parseInt)
                .collect(Collectors.toList());

        //remocao com Funcional Interface
      /**  listaInteiros.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer % 2 != 0)
                    return true;
                else
                    return false;
            }
        });*/

        //removendo com expressoes lambda
        listaInteiros.removeIf(integer -> integer % 2 != 0);

        System.out.println("Numeros Pares: " + listaInteiros);

    }
}
