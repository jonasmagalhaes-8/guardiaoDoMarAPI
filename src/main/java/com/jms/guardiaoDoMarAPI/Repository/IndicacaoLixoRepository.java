package com.jms.guardiaoDoMarAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jms.guardiaoDoMarAPI.Model.IndicacaoLixoModel;

@Repository
public interface IndicacaoLixoRepository extends JpaRepository<IndicacaoLixoModel, Integer> {
}