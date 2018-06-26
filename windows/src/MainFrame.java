import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.math.BigInteger;
import java.util.Random;


public class MainFrame extends JFrame {
    JFrame frame = new JFrame("Jfile choose");
    private JLabel jlb2 = new JLabel("加密檔案");
    private JLabel jlb3 = new JLabel("顯示檔案名稱");

    private JButton key = new JButton("輸入密碼");
    private JButton loading1 = new JButton("加密");
    private JButton loading2 = new JButton("解密");
    private JTextField jtf = new JTextField();
    private JScrollPane j = new JScrollPane(jtf);
    private JTextField jtf1 = new JTextField();
    private JLabel jlb = new JLabel();
    private JLabel jlb4 = new JLabel();

    private Container cp;
    private JPanel jpnn = new JPanel(new GridLayout(1, 1, 5, 5));
    private JPanel jpnc = new JPanel(new GridLayout(2, 3, 3, 5));
    private JPanel jpns = new JPanel(new GridLayout(1, 1, 3, 3));



    public MainFrame() {
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 400, 300);
        this.setTitle("XOR");
        cp = this.getContentPane();
        this.add(jlb4,BorderLayout.CENTER);
        jpnn.add(build());
        jpnc.add(jlb2);
        jpnc.add(j);
        jpnc.add(loading1);
        jpnc.add(jlb3);
        jpnc.add(jtf1);
        jpnc.add(loading2);
        jpns.add(jlb);
        cp.add(jpnn, BorderLayout.NORTH);
        cp.add(jpnc, BorderLayout.CENTER);
        cp.add(jpns, BorderLayout.SOUTH);

        loading1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                key();
            }
        });
        loading2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                answer();
            }
        });
    }

    public void key() {
        String oldstr = jtf.getText();
        String goldkey = key.getText();
        String newstr = "";
        for (int i = 0; i < oldstr.length(); i++) {
            int j = i % goldkey.length();
            newstr = newstr + (oldstr.charAt(i) ^ goldkey.charAt(j));
            if (i != oldstr.length() - 1) {
                newstr = newstr + ',';
            }
        }
        jtf.setText(newstr);
    }

    public void answer() {
        String str[] = jtf.getText().split(",");
        String goldkey = key.getText();
        String newstr = "";
        for (int i = 0; i < str.length; i++) {
            int j = i % goldkey.length();
            newstr = newstr + (char) (Integer.parseInt(str[i]) ^ goldkey.charAt(j));
        }
        jtf1.setText(newstr);
    }

    public JMenuBar build() {
        JMenuBar mber = new JMenuBar();
        JMenu menu = new JMenu("選項(F)");
        menu.setMnemonic(KeyEvent.VK_F);
        mber.add(menu);
        JMenuItem item = new JMenuItem("建立檔案 (o)", KeyEvent.VK_O);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                key();
                MainFrame2 frm = new MainFrame2();
                frm.setVisible(true);
            }
        });
        menu.add(item);
        item = new JMenuItem("開啟檔案 (S)", KeyEvent.VK_S);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser choose = new JFileChooser();
                choose.showOpenDialog(frame);
                File f = choose.getSelectedFile();
                jlb.setText(f.getAbsolutePath());
                jtf.setText(f.getName());
            }
        });
        menu.add(item);
        return mber;
    }


}