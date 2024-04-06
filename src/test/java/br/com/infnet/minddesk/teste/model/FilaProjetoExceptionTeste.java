package br.com.infnet.minddesk.teste.model;

import br.com.infnet.minddesk.exception.FilaProjetoException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilaProjetoExceptionTeste {

    @Test
    public void testFilaProjetoExceptio() {
        assertThrows(FilaProjetoException.class, () -> {
            throw new FilaProjetoException("Erro ao processar a Fila Projeto");
        });
    }

    @Test
    public void testFilaProjetoExceptionComMensagemECausa() {
        assertThrows(FilaProjetoException.class, () -> {
            throw new FilaProjetoException("Erro ao processar a Fila Projeto", new RuntimeException("Causa do erro"));
        });
    }
}

