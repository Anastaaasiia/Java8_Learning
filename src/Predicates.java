import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Predicates {

    private static void printStudentsByAge(List<Student> students,
                                           String ageText,
                                           Predicate<Student> ageCondition){
        System.out.println(ageText);
        System.out.println("===========");
        for(Student student : students){
            if(ageCondition.test(student))
                System.out.println(student.getName());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        printStudentsByAge(Main.students, "Students over 20", student -> student.getAge()>20);
        printStudentsByAge(Main.students, "Students under 20", student -> student.getAge()<=20);

        //More predicates exmaples
        IntPredicate intp = i -> i >15;
        System.out.println("\nMore predicates exmaples\n"+intp.test(10));
        int a=20;
        System.out.println(intp.test(a+5));

        //Combine predicates
        IntPredicate greaterThen35 = i ->i>35;
        IntPredicate lessThen57 = i ->i<57;
        System.out.println(greaterThen35.and(lessThen57).test(45));

        //Supplier example
        Random rand = new Random();
        Supplier<Integer> randomSupplier = ()->rand.nextInt(1000);
        System.out.println("\nSupplier example with random Integer: "+randomSupplier.get());

        String someString="some_string";
        Supplier<String> upperSomeString = ()->someString.toUpperCase();
        System.out.println("Supplier example with String: "+upperSomeString.get());
    }
}
