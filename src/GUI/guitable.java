package GUI;

import javax.swing.*;
import java.awt.*;

public abstract class guitable extends  JFrame  {
    public abstract void button();
    public void window(String name,int width,int height){

        ImageIcon img = new ImageIcon("C:\\Users\\MSI\\Desktop\\20200546_w1830258_NaveenGrero\\1830258_naveen\\src\\GUI\\img_1.png");
        setIconImage(img.getImage());
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 3
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        setLayout(new BorderLayout());
        setVisible(true);


    }
}
