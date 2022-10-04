import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class New_Custom {

    public static void main(String[] args){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

//        IntStream.rangeClosed(1, 10).forEach(System.out::println);
//        IntStream.iterate(1, x -> x + 2).limit(10).peek(System.out::println).sum();
//        System.out.println(IntStream.iterate(1, x -> x + 2).limit(10).sum());

        //print first 10 even numbers using the peek and then their sum.

        System.out.println(IntStream.iterate(2, x -> x * 2).limit(10).boxed().collect(Collectors.toList()));
//        System.out.println(IntStream.iterate(2, x -> x * 2).limit(10).sum());
    }
}
