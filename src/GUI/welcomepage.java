package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.CENTER;

public class welcomepage extends guitable  implements ActionListener {
    private JButton next;
    private JLabel welcome,welcome1;





    public welcomepage(){

        welcome = new JLabel();                                                      //Adding a welcome page.
        welcome.setText(" WELCOME TO SKIN CONSULTATION");
        welcome.setBounds(0,200,550,32);
        welcome.setFont(new Font("ALGERIAN",Font.BOLD,28));
        welcome.setForeground(new Color(255, 255, 255));

        welcome1 = new JLabel();                                                      //Adding a welcome page.
        welcome1.setText(" CENTER  !!");
        welcome1.setBounds(170,248,550,32);
        welcome1.setFont(new Font("ALGERIAN",Font.BOLD,28));
        welcome1.setForeground(new Color(255, 255, 255));


        JLabel background;
        setSize(1200,700);
        ImageIcon imgs=new ImageIcon("C:\\Users\\MSI\\Desktop\\20200546_w1830258_NaveenGrero\\1830258_naveen\\src\\GUI\\img_1.png");     //Adding an  image  to welcome page.
        background=new JLabel("",imgs,CENTER);
        background.setBounds(0,0,1200,500);
        button();
        add(background);
        window(" Skin Consultation Center ",500,500);



    }

    public void button_set(JButton but,String name) {
        but.setBounds(210,420,70,30);
        but.setText(name);
        but.setFocusable(false);
        but.addActionListener(this);
        this.add(but);
        this.add(welcome);
        this.add(welcome1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== next) {
            this.dispose();
            new guimain();
        }

    }
    @Override
    public void button() {

        next = new JButton();
        button_set(next,"NEXT");

    }

}
