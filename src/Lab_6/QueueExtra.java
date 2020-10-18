package Lab_6;

public interface QueueExtra<T> extends Queue<T> {
	/**
	 * Добавляет все указанные элементы в конец очереди по очереди
	 * @param items элементы
	 * @throws QueueException если элементов больше, чем свободного места в очереди
	 *                         (элементы при этом не добавлять в очередь!)
	 * @throws IllegalStateException если очередь ещё не была инициализирована {@link Queue#init(int)}
	 *                          (элементы при этом не добавлять в очередь!)
	 */
	void offer(T[] items) throws QueueException, IllegalStateException;
}