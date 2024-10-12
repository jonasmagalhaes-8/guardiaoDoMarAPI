package com.jms.guardiaoDoMarAPI.Repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jms.guardiaoDoMarAPI.Model.ComunidadeModel;

@Repository
public interface ComunidadeRepository extends JpaRepository<ComunidadeModel, Integer> {
		
	@Query(value = "SELECT DISTINCT "
			+ "C.id, "
			+ "C.nome, "
			+ "C.cidade, "
			+ "C.estado, "
			+ "(SELECT COUNT(CUSUARIOS.id) FROM tb_comunidade_usuarios CUSUARIOS WHERE C.id = CUSUARIOS.id_comunidade) AS total_membros, "
			+ "CP.data_criacao as ultima_postagem, "
			+ "CUSUARIOS.id_usuario "
			+ "FROM "
			+ "tb_comunidade C "
			+ "JOIN "
			+ "tb_comunidade_usuarios CUSUARIOS "
			+ "ON "
			+ "C.id = CUSUARIOS.id_comunidade AND CUSUARIOS.id_usuario = :usuarioId "
			+ "LEFT JOIN "
			+ "tb_comunidade_postagens CP ON CP.id_comunidade = C.id and "
			+ "CP.id = ("
			+ "SELECT MAX(id) "
			+ "FROM tb_comunidade_postagens "
			+ "WHERE id_comunidade = C.id)", nativeQuery = true)
	List<Map<String, Object>> listarComunidadesPorUsuario(int usuarioId);
	
	@Query(value = "SELECT new ComunidadeModel(C.contatoAdministrador, C.descricao, C.dataCriacao, COALESCE(CUSUARIOS.membroAdministrador, FALSE)) "
			  + "FROM ComunidadeModel C "
			  + "LEFT JOIN ComunidadeUsuariosModel CUSUARIOS ON CUSUARIOS.idComunidade = :comunidadeId AND CUSUARIOS.idUsuario = :usuarioId "
			  + "WHERE C.id = :comunidadeId")
	ComunidadeModel detalhesComunidade(int comunidadeId, int usuarioId);		
		
	@Query(value = "SELECT DISTINCT "
			+ "C.id, "
			+ "C.nome, "
			+ "C.cidade, "
			+ "C.estado, "
			+ "(SELECT COUNT(CUSUARIOS.id) FROM tb_comunidade_usuarios CUSUARIOS WHERE C.id = CUSUARIOS.id_comunidade) AS total_membros, "
			+ "CP.data_criacao as ultima_postagem, "
			+ "CUSUARIOS.id_usuario "
			+ "FROM "
			+ "tb_comunidade C "
			+ "LEFT JOIN "
			+ "tb_comunidade_usuarios CUSUARIOS "
			+ "ON "
			+ "C.id = CUSUARIOS.id_comunidade AND CUSUARIOS.id_usuario = :usuarioId "
			+ "LEFT JOIN "
			+ "tb_comunidade_postagens CP ON CP.id_comunidade = C.id and "
			+ "CP.id = ("
			+ "SELECT MAX(id) "
			+ "FROM tb_comunidade_postagens "
			+ "WHERE id_comunidade = C.id)", nativeQuery = true)
	List<Map<String, Object>> listarTodasComunidades(int usuarioId);
}