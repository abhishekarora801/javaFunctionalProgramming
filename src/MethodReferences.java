import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public class MethodReferences {

    @SuppressWarnings("unused")
    public static void main(String[] args){

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF",
                "Azure", "Docker", "Kubernetes");

        courses.stream()
                .map(x -> x.toUpperCase())
                .forEach(MethodReferences::print);

        courses.stream()
                .map(String::toUpperCase)
                .forEach(MethodReferences::print);

        Supplier<String> supplier = String::new;
        System.out.println(supplier.get());
    }
    //static method
    private static void print(String x){
        System.out.println(x);
    }
}
