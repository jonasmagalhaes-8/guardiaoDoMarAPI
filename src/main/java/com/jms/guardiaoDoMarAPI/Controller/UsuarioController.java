package com.jms.guardiaoDoMarAPI.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jms.guardiaoDoMarAPI.Model.UsuarioModel;
import com.jms.guardiaoDoMarAPI.Response.ResponseModel;
import com.jms.guardiaoDoMarAPI.Service.UsuarioService;

@RestController
@RequestMapping(value = "guardiaodomar/usuario")
public class UsuarioController {
	
	private final UsuarioService service;

	public UsuarioController(final UsuarioService service) {
	    this.service = service;
	}
		
	@PostMapping("/logar")
	public ResponseEntity<ResponseModel> logar(@RequestBody UsuarioModel UsuarioLogin) {
		return service.logar(UsuarioLogin);
	}
			
	@PostMapping("/cadastrar")
	public ResponseEntity<ResponseModel> cadastroUsuario(@RequestBody UsuarioModel UsuarioInsert) {
		return service.cadastroUsuario(UsuarioInsert);
	}
		
	@PutMapping("/atualizarSenha")
	public ResponseEntity<?> atualizarSenha(@RequestBody UsuarioModel UsuarioResetSenha) {
		return service.atualizarSenha(UsuarioResetSenha);
	}
	
	@GetMapping(value = "/recuperarsenha/{email}")
	public ResponseEntity<?> recuperacaoSenha (@PathVariable String email) {
		return service.recuperacaoSenha(email);
	}
}