package al.infnet.edu.br.eventlibrary.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDespachadoEvent {
    private Long pedidoId;            // ID do pedido
    private String codigoProduto;     // Código do produto
    private int quantidade;           // Quantidade despachada
    private String clienteNome;       // Nome do cliente
    private String enderecoEntrega;   // Endereço de entrega
    private LocalDateTime dataDespacho; // Data e hora do despacho
    private String transportadora;    // Informações sobre a transportadora
}
