package com.jms.guardiaoDoMarAPI.Controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jms.guardiaoDoMarAPI.Model.ComunidadeModel;
import com.jms.guardiaoDoMarAPI.Service.ComunidadeService;

@RestController
@RequestMapping(value = "guardiaodomar/comunidade")
public class ComunidadeController {
	
	private final ComunidadeService service;

	public ComunidadeController(final ComunidadeService service) {
	    this.service = service;
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarComunidade(@RequestBody ComunidadeModel comunidadeInsert) {
		return service.cadastro(comunidadeInsert);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarComunidade(@RequestBody ComunidadeModel comunidadeUpdate) {
		return service.atualizarComunidade(comunidadeUpdate);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public void deletar(@PathVariable int id) {
		service.deletar(id);
	}
	
	@GetMapping(value = "/detalhar")
	public ComunidadeModel detalhar (@RequestParam int idComunidade, @RequestParam int usuarioId) {
		return service.detalhar(idComunidade, usuarioId);
	}
	
	@GetMapping("/listarporusuario/{id}")
	public List<Map<String, Object>> listarPorUsuario(@PathVariable int id) {
		return service.listarPorUsuario(id);
	}
	
	@GetMapping("/listartodas/{idUsuario}")
	public List<Map<String, Object>> listarTodas (@PathVariable int idUsuario) {
		return service.listarTodas(idUsuario);
	}
}