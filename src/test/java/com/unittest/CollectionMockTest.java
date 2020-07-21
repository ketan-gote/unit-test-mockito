package com.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CollectionMockTest {

	List<String> mockList = mock(List.class);
	
	@Test
	public void simple_Test()
	{
		when(mockList.size()).thenReturn(50);
		assertEquals(50, mockList.size());
	}
	
	@Test
	public void returnDifferentValues_Test()
	{ 
		when(mockList.size()).thenReturn(50).thenReturn(100);
		assertEquals(50, mockList.size());
		assertEquals(100, mockList.size());
	}
	
	@Test
	public void returnWithParam_Test(){
		when(mockList.get(0)).thenReturn("Ketan Gote");
		assertEquals("Ketan Gote", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	@Test
	public void returnWithAnyArg_Test(){
		when(mockList.get(anyInt())).thenReturn("Ketan Gote");
		assertEquals("Ketan Gote", mockList.get(0));
		assertEquals("Ketan Gote", mockList.get(101));
	}
	
	@Test
	public void verificationBasics() {
		String value1 = mockList.get(0);
		String value2 = mockList.get(1);

		verify(mockList).get(0);
		verify(mockList, times(2)).get(anyInt());
		verify(mockList, atLeast(1)).get(anyInt());
		verify(mockList, atLeastOnce()).get(anyInt());
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, never()).get(2);
	}
	
	@Test
	public void spying_Test(){
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test4");
	}
}
