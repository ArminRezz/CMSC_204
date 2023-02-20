import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyQueueTestStudent {
	public MyQueue<String> stringQ;
	public String a = "a", b = "b", c = "c", d = "d", e = "e", f = "f";

	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests

	@BeforeEach
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);

		// STUDENT: add setup for doubleQ for student tests
		doubleQ = new MyQueue<Double>(5);
		doubleQ.enqueue(1.1);
		doubleQ.enqueue(2.2);
		doubleQ.enqueue(3.3);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false, stringQ.isEmpty());
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			// Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		} catch (QueueUnderflowException e) {
			assertTrue("This should have caused an QueueUnderflowException", true);
		} catch (Exception e) {
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
}
