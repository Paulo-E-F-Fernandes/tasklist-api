package br.com.paulofernandes.tasklistapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulofernandes.tasklistapi.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByStatusNot(String string);

}
