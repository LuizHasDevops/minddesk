package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.model.*;
import br.com.infnet.minddesk.services.DTOConverterService;
import br.com.infnet.minddesk.services.impl.SolicitacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoServiceImpl solicitacaoService;

    @Autowired
    private DTOConverterService dtoConverterService;

    @PostMapping
    public ResponseEntity<Solicitacao> criarSolicitacao(@RequestBody Solicitacao json) {
        Solicitacao solicitacao = dtoConverterService.converterParaSolicitacaoDTO(json);
        solicitacaoService.save(solicitacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }

    @GetMapping
    public ResponseEntity<List<Solicitacao>> listarSolicitacoes() {
        List<Solicitacao> solicitacoes = solicitacaoService.findAll();
        return ResponseEntity.ok(solicitacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> buscarSolicitacaoPorId(@PathVariable Long id) {
        Optional<Solicitacao> solicitacaoOptional = solicitacaoService.findById(id);
        return solicitacaoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitacao> atualizarSolicitacao(@PathVariable Long id, @RequestBody Solicitacao solicitacaoAtualizada) {
        Optional<Solicitacao> solicitacaoOptional = solicitacaoService.findById(id);
        if (solicitacaoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Solicitacao solicitacao = solicitacaoOptional.get();
        Solicitacao solicitacaoAtualizadaSalva = solicitacaoService.update(id, solicitacaoAtualizada);
        return ResponseEntity.ok(solicitacaoAtualizadaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarSolicitacao(@PathVariable Long id) {
        Optional<Solicitacao> solicitacaoOptional = solicitacaoService.findById(id);
        if (solicitacaoOptional.isPresent()) {
            solicitacaoService.deleteById(id);
            return ResponseEntity.ok("Solicitação deletada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
