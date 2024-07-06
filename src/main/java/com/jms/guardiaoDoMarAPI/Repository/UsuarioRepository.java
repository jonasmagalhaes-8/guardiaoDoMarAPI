package com.jms.guardiaoDoMarAPI.Repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jms.guardiaoDoMarAPI.Model.UsuarioModel;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
			
	@Query(value = "SELECT COUNT(ID) FROM PUBLIC.TB_USUARIO WHERE EMAIL = :email or TELEFONE = :telefone", nativeQuery = true)
	int verificaLoginJaCadastrados(String email, String telefone);
	
	@Query(value = "SELECT new UsuarioModel(u.senha, u.id) FROM UsuarioModel u where email = :email")
	UsuarioModel logar(String email);
	
	@Query(value = "SELECT new UsuarioModel(u.id) FROM UsuarioModel u where email = :email")
	UsuarioModel recuperaIdPorEmail(String email);
		
	@Modifying
	@Query(value = "UPDATE public.tb_usuario SET senha = :novaSenha WHERE id = :id", nativeQuery = true)
	int novaSenha(String novaSenha, Integer id);
	
	@Query(value = "SELECT new UsuarioModel(u.id, u.telefone) FROM UsuarioModel u where email = :email")
	UsuarioModel getTelefoneRecuperacaoSenha(String email);
}