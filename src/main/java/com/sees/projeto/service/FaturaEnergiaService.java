package com.sees.projeto.service;

import com.sees.projeto.entity.FaturaEnergia;
import com.sees.projeto.entity.Usuario;
import com.sees.projeto.repository.FaturaEnergiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FaturaEnergiaService {

    private final FaturaEnergiaRepository repository;

    public FaturaEnergiaService(FaturaEnergiaRepository repository) {
        this.repository = repository;
    }

    public boolean usuarioTemFaturas(Long usuarioId) {
        return repository.existsByUsuarioUsuarioId(usuarioId);
    }

    public List<FaturaEnergia> listarOrdenadas(Long usuarioId) {
        return repository.findByUsuarioUsuarioIdOrderByMesAnoAsc(usuarioId);
    }

    @Transactional
    public void salvarDozeFaturas(Usuario usuario, String[] meses, String[] kwhs, String[] valores) {
        for (int i = 0; i < meses.length; i++) {
            FaturaEnergia fatura = new FaturaEnergia();
            fatura.setUsuario(usuario);
            fatura.setMesAno(meses[i]);
            fatura.setKwh(new BigDecimal(kwhs[i]));
            fatura.setValorPago(new BigDecimal(valores[i]));

            repository.save(fatura);
        }
    }
}
