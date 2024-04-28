package com.jms.guardiaoDoMarAPI.Service;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jms.guardiaoDoMarAPI.Model.IndicacaoLixoModel;
import com.jms.guardiaoDoMarAPI.Repository.IndicacaoLixoRepository;
import com.jms.guardiaoDoMarAPI.Response.ResponseModel;
import com.jms.guardiaoDoMarAPI.WebSocket.WebSocketHandler;

@Service
public class IndicacaoLixoService {
	
	private final IndicacaoLixoRepository indicacaoLixoRepository;
	
	public IndicacaoLixoService(final IndicacaoLixoRepository indicacaoLixoRepository) {
	    this.indicacaoLixoRepository = indicacaoLixoRepository;
	}
			
	public ResponseEntity<ResponseModel> novaIndicacao(IndicacaoLixoModel novaPostagem) {	
		novaPostagem.setDataCriacaoIndicacao(new Date());
		novaPostagem.setFlagLimpezaConcluida(false);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			WebSocketHandler.enviarMensagemParaTodos(mapper.writeValueAsString(indicacaoLixoRepository.save(novaPostagem)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel("Indicação de lixo realizada com sucesso!\nA mesma pode ser vista por todos os usuários no Mapa, obrigado!"));
		
	}
		
	public List<IndicacaoLixoModel> listarTodas() {
		return indicacaoLixoRepository.findAll();
	}
}