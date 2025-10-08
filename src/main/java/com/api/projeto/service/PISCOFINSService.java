package com.api.projeto.service;

import com.api.projeto.entity.PISCOFINS;
import com.api.projeto.repository.PISCOFINSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PISCOFINSService {

    @Autowired
    private PISCOFINSRepository piscofinsRepository;

    public List<PISCOFINS> listarTodos() {
        return piscofinsRepository.findAll();
    }

    public PISCOFINS salvar(PISCOFINS piscofins) {
        return piscofinsRepository.save(piscofins);
    }

    public Optional<PISCOFINS> buscarPorId(Long id) {
        return piscofinsRepository.findById(id);
    }

    public void excluir(Long id) {
        piscofinsRepository.deleteById(id);
    }
}