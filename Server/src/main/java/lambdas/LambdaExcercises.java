package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExcercises {

    public static void main(String[] args) {
        List<String> toUpperCase = Arrays.asList("Lorem",
                "ipsum", "dolor", "sit amet",
                "consectetur",
                "adipiscing elit");

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<String> toFilter = Arrays.asList("Lorem",
                "ipsum", "dolor", "sit amet",
                "consectetur", "arg",
                "adipiscing elit", "arr");


    }

    private static List<String> upperCase(List<String> list) {

        return list.stream()
                .map(x -> x.toUpperCase()) // po cichu daje return
                .collect(Collectors.toList());


    }

    private static double average(List<Integer> list) {

        return list.stream()
                .mapToInt(x -> x)
                .average()
                .getAsDouble();

    }

    private static List<String> search(List<String> list) {

        return list.stream() //zaczynamy od stream
                .filter(x -> x.startsWith("a") && x.length() == 3) //dodajemy filtr bo chcemy..... filtrowac
                .collect(Collectors.toList()); // musimy jeszcze zebrac i  pokazac wiec collect
    }

    private static String getString(List<Integer> list) {

        return list.stream().map(x -> {
            if ((x % 2) == 0) {
                return "e" + x;
            } else {

                return "o" + x;
            }
        }).collect(Collectors.joining(","));

    }

}
