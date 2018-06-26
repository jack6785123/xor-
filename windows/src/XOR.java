

//互斥或閘加密
//原文: 00000011
//金鑰: 00000101
//密文: 00000110

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOR extends JFrame{

    public static void main(String[] args) {
        XOR xor = new XOR();
        xor.setVisible(true);
    }

    private JPanel panel1 = new JPanel(new GridBagLayout());
    private JLabel keylb = new JLabel("金鑰:");
    private JTextField key = new JTextField(5);

    private JPanel panel2 = new JPanel(new GridBagLayout());
    private JLabel label1 = new JLabel("原文:");
    private JTextArea text1 = new JTextArea();
    private JLabel label2 = new JLabel("密文:");
    private JTextArea text2 = new JTextArea();

    private JPanel panel3 = new JPanel();
    private JButton run1 = new JButton("加密");
    private JButton run2 = new JButton("解密");

    XOR(){
        init();
    }

    private void init(){
//----------視窗設定----------
        setTitle("互斥或閘");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
//----------版面設定----------
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 0;
        constraints.weightx = 1;
        add(panel1, constraints);
        constraints.weighty = 1;
        add(panel2, constraints);
        constraints.weighty = 0;
        add(panel3, constraints);

        constraints.gridwidth = 1;
        constraints.weightx = 0;
        panel1.add(keylb, constraints);

        constraints.gridwidth = 1;
        constraints.weightx = 0;
        panel1.add(key, constraints);

        panel2.add(label1, constraints);

        constraints.gridwidth = 0;
        constraints.insets.left = 2;
        constraints.insets.right = 2;
        panel2.add(label2, constraints);

        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        panel2.add(text1, constraints);
        panel2.add(text2, constraints);

        panel3.add(run1);
        panel3.add(run2);
//----------字體----------
        keylb.setFont(new Font(null, Font.BOLD, 24));
        key.setFont(new Font(null, Font.BOLD, 24));
        label1.setFont(new Font(null, Font.BOLD, 24));
        label2.setFont(new Font(null, Font.BOLD, 24));
        text1.setFont(new Font(null, Font.BOLD, 24));
        text2.setFont(new Font(null, Font.BOLD, 24));
        run1.setFont(new Font(null, Font.BOLD, 24));
        run2.setFont(new Font(null, Font.BOLD, 24));

        text1.setLineWrap(true);
        text2.setLineWrap(true);
//----------加密按鈕----------
        run1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldstr = text1.getText();
                String goldkey = key.getText();
                String newstr = "";
                for (int i = 0; i < oldstr.length(); i++){
                    int j = i % goldkey.length();
                    newstr = newstr + (oldstr.charAt(i) ^ goldkey.charAt(j));
                    if (i != oldstr.length() - 1){
                        newstr = newstr + ',';
                    }
                }
                text2.setText(newstr);
            }
        });
//----------解密按鈕----------
        run2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str[] = text2.getText().split(",");
                String goldkey = key.getText();
                String newstr = "";
                for (int i = 0; i < str.length; i++){
                    int j = i % goldkey.length();
                    newstr = newstr + (char)(Integer.parseInt(str[i]) ^ goldkey.charAt(j));
                }
                text1.setText(newstr);
            }
        });
    }

}

