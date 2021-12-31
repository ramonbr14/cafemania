package br.edu.ifam.tads.cafemania.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, unique=false)
	private String nome;
	@Column(nullable=false, unique=false)
	private String cpf;
	@Column(nullable=false, unique=false)
	private Date datanascimento;
	@Column(nullable=false, unique=false)
	private String email;
	@Column(nullable=false, unique=false)
	private String tipoUsuario;
	/* Problema no Enum
	 * @Enumerated(EnumType.STRING)
	private Enum<?> tipoUsuario;*/
	
		
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(Long id, String nome, String cpf, Date datanascimento, String email, String tipoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.datanascimento = datanascimento;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getDatanascimento() {
		return datanascimento;
	}


	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
