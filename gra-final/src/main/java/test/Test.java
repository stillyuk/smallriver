package test;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;

public class Test {

	public static void main(String... args) {
		A a = mock(A.class);
//		when(a.getA()).thenReturn(10);
		System.out.println(a.getA());
		Mockito.verify(a).getA();
	}

}
