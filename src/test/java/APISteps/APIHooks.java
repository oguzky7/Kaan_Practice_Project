package APISteps;

//import org.junit.After;
//import org.junit.Before;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class APIHooks {
    @Before
    public static void beforeAPI(){
        System.out.println("API before method hook");
    }

    @After
    public static void afterAPI(){
        System.out.println("API after method hook");
    }
}
