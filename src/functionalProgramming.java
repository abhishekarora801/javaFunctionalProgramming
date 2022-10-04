import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class functionalProgramming {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        Map<String, Integer> ageMap = new HashMap<String, Integer>();
        ageMap.put("Abhi", 10);
        ageMap.put("Rohit", 18);
        ageMap.put("Shanu", 20);
        ageMap.put("Laksh", 13);
        ageMap.put("Paarth", 15);
        ageMap.put("Aarna", 11);

//        Map aLetterMap = findWithaLetterMap(ageMap);
//        System.out.println(aLetterMap);

//        Map ageGreaterThan15 = findAgeGreaterThan15(ageMap);
//        System.out.println(ageGreaterThan15);

//        List<Integer> doubleNumbers = doubleList(numbers);
//        System.out.println(doubleNumbers);

//        List<Integer> evenNumbers = evenNumbersList(numbers);
//        System.out.println(evenNumbers);

//        List<Integer> lengthOfCourseTitles = lengthOfCourseTitles(courses);
//        System.out.println(lengthOfCourseTitles);

//        int greatest = numbers.stream().reduce(Integer.MIN_VALUE, (x,y) -> x>y ? x:y);
//        System.out.println(greatest);

//        int lowest = numbers.stream().reduce(Integer.MAX_VALUE, (x,y) -> x<y ? x:y);
//        System.out.println(lowest);
//        sortCoursesInReverse(courses);
//        sortCoursesAccordingToLength(courses);
    }

    private static Map findAgeGreaterThan15(Map<String, Integer> ageMap) {
        return ageMap.entrySet().stream()
                .filter(x -> x.getValue() >= 15)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    private static Map findWithaLetterMap(Map<String, Integer> ageMap) {
        return ageMap.entrySet().stream()
                .filter(x -> x.getKey().startsWith("A"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    private static List<Integer> lengthOfCourseTitles(List<String> courses) {
        return courses.stream()
                .map(x -> x.length())
                .collect(Collectors.toList());
    }
    private static List<Integer> evenNumbersList(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x%2 == 0)
                .collect(Collectors.toList());
    }
    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> x*x)
                .collect(Collectors.toList());
    }
    private static void sortCoursesInReverse(List<String> courses){
        courses.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
    private static void sortCoursesAccordingToLength(List<String> courses){
        courses.stream()
                .sorted(Comparator.comparing(x -> x.length()))
                .forEach(System.out::println);
    }
}
