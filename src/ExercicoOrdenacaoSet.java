/* Dadas as seguintes informações sobre minhas series favoritas.
crie um conjunto e ordene este conjunto exibindo:
( Nome = genero = tempo de episodio);

Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
Série 2 = Nome: breakingbad, genero: ação, tempoEpisodio: 50
Série 3 = Nome: PeakyBlinders, genero: drama, tempoEpisodio: 25
 */

import java.util.*;

public class ExercicoOrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("--\t Ordem Aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "Fantasia", 60));
            add(new Serie("Breaking Bad", "Ação", 50));
            add(new Serie("PeakyBlinders", "Ação", 55));

        }};
        for (Serie serie: minhasSeries) System.out.println(serie.getNome()+" - "
                + serie.getGenero()+"- " + serie.getTempoEpisodio());
              {

        }
        System.out.println("--\t Ordem Inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("got", "Fantasia", 60));
            add(new Serie("Breaking Bad", "Ação", 50));
            add(new Serie("PeakyBlinders", "Ação", 55));
        }};
        for (Serie serie: minhasSeries1) System.out.println(serie.getNome()+" - "
                + serie.getGenero()+"- " + serie.getTempoEpisodio());
        {

        }


        System.out.println("--\t Ordem Natural (TempEpisodio)\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie: minhasSeries2) System.out.println(serie.getNome()+" - "
                + serie.getGenero()+"- " + serie.getTempoEpisodio());


        System.out.println("--\t Ordem Nome/Gênero/TempoEpisodio \t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);

        for (Serie serie: minhasSeries3) System.out.println(serie.getNome()+" - "
                + serie.getGenero()+"- " + serie.getTempoEpisodio());


//        System.out.println("--\t Ordem \t--");
//        System.out.println("--\t Ordem \t--");
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
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
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
    public int compareTo(Serie serie) {
        int TempoEpisodio = this.getTempoEpisodio().compareTo(serie.getTempoEpisodio());
        if (tempoEpisodio != 0) return TempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());


    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}
