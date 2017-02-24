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

		//Quais quer m�todos da Interface podem ser invocados
		mockedInterfaceList.add("elemento 1");
		mockedInterfaceList.clear();

		//A fun��o verify � utilizado para garantir(verificar) que determinado
		//m�todo do objeto mockado foi chamado
		verify(mockedInterfaceList).add("elemento 1");
		verify(mockedInterfaceList).clear();
	}

	@Test
	public void mockConcreteClassTest(){

		//Tamb�m podemos mockar uma classe concreta
		LinkedList mockedLinkedList = mock(LinkedList.class);

		//Utilizamos a fun��o para alterar o retorno de um m�todo
		//do objeto mockado
		when(mockedLinkedList.get(0)).thenReturn("Primeiro Elemento");

		System.out.println(mockedLinkedList.get(0));
		System.out.println(mockedLinkedList.get(999)); //O que acontece?

		verify(mockedLinkedList).get(0);
	}

	@Test(expected=RuntimeException.class)
	public void mockExceptionTest1(){

		List mockedList = mock(List.class);

		//Tamb�m podemos utilizar a fun��o when para lan�ar uma exce��o
		//ao chamar um m�todo do objeto mockado
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		System.out.println(mockedList.get(1));

	}

	@Test(expected = RuntimeException.class)
	public void mockExceptionTest2() {

		List mockedList = mock(List.class);

		//A fun��o doThrow tamb�m pode utilizada para lan�ar uma
		//exce��o quando um m�todo do objeto mockado � invocado
		//Deve ser usado para m�todos com retorno void
		doThrow(new RuntimeException()).when(mockedList).clear();
		mockedList.clear();

	}
}
