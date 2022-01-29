package pa3.tests;
import org.junit.Test;
import static org.junit.Assert.*;
import com.gradescope.jh61b.grader.GradedTest;
import java.util.*;
import org.junit.Before;
import pa3.*;

public class TestCoins {
   private Coins c1, c2;
   private int howMany1 = -1, howMany2 = -1;

   @Before
    public void createCoins()
    {	
	c1 = new Coins("test_cases/coins.txt");
	c2 = new Coins("test_cases/coins2.txt");
	howMany1 = c1.makeChange();
	howMany2 = c2.makeChange();
    }

    @Test
    @GradedTest(name="Test coins example 1", max_score=4)
    public void test_140_cents() {
 	assertEquals("140 cents error!", 2,howMany1);
    }

    @Test
    @GradedTest(name="Test coins example 2", max_score=4)
    public void test_140_70_cents() {
	int howmany = c1.howMany(70);
 	assertEquals("70 cents coin error!", 2,howmany);
    }
   
   @Test
    @GradedTest(name="Test coins example 3", max_score=4)
    public void test_140_34_cents() {
	int howmany = c1.howMany(34);
 	assertEquals("34 cents coin error!", 0,howmany);
    }
   
 
      @Test
    @GradedTest(name="Test coins example 4", max_score=4)
    public void test_63_cents() {
 	assertEquals("63 cents error!", 6,howMany2);
    }

    @Test
    @GradedTest(name="Test coins example 5", max_score=4)
    public void test_63_1_cents() {
	int howmany = c2.howMany(1);
 	assertEquals("1 cents coin error!", 3,howmany);
    }
   
   @Test
    @GradedTest(name="Test coins example 6", max_score=4)
    public void test_63_25_cents() {
	int howmany = c2.howMany(25);
 	assertEquals("25 cents coin error!", 2 ,howmany);
    }
   
}
