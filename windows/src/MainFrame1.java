import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame1 extends JFrame {
    JFrame frame = new JFrame("Jfile choose");
    private JButton loading = new JButton("loading");
    private JButton enter = new JButton("Enter");
    private JTextField jtf = new JTextField();
    public MainFrame1(){
        init();
    }
public void init(){
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setBounds(0, 0, 800, 600);

    enter.setLocation(50,50);
    enter.setSize(120,30);

    jtf.setLocation(170,50);
    jtf.setSize(120,30);

    loading.setLocation(290,50);
    loading.setSize(120,30);

    this.add(enter);
    this.add(loading);
    this.add(jtf);
    loading.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser choose = new JFileChooser();
            int a = choose.showOpenDialog(null);
            if(a == JFileChooser.APPROVE_OPTION){


            }


        }
    });



}
}
