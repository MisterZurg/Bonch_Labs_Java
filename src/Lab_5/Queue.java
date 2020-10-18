package Lab_5;
public interface Queue {
	/**
	 * Инициализирует очередь
	 * @param maxSize максимальное количество элементов в очереди
	 * @throws QueueException при повторной инициализации (и не выполняет её)
	 */
	void init(int maxSize) throws QueueException;
	
	/**
	 * @return пуста ли очередь
	 */
	boolean isEmpty();
	
	/**
	 * @return заполнена ли очередь
	 */
	boolean isFull();
	
	/**
	 * @return возвращает текущий размер очереди
	 */
	int size();
	
	/**
	 * @param item элемент
	 * @return содержится ли элемент в очереди
	 */
	boolean contains(int item);
	
	/**
	 * Возвращает элемент с вершины очереди
	 * @return элемент с вершины очереди
	 * @throws QueueException если очередь пуста
	 */
	int peek() throws QueueException;
	
	/**
	 * Удаляет элемент с вершины очереди и возвращает его
	 * @return элемент с вершины очереди
	 * @throws QueueException если очередь пуста
	 */
	int poll() throws QueueException;
	
	/**
	 * Добавляет элемент в конец очереди
	 * @param item элемент
	 * @throws QueueException если очередь уже переполнена
	 */
	void offer(int item) throws QueueException;
}
