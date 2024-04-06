package br.com.infnet.minddesk.teste.model;


import br.com.infnet.minddesk.exception.FilaSuporteException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilaSuporteExceptionTeste{

    @Test
    public void testFilaSuporteException() {
        assertThrows(FilaSuporteException.class, () -> {
            throw new FilaSuporteException("Erro ao processar a Fila Suporte");
        });
    }

    @Test
    public void testFilaSuporteExceptionComMensagemECausa() {
        assertThrows(FilaSuporteException.class, () -> {
            throw new FilaSuporteException("Erro ao processar a Fila Suporte", new RuntimeException("Causa do erro"));
        });
    }
}

