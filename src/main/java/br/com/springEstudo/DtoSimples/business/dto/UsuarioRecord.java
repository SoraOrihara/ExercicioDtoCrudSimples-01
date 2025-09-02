package br.com.springEstudo.DtoSimples.business.dto;

import java.util.UUID;

public record UsuarioRecord(UUID id,String nome, String email) {

}
