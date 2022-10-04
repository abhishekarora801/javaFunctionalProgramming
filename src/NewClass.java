import java.util.List;

public class NewClass {

    public static void main(String[] args){
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker"
        , "Kubernetes");
        System.out.println(courses.stream().peek(System.out::println).filter(x -> x.length() > 11).map(String::toUpperCase).peek(System.out::println).findFirst());
    }
}
