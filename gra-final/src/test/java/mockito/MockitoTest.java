package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Iterator;

import org.junit.Test;

public class MockitoTest {
	@Test
	public void simpleTest() {
		// arrange
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		// act
		String result = i.next() + " " + i.next();
		// verify
		verify(i, times(2)).next();
		// assert
		assertEquals("Hello World", result);
	}

}
