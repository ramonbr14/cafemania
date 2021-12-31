package br.edu.ifam.tads.cafemania.recursos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifam.tads.cafemania.model.Usuario;
import br.edu.ifam.tads.cafemania.service.UsuariosService;

@RestController
@RequestMapping(value="cafemaniaUser")
public class UsuarioController {
	
	@Autowired
	UsuariosService usuariosService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios(){
		return ResponseEntity.ok(usuariosService.obterUsuarios());
	}
	@GetMapping("/procura")
	public ResponseEntity<List<Usuario>>getUsuarioByNome(String nome){
		return ResponseEntity.ok(usuariosService.obterUsuarios());
	}
	
	@GetMapping("/id")
	public ResponseEntity<Usuario> getUsuarios(@PathVariable("id") long id){
		Optional<Usuario> optionalUsuario = usuariosService.obterUsuario(id);
		if(optionalUsuario.isPresent())
			return ResponseEntity.ok(optionalUsuario.get());
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> postUsuarios(@RequestBody Usuario usuarios){
		Usuario usuario = usuariosService.criarUsuario(usuarios);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	@PutMapping
	@RequestMapping(value="/{id}")
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuarios,
			@PathVariable("id") int id){
		return ResponseEntity.ok(usuariosService.atualizarUsuario(id, usuarios));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable("id") int id){
		usuariosService.excluirUsuario(id);
		return ResponseEntity.noContent().build();
	}
}
