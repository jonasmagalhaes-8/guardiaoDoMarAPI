package com.jms.guardiaoDoMarAPI.Model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_comunidade_postagens")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonInclude(Include.NON_NULL)
public class ComunidadePostagensModel implements Serializable {

	private static final long serialVersionUID = -3953842705290689296L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comunidade_postagens_generator")
	@SequenceGenerator(name = "comunidade_postagens_generator", sequenceName = "public.tb_comunidade_postagens_seq", allocationSize = 1)
	private Integer id;
	
	private String postagem;
			
	private Integer idComunidade;
	
	private Integer usuarioCriador;
		
	@JsonFormat(timezone="America/Sao_Paulo")
	private Date dataCriacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostagem() {
		return postagem;
	}

	public void setPostagem(String postagem) {
		this.postagem = postagem;
	}

	public Integer getIdComunidade() {
		return idComunidade;
	}

	public void setIdComunidade(Integer idComunidade) {
		this.idComunidade = idComunidade;
	}

	public Integer getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Integer usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
