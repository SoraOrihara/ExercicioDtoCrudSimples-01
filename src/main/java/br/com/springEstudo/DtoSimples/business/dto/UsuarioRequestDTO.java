package br.com.springEstudo.DtoSimples.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioRequestDTO {

	@JsonProperty(required = true)
	private String nome;
	@JsonProperty(required = true)
	private String email;
	@JsonProperty(required = true)
	private String senha;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioRequestDTO() {
		super();
	}

	public UsuarioRequestDTO(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

}
