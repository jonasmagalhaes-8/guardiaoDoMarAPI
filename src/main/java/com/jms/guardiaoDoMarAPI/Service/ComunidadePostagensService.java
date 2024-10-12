package com.jms.guardiaoDoMarAPI.Service;

import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jms.guardiaoDoMarAPI.Model.ComunidadePostagensModel;
import com.jms.guardiaoDoMarAPI.Repository.ComunidadePostagensRepository;
import com.jms.guardiaoDoMarAPI.Response.ResponseModel;

@Service
public class ComunidadePostagensService {
	
	private final ComunidadePostagensRepository comunidadePostagensRepository;
	
	public ComunidadePostagensService(final ComunidadePostagensRepository comunidadePostagensRepository) {
	    this.comunidadePostagensRepository = comunidadePostagensRepository;
	}
			
	public ResponseEntity<ResponseModel> novaPostagem(ComunidadePostagensModel novaPostagem) {	
		novaPostagem.setDataCriacao(new Date());
		return ResponseEntity.status(HttpStatus.CREATED).body(
				new ResponseModel(new ComunidadePostagensModel(comunidadePostagensRepository.save(novaPostagem)), "Postagem realizada com sucesso!"));
	}
	
	public void deletarPostagem(int idPostagem) {	
		comunidadePostagensRepository.deleteById(idPostagem);
	}
	
	public List<ComunidadePostagensModel> listarPostagensComunidade(int comunidadeId) {
		return comunidadePostagensRepository.findAllByIdComunidadeOrderByIdDesc(comunidadeId);
	}
}