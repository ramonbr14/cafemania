package br.edu.ifam.tads.cafemania.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifam.tads.cafemania.model.Usuario;
import br.edu.ifam.tads.cafemania.repository.UsuariosRepository;

@Service
public class UsuariosService {
	List<Usuario> usuariocfm = new ArrayList<Usuario>();
	
	@Autowired
	UsuariosRepository usuariorepositorio;
	
	public Optional<Usuario> obterUsuario(long id) {
		return usuariorepositorio.findById(id);
	}
	
	public List<Usuario> obterUsuarios(){
		return usuariorepositorio.findAll();
	}
	
	public List<Usuario> obterUsuarios(String nomeUsuario){
		return usuariorepositorio.findByNome(nomeUsuario);
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		return usuariorepositorio.save(usuario);
	}
	
	public Usuario atualizarUsuario(long id, Usuario usuario) {
		usuario.setId(id);
		return usuariorepositorio.save(usuario);	
	}
	
	public void excluirUsuario(long id) {
		usuariorepositorio.deleteById(id);
	}
}
