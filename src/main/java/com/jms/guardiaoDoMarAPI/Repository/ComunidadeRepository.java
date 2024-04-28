package com.jms.guardiaoDoMarAPI.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jms.guardiaoDoMarAPI.Model.ComunidadeModel;

@Repository
public interface ComunidadeRepository extends JpaRepository<ComunidadeModel, Integer> {
		
	@Query(value = "SELECT DISTINCT new ComunidadeModel(C.id, C.nome, C.cidade, C.estado, "
			  + "(SELECT COUNT(id) FROM ComunidadeUsuariosModel CU WHERE C.id = CU.idComunidade), CP.dataCriacao) "
			  + "FROM ComunidadeModel C "
			  + "JOIN ComunidadeUsuariosModel CU on C.id = CU.idComunidade and CU.idUsuario = :usuarioId "
			  + "LEFT JOIN ComunidadePostagensModel CP ON CP.idComunidade = C.id and "
			  + "CP.id = ("
			  + "SELECT MAX(id) "
			  + "FROM ComunidadePostagensModel "
			  + "WHERE idComunidade = C.id)")
	List<ComunidadeModel> listarComunidadesPorUsuario(int usuarioId);
	
	@Query(value = "SELECT new ComunidadeModel(C.contatoAdministrador, C.descricao, C.dataCriacao) "
			  + "FROM ComunidadeModel C where C.id = :id")
	ComunidadeModel detalhesComunidade(int id);	
	
	@Query(value = "SELECT DISTINCT new ComunidadeModel(C.id, C.nome, C.cidade, C.estado, "
	  + "(SELECT COUNT(id) FROM ComunidadeUsuariosModel CU WHERE C.id = CU.idComunidade), CP.dataCriacao) "
	  + "FROM ComunidadeModel C "
	  + "LEFT JOIN ComunidadePostagensModel CP ON CP.idComunidade = C.id and "
	  + "CP.id = ("
	  + "SELECT MAX(id) "
	  + "FROM ComunidadePostagensModel "
	  + "WHERE idComunidade = C.id)")
	List<ComunidadeModel> listarTodasComunidades();	
}