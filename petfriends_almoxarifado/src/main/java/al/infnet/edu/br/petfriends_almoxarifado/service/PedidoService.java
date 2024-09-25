package al.infnet.edu.br.petfriends_almoxarifado.service;

import al.infnet.edu.br.eventlibrary.events.PedidoCriadoEvent;
import al.infnet.edu.br.petfriends_almoxarifado.domain.ProdutoEstoque;
import al.infnet.edu.br.petfriends_almoxarifado.repository.ProdutoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private ProdutoEstoqueRepository produtoEstoqueRepository;

    public void processarPedidoCriado(PedidoCriadoEvent pedidoCriadoEvent) {
        String codigoProduto = pedidoCriadoEvent.getCodigoProduto();
        int quantidade = pedidoCriadoEvent.getQuantidade();

        Optional<ProdutoEstoque> produtoEstoqueOpt = produtoEstoqueRepository.findByCodigoProduto(codigoProduto);
        if (produtoEstoqueOpt.isPresent()) {
            ProdutoEstoque produtoEstoque = produtoEstoqueOpt.get();
            produtoEstoque.setQuantidade(produtoEstoque.getQuantidade() - quantidade);
            produtoEstoqueRepository.save(produtoEstoque);
            System.out.println("Estoque atualizado para o produto: " + codigoProduto);
        } else {
            System.out.println("Produto não encontrado no estoque: " + codigoProduto);
        }
    }
}

