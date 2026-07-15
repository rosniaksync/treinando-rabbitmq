package microsservico.processamento.consumer;

import microsservico.processamento.dto.PedidoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProcessamentoConsumer {

    @RabbitListener(queues = "${broker.queue.processamento.name}")
    public void listenerProcessamentoQueue(PedidoDto pedidoDto) {
        System.out.println(pedidoDto.getDescricao());
    }
}
