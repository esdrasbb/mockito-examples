package org.uni7.pos.primeiro.bean;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class Item {

    private String nome;
    private int quantidade;

    public Item(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
