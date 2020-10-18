package Lab_6;

import java.util.ArrayList;
import java.util.List;

public class MyGenericQueue<T> implements QueueExtra {
    /**
     * Инициализирует очередь
     *
     * @param maxSize максимальное количество элементов в очереди
     * @throws QueueException при повторной инициализации (и не выполняет её)
     */
    int maxSize;
    boolean token = false;
    List<T> IdontKnowHow2NameThat = new ArrayList<>();

    @Override
    public void init(int maxSize) throws QueueException {
        if (token == true) {
            throw new QueueException("Объект уже был инициализирован.");
        } else {
            this.maxSize = maxSize;
            token = true;
        }
    }

    /**
     * @return пуста ли очередь
     */
    @Override
    public boolean isEmpty() {
        if (IdontKnowHow2NameThat.isEmpty())
            return true;
        else
            return false;
    }

    /**
     * @return заполнена ли очередь
     */
    @Override
    public boolean isFull() {
        if (!IdontKnowHow2NameThat.isEmpty())
            return true;
        else
            return false;
    }

    /**
     * @return возвращает текущий размер очереди
     */
    @Override
    public int size() {
        return IdontKnowHow2NameThat.size();
    }

    /**
     * @param item элемент
     * @return содержится ли элемент в очереди
     */
    public boolean contains(Object item) {
        if (IdontKnowHow2NameThat.contains(item)) {
            return true;
        } else
            return false;
    }

    /**
     * Возвращает элемент с вершины очереди
     *
     * @return элемент с вершины очереди
     * @throws QueueException если очередь пуста
     */
    @Override
    public T peek() throws QueueException {
        if (IdontKnowHow2NameThat.size() == 0) {
            throw new QueueException("Очередь пуста.");
        } else {
            T value = IdontKnowHow2NameThat.get(0);
            return value;
        }
    }

    /**
     * Удаляет элемент с вершины очереди и возвращает его
     *
     * @return элемент с вершины очереди
     * @throws QueueException если очередь пуста
     */
    @Override
    public T poll() throws QueueException {
        if (IdontKnowHow2NameThat.size() == 0) {
            throw new QueueException("Очередь пуста.");
        } else {
            T flask = IdontKnowHow2NameThat.get(IdontKnowHow2NameThat.size() - 1);
            IdontKnowHow2NameThat.remove(IdontKnowHow2NameThat.size() - 1);
            return flask;
        }
    }

    /**
     * Добавляет элемент в конец очереди
     *
     * @param item элемент
     * @throws QueueException если очередь уже переполнена
     */

    public void offer(Object item) throws QueueException {
        if (IdontKnowHow2NameThat.size() >= maxSize) {
            throw new QueueException("Очередь переполнена.");
        } else {
            IdontKnowHow2NameThat.add((T) item);
        }
    }

    /**
     * Добавляет все указанные элементы в конец очереди по очереди
     *
     * @param items элементы
     * @throws QueueException        если элементов больше, чем свободного места в очереди
     *                               (элементы при этом не добавлять в очередь!)
     * @throws IllegalStateException если очередь ещё не была инициализирована {@link Queue#init(int)}
     *                               (элементы при этом не добавлять в очередь!)
     */
    public void offer(Object[] items) throws QueueException, IllegalStateException {
        if (token == false) {
            throw new IllegalStateException("Очередь не была инициализирована.");
        } else if ((IdontKnowHow2NameThat.size() + items.length) > maxSize) {
            throw new QueueException("Очередь переполнена.");
        } else
            for (Object item : items) {
                IdontKnowHow2NameThat.add((T) item);
            }
    }
}
