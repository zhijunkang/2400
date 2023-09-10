package org.come.action.monitor;

public class TBean<T> {

	private T t;

	public TBean(T t) {
		super();
		this.t = t;
	}

	public T getT() {
		return this.t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}
