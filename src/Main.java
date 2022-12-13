import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static Color[] colors = new Color[]{Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
    public static ArrayList<ArrayList<Circle>> attempts = new ArrayList<>();
    public static int onIndex = 0;
    public static ArrayList<Circle> answer = new ArrayList<>(6);
    public static boolean mousePressed = false;
    public static boolean gameEnd = false;
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            answer.add(new Circle(colors[(int) (Math.random() * 9)]));
        }
        attempts.add(new ArrayList<>());
        Board.init();
        while (!gameEnd) {
            if (StdDraw.isMousePressed() && !mousePressed) {
                mousePressed = true;
                click(StdDraw.mouseX, StdDraw.mouseY);
            } else if (!StdDraw.isMousePressed() && mousePressed) {
                mousePressed = false;
            }
        }
    }
    public static void click(double x, double y){
        if (y >= 0.15 && y <= 0.23){
            //color
            for (int i = 1; i < 10; i++) {
                if (x >= i / 10.0 - 0.04 && x <= i / 10.0 + 0.04){
                    if (attempts.get(onIndex).size() < 6) {
                        attempts.get(onIndex).add(new Circle(Main.colors[i - 1]));
                        Board.init();
                    }
                    break;
                }
            }
            return;
        }
        if (y >= 0.08 && y <= 0.12) {
            //red buttons
            if (x >= 0.1 && x <= 0.2){
                if (attempts.get(onIndex).size() > 0) {
                    attempts.get(onIndex).remove(attempts.get(onIndex).size() - 1);
                    Board.init();
                }
                return;
            } else if (x >= 0.8 && x <= 0.9) {
                attempts.get(onIndex).clear();
                Board.init();
                return;
            }
        }if (y >= 0.055 && y <= 0.095 && x >= 0.4 && x <= 0.6) {
            //green button
            if (attempts.get(onIndex).size() == 6){
                System.out.println();
                for (int i = 0; i < 6; i++) {
                    if (answer.get(i).color == attempts.get(onIndex).get(i).color){
                        attempts.get(onIndex).get(i).background = new Color(148, 226 ,187);
                        attempts.get(onIndex).get(i).correct = true;
                        answer.get(i).counted = true;
                    }
                }
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (!answer.get(j).counted && answer.get(j).color == attempts.get(onIndex).get(i).color && attempts.get(onIndex).get(i).background == null){
                            attempts.get(onIndex).get(i).background = new Color(252, 245, 152);
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    if (attempts.get(onIndex).get(i).background == null){
                        attempts.get(onIndex).get(i).background = new Color(120, 0, 0);
                    }
                }
                for (int i = 0; i < 6; i++) {
                    answer.get(i).counted = false;
                }
                for (Circle c: attempts.get(onIndex)) {
                    c.submitted = true;
                }
                boolean win = true;
                for (Circle c: attempts.get(onIndex)) {
                    if (!c.correct){
                        win = false;
                        System.out.println("!equals");
                    } else {
                        System.out.println("equals");
                    }
                }
                if (win){
                    gameEnd = true;
                    Board.init();
                    System.out.println("YOU WIN");
                    return;
                }
                attempts.add(new ArrayList<>());
                onIndex++;
                Board.init();
            }
        }
    }
}
class Circle{
    public Color color;
    public boolean submitted;
    public Color background;
    public boolean counted = false;
    public boolean correct = false;
    public Circle(Color c){
        color = c;
        submitted = false;
        background = null;
    }
}