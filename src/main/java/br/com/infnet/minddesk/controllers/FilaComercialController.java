package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.model.FilaComercial;
import br.com.infnet.minddesk.services.FilaComercialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Fila Comercial", description = " - Operações relacionadas ao Comercial.")
@RequestMapping("/fila-comercial")
public class FilaComercialController {

    @Autowired
    private FilaComercialService filaComercialService;
    @Operation(summary = "Criar um novo Ticket.")
    @PostMapping("/criar")
    public ResponseEntity<FilaComercial> criarFilaComercial(@RequestBody FilaComercial filaComercial) {
        filaComercialService.save(filaComercial);
        return new ResponseEntity<>(filaComercial, HttpStatus.CREATED);
    }
    @Operation(summary = "Listar os Tickets.")
    @GetMapping("/listar")
    public ResponseEntity<List<FilaComercial>> listarFilaComercial() {
        List<FilaComercial> filasComerciais = filaComercialService.findAll();
        return new ResponseEntity<>(filasComerciais, HttpStatus.OK);
    }
    @Operation(summary = "Buscar os tickets por ID.")
    @GetMapping("/{id}")
    public ResponseEntity<FilaComercial> buscarFilaComercialPorId(@PathVariable Long id) {
        return filaComercialService.findById(id)
                .map(filaComercial -> new ResponseEntity<>(filaComercial, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Atualizar o Ticket por ID.")
    @PutMapping("/{id}")
    public ResponseEntity<FilaComercial> atualizarFilaComercial(@PathVariable Long id, @RequestBody FilaComercial filaComercialAtualizada) {
        return new ResponseEntity<>(filaComercialService.update(id, filaComercialAtualizada), HttpStatus.OK);
    }
    @Operation(summary = "Deletar Ticket por ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilaComercial(@PathVariable Long id) {
        filaComercialService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
