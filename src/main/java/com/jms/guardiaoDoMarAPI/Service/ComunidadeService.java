package com.jms.guardiaoDoMarAPI.Service;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jms.guardiaoDoMarAPI.Model.ComunidadeModel;
import com.jms.guardiaoDoMarAPI.Model.ComunidadeUsuariosModel;
import com.jms.guardiaoDoMarAPI.Repository.ComunidadeRepository;
import com.jms.guardiaoDoMarAPI.Response.ResponseModel;

@Service
public class ComunidadeService {
	
	private final ComunidadeRepository repository;
	
	private final ComunidadeUsuariosService usuariosService;
	
	private final ComunidadePostagensService comunidadePostagensService;
				
	public ComunidadeService(ComunidadeRepository comunidadeRepository,
			ComunidadeUsuariosService comunidadeUsuariosService, ComunidadePostagensService comunidadePostagensService) {
		this.repository = comunidadeRepository;
		this.usuariosService = comunidadeUsuariosService;
		this.comunidadePostagensService = comunidadePostagensService;
	}

	//atualizarComunidade
	
	public ResponseEntity<?> cadastro(ComunidadeModel novaComunidade) {
		
		novaComunidade.setDataCriacao(new Date());
		
		int idComunidadeCriada = repository.save(novaComunidade).getId();
		
		ComunidadeUsuariosModel novoUsuarioComunidade = new ComunidadeUsuariosModel(novaComunidade.getUsuarioCriador(), idComunidadeCriada, true);
		
		usuariosService.cadastraUsuarioComunidade(novoUsuarioComunidade);
						
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel("Comunidade criada com sucesso!"));
	}
	
	public List<ComunidadeModel> listarPorUsuario(int id) {
		return repository.listarComunidadesPorUsuario(id);
	}
	
	public List<ComunidadeModel> listarTodas() {
		return repository.listarTodasComunidades();
	}
	
	public ComunidadeModel detalhar(int id) {	
		
		ComunidadeModel comunidade = repository.detalhesComunidade(id);
		
		comunidade.setPostagens(comunidadePostagensService.listarPostagensComunidade(id));
		
		return comunidade;
	}
	
	public void deletar(int idComunidade) {	
		repository.deleteById(idComunidade);
	}
}