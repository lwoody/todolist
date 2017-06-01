package kr.or.connect.todo.persistence;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlPrameterRowSource;

@Repository
public class TodoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	public TodoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("todo")
				.usingGeneratedKeyColumns("id");
	}

	private RowMapper<Todo> rowMapper = BeanPropertyRowMapper.newInstance(Todo.class);

	//INSERT
	public Integer insert(Todo todo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todo);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	//DELETE_BY_ID
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(TodoSqls.DELETE_BY_ID, params);
	}

	//CLEAR_COMPLETED
	public int clearCompleted(){
		Map<String, ?> params = Collections.emptyMap();
		return jdbc.update(TodoSqls.CLEAR_COMPLETED, params);
	}

	//SELECT_ALL
	public List<Todo> selectAll() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.query(TodoSqls.SELECT_ALL, params, rowMapper);
	}

	//SELECT_BY_COMLETED
	public List<Todo> selectByCompleted(int completed){
		Map<String, Object> params = Collections.singletonMap("completed", completed);
		return jdbc.query(TodoSqls.SELECT_BY_COMPLETED)
	}

	//UPDATE_BY_ID
	public int update(Todo todo){
		SqlParameterSource params = new BeanPropertySqlParameterSource(todo);
		return jdbc.update(TodoSqls.UPDATE_BY_ID, params);
	}

	//COUNT_NOT_COMPLETED
	public int countNotCompleted(){
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.query(TodoSqls.COUNT_NOT_COMPLETED, params, Integer.class);
	}

}
