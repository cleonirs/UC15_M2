package com.api.projeto.service;

import com.api.projeto.entity.ICMS;
import com.api.projeto.repository.ICMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ICMSService {

    @Autowired
    private ICMSRepository icmsRepository;

    // Método para listar todas as alíquotas ICMS
    public List<ICMS> listarTodos() {
        return icmsRepository.findAll();
    }

    // Método para salvar/atualizar
    public ICMS salvar(ICMS icms) {
        return icmsRepository.save(icms);
    }

    // Método para buscar por ID
    public Optional<ICMS> buscarPorId(Long id) {
        return icmsRepository.findById(id);
    }

    // Método para excluir por ID
    public void excluir(Long id) {
        icmsRepository.deleteById(id);
    }
}