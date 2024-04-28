package com.jms.guardiaoDoMarAPI.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jms.guardiaoDoMarAPI.Model.UsuarioModel;
import com.jms.guardiaoDoMarAPI.Repository.UsuarioRepository;
import com.jms.guardiaoDoMarAPI.Response.ResponseModel;


@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(final UsuarioRepository usuarioRepository) {
	    this.usuarioRepository = usuarioRepository;
	}
			
	public ResponseEntity<ResponseModel> cadastroUsuario(UsuarioModel usuarioInsert) {	
		int usuariosEncontrados = usuarioRepository.verificaLoginJaCadastrados(usuarioInsert.getEmail(), usuarioInsert.getTelefone());
		if(usuariosEncontrados==0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel(usuarioRepository.save(usuarioInsert).getId(), "Cadastro realizado com sucesso!\nEfetuando Login..."));
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel("E-mail ou Telefone já cadastrados!"));
	}

	public ResponseEntity<ResponseModel> logar(UsuarioModel usuarioLogin) {	
		UsuarioModel usuarioEncontrado = usuarioRepository.logar(usuarioLogin.getEmail());
		if(usuarioEncontrado!=null) {
			if((usuarioLogin.getSenha().equals(usuarioEncontrado.getSenha()))) {
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(usuarioEncontrado.getId(), "Login realizado com sucesso!"));
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel("Senha informada inválida!"));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("E-mail informado não encontrado!"));
	}
		
	public ResponseEntity<?> recuperacaoSenha(String email) {
		UsuarioModel usuario = usuarioRepository.getTelefoneRecuperacaoSenha(email);
		if(usuario!=null) return ResponseEntity.status(HttpStatus.OK).body(usuario);
		else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum telefone encontrado para o e-mail informado");
	}
	
	public ResponseEntity<?> atualizarSenha(UsuarioModel usuarioUpdateSenha) {
		usuarioRepository.novaSenha(usuarioUpdateSenha.getSenha(), usuarioUpdateSenha.getId());
		return ResponseEntity.status(HttpStatus.OK).body("Senha atualizada!");
	}
}