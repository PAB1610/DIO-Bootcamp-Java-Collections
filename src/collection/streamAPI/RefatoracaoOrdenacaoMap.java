package collection.streamAPI;

import java.util.*;
import java.util.function.Function;

public class RefatoracaoOrdenacaoMap {
    public static void main(String[] args) {

        //organizar lista em ordem aleatória (HashMap)
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cani", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry: agenda.entrySet()) {
            System.out.println(entry.getKey() + " - "+ entry.getValue().getNome());
        }

        //organizar por ordem de inserção
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cani", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda1);
        for (Map.Entry<Integer, Contato> entry: agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - "+ entry.getValue().getNome());
        }

        //organizar pelo valor da chave (ID)
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);

        System.out.println(agenda2);
        for (Map.Entry<Integer, Contato> entry: agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - "+ entry.getValue().getNome());
        }

        //organizar por numero telefone forma como estávamos fazendo
        /**Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new ComparatorOrdemNumerica());
        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set) {
            System.out.println(entry.getKey() + " - "+ entry.getValue().getNumero() +
                    " - " + entry.getValue().getNome());
        }*/

        //refatorando para utilizar classe anonima
        //escolher a opção (Comparator<Map.Entry<Integer, Contato>>) mesmo argumento
        //o metodo compare é trazido para dentro do argumento na declaracao do objeto
       /** Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
                return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
            }
        });*/

       //refatorando utilizar classe anonima e o metodo comparing que necessita
        // implementar metodo apply
      /**  Set<Map.Entry<Integer, Contato>> set = new TreeSet<>
                (Comparator.comparing(new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));*/

        //refatorando utilizar expressão lambda (lado direito a variavel e
        // esquerdo codigo)
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                auxiliar -> auxiliar.getValue().getNumero())); //expressao lambda

        set.addAll(agenda.entrySet());
        System.out.println("\n--Ordem Telefone--");
        for (Map.Entry<Integer, Contato> entry: set) {
            System.out.println(entry.getKey() + " - "+ entry.getValue().getNumero() +
                    " - " + entry.getValue().getNome());
        }



    }
}

class Contato{
    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) && Objects.equals(numero, contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }


    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}

/*class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
    }
}*/

class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>>{
    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
    }


}



