package al.infnet.edu.br.petfriends_transporte.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoPedido;
    private String destinatario;

    @Embedded
    private Endereco endereco;

    private String statusEntrega;

    private LocalDateTime dataEnvio;
    private LocalDateTime dataEntregaPrevista;
    private LocalDateTime dataEntregaRealizada;
}
