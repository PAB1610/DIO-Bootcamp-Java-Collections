package collection.set;

import java.util.*;

/**Ordenacao dos elementos a seguir
 * Serie 1: Nome: Got, genero: fantasia, tempoEpisodio:60
 * Serie 2 = Nome: Dark, genero: drama, tempoEpisodio: 60
 * Serie 3: Nome: That '70s show, genero: comedia, tempoEpisodio: 25*/

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("Got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};

        //imprimir em ordem aleatoria. É só mandar imprimir pois a interface SET
        //não guarda posicao dos itens adicionados
        System.out.println(minhasSeries);
        for (Serie s: minhasSeries) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - "+ s.getTempoEpisodio());
        }

        //imprimir de acordo com a ordem de inserção (utiliza-se LinkedHashSet)
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("Got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};

        System.out.println("---ORDEM DE INSERCAO---");
        for (Serie s: minhasSeries1) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - "+ s.getTempoEpisodio());
        }

        //imprimir de acordo com a ordem natural (POR TEMPO DE EPISODIO)
        //É preciso implementar a TreeSET.
        System.out.println("\n---ORDEM DE NATURAL-(TEMPO EPISODIO)---");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);

        //nesta impressao as series com mesmo tempo só aparecerá uma por causa da
        //nao inserção na lista de itens repitidos.
        for (Serie s: minhasSeries2) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - "+ s.getTempoEpisodio());
        }


        //Adição já é feita em ordem natural
        System.out.println("\n---ORDEM-NOME-GENERO-TEMPO---");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempo());
        //minhasSeries3.addAll(minhasSeries);
        minhasSeries3.add(new Serie("that '70s show", "comedia", 25));
        minhasSeries3.add(new Serie("Got", "fantasia", 60));
        minhasSeries3.add(new Serie("dark", "drama", 60));


        for (Serie s: minhasSeries3) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - "+ s.getTempoEpisodio());
        }

    }

}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "N='" + nome + '\'' +
                ",G='" + genero + '\'' +
                ", E=" + tempoEpisodio +
                '}';
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    /**Retorna 0 quando comparacao é igual e -1 quando é menor e 1 qdo maior*/
    public int compareTo(Serie serie) {
        int auxiliarTempo = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        int auxiliarGenero = this.getGenero().compareTo(serie.getGenero());
        // int auxiliarGenero = this.getGenero().compareTo(serie.getGenero());
        if(auxiliarTempo != 0) //se os tempos nao forem iguais
            return auxiliarTempo;
        else
            return auxiliarGenero;
    }
}

class ComparatorNomeGeneroTempo implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {

        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if(nome != 0)
            return nome;

        int auxiliarGenero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
        if(auxiliarGenero != 0)
            return auxiliarGenero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());

    }
}