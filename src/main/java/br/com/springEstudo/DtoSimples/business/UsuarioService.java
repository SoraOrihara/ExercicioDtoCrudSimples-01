package br.com.springEstudo.DtoSimples.business;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.springEstudo.DtoSimples.business.dto.UsuarioRecord;
import br.com.springEstudo.DtoSimples.business.dto.UsuarioRequestDTO;
import br.com.springEstudo.DtoSimples.business.dto.UsuarioResponseDTO;
import br.com.springEstudo.DtoSimples.business.mapstruct.UsuarioMapper;
import br.com.springEstudo.DtoSimples.business.mapstruct.UsuarioUpdate;
import br.com.springEstudo.DtoSimples.infrastructure.entities.UsuarioEntity;
import br.com.springEstudo.DtoSimples.infrastructure.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;
	private final UsuarioUpdate usuarioUpdate;
	
	public UsuarioService(UsuarioRepository usuarioRepository,UsuarioMapper usuarioMapper, UsuarioUpdate usuarioUpdate) {
		this.usuarioRepository=usuarioRepository;
		this.usuarioMapper=usuarioMapper;
		this.usuarioUpdate=usuarioUpdate;
	}
	
	
	public List<UsuarioResponseDTO> listarTodos(){
		return usuarioMapper.paraListaUsuarioResponseDTO(usuarioRepository.findAll());
	}
	
	public UsuarioRecord buscarPorEmail(String email) {
		return usuarioMapper.paraUsuarioRecord(usuarioRepository.findByEmail(email));
	}
	
	public UsuarioResponseDTO salvar(UsuarioRequestDTO request) {
		return usuarioMapper.paraUsuarioResponseDTO(usuarioRepository.save(usuarioMapper.paraUsuarioEntity(request)));
	}
	
	public UsuarioResponseDTO update(UsuarioRequestDTO request , UUID id) {
		UsuarioEntity entity = usuarioRepository.findById(id).orElseThrow();
		usuarioUpdate.updateUsuario(request, entity);
		return usuarioMapper.paraUsuarioResponseDTO(usuarioRepository.save(entity));
	}
	
	
	public void deletarPorID(UUID id) {
		if(!usuarioRepository.existsById(id)) {
			throw new RuntimeException("Id não encontrado");
		}
		usuarioRepository.deleteById(id);
	}
	
	public void deletarPorEmail(String email) {
		if(!usuarioRepository.existsByEmail(email)) {
			throw new RuntimeException("Email não encontrado");
		}
		usuarioRepository.deleteByEmail(email);
	}
	
}
