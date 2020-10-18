package Lab_1;

public class Lab_1_2 {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        //Line
        double kL_1 = 1, bL_1 = 1,    //dith one  /
                kL_2 = -1, bL_2 = 9; //line dat one \
        //Circle
        double xC = 5, yC = 5, rC = 4;
        // Comparing inputed data With some fisting
        if (y < (kL_1 * x + bL_1)) { //Чекаем Under dith Line  /
            if (y < (kL_2 * x + bL_2)) { //Чекаем Under dith Line  \
                if ((Math.pow(x - xC, 2) + Math.pow(y - yC, 2) >= (Math.pow(rC, 2)))) {//Чекаем нижнюю Circle
                    System.out.println(1);
                } else
                    System.out.println(4);
                //System.out.println( (x>3 && y>3) ? 5 :2); //Квадрат или Круг
            } //Чекаем Above Line \
            else if ((Math.pow(x - xC, 2) + Math.pow(y - yC, 2) >= (Math.pow(rC, 2))))//Чекаем верхнюю часть Circle
                System.out.println(2);
            else
                System.out.println((x < 8 && 4 < y) ? 8 : 5); // В Квадрате или Круге
        } else if (y < (kL_2 * x + bL_2)) { //Чекаем Under dith Line  \
            if ((Math.pow(x - xC, 2) + Math.pow(y - yC, 2) >= (Math.pow(rC, 2))))//Чекаем левый Circle
                System.out.println((((0 < x && x < 2) && (y < 4) || (0 < x && x < 1)) && (4 < y && y < 9)) ? 3 : 6); //Область или Квадрат
            else System.out.println(7);
        }
        if ((Math.pow(x - xC, 2) + Math.pow(y - yC, 2) >= (Math.pow(rC, 2))))//Чекаем верхний Circle
            System.out.println((1 < x && x < 8) && (y < 10) ? 10 : 11); //квадрат или область
        else System.out.println(9); //Круг
    }
}
