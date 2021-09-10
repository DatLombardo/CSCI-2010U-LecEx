import java.util.Scanner;

public class IntroJava {
    public static void gettingInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Name: ");
        String name = scanner.nextLine();

        System.out.println("Student GPA: ");
        float gpa = scanner.nextFloat();
        /*
        %f - float / doubles
        %s - Strings
        %d - ints / longs
         */
        System.out.printf("The students name is %s and their GPA is %.2f", name, gpa);
        scanner.close();
    }

    public static void basics(){
        int age = 24;
        double fakePI = 3.1454;
        float gpa = 4.3f;
        //This is my first comment in Java
        /*
        This is my first
        block comment.
         */
        String profName = "Michael Lombardo";

        System.out.println("Hello the professors name is " + profName + ", he is " + age + " years old.");
    }
    public static void main(String[] args){
        basics();
        gettingInput();
    }
}
