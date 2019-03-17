package cn.tedu.store.service.ex;
/**
 * 自定义:应用类异常
 * @author soft01
 */
public class ClassNameAlreadyException extends RuntimeException{
 
	private static final long serialVersionUID = 1L;

	public ClassNameAlreadyException() {
		super();
		 
	}
	public ClassNameAlreadyException(String message) {
		super(message);	 
	}
}
