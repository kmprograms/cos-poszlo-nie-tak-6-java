import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    /*
        Pobieraj od użytkownika n napisów.
        Zlicz, ile napisów posiada parzystą ilość znaków.
    */

    static String getExpression(String message) {
        System.out.println(message + ":");
        return new Scanner(System.in).nextLine();
    }

    static List<String> getExpressions(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number of items must be positive");
        }
        /*List<String> expressions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            expressions.add(getExpression("Podaj napis nr " + i));
        }
        return expressions;*/

        return IntStream
                .range(0, n)
                .mapToObj(idx -> getExpression("Podaj napis nr %d".formatted(idx)))
                .toList();
    }

    static long countEvenLengthExpressions(List<String> expressions) {
        /*int counter = 0;
        for (int i = 0; i < expressions.size(); i++) {
            String Expression = expressions.get(i);
            int Length = Expression.length();
            if (Length % 2 == 0) {
                counter = counter + 1;
            }
        }
        return counter;*/
        return expressions
                .stream()
                .filter(expression -> expression.length() % 2 == 0)
                .count();
    }

    public static void main(String[] args) {
        final var N = 3;
        var expressions = getExpressions(N);
        var counter = countEvenLengthExpressions(expressions);
        System.out.println(counter);
    }
}
