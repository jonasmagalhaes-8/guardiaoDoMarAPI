package com.jms.guardiaoDoMarAPI.Repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jms.guardiaoDoMarAPI.Model.ComunidadeUsuariosModel;

@Repository
@Transactional
public interface ComunidadeUsuariosRepository extends JpaRepository<ComunidadeUsuariosModel, Integer> {
	void deleteAllByIdUsuarioAndIdComunidade(int usuarioId, int comunidadeId);
}