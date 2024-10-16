package com.jms.guardiaoDoMarAPI.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
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
	
	private final ComunidadeUsuariosService comunidadeUsuariosService;
	
	private final ComunidadePostagensService comunidadePostagensService;
				
	public ComunidadeService(ComunidadeRepository comunidadeRepository,
			ComunidadeUsuariosService comunidadeUsuariosService, ComunidadePostagensService comunidadePostagensService) {
		this.repository = comunidadeRepository;
		this.comunidadeUsuariosService = comunidadeUsuariosService;
		this.comunidadePostagensService = comunidadePostagensService;
	}

	public ResponseEntity<?> atualizarComunidade(ComunidadeModel comunidadeAtualizada) {
		
		ComunidadeModel comunidadeASerAtualizada = repository.findById(comunidadeAtualizada.getId()).get();
		
		BeanUtils.copyProperties(comunidadeAtualizada, comunidadeASerAtualizada, "id", "usuarioCriador", "dataCriacao");
			
		repository.save(comunidadeASerAtualizada);
				
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel("Comunidade atualizada com sucesso!"));
	}
	
	public ResponseEntity<?> cadastro(ComunidadeModel novaComunidade) {
		
		novaComunidade.setDataCriacao(new Date());
		
		int idComunidadeCriada = repository.save(novaComunidade).getId();
		
		ComunidadeUsuariosModel novoUsuarioComunidade = new ComunidadeUsuariosModel(novaComunidade.getUsuarioCriador(), idComunidadeCriada, true);
		
		comunidadeUsuariosService.cadastraUsuarioComunidade(novoUsuarioComunidade);
						
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel("Comunidade criada com sucesso!"));
	}
	
	public List<Map<String, Object>> listarPorUsuario(int id) {
		return repository.listarComunidadesPorUsuario(id);
	}
	
	public List<Map<String, Object>> listarTodas(int usuarioId) {
		return repository.listarTodasComunidades(usuarioId);
	}
	
	public ComunidadeModel detalhar(int comunidadeId, int usuarioId) {	
		
		ComunidadeModel comunidade = repository.detalhesComunidade(comunidadeId, usuarioId);
		
		comunidade.setPostagens(comunidadePostagensService.listarPostagensComunidade(comunidadeId));
		
		return comunidade;
	}
	
	public void deletar(int idComunidade) {	
		repository.deleteById(idComunidade);
	}
}