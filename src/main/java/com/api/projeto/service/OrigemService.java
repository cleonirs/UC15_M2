package com.api.projeto.service;

import com.api.projeto.entity.Origem;
import com.api.projeto.repository.OrigemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrigemService {

    @Autowired
    private OrigemRepository origemRepository;

    public List<Origem> listarTodos() {
        return origemRepository.findAll();
    }

    public Origem salvar(Origem origem) {
        return origemRepository.save(origem);
    }

    public Optional<Origem> buscarPorId(Long id) {
        return origemRepository.findById(id);
    }

    public void excluir(Long id) {
        origemRepository.deleteById(id);
    }
}