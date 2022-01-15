package br.edu.ifam.tads.cafemania.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BancadeCafe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, unique=false)
	private String nomeBanca;
	@Column(nullable=false, unique=false)
	private String endereco;
	@ManyToOne
	private Usuario Dono;
	
	public BancadeCafe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BancadeCafe(Long id, String nomeBanca, String endereco, Usuario dono) {
		super();
		this.id = id;
		this.nomeBanca = nomeBanca;
		this.endereco = endereco;
		Dono = dono;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeBanca() {
		return nomeBanca;
	}
	public void setNomeBanca(String nomeBanca) {
		this.nomeBanca = nomeBanca;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Usuario getDono() {
		return Dono;
	}
	public void setDono(Usuario dono) {
		Dono = dono;
	}
		
}
