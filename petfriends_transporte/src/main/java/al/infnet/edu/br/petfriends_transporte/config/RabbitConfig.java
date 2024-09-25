package al.infnet.edu.br.petfriends_transporte.config;

import al.infnet.edu.br.eventlibrary.events.PedidoDespachadoEvent;
import al.infnet.edu.br.petfriends_transporte.service.TransporteService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfig {

    public static final String QUEUE_NAME = "pedidos.despachados.queue"; // Nome da fila

    @Bean
    public Queue pedidosDespachadosQueue() {
        return new Queue(QUEUE_NAME, true); // Criação da fila
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory); // Criação do RabbitTemplate
    }

    @Autowired
    private TransporteService transporteService; // Injetando o serviço

    @RabbitListener(queues = QUEUE_NAME) // Listener para a fila
    public void receiveMessage(PedidoDespachadoEvent pedidoDespachadoEvent) {
        transporteService.processarPedidoDespachado(pedidoDespachadoEvent);
    }
}
