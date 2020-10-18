package Lab_3;

public class Main {
    public static void main(String[] args) {
        //String sourceText = args[0];
        String sourceText = "first_second_third_fourth_fifth_six_guy";
        System.out.println(sourceText);
        String words[] = sourceText.split("_");
        StringBuilder builder = new StringBuilder();
        int i;
        for (i = 0; i < words.length - 2; i++) {
            builder.append(words[i]).append("_");
        }
        builder.append(words[i]);

        //Заменить четвёртое слово на последовательность "#" той же длины
        //System.out.println(words[3]);
        char[] okto = words[3].toCharArray();
        for (int l = 0; l < okto.length; ++l) {
            if (okto[l] != '#') {
                okto[l] = '#';
            }
        }
        words[3] = new String(okto);
        //Going to update our String #1
        builder = new StringBuilder();
        for (i = 0; i < words.length - 2; i++) {
            builder.append(words[i]).append("_");
        }
        builder.append(words[i]);
        //String is updated
        //Привести первое слово к нижнему регистру (Дом -> дом)
        //Инвертировать первое слово
        builder = new StringBuilder(words[0].toLowerCase());
        builder.reverse();
        words[0] = builder.toString();
        //Going to update our String #2
        builder = new StringBuilder();
        for (i = 0; i < words.length - 2; i++) {
            builder.append(words[i]).append("_");
        }
        builder.append(words[i]);
        //String is updated
        //Удалить символ с индексом 8

        builder.deleteCharAt(8);
        String updatedText = builder.toString();
        //Going to update our Builder #1
        builder = new StringBuilder(updatedText);
        words = updatedText.split("_");

        //СДЕЛАНО Удалить последнее слово (вместе с подчёркиванием)
        //Привести нечётные слова к верхнему регистру (Дом -> ДОМ)
        for (i = 0; i < words.length; i++) {
            if (i % 2 != 0) {
                builder = new StringBuilder(words[i].toUpperCase());
                words[i] = builder.toString();
            }
        }
        //Going to update our String #3
        builder = new StringBuilder();
        for (i = 0; i < words.length - 1; i++) {
            builder.append(words[i]).append("_");
        }
        builder.append(words[i]);
        //String is updated
        //Повернуть третье слово циклически на 4 символов вправо (Пример поворота на 2 символа: стена => насте)
        if (words[2].length() > 4) {
            char[] changingWord = words[2].toCharArray();
            char cache[] = {
                    words[2].charAt(words[2].length() - 4),
                    words[2].charAt(words[2].length() - 3),
                    words[2].charAt(words[2].length() - 2),
                    words[2].charAt(words[2].length() - 1)
            };
            for (i = changingWord.length - 1; i > 3; i--) {
                changingWord[i] = changingWord[i - 4];
            }
            changingWord[0] = cache[0];
            changingWord[1] = cache[1];
            changingWord[2] = cache[2];
            changingWord[3] = cache[3];
            //преоьразование строки надо подредачить
            words[2] = new String(changingWord);
            builder = new StringBuilder();
        }
        //Going to update our String #4
        builder = new StringBuilder();
        for (i = 0; i < words.length - 1; i++) {
            builder.append(words[i]).append("_");
        }
        builder.append(words[i]);
        //String is updated
        System.out.println(builder.toString());
    }
}