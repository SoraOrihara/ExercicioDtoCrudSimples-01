package br.com.springEstudo.DtoSimples.business;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.springEstudo.DtoSimples.business.dto.UsuarioRequestDTO;
import br.com.springEstudo.DtoSimples.business.dto.UsuarioResponseDTO;
import br.com.springEstudo.DtoSimples.business.mapstruct.UsuarioMapper;
import br.com.springEstudo.DtoSimples.infrastructure.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;
	
	public UsuarioService(UsuarioRepository usuarioRepository,UsuarioMapper usuarioMapper) {
		this.usuarioRepository=usuarioRepository;
		this.usuarioMapper=usuarioMapper;
	}
	
	
	public List<UsuarioResponseDTO> listarTodos(){
		return usuarioMapper.paraListaUsuarioResponseDTO(usuarioRepository.findAll());
	}
	
	public UsuarioResponseDTO salvar(UsuarioRequestDTO request) {
		return usuarioMapper.paraUsuarioResponseDTO(usuarioRepository.save(usuarioMapper.paraUsuarioEntity(request)));
	}
	
	public void deletar(UUID id) {
		if(!usuarioRepository.existsById(id)) {
			throw new RuntimeException("Id não encontrado");
		}
		usuarioRepository.deleteById(id);
	}
	
	
}
