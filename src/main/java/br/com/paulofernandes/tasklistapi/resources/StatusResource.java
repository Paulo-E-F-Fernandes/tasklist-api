package br.com.paulofernandes.tasklistapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulofernandes.tasklistapi.dtos.StatusDTO;
import br.com.paulofernandes.tasklistapi.enums.Status;
import br.com.paulofernandes.tasklistapi.utils.MessageUtils;

@RestController
@CrossOrigin("${origem-permitida}")
public class StatusResource {

	@Autowired
	private MessageUtils messageUtils;

	@GetMapping("/status")
	public List<StatusDTO> listar() {
		final List<StatusDTO> statusList = Status.generateCombo();

		for (final StatusDTO status : statusList) {
			status.setDescription(this.messageUtils.getMessage(status.getDescription()));
		}

		return statusList;
	}

}
