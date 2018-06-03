
import javax.crypto.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MainFrame extends JFrame {
    JFrame frame = new JFrame("Jfile choose");
    private JButton loading = new JButton("loading");
    private JButton enter = new JButton("Enter");
    private JTextField jtf = new JTextField();
    private JLabel jlb = new JLabel();
    private Container cp;
    private JPanel jpnn = new JPanel(new GridLayout(1, 3, 5, 5));
    private JPanel jpnc = new JPanel(new GridLayout(1, 1, 3, 3));
    private KeyGenerator keygen;
    private SecretKey deskey;
    private Cipher c;
    private byte[] cipherByte;
    public  MainFrame() {
        init();
    }
    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 400, 300);
        this.setTitle("XOR加密");
        cp = this.getContentPane();
        deskey = keygen.generateKey();
        
        jpnn.add(jtf);
        jpnn.add(loading);
        jpnn.add(enter);
        jpnc.add(jlb);
        cp.add(jpnn, BorderLayout.NORTH);
        cp.add(jpnc, BorderLayout.CENTER);

        loading.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser choose = new JFileChooser();
                choose.showOpenDialog(frame);
                File f = choose.getSelectedFile();
                jlb.setText(f.getAbsolutePath());
            }

        });
    }

        }



