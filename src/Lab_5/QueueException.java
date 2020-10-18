package Lab_5;

/**
 * Исключение, которое нужно выбрасывать в некоторых ситуациях
 * при реализации методов очереди
 */
public class QueueException extends Exception {
	public QueueException() {
		super();
	}
	
	public QueueException(String message) {
		super(message);
	}
	
	public QueueException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public QueueException(Throwable cause) {
		super(cause);
	}
	
	protected QueueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
