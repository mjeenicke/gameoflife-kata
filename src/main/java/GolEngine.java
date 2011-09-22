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
        applyRuleOne(i, j);
      }
    }
    state = next;
  }

  private void applyRuleOne(int i, int j) {
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
    if (counter >= 2) {
      next[i][j] = state[i][j];
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
