package kr.or.connect.todo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import kr.or.connect.todo.Todo;
import kr.or.connect.todo.service.TodoService;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	private final TodoService service;

	@Autowired
	public TodoController(TodoService service) {
		this.service = service;
	}

	@GetMapping
	List<Todo> selectAll() {
		return service.selectAll();
	}

  @GetMapping("/active")
	List<Todo> viewNotCompleted() {
		return service.selectByCompleted(0);
	}

  @GetMapping("/completed")
	List<Todo> viewCompleted() {
		return service.selectByCompleted(1);
	}

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
	Todo register(@RequestBody Todo todo) {
		return service.register(todo);
	}

  @PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void update(@PathVariable Integer id, @RequestBody Todo todo) {
		todo.setId(id);
		service.update(todo);
	}

  @DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void clearCompleted() {
		service.clearCompleted();
	}

  @DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
