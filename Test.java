package myprojects;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test extends JFrame {

    private Container c;
    private JLabel imgLabel, textLabel;
    private JTextField tf;
    private JTextArea ta;
    private JButton clearButton;
    private ImageIcon img;
    private Font f;
    private Cursor cursor;

    Test() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f = new Font("Aril", Font.ITALIC + Font.BOLD, 14);

        img = new ImageIcon(getClass().getResource("download2.jpg"));

        imgLabel = new JLabel(img);
        imgLabel.setBounds(20, 20, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);

        textLabel = new JLabel("Enter any number : ");
        textLabel.setBounds(20, 220, 250, 40);
        textLabel.setForeground(Color.MAGENTA);
        textLabel.setFont(f);
        c.add(textLabel);

        ta = new JTextArea();
        ta.setBounds(20, 350, 200, 250);
        ta.setBackground(Color.GREEN);
        ta.setFont(f);
        c.add(ta);

        tf = new JTextField();
        tf.setBounds(210, 220, 90, 50);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setBackground(Color.GREEN);
        tf.setFont(f);
        c.add(tf);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        clearButton = new JButton("Clear");
        clearButton.setBounds(210, 290, 90, 50);
        clearButton.setCursor(cursor);
        clearButton.setFont(f);
        clearButton.setBackground(Color.GREEN);
        c.add(clearButton);

        tf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String value = tf.getText();
                if (value.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You didn't any number");
                } else {
                    ta.setText("");

                    int num = Integer.parseInt(tf.getText());

                    for (int i = 1; i <= 10; i++) {

                        int result = num * i;
                        String r = String.valueOf(result);
                        String n = String.valueOf(num);
                        String incr = String.valueOf(i);

                        ta.append(n + " X " + incr + " = " + r + "\n");
                    }

                }

            }

        });

        clearButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                ta.setText("");
                tf.setText("");

            }

        });

    }

    public static void main(String[] args) {

        Test frame = new Test();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 20, 360, 700);
        frame.setTitle("Multiplication Table");
    }
}
