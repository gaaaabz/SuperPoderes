package br.com.fiap.SuperPoderes;

import java.util.List;
import java.util.Optional;

import lombok.Generated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superpoderes")
@CrossOrigin(origins = "*")
public class SuperPoderesController {

    private final SuperPoderesRepository repository;

    @Generated
    public SuperPoderesController(final SuperPoderesRepository repository) {
        this.repository = repository;
    }

    // LISTAR TODOS
    @GetMapping
    public List<SuperPoderes> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Optional<SuperPoderes> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    // CRIAR
    @PostMapping
    public SuperPoderes criar(@RequestBody SuperPoderes superPoder) {
        return repository.save(superPoder);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public SuperPoderes atualizar(@PathVariable Long id, @RequestBody SuperPoderes superPoderAtualizado) {

        SuperPoderes superPoder = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Super poder não encontrado"));

        superPoder.setNome(superPoderAtualizado.getNome());
        superPoder.setDescricao(superPoderAtualizado.getDescricao());

        return repository.save(superPoder);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}