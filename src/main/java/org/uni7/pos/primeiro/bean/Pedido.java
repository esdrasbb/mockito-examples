package org.uni7.pos.primeiro.bean;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collection;
import java.util.Date;

public class Pedido {

    private Date data;
    private Collection<Item> itens;

    public Pedido(Date data, Collection<Item> itens) {
        this.data = data;
        this.itens = itens;
    }

    public Date getData() {
        return data;
    }

    public Collection<Item> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
