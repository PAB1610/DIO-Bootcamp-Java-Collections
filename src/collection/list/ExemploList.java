package collection.list;

import java.util.*;

/**Dada uma lista com 7 notas de um aluno{7, 8.5, 9.3, 5, 7, 0, 3.6} faça:
 * 1. Crie uma lista e adicione as sete notas.
 * 2. Exibir posição da nota 5 (posicão 3)
 * 3. Adicionar a nota 8 à posição 4 da lista
 * 4. Substituir nata 5 pela nota 7
 * 5. Verifica se o valor está na lista
 * */
public class ExemploList {
    public static <Interator> void main(String[] args) {

        //criando lista
        List<Double> notas = new ArrayList<>(); //generics e diamond operator

        //adicionando elementos
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);

        //imprimindo elementos na tela de 2 formas
        System.out.println("Notas: "+ notas + "exemplo 1");
        System.out.println("Notas: " + notas.toString() + "exemplo 2");

        //mostrar posição de acordo com o valor passado no argumento
        System.out.println("Posição: " + notas.indexOf(5d));

        //neste exemplo não há o valor na lista, portanto o retorno é -1.
        System.out.println("Posição: " + notas.indexOf(10.0));

        //adicionando passando posição
        notas.add(4, 8.0);

        System.out.println("Notas com adição: "+ notas);

        //alterar nota sem saber em qual indice a nota esta, apenas passa-se o seu valor
        notas.set(notas.indexOf(5d), 6.0);
        System.out.println("Notas apos alteração: "+ notas);

        //verifica se a lista contem o valor passado
        System.out.println("Nota 5.0 na lista? " + notas.contains(5d));

        //imprimir a lista usando foreach
        for (Double nota : notas) {
            System.out.print(nota + ", ");
        }

        //exibir valor da posição informada
        System.out.println("Terceira nota adicionada: "+ notas.get(2));

        //exibir menor valor da lista
        System.out.println("Menor nota: "+ Collections.min(notas));

        //exibir maior valor da lista
        System.out.println("Maior nota: "+ Collections.max(notas));

        //exibir soma dos valores com iterator
       Iterator<Double> interator = notas.iterator();
        Double somando = 0d;
        while(interator.hasNext()){//tem algum elemento depois de voce?
            Double auxiliar = interator.next();
            somando+= auxiliar;
        }
        System.out.println("Soma Iterator: "+somando);

//exibir soma dos valores com foreach
        Double soma = 0.0;
        for (Double nota : notas) {
            soma+= nota;
        }
        System.out.println("Soma FOREACH: "+soma);

        //ebibir a media das notas
        System.out.println("Media: " + (soma/notas.size()));

        //remover nova
        notas.remove(0d);
        System.out.println("Notas sem 0: " + notas);

        //remover notas menos que 7 e exibir lista - usando mesma estatégia iterator
        Iterator<Double> interator1 = notas.iterator();
        while(interator1.hasNext()){//enquanto houver outro elemento
            Double auxiliar = interator1.next(); //auxiliar recebe o proximo elemento
            if(auxiliar < 7)
                interator1.remove();
        }
        System.out.println("Notas maiores que 7: "+ notas);

        //apagar toda a lista
        notas.clear();

        //verifica se a lista está vazia ISEMPTY - retorna true se a lista esta vazia
        System.out.println("Vazia: " + notas);
        System.out.println("Vazia: " + notas.isEmpty());



    }
}
