package com.jms.guardiaoDoMarAPI.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jms.guardiaoDoMarAPI.Model.ComunidadeUsuariosModel;
import com.jms.guardiaoDoMarAPI.Service.ComunidadeUsuariosService;

@RestController
@RequestMapping(value = "guardiaodomar/comunidadeusuarios")
public class ComunidadeUsuariosController {
	
	private final ComunidadeUsuariosService service;

	public ComunidadeUsuariosController(final ComunidadeUsuariosService service) {
	    this.service = service;
	}
				
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrocomunidadeusuarios(@RequestBody ComunidadeUsuariosModel comunidadeusuariosInsert) {
		return service.cadastraUsuarioComunidade(comunidadeusuariosInsert);
	}
	
	@DeleteMapping("/removerusuario")
	public void recuperacaoSenha (@RequestParam int idUsuario, @RequestParam int idComunidade) {
		service.removerusuario(idUsuario, idComunidade);
	}
}