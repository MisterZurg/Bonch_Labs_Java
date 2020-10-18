package Lab_5;

import java.util.ArrayList;
import java.util.List;

public class MyQueue implements Queue {
    /**
     * Инициализирует очередь
     *
     * @param maxSize максимальное количество элементов в очереди
     * @throws QueueException при повторной инициализации (и не выполняет её)
     */
    int maxSize;
    boolean token = false;
    List<Integer> IdontHaveIdeaHow2NameThat = new ArrayList<>();

    @Override
    public void init(int maxSize) throws QueueException {
        if (this.token) {
            throw new QueueException("Object has been already initialized.");
        } else {
            this.maxSize = maxSize;
            this.token = false;
        }
    }
    /**
     * @return пуста ли очередь
     */
    @Override
    public boolean isEmpty() {
        if (this.IdontHaveIdeaHow2NameThat.isEmpty()){
            return true;
        }else return false;
    }

    /**
     * @return заполнена ли очередь
     */
    @Override
    public boolean isFull() {
        if (!this.IdontHaveIdeaHow2NameThat.isEmpty()){
            return true;
        }else return false;
    }

    /**
     * @return возвращает текущий размер очереди
     */
    @Override
    public int size() {
        return this.IdontHaveIdeaHow2NameThat.size();
    }

    /**
     * @param item элемент
     * @return содержится ли элемент в очереди
     */
    @Override
    public boolean contains(int item) {
        if (this.IdontHaveIdeaHow2NameThat.contains(item))
            return true;
        else
            return false;
    }
    /**
     * Возвращает элемент с вершины очереди
     *
     * @return элемент с вершины очереди
     * @throws QueueException если очередь пуста
     */
    @Override
    public int peek() throws QueueException {
        if (this.IdontHaveIdeaHow2NameThat.size() == 0) {
            throw new QueueException("Queue is empty.");
        } else {
            int value = (Integer)this.IdontHaveIdeaHow2NameThat.get(0);
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
    public int poll() throws QueueException {
        if (this.IdontHaveIdeaHow2NameThat.size() == 0) {
            throw new QueueException("Queue is empty.");
        } else {
            int number = (Integer)this.IdontHaveIdeaHow2NameThat.get(this.IdontHaveIdeaHow2NameThat.size() - 1);
            this.IdontHaveIdeaHow2NameThat.remove(this.IdontHaveIdeaHow2NameThat.size() - 1);
            return number;
        }
    }

    /**
     * Добавляет элемент в конец очереди
     *
     * @param item элемент
     * @throws QueueException если очередь уже переполнена
     */
    @Override
    public void offer(int item) throws QueueException {
        if (this.IdontHaveIdeaHow2NameThat.size() >= this.maxSize) {
            throw new QueueException("Queue is fullHD4k.");
        } else {
            this.IdontHaveIdeaHow2NameThat.add(item);
        }
    }

    public void offer(int... items) throws QueueException, IllegalStateException {
        if (!this.token) {
            throw new IllegalStateException("Queue hasn't been initialized.");
        } else if (this.IdontHaveIdeaHow2NameThat.size() + items.length > this.maxSize) {
            throw new QueueException("Queue is fullHD4k.");
        } else {
            int[] var2 = items;
            int var3 = items.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                int item = var2[var4];
                this.IdontHaveIdeaHow2NameThat.add(item);
            }

        }
    }
}