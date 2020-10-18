package Lab_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHuistem implements FileSystemExtra {
    String gottenFileName; //Здесь будет имя файла из Main'a
    String gottenFileText; //Здесь будет текст файла из Main'a
    Map<String, String> myFileSystem = new HashMap<String, String>(); //Key gottenFileName

    class GavnoFile {
        boolean canRead = true;
        boolean canWrite = true;
        static final String READ = "read";
        static final String WRITE = "write";

        public GavnoFile(String param, boolean value) {
            if (param.equals(READ)) {
                canRead = value;
            } else if (param.equals(WRITE)) {
                canWrite = value;
            }
        }

        GavnoFile(boolean canRead, boolean canWrite) {
            this.canRead = canRead;
            this.canWrite = canWrite;
        }

        public boolean isCanRead() {
            return canRead;
        }

        public boolean isCanWrite() {
            return canWrite;
        }
    }

    Map<String, GavnoFile> rights2WriteOfFileSystem = new HashMap<String, GavnoFile>(); //Доступ на запись Disrespect Women
    Map<String, GavnoFile> rights2ReadOfFileSystem = new HashMap<String, GavnoFile>(); //Доступ на чтение  Disrespect Women                                                         //Value gottenFileText
    ArrayList<String> allFileNamesArrayList = new ArrayList<String>();

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
        if (this.myFileSystem.containsKey(fileName))
            //rights2WriteOfFileSystem.put(fileName,new GavnoFile(true,writable)); //Доступ fileName на запись (true/false)
            new GavnoFile(GavnoFile.WRITE, writable);
        //System.out.println(rights2WriteOfFileSystem);
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
        //rights2WriteOfFileSystem.put(fileName,new GavnoFile(readable,true));
        if (this.myFileSystem.containsKey(fileName))
            new GavnoFile(GavnoFile.READ, readable);
        //rights2ReadOfFileSystem.put(fileName,readable); //Доступ fileName на чтение (true/false)
        // System.out.println(Rights2ReadOfFileSystem);
    }

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
        myFileSystem.put(fileName, text);//Положили это HashMap
        //   rights2WriteOfFileSystem.put(fileName,true);    //По дефолту присваиваем тру запись при создании
        //   rights2ReadOfFileSystem.put(fileName,true);     //По дефолту присваиваем тру на чтение при создании

    }

    /**
     * Получить содержимое файла
     *
     * @param fileName имя файла
     * @return содержимое файла или null, если файл не существует
     */
    @Override
    public String readFile(String fileName) {
        // System.out.println(Rights2ReadOfFileSystem.get(fileName).booleanValue());
        if (this.myFileSystem.containsKey(fileName)) {
            if (this.rights2ReadOfFileSystem.get(fileName).isCanRead()) { //!!!!!!!!!
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
        if (this.myFileSystem.containsKey(fileName)) {
            if (this.rights2WriteOfFileSystem.get(fileName).isCanWrite())
                this.myFileSystem.remove(fileName);
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
            if ((this.rights2ReadOfFileSystem.get(oldFileName).isCanRead() && this.rights2WriteOfFileSystem.get(oldFileName).isCanWrite())) {
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
        if (this.myFileSystem.containsKey(fileName)) {
            if (this.rights2WriteOfFileSystem.get(fileName).isCanWrite())
                myFileSystem.put(fileName, newText);
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
        if (this.myFileSystem.containsKey(fileName)) {
            if ((this.rights2ReadOfFileSystem.get(fileName).isCanRead() && this.rights2WriteOfFileSystem.get(fileName).isCanWrite())) {
                String oldText = this.myFileSystem.get(fileName);
                String newText = this.myFileSystem.get(fileName) + appendText;
                this.myFileSystem.put(fileName, newText);
            }
        }
    }
}

