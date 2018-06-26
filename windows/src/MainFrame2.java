import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;



public class MainFrame2 extends JFrame {
    private JTextArea txt;
    private JFileChooser file = new JFileChooser(".");
    private JLabel jlb = new JLabel();
    private JButton key1 = new JButton("輸入密碼");
    public MainFrame2() {
        init();
    }
    public void init() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 400, 300);
        this.setTitle("XOR加密");

        txt = new JTextArea(80, 80);
        JScrollPane p = new JScrollPane(txt);

        Container con = getContentPane();
        con.add(buildMenu(), "North");
        con.add(p, "Center");
    }
    //建立功能表內容
    public JMenuBar buildMenu() {
        JMenuBar mber = new JMenuBar();
        JMenu menu = new JMenu("檔案(F)");
//        JMenu menu1 = new JMenu("加密(Y)");
        menu.setMnemonic(KeyEvent.VK_F);
//        menu1.setMnemonic(KeyEvent.VK_Y);
        mber.add(menu);
//        mber.add(menu1);
        //設定檔案功能列表項目
        //開啟檔案
        JMenuItem item = new JMenuItem("開啟 (O)", KeyEvent.VK_O);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readfile();
            }
        });
        menu.add(item);
        //儲存檔案
        item = new JMenuItem("儲存 (S)", KeyEvent.VK_S);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writefile();
            }
        });
        menu.add(item);
        item = new JMenuItem("加密(S)", KeyEvent.VK_S);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                read();
            }
        });
        menu.add(item);
        item = new JMenuItem("解密(A)", KeyEvent.VK_A);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write();
            }
        });
        menu.add(item);
        //結束程式
        item = new JMenuItem("結束 (X)", KeyEvent.VK_X);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(item);
        return mber;
    }

    public void readfile() {
        int state = file.showSaveDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            File f = file.getSelectedFile();
            try {
                txt.read(new FileReader(f), "");
            } catch (IOException ie) {
                System.out.println(ie);
            }
        }
    }
    public void writefile() {
        int state = file.showSaveDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            File f = file.getSelectedFile();
            try {
                txt.write(new FileWriter(f));
            } catch (IOException key) {
                System.out.println(key);
            }
        }
    }
    public void read() {
        String key = JOptionPane.showInputDialog("Please Input Encrypt Key:");
        char data [] = txt.getText().toCharArray();
        int n = data.length;
        char chardata [] = new char[n];
        char key1 [] = key.toCharArray();
        int k = key1.length;
        for (int i = 0 ; i < n ; i++){
            chardata[i] = (char)((int)data[i] ^ (int)key1[i % k ]);
        }
        txt.setText(new String(chardata));
    }

    public void write(){
        String key = JOptionPane.showInputDialog("Please Input Decrypt Key:");
        char data [] = txt.getText().toCharArray();
        int n = data.length;
        char chardata [] = new char[n];
        char key1 [] = key.toCharArray();
        int k = key1.length;
        for (int i = 0 ; i < n ; i++){
            chardata[i] = (char)((int)data[i] ^ (int)key1[i % k]);
        }
        txt.setText(new String(chardata));
    }
}