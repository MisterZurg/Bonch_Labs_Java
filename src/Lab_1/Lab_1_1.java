package Lab_1;

import java.util.Scanner;

public class Lab_1_1 {
    //На самом деле 2
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        //Line
        double xL_1 = 0, yL_1 = 11, xL_2 = 11, yL_2 = 0,//kL -> коэф. наклона.
                kL = (yL_1 - yL_2) / (xL_1 - xL_2), bL = yL_1 - kL * xL_1;
        //Circle
        double xC = 7, yC = 5, rC = 5;
        // Comparing inputed data With some fisting
        if (y < (kL * x + bL)) { //Чекаем Under Line
            if ((Math.pow(x - xC, 2) + Math.pow(y - yC, 2) >= (Math.pow(rC, 2)))) {//Чекаем нижнюю Circle
                System.out.println(1);
            } else
                System.out.println((x > 3 && y > 3) ? 5 : 2); //Квадрат или Круг
        } //Чекаем Above Line
        else if ((Math.pow(x - xC, 2) + Math.pow(y - yC, 2) >= (Math.pow(rC, 2)))) {//Чекаем верхнюю часть Circle
            System.out.println(3);
        } else
            System.out.println((((3 < x && x < 8) || (8 < x && x < 11)) && (3 < y && y < 8)) ? 6 : 4); //Квадрат или Круг
    }
}


