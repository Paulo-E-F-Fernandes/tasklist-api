package br.com.paulofernandes.tasklistapi.resources;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulofernandes.tasklistapi.enums.Status;
import br.com.paulofernandes.tasklistapi.models.Task;
import br.com.paulofernandes.tasklistapi.repositories.TaskRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class TaskResource {

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping("/task")
	public List<Task> listar() {
		return this.taskRepository.findByStatusNot(Status.INACTIVE.getDescription());
	}

	@PostMapping("/task")
	public void adicionar(@RequestBody @Valid Task task) {
		final LocalDateTime now = LocalDateTime.now();
		task.setDataCriacao(now);

		if (Status.DONE.getDescription().equals(task.getStatus())) {
			task.setDataConclusao(now);
		} else if (!Status.BACKLOG.getDescription().equals(task.getStatus())) {
			task.setDataEdicao(now);
		}

		this.taskRepository.save(task);
	}

	@PutMapping("/task")
	public Task atualizar(@RequestBody @Valid Task task) {
		final LocalDateTime now = LocalDateTime.now();
		task.setDataEdicao(now);

		if (Status.DONE.getDescription().equals(task.getStatus())) {
			task.setDataConclusao(now);
		} else {
			task.setDataConclusao(null);
		}

		return this.taskRepository.save(task);
	}


	@DeleteMapping("/task/{id}")
	public void inativar(@PathVariable("id") String id) {
		final LocalDateTime now = LocalDateTime.now();
		final Task task = this.taskRepository.getOne(Long.parseLong(id));
		task.setDataEdicao(now);
		task.setDataRemocao(now);
		task.setStatus(Status.INACTIVE.getDescription());

		this.taskRepository.save(task);
	}

}
