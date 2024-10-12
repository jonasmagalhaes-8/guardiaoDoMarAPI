package com.jms.guardiaoDoMarAPI.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Random;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jms.guardiaoDoMarAPI.Model.UsuarioModel;
import com.jms.guardiaoDoMarAPI.Model.UsuarioRecuperacaoSenhaModel;
import com.jms.guardiaoDoMarAPI.Repository.UsuarioRecuperacaoSenhaRepository;
import com.jms.guardiaoDoMarAPI.Repository.UsuarioRepository;
import com.jms.guardiaoDoMarAPI.Response.ResponseModel;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	private final EmailService emailService;
	private final UsuarioRecuperacaoSenhaRepository usuarioRecuperacaoSenhaRepository;
			
	public UsuarioService(UsuarioRepository usuarioRepository, EmailService emailService,
			UsuarioRecuperacaoSenhaRepository usuarioRecuperacaoSenhaRepository) {
		this.usuarioRepository = usuarioRepository;
		this.emailService = emailService;
		this.usuarioRecuperacaoSenhaRepository = usuarioRecuperacaoSenhaRepository;
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
		
	public ResponseEntity<?> solicitacaoRecuperacaoSenha(String email) {
		UsuarioModel existeUsuarioEmail = usuarioRepository.recuperaIdPorEmail(email);
		if(existeUsuarioEmail!=null) {
			int tokenRecuperacaoSenha = geraTokenRecuperacaoSenha();
			usuarioRecuperacaoSenhaRepository.save(new UsuarioRecuperacaoSenhaModel(new Date(), tokenRecuperacaoSenha, existeUsuarioEmail.getId()));
			emailService.enviarEmailRecuperacaoDeSenha(email, tokenRecuperacaoSenha);
			return ResponseEntity.status(HttpStatus.OK).body("Te enviaremos um e-mail para que possa criar uma nova senha, fique atento a sua caixa de entrada!");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("E-mail informado não cadastrado para nenhuma conta!");
	}
	
	int geraTokenRecuperacaoSenha() {
		return 100000 + new Random().nextInt(900000);
	}
		
	public ResponseEntity<?> validarTokenEnviadoRecuperacaoSenha(int token) {
		UsuarioRecuperacaoSenhaModel existeSolicitacao = usuarioRecuperacaoSenhaRepository.findByToken(token);
		if(existeSolicitacao!=null) {
			Instant dataSolicitacao = existeSolicitacao.getDataSolicitacao().toInstant();
			if(Duration.between(Instant.now(), dataSolicitacao).toMinutes()>=60) {
				usuarioRecuperacaoSenhaRepository.deleteByToken(existeSolicitacao.getToken());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token expirado! Tente novamente");
			}
			usuarioRecuperacaoSenhaRepository.deleteAllByIdUsuario(existeSolicitacao.getIdUsuario());
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(existeSolicitacao.getIdUsuario(), "Código validado com sucesso!"));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token informado inválido! Tente novamente"); 
	}
	
	public ResponseEntity<?> atualizarSenha(UsuarioModel usuarioUpdateSenha) {
		usuarioRepository.novaSenha(usuarioUpdateSenha.getSenha(), usuarioUpdateSenha.getId());
		return ResponseEntity.status(HttpStatus.OK).body("Senha atualizada com sucesso!");
	}
}