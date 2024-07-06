package com.jms.guardiaoDoMarAPI.Repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jms.guardiaoDoMarAPI.Model.UsuarioRecuperacaoSenhaModel;

@Repository
@Transactional
public interface UsuarioRecuperacaoSenhaRepository extends JpaRepository<UsuarioRecuperacaoSenhaModel, Integer> {
	void deleteByTokenAndIdUsuario(int token, int idUsuario);
	void deleteByToken(int token);
	void deleteAllByIdUsuario(int token);
	UsuarioRecuperacaoSenhaModel findByToken(int token);
}