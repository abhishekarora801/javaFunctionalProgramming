import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class New_Latest_Custom {

    public static void main(String[] args){

        Predicate<Course> reviewScoreGreaterThan95Predicate
                = createPredicateWithCutoffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate
                = createPredicateWithCutoffReviewScore(90);
    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }
}
