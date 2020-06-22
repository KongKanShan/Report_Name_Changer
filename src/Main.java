import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String argc[])throws IOException {
        MainUI UI = new MainUI();
        JFrame jFrame = new JFrame();
        jFrame.setTitle("重命名");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(UI.Panel1);
        jFrame.setVisible(true);
        jFrame.setSize(450,700);
    }
}
