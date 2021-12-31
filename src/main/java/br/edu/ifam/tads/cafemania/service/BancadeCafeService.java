package br.edu.ifam.tads.cafemania.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifam.tads.cafemania.model.BancadeCafe;
import br.edu.ifam.tads.cafemania.repository.BancadeCafeRepository;

@Service
public class BancadeCafeService {
	List<BancadeCafe> bancadeCafecfm = new ArrayList<BancadeCafe>();
	
	@Autowired
	BancadeCafeRepository bancadeCaferepositorio;
	
	public Optional<BancadeCafe> obterBancadeCafe(long id) {
		return bancadeCaferepositorio.findById(id);
	}
	
	public List<BancadeCafe> obterBancadeCafes(){
		return bancadeCaferepositorio.findAll();
	}
	
	public List<BancadeCafe> obterBancadeCafe(String nomeBancadeCafe){
		return bancadeCaferepositorio.findByNomeBanca(nomeBancadeCafe);
	}
	
	public BancadeCafe criarBancadeCafe(BancadeCafe bancadeCafe) {
		return bancadeCaferepositorio.save(bancadeCafe);
	}
	
	public BancadeCafe atualizarBancadeCafe(long id, BancadeCafe bancadeCafe) {
		bancadeCafe.setId(id);
		return bancadeCaferepositorio.save(bancadeCafe);	
	}
	
	public void excluirBancadeCafe(long id) {
		bancadeCaferepositorio.deleteById(id);
	}
}
