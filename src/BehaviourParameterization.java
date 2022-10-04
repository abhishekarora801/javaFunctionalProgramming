import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class BehaviourParameterization {

    @SuppressWarnings("unused")
    public static void main(String[] args){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

//        filterAndPrint(numbers, x -> x % 2 == 0);
//        filterAndPrint(numbers, x -> x % 2 != 0);
//
//        List squaredNumbers = mapAndCreateNewList(numbers, x -> x * x);
//        List cubedNumbers = mapAndCreateNewList(numbers, x -> x * x * x);
//        List doubledNumbers = mapAndCreateNewList(numbers, x -> x + x);
//        System.out.println(squaredNumbers);
//        System.out.println(cubedNumbers);
//        System.out.println(doubledNumbers);

//        Supplier<Integer> randomIntegerSupplier = () -> {
//            Random random = new Random();
//            return random.nextInt(1000);
//        };
//        System.out.println(randomIntegerSupplier.get());

//        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
//        System.out.println(unaryOperator.apply(10));

//        Predicate<Integer> predicate = x -> x%2 == 0;
//        System.out.println(predicate.test(6));

//        BiPredicate<Integer, Integer> biPredicate = (x,y) -> x>y;
//        System.out.println(biPredicate.test(100, 20));

        BiPredicate<String, String> biPredicate1 = (x,y) -> x == y;
        System.out.println(biPredicate1.test("Abhi", "Abhi"));

        BiFunction<Integer, Integer, Integer> biFunction = (x,y) -> {
            return (x+y) * (x+y);
        };
        System.out.println(biFunction.apply(10, 2));

        BiConsumer<Integer, Integer> biConsumer = (x,y) -> System.out.println(x+ " " +y);
        biConsumer.accept(2,3);

        IntBinaryOperator intBinaryOperator = (x, y) -> x+y;
        System.out.println(intBinaryOperator.applyAsInt(5,5));

        IntUnaryOperator intUnaryOperator = x -> 2 * x;
        System.out.println(intUnaryOperator.applyAsInt(100));

        IntSupplier intSupplier = () -> {
          Random random = new Random();
          return random.nextInt(500);
        };
        System.out.println(intSupplier.getAsInt());

        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Abhi");

        BiConsumer<String, Integer> biConsumer2 = (x,y) -> {
            System.out.println("My first name is " + x);
            System.out.println("My age is " + y);
        };
        biConsumer2.accept("Abhishek", 26);

        Supplier<String> stringSupplier = () -> {
            return "Abhi";
        };
        System.out.println(stringSupplier.get());

        Consumer<String> newConsumer = x -> {
            System.out.println(x);
            System.out.println(x);
        };
        newConsumer.accept("Abhi");



    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
