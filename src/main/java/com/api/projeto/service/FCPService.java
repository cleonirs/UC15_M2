package com.api.projeto.service;

import com.api.projeto.entity.FCP;
import com.api.projeto.repository.FCPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FCPService {

    @Autowired
    private FCPRepository fcpRepository;

    public List<FCP> listarTodos() {
        return fcpRepository.findAll();
    }

    public FCP salvar(FCP fcp) {
        return fcpRepository.save(fcp);
    }

    public Optional<FCP> buscarPorId(Long id) {
        return fcpRepository.findById(id);
    }

    public void excluir(Long id) {
        fcpRepository.deleteById(id);
    }
}