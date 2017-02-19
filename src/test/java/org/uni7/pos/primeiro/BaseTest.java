package org.uni7.pos.primeiro;

import org.uni7.pos.primeiro.bean.Item;
import org.uni7.pos.primeiro.bean.Pedido;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class BaseTest {

    public Pedido criaPedidoValido() {
        return new Pedido(new Date(), criaListaItensValida());
    }

    public Pedido criaPedidoInvalido() {
        return new Pedido(new Date(), criaListaItensInvalida());
    }

    private Collection<Item> criaListaItensValida() {
        Collection<Item> itens = new ArrayList<>(3);
        itens.add(new Item("Item A", 100));
        itens.add(new Item("Item B", 150));
        itens.add(new Item("Item C", 500));
        return itens;
    }

    private Collection<Item> criaListaItensInvalida() {
        return Collections.emptyList();
    }
}
