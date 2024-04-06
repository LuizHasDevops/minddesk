package br.com.infnet.minddesk.teste.model;

import br.com.infnet.minddesk.exception.ClienteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilaComercialExceptionTeste {

    @Test
    public void testFilaComercialException() {
        assertThrows(ClienteException.class, () -> {
            throw new ClienteException("Erro ao processar a Fila Comercial");
        });
    }

    @Test
    public void testFilaComercialExceptionComMensagemECausa() {
        assertThrows(ClienteException.class, () -> {
            throw new ClienteException("Erro ao processar a Fila Comercial", new RuntimeException("Causa do erro"));
        });
    }
}
