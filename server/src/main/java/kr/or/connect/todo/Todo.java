package kr.or.connect.todo;

import java.util.Date;

public class Todo {
	private int id;
	private String todo;
	private int completed;
	private Date date;

	public Todo() {
	}

	public Todo(int id, String todo, int completed, Date date) {
		this(todo, completed, date);
		this.id = id;
		this.date = date;
	}

	public Todo(String todo, int completed, Date date) {
		this.todo = todo;
		this.completed = completed;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", todo=" + todo + ", completed=" + completed + ", date=" + date + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
