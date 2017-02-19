package org.uni7.pos.primeiro.service.impl;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.uni7.pos.primeiro.bean.Item;
import org.uni7.pos.primeiro.bean.Pedido;
import org.uni7.pos.primeiro.dao.Dao;
import org.uni7.pos.primeiro.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {

    private Dao dao;

    public PedidoServiceImpl(Dao dao) {
        this.dao = dao;
    }

    public boolean temEstoque(Item item, int quantidadeDesejada) {
        boolean retorno = Boolean.FALSE;

        if (dao.saldo(item) >= quantidadeDesejada){
            retorno = Boolean.TRUE;
        }

        return retorno;
    }

    public boolean efetuar(Pedido pedido) {
        boolean retorno = Boolean.FALSE;

        if (validar(pedido)) {
            retorno = processar(pedido);
        }

        return retorno;
    }

    private boolean validar(Pedido pedido) {
        boolean retorno = Boolean.FALSE;

        if (pedido != null && pedido.getData() != null && CollectionUtils.isNotEmpty(pedido.getItens())) {
            retorno = pedido.getItens().stream().allMatch(i -> StringUtils.isNotBlank(i.getNome())
                    && i.getQuantidade() > 0);
        }

        return retorno;
    }

    private boolean processar(Pedido pedido) {
        return dao.salvar(pedido);
    }
}
