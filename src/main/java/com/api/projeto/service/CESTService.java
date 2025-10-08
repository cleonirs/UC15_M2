package com.api.projeto.service;

import com.api.projeto.entity.CEST;
import com.api.projeto.repository.CESTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CESTService {

    @Autowired
    private CESTRepository cestRepository;

    public List<CEST> listarTodos() {
        return cestRepository.findAll();
    }

    public CEST salvar(CEST cest) {
        return cestRepository.save(cest);
    }

    public Optional<CEST> buscarPorId(Long id) {
        return cestRepository.findById(id);
    }

    public void excluir(Long id) {
        cestRepository.deleteById(id);
    }
}