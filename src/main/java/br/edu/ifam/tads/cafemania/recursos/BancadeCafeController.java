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

import br.edu.ifam.tads.cafemania.model.BancadeCafe;
import br.edu.ifam.tads.cafemania.service.BancadeCafeService;

@RestController
@RequestMapping(value="cafemaniaBanca")
public class BancadeCafeController {
	
	@Autowired
	BancadeCafeService bancadeCafeService;
	
	@GetMapping
	public ResponseEntity<List<BancadeCafe>> getBancadeCafe(){
		return ResponseEntity.ok(bancadeCafeService.obterBancadeCafes());
	}
	
	@GetMapping("/procura")
	public ResponseEntity<List<BancadeCafe>>getBancadeCafeByNome(String nomebanca){
		return ResponseEntity.ok(bancadeCafeService.obterBancadeCafes());
	}
	@GetMapping("/id")
	public ResponseEntity<BancadeCafe> getBancadeCafe(@PathVariable("id") long id){
		Optional<BancadeCafe> optionalBancadeCafe = bancadeCafeService.obterBancadeCafe(id);
		if(optionalBancadeCafe.isPresent())
			return ResponseEntity.ok(optionalBancadeCafe.get());
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<BancadeCafe> postBancadeCafe(@RequestBody BancadeCafe bancadeCafe){
		BancadeCafe banca = bancadeCafeService.criarBancadeCafe(bancadeCafe);
		return ResponseEntity.status(HttpStatus.CREATED).body(banca);
	}
	
	@PutMapping
	@RequestMapping(value="/{id}")
	public ResponseEntity<BancadeCafe> putBancadeCafe(@RequestBody BancadeCafe bancadeCafe,
			@PathVariable("id") int id){
		return ResponseEntity.ok(bancadeCafeService.atualizarBancadeCafe(id, bancadeCafe));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteBancadeCafe(@PathVariable("id") int id){
		bancadeCafeService.excluirBancadeCafe(id);
		return ResponseEntity.noContent().build();
	}
}
