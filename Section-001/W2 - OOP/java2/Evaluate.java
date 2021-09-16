package java2;

import java2.animals.Animal;
import java2.animals.Giraffe;
import java2.animals.Cricket;

//import java2.animals.*;

import java.util.Date;

public class Evaluate {
    public static void main(String[] args){
        Animal giraffe = new Giraffe(600.0f, "Leaves", "Giraffe", new Date());
        System.out.println(giraffe);
        giraffe.speak();

        Animal crick = new Cricket(0.007f, "Bugs", "Cricket", new Date());
        System.out.println(crick);
        crick.speak();
    }
}
