import java.awt.*;

public class Board {
    public static void init() {
        //Background
        StdDraw.setPenColor(14,14,14);
        StdDraw.filledSquare(0.5,0.5,0.5);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(0.5,0.15,0.45,0.1);
        //Selectors
        double pips = Main.colors.length;
        for (int i = 1; i <= pips; i++) {
            StdDraw.setPenColor(Main.colors[i - 1]);
            StdDraw.filledCircle(i * 0.9/pips, 0.19, 0.04);
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.circle(i * 0.9/pips, 0.19, 0.04);
        }
        //buttons
        StdDraw.setPenColor(148, 226 ,187);
        StdDraw.filledRectangle(0.5, 0.075, 0.1, 0.02);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(0.5, 0.075, "SUBMIT");
        StdDraw.setPenColor(249, 84 ,111);
        StdDraw.filledRectangle(0.15, 0.1, 0.05, 0.02);
        StdDraw.filledRectangle(0.85, 0.1, 0.05, 0.02);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(0.15, 0.1, "DEL");
        StdDraw.text(0.85, 0.1, "CLR");
        //attempts
        int num = Main.attempts.size();
        System.out.println(num);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 6; j++) {
                if (j < Main.attempts.get(i).size()){
                    StdDraw.setPenColor(Main.attempts.get(i).get(j));
                } else {
                    StdDraw.setPenColor(Color.GRAY);
                }
                StdDraw.filledCircle((j + 1) / 7.0, 0.25 + (i + 1) * 0.75 / (num + 1), 0.04);
            }
        }
    }
}

