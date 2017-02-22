package org.uni7.pos.general;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class MockitoGeneralTestPart4 {

	/*
	 * No mockito também podemos utilizar "Mocks Parciais"
	 * São usados quando desejamos mockar apenas algum(ns) métodos
	 * de determinada classe
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void spyObjectsTest() {
		
		List list = new LinkedList();
		List spy = spy(list);

		when(spy.size()).thenReturn(100);

		// usando o spy os métodos reais são invocados
		spy.add("one");
		spy.add("two");

		System.out.println(spy.get(0));
		System.out.println(spy.size());

		verify(spy).add("one");
		verify(spy).add("two");

		// IndexOutOfBoundsException, pois o método real é chamado
		//when(spy.get(2)).thenReturn("foo");

		// Devemos utilizar doReturn() para mockar
		doReturn("foo").when(spy).get(2);
		System.out.println(spy.get(2));
	}

}
