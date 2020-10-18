package Lab_4;

public interface FileSystemExtra extends FileSystem {
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
     * @param fileName имя файла
     * @param writable возможность записи файла
     */
    void setWritable(String fileName, boolean writable);

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
     * @param fileName имя файла
     * @param readable возможность чтения файла
     */
    void setReadable(String fileName, boolean readable);
}
