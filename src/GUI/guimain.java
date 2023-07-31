package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guimain extends guitable implements ActionListener {
    private JButton button1,button2,button3;

    public guimain(){
//        LoadFile();
        ImageIcon img = new ImageIcon("C:\\Users\\MSI\\Desktop\\20200546_w1830258_NaveenGrero\\1830258_naveen\\src\\GUI\\img.png");

        JLabel label = new JLabel();                                                      //Adding a heading.
        label.setText("SKIN CONSULTATION CENTER");
        label.setIcon(img);
        label.setHorizontalTextPosition(JLabel.CENTER);
        //label.setForeground(new Color(0x00FF));
        label.setVerticalTextPosition(JLabel.TOP);
        label.setBounds(20,10,400,450);
        label.setFont(new Font("SansSerif", Font.BOLD, 26));
        label.setForeground(new Color(26, 11, 150,255));
        label.setBackground(Color.white);
        label.setOpaque(true);

        JLabel label1 = new JLabel();
        label1.setBounds(0,0,800,500);
        label1.setBackground(new Color(0x1A887B));
        label1.setOpaque(true);


        System.out.println("GUI file valid");
        button();

        this.add(label);
        this.add(label1);

        window("Westminster Skin Consultation Manager",800,500);
    }

    public void button_set(JButton but,String name , int y) {
        but.setBounds(420,y,350,40);
        but.setText(name);
        but.setFont(new Font(Font.SERIF,Font.BOLD,15));
        but.setForeground(new Color(0xFDEB3A));
        but.setFocusable(false);
        but.setBackground(Color.blue);
        but.addActionListener(this);
        this.add(but);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) {
            this.dispose();
            new consultationpage();
        } else if (e.getSource()==button2) {
            this.dispose();
            new doctordetailspage(true);

        }else{
            this.dispose();
        }
    }
    @Override
    public void button() {
        button1 = new JButton();
        button_set(button1,"CONSULTATION",100);
        button2 = new JButton();
        button_set(button2,"DOCTORS' DETAILS",180);
        button3 = new JButton();
        button_set(button3,"CLOSE",260);


    }
}
