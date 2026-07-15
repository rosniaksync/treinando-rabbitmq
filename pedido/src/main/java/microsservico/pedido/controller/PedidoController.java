package microsservico.pedido.controller;

import microsservico.pedido.model.Pedido;
import microsservico.pedido.service.PedidoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RabbitTemplate rabbitTemplate;
    private final PedidoService service;

    public PedidoController(RabbitTemplate rabbitTemplate, PedidoService service) {
        this.rabbitTemplate = rabbitTemplate;
        this.service = service;
    }

    @Value("${broker.queue.processamento.name}")
    private String routingKey;

    @PostMapping
    public String criarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = service.salvarPedido(pedido);
        rabbitTemplate.convertAndSend("", routingKey, pedidoSalvo);
        return "Pedido salvo e enviado e enviado para processamento: "+pedido.getDescricao();
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return service.listarPedidos();
    }
}