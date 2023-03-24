package collection.map;

import java.util.*;

/**Ordenar o dicionario de livros e seus autores*/
public class ExemploOrdenacaoMap {
    public static void main(String[] args) {


        //mostrar dicionario na ordem aleatoria - usa-se HashMap

        Map<String, Livros> meusLivros = new HashMap<>(){{
           put("Hawking, Stephen", new Livros("Uma Breve história do Tempo", 256));
           put("Duhigg, Charles", new Livros("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livros("21 Lições Para o século 21", 432));
        }};

        System.out.println(meusLivros);

        // (apenas nome autor e nome livro), para trabalhar com elementos separados
        //usa-se entrySet()
        System.out.println("---autor-livro---");
        for (Map.Entry<String, Livros> livro: meusLivros.entrySet() ) {
            System.out.println(livro.getKey() + " - " +livro.getValue().getNome());

        }

        //ordem de inserção LinkedHashMap

        Map<String, Livros> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livros("Uma Breve história do Tempo", 256));
            put("Duhigg, Charles", new Livros("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livros("21 Lições Para o século 21", 432));
        }};

        System.out.println("\n--ordem de inserção--\n" + meusLivros1);


        //ordem por ordem das chaves

        Map<String, Livros> meusLivros2 = new TreeMap<>(meusLivros1);
        System.out.println("\n--ordem de inserção--\n" + meusLivros2);
        for (Map.Entry<String, Livros> livro: meusLivros2.entrySet() ) {
            System.out.println(livro.getKey() + " - " +livro.getValue().getNome());
        }

        //ordenar pela ordem alfabetica dos livros - como está na chave, preciso
        //trabalhar com COMPARATOR
        System.out.println("\n ordem nome:");
        Set<Map.Entry<String, Livros>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livros> livro: meusLivros3) {
            System.out.println(livro.getKey() + " - " +livro.getValue().getNome());
        }

        //ordenar por número de página





    }
}

class Livros{
    private String nome;
    private Integer paginas;

    public Livros(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return "Livros{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}'+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livros livros = (Livros) o;
        return Objects.equals(nome, livros.nome) && Objects.equals(paginas, livros.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livros>>{

    //fazendo comparacao entre nome dos livros
    @Override
    public int compare(Map.Entry<String, Livros> livro1, Map.Entry<String, Livros> livro2) {
        return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
    }
}