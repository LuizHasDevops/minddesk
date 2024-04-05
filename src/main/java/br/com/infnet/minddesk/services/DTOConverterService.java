package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.Agente;
import br.com.infnet.minddesk.model.Categoria;
import br.com.infnet.minddesk.model.Cliente;
import br.com.infnet.minddesk.model.Solicitacao;
import org.springframework.stereotype.Service;

@Service
public class DTOConverterService {

    public Solicitacao converterParaSolicitacaoDTO(Solicitacao solicitacaoDTO) {


        Categoria categoria = new Categoria();
        categoria.setId(solicitacaoDTO.getCategoria().getId());
        categoria.setNome(solicitacaoDTO.getCategoria().getNome());
        categoria.setDescricao(solicitacaoDTO.getCategoria().getDescricao());

        Cliente cliente = new Cliente();
        cliente.setId(solicitacaoDTO.getCliente().getId());
        cliente.setNome(solicitacaoDTO.getCliente().getNome());
        cliente.setEmail(solicitacaoDTO.getCliente().getEmail());
        cliente.setTelefone(solicitacaoDTO.getCliente().getTelefone());

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setTexto(solicitacaoDTO.getTexto());
        solicitacao.setUrgencia(solicitacaoDTO.getUrgencia());
        solicitacao.setDescricao(solicitacaoDTO.getDescricao());


        solicitacao.setCategoria(categoria);


        return solicitacao;
    }
}
