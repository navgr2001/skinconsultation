package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static Console.WestministerSkinConsultationManager.doctorArr;

public class doctordetailspage extends guitable implements ActionListener {
    private JButton back,reset,sort;

    doctordetailspage(boolean cat){

        ImageIcon img = new ImageIcon("C:\\Users\\MSI\\Desktop\\20200546_w1830258_NaveenGrero\\1830258_naveen\\src\\GUI\\img_2.png");
        JLabel topic = new JLabel();
        topic.setText("DOCTORS' DETAILS");
        topic.setBounds(350,20,550,20);
        topic.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,25));
        topic.setForeground(new Color(227, 30, 30));

        JLabel colum = new JLabel();
        colum.setText("|    Name     |   Surname    |   Birth-Date  |   Mobile-NO   |   Licence  | Specialisation |");
        colum.setBounds(33,-70,850,300);
        colum.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,15));
        colum.setForeground(new Color(203, 10, 10, 255));


        DefaultTableModel tableModel = new DefaultTableModel(0,6);
        JTable table = new JTable(tableModel);
        table.setBounds(35,100,800,300);
        if (cat){

            System.out.println(doctorArr.size());
            for (Console.doctor doctor : doctorArr) {
                String[] details = {doctor.getName(), doctor.getSurname(), String.valueOf(doctor.getDateofbirth()), doctor.getMobilenumber(), doctor.getMedicallicence(), doctor.getSpecialization()};
                tableModel.addRow(details);

            }
        }else{
            System.out.println("sort");
            int i = doctorArr.size();
            String [] sort = new String[i];
            for (int j = 0; j < i;j++) {
                sort[j]=doctorArr.get(j).getSurname();
            }


            Arrays.sort(sort);
            for (String s : sort) {
                for (Console.doctor doctor : doctorArr) {
                    if (s.equals(doctor.getSurname())) {
                        String[] details = {doctor.getName(), doctor.getSurname(), String.valueOf(doctor.getDateofbirth()),doctor.getMobilenumber(), doctor.getMedicallicence(), doctor.getSpecialization()};
                        tableModel.addRow(details);
                    }
                }
            }
        }
        JLabel dr = new JLabel();
        dr.setIcon(img);
        dr.setBounds(0,0,900,500);


        dr.setOpaque(true);

        this.add(topic);
        this.add(colum);
        this.add(table);


        System.out.println("GUI file valid");
        button();
        this.add(dr);
        window("All Doctors Exist",900,500);

    }

    public void button_set(JButton but,String name, int x, int y , int width , int height) {
        but.setBounds(x,y,width,height);
        but.setText(name);
        but.setFocusable(false);
        but.addActionListener(this);
        this.add(but);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back) {
            this.dispose();
            new guimain();//animus class call
        } else if (e.getSource()==reset) {
            this.dispose();
            new doctordetailspage(true);

        } else if (e.getSource()==sort){
            this.dispose();
            new doctordetailspage(false);
        }
    }
    @Override
    public void button() {
        back = new JButton();
        back.setFont(new Font("Calibri", Font.BOLD, 12));
        button_set(back,"Back",40,410,65,30);

        reset = new JButton();
        button_set(reset,"reset",120,410,65,30);

        sort = new JButton();
        button_set(sort,"sort",750,410,80,30);

    }
}
