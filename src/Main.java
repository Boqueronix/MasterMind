import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static Color[] colors = new Color[]{Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
    public static ArrayList<ArrayList<Color>> attempts = new ArrayList<>(1);
    public static ArrayList<Color> answer = new ArrayList<>(6);
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            answer.add(Color.RED);
        }
        attempts.add(new ArrayList<>(1));
        Board.init();
    }
}