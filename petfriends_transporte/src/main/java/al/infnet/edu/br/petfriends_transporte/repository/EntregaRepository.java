package al.infnet.edu.br.petfriends_transporte.repository;

import al.infnet.edu.br.petfriends_transporte.domain.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    List<Entrega> findByCodigoPedido(String codigoPedido);

}
