package practice.problemSolving.recursion;

/**
 * Implement the "paint fill" function that one might see on many image editing
 * programs. That is, given a screen (represented by a two-dimensional array of colors),
 * a point, and a new color, fill in the surrounding area until the color changes from the
 * original color.
 *
 * @author Yashraj R. Sontakke
 */
public class PaintScreen_9_7 {
    public enum Color {
        BLACK, WHITE, BLUE, RED;
    }

    public void paintScreen(Color[][] screen, int x, int y, Color newColor) {
        if (screen[x][y] != newColor) {
            paintScreen(screen, x, y, screen[x][y], newColor);
        }
    }

    public void paintScreen(Color[][] screen, int x, int y, Color oldColor, Color newColor) {
        if (x < 0 || x >= screen.length || y < 0 || y >= screen.length) {
            return;
        }
        if (screen[x][y] == oldColor) {
            screen[x][y] = newColor;
            paintScreen(screen, x - 1, y, oldColor, newColor);
            paintScreen(screen, x + 1, y, oldColor, newColor);
            paintScreen(screen, x, y - 1, oldColor, newColor);
            paintScreen(screen, x, y + 1, oldColor, newColor);
        }
    }

    public static void main(String[] args) {
        Color[][] screen = new Color[3][3];
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen.length; j++) {
                screen[i][j] = Color.RED;
            }
        }
        PaintScreen_9_7 paintScreen = new PaintScreen_9_7();
        paintScreen.paintScreen(screen, 0, 0, Color.BLUE);

        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen.length; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}
