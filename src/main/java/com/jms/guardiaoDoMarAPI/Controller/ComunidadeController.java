package com.jms.guardiaoDoMarAPI.Controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<?> cadastrocomunidade(@RequestBody ComunidadeModel comunidadeInsert) {
		return service.cadastro(comunidadeInsert);
	}
	
	/*@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarSenha(@RequestBody ComunidadeModel comunidadeResetSenha) {
		return service.atualizarSenha(comunidadeResetSenha);
	}*/
	
	@DeleteMapping(value = "/deletar/{id}")
	public void deletar(@PathVariable int id) {
		service.deletar(id);
	}
	
	@GetMapping(value = "/detalhar/{id}")
	public ComunidadeModel detalhar (@PathVariable int id) {
		return service.detalhar(id);
	}
	
	@GetMapping("/listarporusuario/{id}")
	public List<ComunidadeModel> listarPorUsuario(@PathVariable int id) {
		return service.listarPorUsuario(id);
	}
	
	@GetMapping("/listartodas")
	public List<ComunidadeModel> listarTodas () {
		return service.listarTodas();
	}
}