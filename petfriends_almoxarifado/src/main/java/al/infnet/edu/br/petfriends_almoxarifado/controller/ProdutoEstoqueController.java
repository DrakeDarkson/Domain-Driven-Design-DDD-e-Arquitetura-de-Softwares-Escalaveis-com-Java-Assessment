package al.infnet.edu.br.petfriends_almoxarifado.controller;

import al.infnet.edu.br.petfriends_almoxarifado.domain.ProdutoEstoque;
import al.infnet.edu.br.petfriends_almoxarifado.repository.ProdutoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoque")
public class ProdutoEstoqueController {

    @Autowired
    private ProdutoEstoqueRepository produtoEstoqueRepository;

    @GetMapping
    public List<ProdutoEstoque> listarTodos() {
        return produtoEstoqueRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Optional<ProdutoEstoque> buscarPorCodigo(@PathVariable String codigo) {
        return produtoEstoqueRepository.findByCodigoProduto(codigo);
    }

    @PostMapping
    public ProdutoEstoque criarProduto(@RequestBody ProdutoEstoque produtoEstoque) {
        return produtoEstoqueRepository.save(produtoEstoque);
    }

    @PutMapping("/{id}")
    public ProdutoEstoque atualizarProduto(@PathVariable Long id, @RequestBody ProdutoEstoque produtoEstoque) {
        produtoEstoque.setId(id);
        return produtoEstoqueRepository.save(produtoEstoque);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoEstoqueRepository.deleteById(id);
    }
}