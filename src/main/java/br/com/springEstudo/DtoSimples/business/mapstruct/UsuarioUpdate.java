package br.com.springEstudo.DtoSimples.business.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.springEstudo.DtoSimples.business.dto.UsuarioRequestDTO;
import br.com.springEstudo.DtoSimples.infrastructure.entities.UsuarioEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioUpdate {

	
	void updateUsuario(UsuarioRequestDTO dto, @MappingTarget UsuarioEntity entity);
	
}
