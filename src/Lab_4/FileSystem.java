package Lab_4;

import java.util.List;

public interface FileSystem {
    /**
     * Создать файл с содержимым
     * @param fileName имя файла
     * @param text содержимое
     */
    void createFile(String fileName, String text);

    /**
     * Получить содержимое файла
     * @param fileName имя файла
     * @return содержимое файла или null, если файл не существует
     */
    String readFile(String fileName);

    /**
     * Удалить файл
     * @param fileName имя файла
     */
    void deleteFile(String fileName);

    /**
     * Переместить файл с одного имени в другое
     * @param oldFileName старое имя файла
     * @param newFileName новое имя файла
     */
    void moveFile(String oldFileName, String newFileName);

    /**
     * Найти список файлов, имеющих fileNamePart в названии
     * @param fileNamePart часть имени файла
     */
    List<String> searchFiles(String fileNamePart);

    /**
     * Изменить содержимое файла
     * @param fileName имя файла
     * @param newText новое содержимое файла
     */
    void changeFile(String fileName, String newText);

    /**
     * Добавить содержимое в конец файла
     * @param fileName имя файла
     * @param appendText добавляемое содержимое в конец файла
     */
    void appendFile(String fileName, String appendText);
}

