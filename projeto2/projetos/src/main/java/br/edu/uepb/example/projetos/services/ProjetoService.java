package br.edu.uepb.example.projetos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.uepb.example.projetos.domain.Projeto;
import br.edu.uepb.example.projetos.exceptions.ExistingSameNameException;
import br.edu.uepb.example.projetos.repository.ProjetoRepository;
import javassist.NotFoundException;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto createProjeto(Projeto projeto) throws ExistingSameNameException {
        if (projetoRepository.findByNome(projeto.getNome()).isPresent())
            throw new ExistingSameNameException("Já existe um projeto com esse nome!");
        return projetoRepository.save(projeto);
    }

    public Projeto updateProjeto(Long id, Projeto projeto) {
        projeto.setId(id);
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listAllProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto findById(Long id) throws NotFoundException {
        return projetoRepository.findById(id).orElseThrow(() -> new NotFoundException("Não existe um projeto com esse identificador!"));
    }

    public void deleteProjeto(Long id) {
        Projeto projetoToDelete = projetoRepository.findById(id).get();
        projetoRepository.delete(projetoToDelete);
    }

}