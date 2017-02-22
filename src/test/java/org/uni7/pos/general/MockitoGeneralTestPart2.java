package org.uni7.pos.general;

import static org.mockito.AdditionalMatchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.uni7.pos.util.ReturnValuesExample;
import org.uni7.pos.util.SimpleBusinessService;

public class MockitoGeneralTestPart2 {

	@SuppressWarnings("rawtypes")
	//Tamb�m podemos utilizar a anota��o @Mock para "mockar"
	//uma interface ou classe. Mas h� um por�m....
	@Mock
	private List mockedList; 
	
	@SuppressWarnings("rawtypes")
	@Mock
	private Map mockedMap; 

	//O por�m � que devemos ter um m�todo com anota��o @Before do JUnit
	//para inicializar todos os mocks criados com anota��es
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}

	//O objetivo desse m�todo � mostrar quais s�o os valores de retornos
	//padr�es para um objeto mockado
	@Test	
	public void valoresDefaultParaRetornoTest(){
		
		System.out.println("===Teste de Valores de retorno Default====");
		
		ReturnValuesExample returnValues = mock (ReturnValuesExample.class);
		
		System.out.println("Boolean:  " + returnValues.isBooleano());
		System.out.println("Inteiro:  " + returnValues.getInteiro());
		System.out.println("Long:  " + returnValues.getInteiroLongo());
		System.out.println("Double:  " + returnValues.getDecimal());
		System.out.println("Boolean Wrapper:  " + returnValues.getBooleanoWrapper());
		System.out.println("Inteiro Wrapper:  " + returnValues.getInteiroWrapper());
		System.out.println("Long Wrapper:  " + returnValues.getInteiroLongoWrapper());
		System.out.println("Double Wrapper:  " + returnValues.getDecimalWrapper());
		System.out.println("Lista:  " + returnValues.getLista());
		System.out.println("Object:  " + returnValues.getBusinessService());
		
		System.out.println("============================");
		System.out.println();
	}

	//Os Argument Matchers s�o utilizados como curingas
	//para os argumentos de m�todos que ser�o mocados
	@Test
	public void argumentMatchersTest() {

		System.out.println("===Teste de Argument Matchers ====");
		
		//Se o m�todo mockedMap.get() foi chamado com qualquer valor inteiro
		//o retorno ser� "chave inteira"
		when(mockedMap.get(anyInt())).thenReturn("chave inteira");
		System.out.println("Elemento 5: " + mockedMap.get(5));
		System.out.println("Elemento 99: " + mockedMap.get(99));

		//Tamb�m existem matchers para os outros tipos b�sicos
		when(mockedMap.get(anyBoolean())).thenReturn("chave boolean");
		System.out.println("Map Chave true: " + mockedMap.get(true));
		
		when(mockedMap.get(anyDouble())).thenReturn("chave double");
		System.out.println("Map Chave double: " + mockedMap.get((Double)1.2));
		
		when(mockedMap.get(anyString())).thenReturn("chave string");
		System.out.println("Map Chave string: " + mockedMap.get("string"));
		
		when(mockedMap.get(anyList())).thenReturn("chave lista");
		System.out.println("Map Chave lista: " + mockedMap.get(Arrays.asList(1,2,3)));
		
		when(mockedMap.get(isNull())).thenReturn("chave nula");
		System.out.println("Map Chave null: " + mockedMap.get(null));

		//Existem alguns matchers espec�ficos para Strings
		when(mockedMap.get(contains("mockito"))).thenReturn("chave cont�m string mockito");
		System.out.println("Map Chave mockito: " + mockedMap.get("lib mockito � interessante"));
		when(mockedMap.get(startsWith("mockito"))).thenReturn("chave inicia mockito");
		when(mockedMap.get(endsWith("mockito"))).thenReturn("chave finaliza mockito");
		
		//Matcher para obejtos de uma classe
		when(mockedMap.get(isA(SimpleBusinessService.class))).thenReturn("chave SimpleBusinessService");
		System.out.println("Map Chave SimpleBusinessService: " + mockedMap.get(new SimpleBusinessService()));
		
		//Matcher com express�es booleans
		when(mockedMap.get(or(eq(1), eq(3)))).thenReturn("chave 1 ou 3");
		System.out.println("Map Chave 1: " + mockedMap.get(1));
		System.out.println("Map Chave 2: " + mockedMap.get(2));
		System.out.println("Map Chave 3: " + mockedMap.get(3));
		
		System.out.println("============================");
		System.out.println();

	}

	//Tamb�m podemos criar Matchers de argumentos personalizados	
	//utilizando a fun��o argThat
	@Test
	public void argumentMatchersPersonalizadoTest() {

		System.out.println("===Teste de Argument Matchers Personalizado ====");
		
		//A primeira forma � criar uma classe que implementa a 
		//interface ArgumentMatcher
		when(mockedList.contains(argThat(new ArgumentMatcher<Integer>() {
			@Override
			public boolean matches(Integer arg0) {
				if(arg0!=null && arg0.intValue() > 10) {
					return true;
				}
				return false;
			}			
		}))).thenReturn(true);

		System.out.println("Lista cont�m chave 5: " + mockedList.contains(5));
		System.out.println("Lista cont�m chave 15: " + mockedList.contains(15));

		//A partir do Java 8 tamb�m podemos utilizar lambdas
		when(mockedMap.get(argThat(someInteger -> ((Integer) someInteger).intValue() % 2 == 0)))
				.thenReturn("n�mero par");

		System.out.println("Elemento 2 do map: " + mockedMap.get(2));
		System.out.println("Elemento 3 do map: " + mockedMap.get(3));
		System.out.println("Elemento 4 do map: " + mockedMap.get(4));

		System.out.println("============================");
		System.out.println();

	}

}
