package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**Dadas as informações, exiba a lista na orde nome - idade - cor.
 *
 * Informações
 * Gato1 nome:Jon - idade: 18 - cor: preto
 * Gato2: nome:Simba - idade: 6 - cor tigrado
 * Gato3: nome: Jon* - idade:12 - cor:amarelo
 */
public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
            add(new Gato("JON", 1, "amarelo"));
            add(new Gato("Jon", 14, "preto"));
        }};


        System.out.println(meusGatos);// essas impressões apresentam o endereco de memoria
        System.out.println(meusGatos.toString()); //é preciso sobrescrever o metodo TOSTRING

        //imprimir lista na ordem de inserção
        System.out.println("Lista na ordem de inserção: "+ meusGatos);
        //imprimir lista em ordem aleatoria

        //coloquei a lista em ordem aleatoria
        Collections.shuffle(meusGatos);
        System.out.println("Ordem aleatoria:" + meusGatos);

        //imprimir na ordem natural é preciso implementar a Interface Comparable e
        //sobrescrever o metodo CompareTo na classe Gato
        Collections.sort(meusGatos);
        System.out.println("-------");
        System.out.println("ordenada nome: "+ meusGatos);

        /**Para fazer a ordenação é preciso implementar uma classe
         * que implemente a Interface Comparator*/
        //ordenar utilizando interface Comparator
        //ordenar por idade de duas formas
        Collections.sort(meusGatos,new ComparatorIdade() );
        meusGatos.sort(new ComparatorIdade());
        System.out.println("Ordenada Idade: "+ meusGatos);

        //ordenar utilizando interface Comparator
        //ordenar por cor de duas formas
        Collections.sort(meusGatos, new ComparatorCor());
        meusGatos.sort(new ComparatorIdade());
        System.out.println("Ordem cor: "+ meusGatos);

        //ordenar utilizando interface Comparator
        //ordenar por nome, idade e cor
        Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        System.out.println("Ordem 3 atributos: "+ meusGatos);

    }
}//fim classe ExemploOrdenação

/**utiliza-se a Interface Comparable para ordenar naturalmente uma classe
*/
class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Nome: " + this.nome;
        str += ". Idade: " + this.idade;
        str += ". Cor: " + this.cor;
        return str;
    }

    /**Metodo retorna 0 se nomes forem iguais, 1 se for mair e -1 se for menor
     * O metodo compareToIgnoreCase faz a comparação entre Strings* */
    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}



class ComparatorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato gato1, Gato gato2) {
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }
}

class ComparatorCor implements  Comparator<Gato>{

    @Override
    public int compare(Gato gato1, Gato gato2) {
        return gato1.getCor().compareToIgnoreCase(gato2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato gato1, Gato gato2) {
        int nome = gato1.getNome().compareToIgnoreCase(gato2.getNome());
        int cor = gato1.getCor().compareToIgnoreCase(gato2.getCor());
        if(nome != 0){//se os nomes são diferentes
            return nome;
        }else if(cor != 0) {
            return cor;
        }else {
            return Integer.compare(gato1.getIdade(), gato2.getIdade());
        }
    }
}
