package Lab_2;

public class Lab_2_1 {
    public static void main(String[] args) {
        for (int i = 0; i < 6; ++i) {// Цикл по строкам
            for (int j = 1; j <= i * 3; j++)
                System.out.print(' ');
            for (int k = 0; k < 12; k++) // Вывод звёздочек
                System.out.print('*');
            for (int z = 1; z <= (5 - i) * 3; z++)
                System.out.print(' ');
            // Переход на следующую строку
            System.out.println();
        }
    }
}