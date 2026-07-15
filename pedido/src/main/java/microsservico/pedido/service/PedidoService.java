package microsservico.pedido.service;

import microsservico.pedido.model.ItemPedido;
import microsservico.pedido.model.Pedido;
import microsservico.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido salvarPedido(Pedido pedido) {

        if(pedido.getItens() != null) {
            for (ItemPedido itens : pedido.getItens()) {
                itens.setPedido(pedido);
            }
        }

        return repository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return repository.findAll();
    }
}
