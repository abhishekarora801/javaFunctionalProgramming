import java.util.ArrayList;
import java.util.List;

public class List_Modification {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker"
                , "Kubernetes");
//        courses.replaceAll(x -> x.toUpperCase());
        List<String> modifyableCourses = new ArrayList<>(courses);
        modifyableCourses.replaceAll(x -> x.toUpperCase());
        modifyableCourses.removeIf(x -> x.length() <= 6);
        System.out.println(modifyableCourses);
    }
}
