package br.edu.ifam.tads.cafemania.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifam.tads.cafemania.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{
	List<Usuario> findByNome(String nome);
}
