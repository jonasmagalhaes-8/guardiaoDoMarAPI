package com.jms.guardiaoDoMarAPI.Model;

import java.io.Serializable;
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
@Table(name = "tb_comunidade_usuarios")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonInclude(Include.NON_NULL)
public class ComunidadeUsuariosModel implements Serializable {

	private static final long serialVersionUID = -544889845798827779L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comunidadeusuarios_generator")
	@SequenceGenerator(name = "comunidadeusuarios_generator", sequenceName = "public.tb_comunidadeusuarios_seq", allocationSize = 1)
	private Integer id;
		
	private int idUsuario;
	
	private int idComunidade;
	
	private boolean membroAdministrador;
		
	public ComunidadeUsuariosModel() {
		
	}
			
	public ComunidadeUsuariosModel(int idUsuario, int idComunidade, boolean membroAdministrador) {
		this.idUsuario = idUsuario;
		this.idComunidade = idComunidade;
		this.membroAdministrador = membroAdministrador;
	}



	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdComunidade() {
		return idComunidade;
	}

	public void setIdComunidade(int idComunidade) {
		this.idComunidade = idComunidade;
	}

	public boolean isMembroAdministrador() {
		return membroAdministrador;
	}

	public void setMembroAdministrador(boolean membroAdministrador) {
		this.membroAdministrador = membroAdministrador;
	}
}
