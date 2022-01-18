import java.util.*;

public class Main {

    public static List<Student> students;

    public Main() {
        Student patric = new Student("Patric", 19);
        Student lisa = new Student("Lisa", 22);
        Student filip = new Student("Filip", 18);
        Student jess = new Student("Jess", 25);

        students = new ArrayList<>();
        students.add(patric);
        students.add(lisa);
        students.add(filip);
        students.add(jess);
    }

    public static void main(String[] args) {

        //Sorting students by age using annonimus class
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });

        //Sorting students by age using lambda expression
        Collections.sort(students, (student1, student2) -> student1.getName().compareTo(student2.getName()));

        //Printing out students using Iterable interface & lambda expression
        System.out.println("All students");
        System.out.println("=============");
        students.forEach(student ->{
            System.out.println(student.getName()+" "+student.getAge());
        });

        //Printing out students under 20 using Iterable interface & lambda expression
        System.out.println("Students under 20:");
        System.out.println("==================");
        students.forEach(student ->{
            if(student.getAge()<20){
                System.out.println(student.getName());
            }
        });

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase()+s2.toUpperCase();
//            }
//        }, all_students.get(0).getName(), all_students.get(1).getName());
//        System.out.println(sillyString);

        UpperConcat uc = (s1, s2) -> {
            return s1.toUpperCase()+s2.toUpperCase();
        };
        String sillyString = doStringStuff(uc, students.get(2).getName(), students.get(3).getName());
        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSmth();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}


interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSmth(){
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is: "+getClass().getSimpleName());
            return s1.toUpperCase()+s2.toUpperCase();
        };

        System.out.println("The AnotherClass class's name is: "+getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
//        System.out.println("The AnotherClass class's name is: "+getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The annonymous class's name is: "+getClass().getSimpleName());
//                return s1.toUpperCase()+s2.toUpperCase();
//            }
//        }, "String1", "String2");
    }
}


