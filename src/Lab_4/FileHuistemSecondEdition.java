package Lab_4;

import java.util.*;

public class FileHuistemSecondEdition implements FileSystemExtra {
    String gottenFileName; //Здесь будет имя файла из Main'a
    String gottenFileText; //Здесь будет текст файла из Main'a
    Map<String, String> myFileSystem = new HashMap<String, String>(); //Key gottenFileName     //Value gottenFileText
    Map<String, String> myFileSystemNames = new HashMap<String, String>(); //Key gottenFileName     //Value gottenFileText
    Map<String, Boolean> rights2Read = new HashMap<String, Boolean>();
    Map<String, Boolean> rights2Write = new HashMap<String, Boolean>();
    ArrayList<String> allFileNamesArrayList = new ArrayList<String>(); //для searchFiles

    /**
     * Создать файл с содержимым
     *
     * @param fileName имя файла
     * @param text     содержимое
     */
    @Override
    public void createFile(String fileName, String text) {
        this.gottenFileName = fileName;  //Присвоили локальной переменной класса FileHuistem
        this.gottenFileText = text;      //Присвоили локальной переменной класса FileHuistem
        this.myFileSystem.put(fileName, text);//Положили это HashMap
        this.myFileSystemNames.put(fileName,fileName);
        this.rights2Write.put(fileName, true);
        this.rights2Read.put(fileName, true);
    }

    /**
     * Получить содержимое файла
     *
     * @param fileName имя файла
     * @return содержимое файла или null, если файл не существует
     */
    @Override
    public String readFile(String fileName) {
        if (this.myFileSystem.containsKey(fileName)) {
            if (this.rights2Read.get(fileName)==true && this.myFileSystemNames.containsValue(fileName)) { //!!!!!!!!!
                if (this.myFileSystem.containsKey(fileName)) { //key.exists
                    return this.myFileSystem.get(fileName);
                } else
                    return null;
            } else
                return null;
        }
        return null;
    }

    /**
     * Удалить файл
     *
     * @param fileName имя файла
     */
    @Override
    public void deleteFile(String fileName) {
        if (myFileSystem.containsKey(fileName)) {
            if (this.rights2Write.get(fileName)) {
                myFileSystem.remove(fileName);
            }
        }
    }
    /**
     * Переместить файл с одного имени в другое
     *
     * @param oldFileName старое имя файла
     * @param newFileName новое имя файла
     */
    @Override
    public void moveFile(String oldFileName, String newFileName) {
        if (this.myFileSystem.containsKey(oldFileName)) {
            if ((this.rights2Read.get(oldFileName) && this.rights2Write.get(oldFileName))) {
                this.myFileSystem.put(newFileName, this.myFileSystem.get(oldFileName)); //Я пока спокоен
                this.myFileSystem.remove(oldFileName);
            }
        }
    }

    /**
     * Найти список файлов, имеющих fileNamePart в названии
     *
     * @param fileNamePart часть имени файла
     */
    @Override
    public List<String> searchFiles(String fileNamePart) {

        for (Map.Entry<String, String> entry : myFileSystem.entrySet()) {
            String gay = entry.getKey();
            if (gay.contains(fileNamePart)) {
                allFileNamesArrayList.add(gay);
            }
        }
        return allFileNamesArrayList;
    }

    /**
     * Изменить содержимое файла
     *
     * @param fileName имя файла
     * @param newText  новое содержимое файла
     */
    @Override
    public void changeFile(String fileName, String newText) {
        if (myFileSystem.containsKey(fileName)) {
            if (this.rights2Write.get(fileName)) {
                myFileSystem.put(fileName, newText);
            }
        }
    }
    /**
     * Добавить содержимое в конец файла
     *
     * @param fileName   имя файла
     * @param appendText добавляемое содержимое в конец файла
     */
    @Override
    public void appendFile(String fileName, String appendText) {
        if (myFileSystem.containsKey(fileName)) {
            if ((this.rights2Read.get(fileName) && this.rights2Write.get(fileName))) {
                String oldText = myFileSystem.get(fileName);
                String newText = myFileSystem.get(fileName) + appendText;
                myFileSystem.put(fileName, newText);
            }
        }
    }
    /**
     * Изменяет право записи файла<br>
     * Правилу подвергаются следующие функции:<br>
     * <ul>
     *     <li>{@link #moveFile(String, String)}</li>
     *     <li>{@link #appendFile(String, String)}</li>
     *     <li>{@link #changeFile(String, String)}</li>
     *     <li>{@link #deleteFile(String)}</li>
     * </ul>
     * Указанные функции не должны выполнять своё действие, если это не разрешено правами<br>
     * По умолчанию для всех файлов writable = true
     *
     * @param fileName имя файла
     * @param writable возможность записи файла
     */
    @Override
    public void setWritable(String fileName, boolean writable) {
        if (myFileSystem.containsKey(fileName))
            this.rights2Write.put(fileName,writable);
    }

    /**
     * Изменяет право чтения файла<br>
     * Правилу подвергаются следующие функции:<br>
     * <ul>
     *     <li>{@link #moveFile(String, String)}</li>
     *     <li>{@link #appendFile(String, String)}</li>
     *     <li>{@link #readFile(String)}</li>
     * </ul>
     * Указанные функции не должны выполнять своё действие, если это не разрешено правами<br>
     * По умолчанию для всех файлов readable = true
     *
     * @param fileName имя файла
     * @param readable возможность чтения файла
     */
    @Override
    public void setReadable(String fileName, boolean readable) {
        if (myFileSystem.containsKey(fileName))
            this.rights2Read.put(fileName,readable);
    }
}
