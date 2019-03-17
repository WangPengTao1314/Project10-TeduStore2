package cn.tedu.store.bean;

import java.io.Serializable;

public class ResponseResult <T>implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private String state;
	private String message;
	private T datap;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getDatap() {
		return datap;
	}
	public void setDatap(T datap) {
		this.datap = datap;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datap == null) ? 0 : datap.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseResult other = (ResponseResult) obj;
		if (datap == null) {
			if (other.datap != null)
				return false;
		} else if (!datap.equals(other.datap))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", datap=" + datap + "]";
	}
	
	
}
