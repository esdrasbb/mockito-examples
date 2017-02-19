package org.uni7.pos.primeiro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.uni7.pos.primeiro.bean.Item;
import org.uni7.pos.primeiro.bean.Pedido;
import org.uni7.pos.primeiro.dao.Dao;
import org.uni7.pos.primeiro.service.PedidoService;
import org.uni7.pos.primeiro.service.impl.PedidoServiceImpl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceTest extends BaseTest {

    @Mock
    private Dao dao;

    @Test
    public void salvarPedidoComSucesso() {
        Pedido pedido = this.criaPedidoValido();
        when(dao.salvar(pedido)).thenReturn(Boolean.TRUE);

        PedidoService pedidoService = new PedidoServiceImpl(dao);

        assertTrue(pedidoService.efetuar(pedido));

        //verificando se o método salvar foi chamado no stub
        verify(dao, times(1)).salvar(pedido);
    }

    @Test
    public void temEstoqueComSucesso() {
        PedidoService pedidoService = new PedidoServiceImpl(dao);
        Item item = new Item("Item A", 0);
        when(dao.saldo(item)).thenReturn(100);

        assertTrue(pedidoService.temEstoque(item, 50));

        //verificando se somente o método saldo foi chamado no stub
        verify(dao, times(1)).saldo(item);
        verify(dao, times(0)).salvar(this.criaPedidoValido());
    }
}
