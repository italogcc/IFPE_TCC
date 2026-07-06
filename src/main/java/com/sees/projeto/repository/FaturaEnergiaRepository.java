package com.sees.projeto.repository;

import com.sees.projeto.entity.FaturaEnergia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaturaEnergiaRepository extends JpaRepository<FaturaEnergia, Long> {

    List<FaturaEnergia> findByUsuarioUsuarioIdOrderByMesAnoAsc(Long usuarioId);

    boolean existsByUsuarioUsuarioId(Long usuarioId);
}
