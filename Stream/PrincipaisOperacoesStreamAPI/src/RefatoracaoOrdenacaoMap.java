import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RefatoracaoOrdenacaoMap {

    /*
     * Dadas as seguinte informações de id e contato, crie um decionário e
     * ordene este dicionário exibindo (Nome id - Nome contato);
     * 
     * id = 1 - Contato = nome: Simba, numero: 2222;
     * id = 4 - Contato = nome: Cami, numero: 5555;
     * id = 3 - Contato = nome: Jan, numero: 1111;
     */
    /**
     * @param args
     */
    public static void main(String[] args){

        //System.out.println("--\tOrdem aleatória\t--");
        //Map<Integer, Contato> agenda = new HashMap<>(){{
        //    put(1, new Contato("Simba", 5555));
        //    put(4, new Contato("Cami", 1111));
        //    put(3, new Contato("Jon", 2222));
        //}};
        //System.out.println(agenda);
        //    for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
        //        System.out.println(entry.getKey() + " - " + entry.getValue().getNome());


        System.out.println("--\tOrdem Aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato("Simba:", 5555));
            put(4, new Contato("Cami:", 1111));
            put(3, new Contato("Jon:", 2222));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry: agenda.entrySet()){
            System.out.println(entry.getKey() + " - " +
            entry.getValue().getNome() + " " + entry.getValue().getNumero());
        }


        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        for (Map.Entry<Integer, Contato> entry: agenda1.entrySet()){
            System.out.println(entry.getKey() + " - " +
            entry.getValue().getNome() + " " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem Id\t--");
        Map<Integer, Contato> agenda2 = new TreeMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        for (Map.Entry<Integer, Contato> entry: agenda2.entrySet()){
            System.out.println(entry.getKey() + " - " +
            entry.getValue().getNome() + " " + entry.getValue().getNumero());
        }




        System.out.println("--\tOrdem número telefone\t--");

        //ANONIMO

        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
                return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
            }
        });

        */
        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
            new Function<Map.Entry<Integer, Contato>, Integer>() {

                @Override
                public Integer apply(Map.Entry<Integer, Contato> c1) {
                    return c1.getValue().getNumero();
                }
        }));
        */

        //LAMBIDA

        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
            c1 -> c1.getValue().getNumero()));

        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set){
            System.out.println(entry.getKey() + " - " +
            entry.getValue().getNome() + " " + entry.getValue().getNumero());
        }


        
        System.out.println("--\tOrdem nome Contato\t--");
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new ComparatorOrdemContato());
        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set1){
            System.out.println(entry.getKey() + " - " +
            entry.getValue().getNome() + " " + entry.getValue().getNumero());
        }


    }
}

