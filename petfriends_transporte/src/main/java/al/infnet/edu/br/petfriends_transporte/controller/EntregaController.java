package al.infnet.edu.br.petfriends_transporte.controller;

import al.infnet.edu.br.petfriends_transporte.domain.Entrega;
import al.infnet.edu.br.petfriends_transporte.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaRepository entregaRepository;

    @GetMapping
    public List<Entrega> listarTodas() {
        return entregaRepository.findAll();
    }

    @GetMapping("/{codigoPedido}")
    public List<Entrega> buscarPorCodigoPedido(@PathVariable String codigoPedido) {
        return entregaRepository.findByCodigoPedido(codigoPedido);
    }

    @PostMapping
    public Entrega criarEntrega(@RequestBody Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    @PutMapping("/{id}")
    public Entrega atualizarEntrega(@PathVariable Long id, @RequestBody Entrega entrega) {
        entrega.setId(id);
        return entregaRepository.save(entrega);
    }

    @DeleteMapping("/{id}")
    public void deletarEntrega(@PathVariable Long id) {
        entregaRepository.deleteById(id);
    }
}
