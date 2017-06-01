package kr.or.connect.todo.persistence;

public class TodoSqls {
	static final String DELETE_BY_ID =
			"DELETE FROM todo WHERE id = :id";
	static final String CLEAR_COMPLETED =
			"DELETE FROM todo WHERE completed = 1"
	static final String UPDATE_BY_ID =
			"UPDATE todo SET completed = :completed WHERE id= :id";
	static final String SELECT_ALL =
			"SELECT * FROM todo ORDER BY id desc"
	static final String SELECT_BY_COMLETED =
			"SELECT * FROM todo WHERE completed = :completed ORDER BY id desc"
	static final String COUNT_NOT_COMPLETED =
			"SELECT COUNT(*) FROM todo WHERE completed = 0"
}
