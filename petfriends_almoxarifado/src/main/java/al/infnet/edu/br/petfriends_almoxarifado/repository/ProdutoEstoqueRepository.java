package al.infnet.edu.br.petfriends_almoxarifado.repository;

import al.infnet.edu.br.petfriends_almoxarifado.domain.ProdutoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque, Long> {

    Optional<ProdutoEstoque> findByCodigoProduto(String codigoProduto);

}