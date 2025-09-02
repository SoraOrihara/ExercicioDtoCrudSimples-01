package br.com.springEstudo.DtoSimples.business.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.springEstudo.DtoSimples.business.dto.UsuarioRecord;
import br.com.springEstudo.DtoSimples.business.dto.UsuarioRequestDTO;
import br.com.springEstudo.DtoSimples.business.dto.UsuarioResponseDTO;
import br.com.springEstudo.DtoSimples.infrastructure.entities.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	@Mapping(target="id", ignore = true)
	UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO dto);
	
	UsuarioResponseDTO paraUsuarioResponseDTO(UsuarioEntity entity);
	
	UsuarioRecord paraUsuarioRecord(UsuarioEntity entity);
	
	List<UsuarioResponseDTO> paraListaUsuarioResponseDTO(List<UsuarioEntity> lista);
}
