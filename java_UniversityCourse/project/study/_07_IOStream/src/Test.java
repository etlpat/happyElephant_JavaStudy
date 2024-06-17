import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Test {
    public static void main(String[] args) {
        String s1 = "111";
        String s2 = "111";
        String s3 = new String("111");
        String s4 = new String("111");

        System.out.println(s1 == s2);// t
        System.out.println(s1 == s3);// f
        System.out.println(s1 == s4);// f

        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
