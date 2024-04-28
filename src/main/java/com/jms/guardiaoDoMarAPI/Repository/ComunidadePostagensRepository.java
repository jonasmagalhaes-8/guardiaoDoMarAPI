package com.jms.guardiaoDoMarAPI.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jms.guardiaoDoMarAPI.Model.ComunidadePostagensModel;

@Repository
public interface ComunidadePostagensRepository extends JpaRepository<ComunidadePostagensModel, Integer> {
	List<ComunidadePostagensModel> findAllByIdComunidadeOrderByIdDesc(int comunidadeId);
}