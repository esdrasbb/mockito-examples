package org.uni7.pos.general;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

//A partir do Junit 4 podemos utilizar um Runner para instanciar nossos mocks
@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class MockitoGeneralTestPart3 {

	@SuppressWarnings("rawtypes")
	@Mock
	private List mockedList;
	
	@SuppressWarnings("rawtypes")
	@Mock 
	private Map mockedMap;	
	
	//Podemos verificar se determinado método
	//de um objeto mockado foi chamado um determinado número de vezes
	@SuppressWarnings("unchecked")
	@Test
	public void usoVerifyTest(){
		
		mockedList.add(0);
		mockedList.add(1);
		verify(mockedList, atLeast(2)).add(anyInt());	
		
		mockedList.get(5);
		mockedList.get(5);
		mockedList.get(5);
		verify(mockedList, times(3)).get(5);
		
		verify(mockedList, never()).get(10);
		
		mockedMap.get("string");
		verify(mockedMap, atLeastOnce()).get("string");
		
		mockedMap.get("string");
		mockedMap.get("string");
		verify(mockedMap, atMost(5)).get("string");

	}

	//Podemos verificar se os métodos de um objeto mockado  
	//são chamados em determinada ordem
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void usoInOrderTest1(){
		
		List singleMock = mock(List.class);

		singleMock.add("fui adicionado primeiro");
		singleMock.add("fui adicionado segundo");

		InOrder inOrder = inOrder(singleMock);
		inOrder.verify(singleMock).add("fui adicionado primeiro");
		inOrder.verify(singleMock).add("fui adicionado segundo");

	}
	
	//Podemos verificar se os métodos 2 ou mais objetos mockados  
	//são chamados em determinada ordem
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void usoInOrderTest2(){

		List firstMock = mock(List.class);
		List secondMock = mock(List.class);

		firstMock.add("fui adicionado primeiro");
		secondMock.add("fui adicionado segundo");

		InOrder inOrder = inOrder(firstMock, secondMock);

		inOrder.verify(firstMock).add("fui adicionado primeiro");
		inOrder.verify(secondMock).add("fui adicionado segundo");

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void verifyMockInteractions1(){

		List mockOne = mock(List.class);
		List mockTwo = mock(List.class);
		List mockThree = mock(List.class);

		mockOne.add("one");
		
		verify(mockOne).add("one");
		verify(mockOne, never()).add("two");
		verifyZeroInteractions(mockTwo, mockThree);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void verifyMockInteractions2(){

		mockedList.add("one");
		mockedList.add("two");

		verify(mockedList).add("one");
		verify(mockedList).add("two");
		verifyNoMoreInteractions(mockedList);
	}

}
