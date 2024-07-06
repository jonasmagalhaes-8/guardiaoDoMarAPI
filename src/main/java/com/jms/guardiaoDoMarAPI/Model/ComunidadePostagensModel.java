package com.jms.guardiaoDoMarAPI.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
	
	public ComunidadePostagensModel() {
	}

	public ComunidadePostagensModel(ComunidadePostagensModel postagemCriada) {
		this.id = postagemCriada.id;
		this.dataCriacao = postagemCriada.dataCriacao;
	}

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
