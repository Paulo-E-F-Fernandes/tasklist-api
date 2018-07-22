package br.com.paulofernandes.tasklistapi.enums;

import java.util.ArrayList;
import java.util.List;

import br.com.paulofernandes.tasklistapi.dtos.StatusDTO;

public enum Status {

	INACTIVE("inactive", null, false),
	BACKLOG("backlog", "status.description.backlog", true),
	PROGRESS("progress", "status.description.progress", true),
	TESTING("testing", "status.description.testing", true),
	DONE("done", "status.description.done", true);

	private final String description;
	private final String descriptionKey;
	private final boolean visible;

	private Status(String description, String descriptionKey, boolean visible) {
		this.description = description;
		this.descriptionKey = descriptionKey;
		this.visible = visible;
	}

	public String getDescription() {
		return this.description;
	}

	public String getDescriptionKey() {
		return this.descriptionKey;
	}

	public boolean getVisible() {
		return this.visible;
	}

	public static List<StatusDTO> generateCombo() {
		final List<StatusDTO> statusList = new ArrayList<>();

		for (final Status status : Status.values()) {
			if (status.visible) {
				statusList.add(new StatusDTO(status.description, status.descriptionKey));
			}
		}

		return statusList;
	}

}
