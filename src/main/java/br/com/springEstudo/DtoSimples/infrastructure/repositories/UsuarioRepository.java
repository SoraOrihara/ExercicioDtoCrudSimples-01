package br.com.springEstudo.DtoSimples.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springEstudo.DtoSimples.infrastructure.entities.UsuarioEntity;
import jakarta.transaction.Transactional;



@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

	
	UsuarioEntity findByEmail(String email);
	
	@Transactional	
	void deleteByEmail(String email);
	
	boolean existsByEmail(String email);
}
