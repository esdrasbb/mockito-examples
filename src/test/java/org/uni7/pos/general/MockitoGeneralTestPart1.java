package org.uni7.pos.general;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

@SuppressWarnings("rawtypes")
public class MockitoGeneralTestPart1 {

	@Test
	public void mockInterfaceTest(){
		//Podemos fazer mock de uma interface
		List mockedInterfaceList = mock(List.class);

		//Quais quer métodos da Interface podem ser invocados
		mockedInterfaceList.add("elemento 1");
		mockedInterfaceList.clear();

		//A função verify é utilizado para garantir(verificar) que determinado
		//método do objeto mockado foi chamado
		verify(mockedInterfaceList).add("elemento 1");
		verify(mockedInterfaceList).clear();
	}

	@Test
	public void mockConcreteClassTest(){

		//Também podemos mockar uma classe concreta
		LinkedList mockedLinkedList = mock(LinkedList.class);

		//Utilizamos a função para alterar o retorno de um método
		//do objeto mockado
		when(mockedLinkedList.get(0)).thenReturn("Primeiro Elemento");

		System.out.println(mockedLinkedList.get(0));
		System.out.println(mockedLinkedList.get(999)); //O que acontece?

		verify(mockedLinkedList).get(0);
	}

	@Test(expected=RuntimeException.class)
	public void mockExceptionTest1(){

		List mockedList = mock(List.class);

		//Também podemos utilizar a função when para lançar uma exceção
		//ao chamar um método do objeto mockado
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		System.out.println(mockedList.get(1));

	}

	@Test(expected = RuntimeException.class)
	public void mockExceptionTest2() {

		List mockedList = mock(List.class);

		//A função doThrow também pode utilizada para lançar uma
		//exceção quando um método do objeto mockado é invocado
		//Deve ser usado para métodos com retorno void
		doThrow(new RuntimeException()).when(mockedList).clear();
		mockedList.clear();

	}
}
