package br.com.springEstudo.DtoSimples.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.springEstudo.DtoSimples.business.UsuarioService;
import br.com.springEstudo.DtoSimples.business.dto.UsuarioRecord;
import br.com.springEstudo.DtoSimples.business.dto.UsuarioRequestDTO;
import br.com.springEstudo.DtoSimples.business.dto.UsuarioResponseDTO;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService=usuarioService;
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<UsuarioResponseDTO>> listarTodos(){
		return ResponseEntity.ok().body(usuarioService.listarTodos());
	}
	
	@PostMapping("/create")
	public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioRequestDTO request){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(request));
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<UsuarioRecord> buscarPorEmail(@PathVariable String email){
		return ResponseEntity.ok(usuarioService.buscarPorEmail(email));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UsuarioResponseDTO> update(@RequestBody UsuarioRequestDTO request, @PathVariable UUID id){
		return ResponseEntity.ok(usuarioService.update(request, id));
	}
	
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<Void> deletarPorId(@RequestParam UUID id){
		usuarioService.deletarPorID(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/deleteByEmail")
	public ResponseEntity<Void> deletarPorEmail(@RequestParam String email){
		usuarioService.deletarPorEmail(email);
		return ResponseEntity.ok().build();
	}
}
