package br.com.springEstudo.DtoSimples.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioResponseDTO {

	@JsonProperty(required = true)
	private String nome;
	@JsonProperty(required = true)
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsuarioResponseDTO() {
		super();
	}

	public UsuarioResponseDTO(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
}
