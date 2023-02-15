/*
 * Dadas as seguintes informações sobre meus gatos, crie uma lista e 
 * ordene esta lista exibindo:
 * (nome - idade - cor);
 * 
 * Gato 1 = nome: Jon, idade: 18, cor: preto
 * Gato 2 = nome: Simba, idade: 6, cor: tigrado
 * Gatp 3 = nome: Jon, idade: 12, cor: amarelo
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        
        List<Gatos> meusGatos = new ArrayList<>(){{
            add(new Gatos("Jon", 18, "preto"));
            add(new Gatos("Simba", 6, "tigrado"));  //criando uma lista ordenando por 
            add(new Gatos("Jon", 12, "amarelo"));   //nome/idade/cor
        }};
        System.out.println("--\tOrdem de Inserção\t---");         //Ordenando por Inserção
        System.out.println(meusGatos);

        System.out.println("--\tOrdem de Aleatória\t---");        //Criando ordem aleatória
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem natural (nome)\t---");      //Criando ordem natural
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Idade\t---");         //Ordem por idade
//      Collections.sort(meusGatos, new ComparatorIdade());    //O sort ta transformando a lista
        meusGatos.sort(new ComparatorIdade());                 //e deixando meusGatos comparar por idade
        System.out.println(meusGatos);                          

        System.out.println("--\tOrdem cor\t---");
//      Collections.sort(meusGatos, new ComparatorCor());
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Nome/Cor/Idade\t---");
//      Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);
        
/* 
        System.out.println("--\Ordem de Inserção\t---");
        System.out.println("--\Ordem de aleatoria\t---");
        System.out.println("--\Ordem natural (nome)\t---");
        System.out.println("--\Ordem idade\t---");
        System.out.println("--\Ordem cor\t---");
        System.out.println("--\Ordem Nome/Cor/Idade\t---");
*/
    }
}

class Gatos implements Comparable<Gatos>{   //tomar nota Comparable  //implementando uma comparação
    private String nome;
    private Integer idade;
    private String cor;

    public Gatos(String nome, Integer idade, String cor) {
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
        return '{' +
                "nome='" + nome + '\'' +  //O método toString deve retornar uma representação concisa,
                ", idade=" + idade +      //mas informativa, que seja fácil de uma pessoa ler.
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gatos gatos) {
        return this.getNome().compareToIgnoreCase(gatos.getNome());    //Comparando uma String "nome"
    };
}

class ComparatorIdade implements Comparator<Gatos>{

    @Override
    public int compare(Gatos g1, Gatos g2) {                           //Comparando um int "Idade"
            return Integer.compare(g1.getIdade(), g2.getIdade());
    }  
}

class ComparatorCor implements Comparator<Gatos>{

    @Override
    public int compare(Gatos g1, Gatos g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());           ////Comparando uma String "cor"
    }
    
}

class ComparatorNomeCorIdade implements Comparator<Gatos>{

    @Override
    public int compare(Gatos g1, Gatos g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());    //Se os nome forem diferentes, 
        if (nome != 0) return nome;                                   // vão ser ordenados por nome 

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());       //Se os nomes forem iguais,
        if(cor != 0) return cor;                                      //vão ser ordenados por cor

        return Integer.compare(g1.getIdade(), g2.getIdade());         //Se os nomes e cores forem iguais 
    }                                                                 //vão ser ordenados por idade 
    
}