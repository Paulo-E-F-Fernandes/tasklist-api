package br.com.paulofernandes.tasklistapi.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Task implements Serializable {

	private static final long serialVersionUID = 4291182426321588231L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(nullable = false, length = 64)
	@Size(min = 4, max = 64)
	private String titulo;

	@NotEmpty
	@Column(nullable = false)
	private String status;

	@Size(max = 255)
	private String descricao;

	@JsonProperty(value = "dtCriacao")
	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao;

	@JsonProperty(value = "dtEdicao")
	@Column(name = "data_edicao")
	private LocalDateTime dataEdicao;

	@Column(name = "data_remocao")
	private LocalDateTime dataRemocao;

	@JsonProperty(value = "dtConclusao")
	@Column(name = "data_conclusao")
	private LocalDateTime dataConclusao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(LocalDateTime dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public LocalDateTime getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(LocalDateTime dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Task other = (Task) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
