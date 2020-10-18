package Lab_2;

public class Lab_2_2 {
    public static void main(String[] args) {
        for (int i = 0; i < 6; ++i) {// Цикл по строкам
            for (int j = 1; j <= (i * 3) && i < 4; j++)
                System.out.print(' ');
            for (int k = 0; k < 12 && i < 2; k++) // Вывод звёздочек
                System.out.print('*');
            for (int k = 0; k < 11 && i == 2; k++) // Вывод звёздочек
                System.out.print('*');
            for (int k = 0; k < 3 && i == 3; k++) // Вывод звёздочек
                System.out.print('*');
            for (int v = 0; v < 7 && i == 4; v++)
                System.out.print(' ');
            for (int v = 0; v < 2 && i == 5; v++)
                System.out.print(' ');
            for (int z = 0; z < (15 - i * 8) && i < 2; z++)
                System.out.print(' ');
            System.out.println();// Переход на следующую строку
        }
    }
}