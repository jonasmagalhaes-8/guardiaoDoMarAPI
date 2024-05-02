package com.jms.guardiaoDoMarAPI.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jms.guardiaoDoMarAPI.Model.IndicacaoLixoModel;
import com.jms.guardiaoDoMarAPI.Response.ResponseModel;
import com.jms.guardiaoDoMarAPI.Service.IndicacaoLixoService;

@RestController
@CrossOrigin
@RequestMapping(value = "guardiaodomar/indicacaolixo")
public class IndicacaoLixoController {
	
	private final IndicacaoLixoService service;

	public IndicacaoLixoController(final IndicacaoLixoService service) {
	    this.service = service;
	}
				
	@PostMapping("/nova")
	public ResponseEntity<ResponseModel> cadastrocomunidadeusuarios(@RequestBody IndicacaoLixoModel novaIndicacao) {
		return service.novaIndicacao(novaIndicacao);
	}
	
	@GetMapping(value = "/listartodas")
	public List<IndicacaoLixoModel> listarTodas () {
		return service.listarTodas();
	}
}