package com.api.projeto.service;

import com.api.projeto.entity.CST;
import com.api.projeto.repository.CSTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CSTService {

    @Autowired
    private CSTRepository cstRepository;

    public List<CST> listarTodos() {
        return cstRepository.findAll();
    }

    public CST salvar(CST cst) {
        return cstRepository.save(cst);
    }

    public Optional<CST> buscarPorId(Long id) {
        return cstRepository.findById(id);
    }

    public void excluir(Long id) {
        cstRepository.deleteById(id);
    }
}