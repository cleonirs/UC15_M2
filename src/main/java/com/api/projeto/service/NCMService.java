package com.api.projeto.service;

import com.api.projeto.entity.NCM;
import com.api.projeto.repository.NCMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NCMService {

    @Autowired
    private NCMRepository ncmRepository;

    public List<NCM> listarTodos() {
        return ncmRepository.findAll();
    }

    public NCM salvar(NCM ncm) {
        return ncmRepository.save(ncm);
    }

    public Optional<NCM> buscarPorId(Long id) {
        return ncmRepository.findById(id);
    }

    public void excluir(Long id) {
        ncmRepository.deleteById(id);
    }
}