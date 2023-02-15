import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploOrdenacaoMap {

    /*
     * Dadas as seguintes informações sobre meus livros favoritos e seus autores,
     * crie um dicionário e ordene este dicionário:
     * exibindo (Nome Autor - Nome Livro);
     * 
     * Autor = Hawking, Stephen - Livro = nome: Uma breve  História do Tempo. Páginas: 256
     * Autor = Duhigg, Charles - Livro = nome: O poder do Hábito. Páginas: 408
     * Autor = Harari, Yuval Noah - Livro = nome: 21 lições para o Século 21. Páginas: 432
     */

    public static void main(String[] args) {
        
        System.out.println("--\tOrdem de Inserção\t---");
        
        /* 
        System.out.println("--\Ordem de Inserção\t---");
        System.out.println("--\Ordem de aleatoria\t---");
        System.out.println("--\Ordem natural (nome)\t---");
        System.out.println("--\Ordem idade\t---");
        System.out.println("--\Ordem cor\t---");
        System.out.println("--\Ordem Nome/Cor/Idade\t---");
*/
        System.out.println("--\tOrdem de aleatoria\t---");
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve  História do Tempo" , 256));
            put("Duhigg, Charles", new Livro("O poder do Hábito" , 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o Século 21" , 432));
        }};
        for (Map.Entry<String ,Livro> livro : meusLivros.entrySet()) 
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    

            System.out.println("--\tOrdem de Inserção\t---");
        Map<String , Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve  História do Tempo" , 256));
            put("Duhigg, Charles", new Livro("O poder do Hábito" , 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o Século 21" , 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        
            System.out.println("--\tOrdem alfabética autores\t---");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()) 
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

            System.out.println("--\tOrdem alfabética dos livros\t---");
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String,Livro> livro : meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome()); 


        //Ordenar por numero de páginas 
    }   
}
