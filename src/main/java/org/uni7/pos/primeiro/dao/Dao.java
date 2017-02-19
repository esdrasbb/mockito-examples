package org.uni7.pos.primeiro.dao;


import org.uni7.pos.primeiro.bean.Item;
import org.uni7.pos.primeiro.bean.Pedido;

public interface Dao {

    boolean salvar(Pedido pedido);

    int saldo(Item item);
}
