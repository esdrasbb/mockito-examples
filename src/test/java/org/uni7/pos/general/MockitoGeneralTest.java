package org.uni7.pos.general;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SuppressWarnings("unchecked")
public class MockitoGeneralTest {

    //Alguns comandos do Mockito na prática!!!
    // Fluent interface
	
    @Test
    public void usoVerify() {
        List mockedList = mock(List.class);
        mockedList.add("um");
        mockedList.add("dois");
        mockedList.add("dois");
        mockedList.clear();

        verify(mockedList).add("um");
        verify(mockedList).clear();

        //fluent interface
        verify(mockedList, never()).size(); //never called
        verify(mockedList, atLeastOnce()).clear(); //called at least once
        verify(mockedList, atLeast(2)).add("dois"); //called at least twice
        verify(mockedList, times(2)).add("dois"); //called two times;
        verify(mockedList, atMost(1)).add("um"); //called at most 3 times
    }

    @Test
    public void usoStub() {
        List mockedList = mock(List.class);

        when(mockedList.get(0)).thenReturn("primeirão");

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(999)); //mas cadê o IndexOutOfBoundsException???
    }

    @Test
    public void usoSpy() {

        //Deve tomar cuidado e usar preferencialmente com código legado
        List list = new LinkedList();
        List spy = spy(list);

        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));

        System.out.println(spy.size());

        verify(spy).add("one");
        verify(spy).add("two");
        verify(spy, times(1)).size();
    }

    @Test
    public void pegadinhaUsoSpy() {

        List list = new LinkedList();
        List spy = spy(list);

        when(spy.get(0)).thenReturn("foo");
        System.out.println(spy.get(0));

//        doReturn("foo").when(spy).get(0);
//        System.out.println(spy.get(0));
    }

    @Test
    public void usoAny() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        assertEquals(-1, c.compareTo(9));
    }

    @Test
    public void usoIsA() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(isA(String.class))).thenReturn(100);

        assertEquals(c.compareTo("STRING_QQ"), c.compareTo("QQ_OUTRA_STRING"));
    }

    @Test //(expected = IOException.class)
    public void usoDoThrow() throws IOException {
        OutputStream mockStream = mock(OutputStream.class);
        doThrow(new IOException()).when(mockStream).close();

        OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);
        streamWriter.close();
    }
}
