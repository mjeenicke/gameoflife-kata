import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: martti
 * Date: 15.09.11
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
public class GolEngineTest {


  private GolEngine engine;
  private boolean[][] startMatrix = {
          {false, false, false, false, false},
          {false, true, false, false, true},
          {false, false, false, true, false},
          {false, false, false, true, true},
          {true, true, false, false, false}
  };

  private boolean[][] expectedMatrix = {
          {false, false, false, false, false},
          {false, false, false, false, false},
          {false, false, true, true, false},
          {false, false, true, true, true},
          {false, false, false, false, false}
  };

  @Before
  public void setUp() {
    engine = new GolEngine();
  }

  @After
  public void tearDown() {
    engine = null;
  }

  @Test
  public void testFirstAndSecondRule() {

    engine.init(startMatrix);
    System.out.println("vorher:");
    engine.printState();
    engine.next();
    System.out.println("nacher");
    engine.printState();
    assertTrue(compare(expectedMatrix, engine.getStatus()));

  }

  private boolean compare(boolean[][] matrixA, boolean[][] matrixB) {
    if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
      return false;
    }
    for (int i = 0; i < matrixA.length; i++) {
      boolean[] booleans = matrixA[i];
      if (!Arrays.equals(matrixA[i], matrixB[i])) {
        return false;
      }
    }
    return true;

  }

}
