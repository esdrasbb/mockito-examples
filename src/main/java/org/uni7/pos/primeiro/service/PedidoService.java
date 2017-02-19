package org.uni7.pos.primeiro.service;

import org.uni7.pos.primeiro.bean.Item;
import org.uni7.pos.primeiro.bean.Pedido;

public interface PedidoService {

    boolean temEstoque(Item item, int quantidadeDesejada);

    boolean efetuar(Pedido pedido);
}
