package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.model.FilaSuporte;
import br.com.infnet.minddesk.services.FilaSuporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Fila Suporte", description = " - Operações relacionadas ao Suporte.")
@RequestMapping("/fila-suporte")
public class FilaSuporteController {

    @Autowired
    private FilaSuporteService filaSuporteService;

    @Operation(summary = "Criar um novo Ticket.")
    @PostMapping("/criar")
    public ResponseEntity<FilaSuporte> criarFilaSuporte(@RequestBody FilaSuporte filaSuporte) {
        filaSuporteService.save(filaSuporte);
        return new ResponseEntity<>(filaSuporte, HttpStatus.CREATED);
    }

    @Operation(summary = "Listar os Tickets.")
    @GetMapping("/listar")
    public ResponseEntity<List<FilaSuporte>> listarFilaSuporte() {
        List<FilaSuporte> filasSuporte = filaSuporteService.findAll();
        return new ResponseEntity<>(filasSuporte, HttpStatus.OK);
    }

    @Operation(summary = "Buscar os tickets por ID.")
    @GetMapping("/{id}")
    public ResponseEntity<FilaSuporte> buscarFilaSuportePorId(@PathVariable Long id) {
        return filaSuporteService.findById(id)
                .map(filaSuporte -> new ResponseEntity<>(filaSuporte, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Atualizar o Ticket por ID.")
    @PutMapping("/{id}")
    public ResponseEntity<FilaSuporte> atualizarFilaSuporte(@PathVariable Long id, @RequestBody FilaSuporte filaSuporteAtualizada) {
        return new ResponseEntity<>(filaSuporteService.update(id, filaSuporteAtualizada), HttpStatus.OK);
    }

    @Operation(summary = "Deletar Ticket por ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilaSuporte(@PathVariable Long id) {
        filaSuporteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
