package al.infnet.edu.br.eventlibrary.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoCriadoEvent {
    private Long pedidoId;            // ID do pedido
    private String codigoProduto;     // Código do produto
    private int quantidade;           // Quantidade solicitada
    private String clienteNome;       // Nome do cliente
    private String enderecoEntrega;   // Endereço de entrega
    private LocalDateTime dataCriacao; // Data e hora da criação do pedido
}
