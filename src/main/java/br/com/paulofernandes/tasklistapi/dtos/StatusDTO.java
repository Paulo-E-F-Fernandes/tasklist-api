package br.com.paulofernandes.tasklistapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusDTO {

	@JsonProperty(value = "value")
	private final String code;
	@JsonProperty(value = "label")
	private String description;

	public StatusDTO(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
