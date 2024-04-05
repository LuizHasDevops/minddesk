package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.model.FilaProjeto;
import br.com.infnet.minddesk.services.FilaProjetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Fila Projeto", description = " - Operações relacionadas ao Projeto.")
@RequestMapping("/fila-projeto")
public class FilaProjetoController {

    @Autowired
    private FilaProjetoService filaProjetoService;
    @Operation(summary = "Criar um novo Ticket.")
    @PostMapping("/criar")
    public ResponseEntity<FilaProjeto> criarFilaProjeto(@RequestBody FilaProjeto filaProjeto) {
        filaProjetoService.save(filaProjeto);
        return new ResponseEntity<>(filaProjeto, HttpStatus.CREATED);
    }
    @Operation(summary = "Listar os Tickets.")
    @GetMapping("/listar")
    public ResponseEntity<List<FilaProjeto>> listarFilaProjeto() {
        List<FilaProjeto> filasProjetos = filaProjetoService.findAll();
        return new ResponseEntity<>(filasProjetos, HttpStatus.OK);
    }
    @Operation(summary = "Buscar os tickets por ID.")
    @GetMapping("/{id}")
    public ResponseEntity<FilaProjeto> buscarFilaProjetoPorId(@PathVariable Long id) {
        return filaProjetoService.findById(id)
                .map(filaProjeto -> new ResponseEntity<>(filaProjeto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Atualizar o Ticket por ID.")
    @PutMapping("/{id}")
    public ResponseEntity<FilaProjeto> atualizarFilaProjeto(@PathVariable Long id, @RequestBody FilaProjeto filaProjetoAtualizada) {
        return new ResponseEntity<>(filaProjetoService.update(id, filaProjetoAtualizada), HttpStatus.OK);
    }
    @Operation(summary = "Deletar Ticket por ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilaProjeto(@PathVariable Long id) {
        filaProjetoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
