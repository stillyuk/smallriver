package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Iterator;

import org.junit.Test;

@SuppressWarnings("rawtypes")
public class MockitoTest {
	@Test
	public void testSimple() {
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		String result = i.next() + " " + i.next();
		verify(i, times(2)).next();
		assertEquals("Hello World", result);
	}
}
