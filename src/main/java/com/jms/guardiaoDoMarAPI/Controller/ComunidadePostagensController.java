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
import com.jms.guardiaoDoMarAPI.Model.ComunidadePostagensModel;
import com.jms.guardiaoDoMarAPI.Service.ComunidadePostagensService;

@CrossOrigin
@RestController
@RequestMapping(value = "guardiaodomar/comunidadepostagens")
public class ComunidadePostagensController {
	
	private final ComunidadePostagensService service;

	public ComunidadePostagensController(final ComunidadePostagensService service) {
	    this.service = service;
	}
				
	@PostMapping("/novapostagem")
	public ResponseEntity<?> novaPostagem(@RequestBody ComunidadePostagensModel novaPostagem) {
		return service.novaPostagem(novaPostagem);
	}
		
	@DeleteMapping("/deletar/{id}")
	public void deletarPostagem (@PathVariable int id) {
		service.deletarPostagem(id);
	}
	
	@GetMapping(value = "/listar/{id}")
	public List<ComunidadePostagensModel> listarPostagensComunidade (@PathVariable int id) {
		return service.listarPostagensComunidade(id);
	}
}