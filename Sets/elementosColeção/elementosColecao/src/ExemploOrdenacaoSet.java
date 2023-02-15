import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Dados as seguintes informações sebre minhas séries favoritas,
 * crie um conjunto e ordene este conjunto exibindo:
 * (nome - genero - tempo de episódio);
 * 
 * Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
 * Série 2 = Nome: dark, genero: drama, tempoEpisodio: 60
 * Série 3 = Nome: that '70s show', genero: comedia, tempoEpisodio: 25
 */

public class ExemploOrdenacaoSet {
    public static void main(String[] args){
    
//    System.out.println("--\Ordem de Inserção\t---");
//    System.out.println("--\Ordem de aleatoria\t---");
//    System.out.println("--\Ordem natural (nome)\t---");
//    System.out.println("--\Ordem idade\t---");
//    System.out.println("--\Ordem cor\t---");
//    System.out.println("--\Ordem Nome/Cor/Idade\t---");

    System.out.println("--\tOrdem de aleatoria\t---");
    Set<Serie> minhasSeries = new HashSet<>(){{
        add(new Serie("got", "fantasia", 60));
        add(new Serie("Dark", "Drama", 60));
        add(new Serie("That '70s show", "comédia", 25));
    }};
    for (Serie serie : minhasSeries) 
    System.out.println(serie.getNome() + " - "
     + serie.getGenero() + " - " + serie.getTempoEpisodio());



    System.out.println("--\tOrdem de Inserção\t---"); 
    Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
        add(new Serie("got", "fantasia", 60));
        add(new Serie("Dark", "Drama", 60));
        add(new Serie("That '70s show", "comédia", 25));
    }};
    for (Serie serie : minhasSeries1) 
    System.out.println(serie.getNome() + " - "
     + serie.getGenero() + " - " + serie.getTempoEpisodio());
    


     System.out.println("--\tOrdem natural (TempoEpisodio)\t---");
     Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
     for (Serie serie : minhasSeries2) 
     System.out.println(serie.getNome() + " - "
      + serie.getGenero() + " - " + serie.getTempoEpisodio());


      System.out.println("--\tOrdem Nome/Cor/Idade\t---");
      Set<Serie> minhasSeries3 = new TreeSet<>(new compareGeneroNomeTempoEpisodeo());
      minhasSeries3.addAll(minhasSeries3);
      for (Serie serie : minhasSeries3) System.out.println(serie.getNome() +
      " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
      System.out.println(minhasSeries3);
}
}





