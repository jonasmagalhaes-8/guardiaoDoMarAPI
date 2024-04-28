package com.jms.guardiaoDoMarAPI.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jms.guardiaoDoMarAPI.Model.ComunidadeUsuariosModel;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ComunidadeUsuariosRepository extends JpaRepository<ComunidadeUsuariosModel, Integer> {
	void deleteAllByIdUsuarioAndIdComunidade(int usuarioId, int comunidadeId);
}