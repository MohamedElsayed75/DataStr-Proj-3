import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel{
    int[] nums ;

    public Draw(int[] array) {
        nums = array;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int idx = 0; idx < nums.length ; idx++) {
            g.setColor(Color.BLUE);
            g.fillRect(idx, (470 - nums[idx]), 1, nums[idx]);
        }

    }

    public void updateArray(int[] array) {
        nums = array;
    }
}
