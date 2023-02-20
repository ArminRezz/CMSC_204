import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyStackStudentTest {
    public MyStack < String > stringS;
    public String a = "a", b = "b", c = "c", d = "d", e = "e", f = "f";
    public ArrayList < String > fill = new ArrayList < String > ();
    // STUDENT: student tests will use the doubleS
    public MyStack < Double > doubleS;
    public Double aa = 1.0, bb = 2.0, cc = 3.0, dd = 4.0, ee = 5.0, ff = 6.0;
    public ArrayList < Double > filld = new ArrayList < Double > ();

    @BeforeEach
    public void setUp() throws Exception {
        stringS = new MyStack < String > (5);
        stringS.push(a);
        stringS.push(b);
        stringS.push(c);

        doubleS = new MyStack < Double > (5);
        doubleS.push(aa);
        doubleS.push(bb);
        doubleS.push(cc);
    }

    @AfterEach
    public void tearDown() throws Exception {
        stringS = null;
        doubleS = null;
    }

    @Test
    public void testIsEmpty() {
        assertEquals(false, stringS.isEmpty());
        try {
            stringS.pop();
        } catch (StackUnderflowException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            stringS.pop();
        } catch (StackUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            stringS.pop();
        } catch (StackUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(true, stringS.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertEquals(false, stringS.isFull());
        try {
            stringS.push(d);
        } catch (StackOverflowException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            stringS.push(e);
        } catch (StackOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(true, stringS.isFull());
    }

    @Test
    public void testPush() {
        try {
            stringS.push(d);
        } catch (StackOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
			assertEquals(d, stringS.top());
		} catch (StackUnderflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
            doubleS.push(dd);
        } catch (StackOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
			assertEquals(dd, doubleS.top());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    public void testPop() {
        try {
            assertEquals(c, stringS.pop());
        } catch (StackUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            assertEquals(cc, doubleS.pop());
        } catch (StackUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testTop() {
        try {
			assertEquals(c, stringS.top());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			assertEquals(cc, doubleS.top());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}