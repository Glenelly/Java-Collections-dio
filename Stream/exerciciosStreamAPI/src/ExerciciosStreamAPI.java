import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args){
        List<String> numerosAleatorios = Arrays.asList
            ("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        /*System.out.println("Imprima todos os elementos dessa lista de String: ");
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        */

        //Com lambida
        System.out.println("Imprima todos os elementos dessa lista de String: ");
            numerosAleatorios.forEach(System.out::println); 

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set: ");
            numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        /* 
        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
            numerosAleatorios.stream()
                .map(new Function<String, Integer>() {
                @Override
                public Integer apply(String s) {
                        
                return Integer.parseInt(s);
            } 
        });
        */

         //Com lambida
        
        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
            List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream() //Stream<String>
                .map(Integer::parseInt) //Stream<integer>
                .collect(Collectors.toList()); //List<Integer>
        

    /*
        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
            List<Integer> ListParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)   //vai pegar os valores do list e transformar em um tipo
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if (i % 2 == 0 && i > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
                System.out.println(ListParesMaioresQue2);
    */

         //Com lambida
        
        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
        List<Integer> ListParesMaioresQue2 = numerosAleatorios.stream()
            .map(Integer::parseInt)   //vai pegar os valores do list e transformar em um tipo
            .filter(i -> i % 2 == 0 && i > 2).collect(Collectors.toList());
            System.out.println(ListParesMaioresQue2);


/* 
        System.out.println("Mostre a média dos números: ");
            numerosAleatorios.stream()
                .mapToInt(new ToIntFunction<String>() {
                    @Override
                    public int applyAsInt(String s) {
                    return Integer.parseInt(s);
                    } 
        });
*/

        //Simplificado 
        System.out.println("Mostre a média dos números: ");
            numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);


        System.out.println("Remova os valores impares: ");
            numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
            System.out.println(numerosAleatoriosInteger);
    }
}
