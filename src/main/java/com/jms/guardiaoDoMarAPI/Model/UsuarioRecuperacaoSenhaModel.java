package com.jms.guardiaoDoMarAPI.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario_recuperacao_senha")
public class UsuarioRecuperacaoSenhaModel implements Serializable {

	private static final long serialVersionUID = 1513294544688310203L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuariorecuperacaosenha_generator")
	@SequenceGenerator(name = "usuariorecuperacaosenha_generator", sequenceName = "public.tb_usuariorecuperacaosenha_seq", allocationSize = 1)
	private Integer id;
		
	private int idUsuario;
	
	private int token;
	
	private Date dataSolicitacao;
	
	public UsuarioRecuperacaoSenhaModel() {

	}

	public UsuarioRecuperacaoSenhaModel(Date dataSolicitacao, int tokenRecuperacaoSenha, Integer idUsuario) {
		this.dataSolicitacao = dataSolicitacao;
		this.token = tokenRecuperacaoSenha;
		this.idUsuario = idUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
}
