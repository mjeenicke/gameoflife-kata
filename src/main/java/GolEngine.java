/**
 * Created by IntelliJ IDEA.
 * User: martti
 * Date: 15.09.11
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
public class GolEngine {

  private boolean[][] state;
  private boolean[][] next;

  public void init(boolean[][] startMatrix) {
    state = startMatrix;
    next = new boolean[state.length][state[0].length];
  }

  public void next() {
    for (int i = 0; i < state.length; i++) {
      boolean[] rows = state[i];
      for (int j = 0; j < rows.length; j++) {
        applyRules(i, j);
      }
    }
    state = next;
  }

  /*
     Rule 1: Any live cell with fewer than two live neighbours dies,
   as if caused by underpopulation.
     Rule 2; Any live cell with more than three live neighbours dies,
   as if by overcrowding.
     Rule 3. Any live cell with two or three live neighbours lives on
   to the next generation.
     Rule 4. Any dead cell with exactly three live neighbours becomes
   a live cell.
   */
  private void applyRules(int i, int j) {
    int counter = 0;
    for (int x = i - 1; x <= i + 1; x++) {
      for (int y = j - 1; y <= j + 1; y++) {
        if (x >= 0 && x < state.length
                && y >= 0 && y < state[x].length
                && (x != i || y != j)) {
          if (state[x][y])
            counter++;
        }
      }
    }
    if (counter >= 2 && counter < 3) {
      next[i][j] = state[i][j];
    } else if (counter == 3){
      next[i][j] = true;
    } else {
      next[i][j] = false;
    }
  }

  public boolean[][] getStatus() {
    return state;
  }

  public void printState() {
    for (boolean[] row : state) {
      for (boolean value : row) {
        if (value)
          System.out.print(" # ");
        else
          System.out.print(" . ");
      }
      System.out.println();
    }
    System.out.println();
  }

}
