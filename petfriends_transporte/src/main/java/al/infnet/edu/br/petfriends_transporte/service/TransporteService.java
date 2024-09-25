package al.infnet.edu.br.petfriends_transporte.service;

import al.infnet.edu.br.eventlibrary.events.PedidoDespachadoEvent;
import org.springframework.stereotype.Service;

@Service
public class TransporteService {

    public void processarPedidoDespachado(PedidoDespachadoEvent pedidoDespachadoEvent) {
        System.out.println("Pedido despachado recebido: " + pedidoDespachadoEvent);
    }
}
