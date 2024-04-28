package com.jms.guardiaoDoMarAPI.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_comunidade")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonInclude(Include.NON_NULL)
public class ComunidadeModel implements Serializable {

	private static final long serialVersionUID = 2752165831373693218L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comunidade_generator")
	@SequenceGenerator(name = "comunidade_generator", sequenceName = "public.tb_comunidade_seq", allocationSize = 1)
	private Integer id;
	
	private String nome;
	
	private String contatoAdministrador;
	
	private String cidade;
	
	private String estado;
		
	private String descricao;
	
	private Integer usuarioCriador;
	
	@Transient
	private Long quantidadeMembros;
	
	@Transient
	@JsonFormat(timezone="America/Sao_Paulo")
	private Date ultimaPostagem;
	
	private Date dataCriacao;
	
	@Transient
	private List<ComunidadePostagensModel> postagens;
	
	public ComunidadeModel() {
		
	}
					
	public ComunidadeModel(Integer id, String nome, String cidade, String estado, Long quantidadeMembros, Date ultimaPostagem) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.quantidadeMembros = quantidadeMembros;
		this.ultimaPostagem = ultimaPostagem;
	}
		
	public ComunidadeModel(String contatoAdministrador, String descricao, Date dataCriacao) {
		this.contatoAdministrador = contatoAdministrador;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}

	public ComunidadeModel(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContatoAdministrador() {
		return contatoAdministrador;
	}

	public void setContatoAdministrador(String contatoAdministrador) {
		this.contatoAdministrador = contatoAdministrador;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Integer usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public Long getQuantidadeMembros() {
		return quantidadeMembros;
	}

	public void setQuantidadeMembros(Long quantidadeMembros) {
		this.quantidadeMembros = quantidadeMembros;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getUltimaPostagem() {
		return ultimaPostagem;
	}

	public void setUltimaPostagem(Date ultimaPostagem) {
		this.ultimaPostagem = ultimaPostagem;
	}

	public List<ComunidadePostagensModel> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<ComunidadePostagensModel> postagens) {
		this.postagens = postagens;
	}	
}
