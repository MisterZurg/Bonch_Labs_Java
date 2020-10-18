package Lab_8;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String input, print;
        input = args[0];
        print = args[1];
        FileReader fileReader = null;
        FileWriter writer = null;
        try {
            // У FileReader есть конструктор, принимающий адрес
            // файла, который необходимо читать
            fileReader = new FileReader(input);
            writer = new FileWriter(print, false);
            Scanner scanner = new Scanner(fileReader);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                String sourceText = scanner.nextLine();
                int g;

                //Чередовать регистр символов текста посимвольно, начиная с символа с индексом 2 (считая с 0).
                // Первый из символов в нижнем регистре (пробелы считаются за символы)
                char[] chars2UpperCase = sourceText.toCharArray();
                for (int i = 0; i < sourceText.length(); i++) {
                    if (i % 2 == 0 && i > 2) {
                        chars2UpperCase[i] = Character.toLowerCase(chars2UpperCase[i]);
                    } else if (i % 2 == 1 && i > 2) {
                        chars2UpperCase[i] = Character.toUpperCase(chars2UpperCase[i]);
                    }
                }
                sourceText = new String(chars2UpperCase);
                //Клонировать слова, если в них содержится символ 'ь' в верхнем или нижнем регистре
                // (Пример: символ 'в'. "Во_дворе_стоит_дом" => "ВоВо_дворедворе_стоит_дом")
                String words[] = sourceText.split("_");
                for (int i = 0; i < words.length - 1; i++) {
                    if (words[i].contains("ь") || words[i].contains("Ь")) {
                        builder.append(words[i]);
                        builder.append(words[i]);
                        words[i] = builder.toString();
                    }
                    builder = new StringBuilder();
                }
                builder = new StringBuilder();
                //Клонировать слова, если в них содержится символ 'х' в верхнем или нижнем регистре
                // (Пример: символ 'в'. "Во_дворе_стоит_дом" => "ВоВо_дворедворе_стоит_дом")
                for (int i = 0; i < words.length - 1; i++) {
                    if (words[i].contains("х") || words[i].contains("Х")) {
                        builder.append(words[i]);
                        builder.append(words[i]);
                        words[i] = builder.toString();
                    }
                    builder = new StringBuilder();
                }
                builder = new StringBuilder();
                for (g = 0; g < words.length - 1; g++) {
                    builder.append(words[g]).append("_");
                }
                builder.append(words[g]);
                System.out.println(builder.toString());
                writer.write(builder.toString());
            }

            fileReader.close();
            // *Тут работаем с файлом*
        } catch (FileNotFoundException e) {
            // Указанный файл не найден или произошла ошибка доступа
            // (например, нет прав на чтение)
            e.printStackTrace();
        } catch (IOException e) {
            // Произошла общая ошибка ввода-вывода
            // (например, попытались прочесть больше, чем возможно)
            e.printStackTrace();
        } finally {
            // FileReader должен быть закрыт в любом случае
            if (fileReader != null) {
                try {
                    // Закрытие тоже может сгенерировать исключение
                    fileReader.close();
                } catch (IOException e) {
                }
                if (writer != null) {
                    try {
                        // Закрытие тоже может сгенерировать исключение
                        writer.close();
                    } catch (IOException e) {
                    }
                }

            }
        }
    }
}