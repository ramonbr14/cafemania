package br.edu.ifam.tads.cafemania.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifam.tads.cafemania.model.BancadeCafe;

public interface BancadeCafeRepository extends JpaRepository<BancadeCafe, Long>{
	List<BancadeCafe> findByNomeBanca(String nomeBanca);
}
