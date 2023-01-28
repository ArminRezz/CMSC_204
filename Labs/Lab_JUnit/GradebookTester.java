import org.junit.*;
import static org.junit.Assert.*;

public class GradebookTester {
    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp() {
        g1 = new GradeBook(5);
        g1.addScore(50);
        g1.addScore(75);
        
        g2 = new GradeBook(5);
        g2.addScore(60);
        g2.addScore(80);
    }

    @After
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    @Test
    public void addScoreTest() {
        assertTrue(g1.addScore(90));
        assertEquals("50.0 75.0 90.0 ", g1.toString());
        assertEquals(3, g1.getScoreSize());
        
        assertTrue(g2.addScore(100));
        assertEquals("60.0 80.0 100.0 ", g2.toString());
        assertEquals(3, g2.getScoreSize());
    }

    @Test
    public void testSum() {
        assertEquals(125, g1.sum(), .0001);
        assertEquals(140, g2.sum(), .0001);
    }

    @Test
    public void testMinimum() {
        assertEquals(50, g1.minimum(), .001);
        assertEquals(60, g2.minimum(), .001);
    }

    @Test
    public void testFinalScore() {
        assertEquals(75, g1.finalScore(), .0001);
        assertEquals(80, g2.finalScore(), .0001);
    }
}
