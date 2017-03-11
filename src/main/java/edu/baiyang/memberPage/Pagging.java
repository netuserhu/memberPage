package edu.baiyang.memberPage;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Pagging<T> {
	private static final long serialVersionUID = 755183539178076901L;
	private Long total;
	private List<T> data;

	public Pagging() {
		
	}
	
	public Pagging(Long total, List<T> data) {
		this.data = data;
		this.total = total;
	}

	public List<T> getData() {
		return this.data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Boolean isEmpty() {
		return Boolean.valueOf(
				(Objects.equals(Long.valueOf(0L), this.total)) || (this.data == null) || (this.data.isEmpty()));
	}

	public static <T> Pagging<T> empty(Class<T> clazz) {
		List emptyList = Collections.emptyList();
		return new Pagging(Long.valueOf(0L), emptyList);
	}

	public static <T> Pagging<T> empty() {
		return new Pagging(Long.valueOf(0L), Collections.emptyList());
	}
}
