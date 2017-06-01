package kr.or.connect.todo.service;

import org.springframework.stereotype.Service;
import kr.or.connect.todo.Todo;
import kr.or.connect.todo.persistence.TodoDao;
import java.util.Collection;

@Service
public class TodoService {

  TodoDao todoDao;

  public TodoService(TodoDao todoDao) {
		this.todoDao = todoDao;
	}

  //SELECT_ALL
  public List<Todo> selectAll() {
		return todoDao.selectAll();
	}

  //SELECT_BY_COMLETED
  public List<Todo> selectByCompleted(int completed){
    return todoDao.selectByCompleted(completed);
  }

  //UPDATE_BY_ID
  public boolean update(Todo todo){
    return 1 == todoDao.update(todo);
  }

  //COUNT_NOT_COMPLETED
  public int countNotCompleted(){
    return todoDao.countNotCompleted();
  }

  //CLEAR_COMPLETED
  public int clearCompleted(){
    return todoDao.clearCompleted();
  }

  //DELETE_BY_ID
  public boolean deleteById(int id){
    return 1 == todoDao.deleteById(id);
  }

  //INSERT
  public Todo register(Todo todo){
    int id = todoDao.insert(todo);
    todo.setId(id);
    return todo;
  }

}
