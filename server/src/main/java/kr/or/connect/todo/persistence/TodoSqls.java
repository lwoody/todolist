package kr.or.connect.todo.persistence;

public class TodoSqls {
	static final String DELETE_BY_ID =
			"DELETE FROM todo WHERE id= :id";
	static final String UPDATE_BY_ID =
			"UPDATE todo SET completed = :completed WHERE id= :id";
}
