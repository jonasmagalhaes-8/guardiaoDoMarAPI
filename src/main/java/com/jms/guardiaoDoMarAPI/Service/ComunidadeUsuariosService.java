package com.jms.guardiaoDoMarAPI.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jms.guardiaoDoMarAPI.Model.ComunidadeUsuariosModel;
import com.jms.guardiaoDoMarAPI.Repository.ComunidadeUsuariosRepository;

@Service
public class ComunidadeUsuariosService {
	
	private final ComunidadeUsuariosRepository comunidadeRepository;
	
	public ComunidadeUsuariosService(final ComunidadeUsuariosRepository comunidadeRepository) {
	    this.comunidadeRepository = comunidadeRepository;
	}
			
	public ResponseEntity<?> cadastraUsuarioComunidade(ComunidadeUsuariosModel novoUsuarioComunidade) {	
		comunidadeRepository.save(novoUsuarioComunidade);
		return ResponseEntity.ok("Usuario adicionado na comunidade com sucesso!");
	}
	
	public void removerusuario(int idUsuario, int idComunidade) {	
		comunidadeRepository.deleteByIdUsuarioAndIdComunidade(idUsuario, idComunidade);
	}
}