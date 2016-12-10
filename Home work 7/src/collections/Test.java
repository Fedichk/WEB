package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {
        CollectionUtils t = new CollectionUtils();

        List<String> test = new ArrayList<>();
        test.add("Arad");
        test.add("Cehd");
        test.add("Puld");
        test.add("Zard");
        test.add("Ben");

        Predicate<String> stringPredicate = (s)->s.length() < 10;

        List<Integer> testa = new ArrayList<>();
        testa.add(1);
        testa.add(2);
        testa.add(1);
        testa.add(3);
        testa.add(2);

        Integer i = 1;



        System.out.println(t.filter(test, stringPredicate));
        System.out.println(t.anyMatch(test, stringPredicate));
        System.out.println(t.noneMatch(test, stringPredicate));
        System.out.println(t.allMatch(test, stringPredicate));



    }


}
