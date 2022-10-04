import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Course{
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;
    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getReviewScore() {
        return reviewScore;
    }
    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }
    public int getNoOfStudents() {
        return noOfStudents;
    }
    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
    public String toString(){
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}
public class CustomClass {

    public static void main(String[] args){
        List<Course> courses =List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );
        //allMatch, //noneMatch, //anyMatch
        Predicate<Course> isNoOfStudentsGreaterThan20K = x -> x.getNoOfStudents() > 20000;
        Predicate<Course> isNoOfStudentsGreaterThan25K = x -> x.getNoOfStudents() > 25000;
        Predicate<Course> isNoOfStudentsEqualTo14K = x -> x.getNoOfStudents() == 14000;
//        System.out.println(
//                courses.stream().allMatch(isNoOfStudentsGreaterThan20K)
//        );
//        System.out.println(
//                courses.stream().noneMatch(isNoOfStudentsGreaterThan25K)
//        );
//        System.out.println(
//                courses.stream().anyMatch(isNoOfStudentsEqualTo14K)
//        );
        Comparator<Course> comparingByNoOfStudents = Comparator.comparingInt(Course::getNoOfStudents);
        Comparator<Course> comparingByNoOfStudentsInReverse = Comparator.comparingInt(Course::getNoOfStudents).reversed();
//        System.out.println(courses.stream().sorted(comparingByNoOfStudentsInReverse)
//                .collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();
//        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList()));

        //limit function --> display top 5 results --> we use .limit(5)
//        Comparator<Course> comparingByNoOfStudentsAndThenNoOfReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);
//        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndThenNoOfReviews).limit(5).collect(Collectors.toList()));

        //skip function --> if we want to skip top 3 results --> we use .skip(5)
//        Comparator<Course> comparingByNoOfStudentsAndThenNoOfReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
//        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndThenNoOfReviews).skip(3).limit(5).collect(Collectors.toList()));
        //[FullStack:14000:91, Spring Boot:18000:95, Kubernetes:20000:91, Docker:20000:92, Spring:20000:98, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]

        System.out.println(courses);
        //take along and print as per while condition
//        System.out.println(courses.stream().takeWhile(x -> x.getReviewScore() >= 95).collect(Collectors.toList()));
        //drop as per while condition
//        System.out.println(courses.stream().dropWhile(x -> x.getReviewScore() >= 95).collect(Collectors.toList()));

        // max, min,
//        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList()));
        //max --> Sort by the criteria specified, and return the last element in the list.
//        System.out.println(courses.stream()
//                .max(comparingByNoOfStudentsAndNoOfReviews));
        //min --> Sort by the criteria specified, and return the first element in the list.
//        System.out.println(courses.stream()
//                .min(comparingByNoOfStudentsAndNoOfReviews));
//        System.out.println(courses.stream()
//                                    .filter(x -> x.getReviewScore() > 95)
//                                    .findAny()

        System.out.println(courses.stream()
                                    .filter(x -> x.getReviewScore() > 95)
                                    .mapToInt(x -> x.getNoOfStudents())
                                    .sum()
        );

        System.out.println(courses.stream()
                .filter(x -> x.getReviewScore() > 95)
                .mapToInt(x -> x.getNoOfStudents())
                .average()
        );

        System.out.println(courses.stream()
                .filter(x -> x.getReviewScore() > 95)
                .mapToInt(x -> x.getNoOfStudents())
                .count()
        );

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        //{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91],
        // FullStack=[FullStack:14000:91],
        // Microservices=[API:22000:97, Microservices:25000:96],
        // Framework=[Spring:20000:98, Spring Boot:18000:95]}

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        //{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));
    }
}
