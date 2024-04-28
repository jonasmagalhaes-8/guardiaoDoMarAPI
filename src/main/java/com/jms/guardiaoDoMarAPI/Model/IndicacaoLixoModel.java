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
@Table(name = "tb_indicacao_lixo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonInclude(Include.NON_NULL)
public class IndicacaoLixoModel implements Serializable {

	private static final long serialVersionUID = 606471494187494536L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "indicacao_lixo_generator")
	@SequenceGenerator(name = "indicacao_lixo_generator", sequenceName = "public.tb_indicacao_lixo_seq", allocationSize = 1)
	private Integer id;
	
	private String nivelLixo;
	
	private String tipoLixo;
	
	private String descricaoLixo;
	
	private String latitude;
	
	private String longitude;
			
	private boolean flagLimpezaConcluida;
			
	@JsonFormat(timezone="America/Sao_Paulo")
	private Date dataCriacaoIndicacao;
	
	private Integer usuarioCriador;
	
	public IndicacaoLixoModel() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNivelLixo() {
		return nivelLixo;
	}

	public void setNivelLixo(String nivelLixo) {
		this.nivelLixo = nivelLixo;
	}

	public String getTipoLixo() {
		return tipoLixo;
	}

	public void setTipoLixo(String tipoLixo) {
		this.tipoLixo = tipoLixo;
	}

	public String getDescricaoLixo() {
		return descricaoLixo;
	}

	public void setDescricaoLixo(String descricaoLixo) {
		this.descricaoLixo = descricaoLixo;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public boolean isFlagLimpezaConcluida() {
		return flagLimpezaConcluida;
	}

	public void setFlagLimpezaConcluida(boolean flagLimpezaConcluida) {
		this.flagLimpezaConcluida = flagLimpezaConcluida;
	}

	public Date getDataCriacaoIndicacao() {
		return dataCriacaoIndicacao;
	}

	public void setDataCriacaoIndicacao(Date dataCriacaoIndicacao) {
		this.dataCriacaoIndicacao = dataCriacaoIndicacao;
	}

	public Integer getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Integer usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}	
}
