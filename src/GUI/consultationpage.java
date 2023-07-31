package GUI;

import  Console.consultation;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Base64;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static Console.WestministerSkinConsultationManager.consult;
import static Console.WestministerSkinConsultationManager.doctorArr;




public class consultationpage extends guitable implements ActionListener {
    private String name,surname,phoneno,docconsId,note,sttimeHou,sttimeMin,stasettime,entimeHou,notenkey;

    private SecretKey notekey;

    private String filename = null;

    private int cost,patId;
    private int again = 1;

    private LocalDate dateOfBirth,consDate;

    private LocalTime consStart,consEnd,ensettime;
    private JButton back,Cancel,submit,pic;
    private JTextField getname,getbirthday,getid,getdate,getsurname,getphone;
    private JComboBox getdoc,getstarttime1,getstarttime2, getdurtion;
    private JTextArea getnote;
    private JLabel topic,colum,topic1,jname,birthday,id,time,date,jnote,addpho,addphopath,topic12;
    consultationpage(){

        ImageIcon img = new ImageIcon("C:\\Users\\MSI\\Desktop\\20200546_w1830258_NaveenGrero\\1830258_naveen\\src\\GUI\\img_2.png");


        topic = new JLabel();
        topic.setText("DOCTORS' DETAILS");
        topic.setForeground(new Color(2, 2, 2, 255));
        set_lable(topic,290,20,550,20,20);


        colum = new JLabel();
        colum.setText("|    Name      |   Surname    |   Mobile-NO   |   Licence    |  Specialisation |");
        colum.setForeground(new Color(211, 52, 75, 255));
        set_lable(colum,39, -70, 750, 300,15);


        DefaultTableModel tableModel = new DefaultTableModel(0,5);
        JTable table = new JTable(tableModel);
        table.setBounds(40, 100, 700, 240);

        for (int i =0; doctorArr.size()>i;i++) {
            String[] details = {doctorArr.get(i).getName(), doctorArr.get(i).getSurname(), doctorArr.get(i).getMobilenumber(), doctorArr.get(i).getMedicallicence(), doctorArr.get(i).getSpecialization()};
            tableModel.addRow(details);
        }

        //heading
        topic1 = new JLabel();
        topic1.setText("DOCTOR CONSULTATION");
        set_lable(topic1,280, 360, 550, 20,20);

        topic12=new JLabel();
        topic12.setText("(Patients' use Only)");
        topic12.setFont(new Font(Font.DIALOG_INPUT,Font.ITALIC,15));
        topic12.setForeground(new Color(190, 7, 7,254));
        set_lable(topic12,300,380,550,20,15);

//name,surname text field
        jname = new JLabel();
        jname.setText("NAME                 :                    SURNAME           :");
        set_lable(jname,30, 420, 550, 20,15);

        getname = new JTextField();
        set_textfild(getname,240,425,150,20);

        getsurname = new JTextField();
        set_textfild(getsurname,600,425,150,20);

//birthdate, mobile number text field
        birthday = new JLabel();
        birthday.setText("BIRTHDAY(YYY-MM-DD)  :                    MOBILE NUMBER      :");
        set_lable(birthday,30, 470, 550, 20,15);


        getbirthday = new JTextField();
        set_textfild(getbirthday,240,475,150,20);

        getphone = new JTextField();
        set_textfild(getphone,600,475,150,20);
//patientid  text field
        id = new JLabel();
        id.setText("PATIENT ID           :                    DOCTOR LICENCE ID :");
        set_lable(id,30, 520, 550, 20,15);


        getid = new JTextField();
        set_textfild(getid,240,525,150,20);

//doctor licence selection box
        String [] doc = new String[doctorArr.size()];
        for(int i = 0;doctorArr.size()>i;i++){
            doc[i]=doctorArr.get(i).getMedicallicence();
        }
        getdoc =new JComboBox(doc);
        set_combobox(getdoc,600,525,150,20);

//time selection box
        time = new JLabel();
        time.setText("CONSULTATION START TIME:                 CONSULTATION DURATION:");
        set_lable(time,30, 570, 700, 20,15);


        String[] hours = { "HH","08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20","21","22" };
        String[] min = { "MM","00", "15", "30", "45" };
        String[] dura = { "HH","01", "02", "03", "04", "05"};

        //J combo box
        //start time in hours
        getstarttime1 =new JComboBox(hours);
        set_combobox(getstarttime1,260,575,50,20);

//start time in minutes
        getstarttime2 =new JComboBox(min);
        set_combobox(getstarttime2,340,575,50,20);
//time duration
        getdurtion =new JComboBox(dura);
        set_combobox(getdurtion,600,575,150,20);

//consultation date
        date = new JLabel();
        date.setText("CONSULTATION DATE(YYY-MM-DD):");
        set_lable(date,30, 620, 550, 20,15);


        getdate = new JTextField();
        set_textfild(getdate,300,625,150,20);
//add note
        jnote = new JLabel();
        jnote.setText("ADDITIONAL NOTE :");
        set_lable(jnote,30, 670, 550, 20,15);


        getnote = new JTextArea();
        getnote.setText(".");
        getnote.setBounds(30,700,700,200);
        getnote.setFont(new Font("console",Font.ITALIC,15));
        getnote.setLineWrap(true);


        JLabel backimg = new JLabel();
        backimg.setIcon(img);
        backimg.setBounds(0,0,800,1000);
        backimg.setOpaque(true);


        this.add(table);
        this.add(getnote);


        System.out.println("GUI file valid");
        button();
        this.add(backimg);
        window("Consultation",800,1000);
    }
    public void check_equal(){
        int timedura = Integer.parseInt(entimeHou);
        boolean not_equal = true;
        for (consultation consultation : consult) {
            if (docconsId.equals(consultation.getDocconsId())) {
                if (consultation.getConsDate().isEqual(consDate)) {
                    if(consultation.getConsStart().isBefore(consStart) && consultation.getConsEnd().isAfter(consStart) ||
                            consultation.getConsStart().isBefore(consEnd) && consultation.getConsEnd().isAfter(consEnd) ||
                            consultation.getConsStart().isBefore(consStart) && consultation.getConsEnd().isAfter(consEnd) ||
                            consultation.getConsStart().isAfter(consStart) && consultation.getConsEnd().isBefore(consEnd) )
                    {
                        not_equal = false;
                        break;
                    }
                }
            }
        }
        for(consultation consultation : consult){
            if(Objects.equals(consultation.getPatientid(), patId)){
                again++;
            }
        }
        if(again==1){
            cost=(timedura*15);

        }else{
            cost = 25*timedura;
//            System.out.println(cost);
        }
        if(not_equal){

            consult.add(new consultation(again,name,surname, dateOfBirth, phoneno,patId,docconsId, consStart,consEnd,consDate,note,cost,notenkey));


        }else{
            int docsiz=doctorArr.size();
            String [] random = new String[docsiz];
            for(int i =0;docsiz > i ;i++){
                random[i] = doctorArr.get(i).getMedicallicence();
            }
            Random rand = new Random();
            int randomIndex = rand.nextInt(random.length);
            docconsId = random[randomIndex];
            again = 0 ;
            check_equal();
        }
    }
    public void set_combobox(JComboBox combo,int x, int y , int width , int height){
        combo.setBounds(x,y,width,height);
        combo.setBackground(new Color(0xFFFFFF));
        this.add(combo);
    }
    public void set_lable(JLabel lable ,int x, int y , int width , int height,int font){
        lable.setBounds(x,y,width,height);
        lable.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,font));
        this.add(lable);
    }

    public void set_textfild(JTextField textfild,int x, int y , int width , int height){//150,20
        textfild.setBounds(x,y,width,height);
        textfild.setFont(new Font("console",Font.ITALIC,15));
        this.add(textfild);
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

        if (e.getSource()== submit) {
            try {
                String regex = "^[A-Za-z]\\w{2,29}$";
                Pattern p = Pattern.compile(regex);
                name = getname.getText().trim();
                surname = getsurname.getText().trim();
                Matcher f = p.matcher(name);
                Matcher s = p.matcher(surname);
                if (f.matches() && s.matches()) {
                    try {
                        dateOfBirth = LocalDate.parse(getbirthday.getText().trim());
                        phoneno = getphone.getText().trim();
//                        validation for mobile number
                        if (10 == phoneno.length()) {
                            try {
                                Integer.parseInt(phoneno);
                                try {
                                    patId = Integer.parseInt(getid.getText());
                                    docconsId = (String) getdoc.getSelectedItem();
                                    sttimeHou = (String) getstarttime1.getSelectedItem();
                                    sttimeMin = (String) getstarttime2.getSelectedItem();
                                    stasettime = sttimeHou + ":" + sttimeMin + ":00";
                                    try {
                                        consStart = LocalTime.parse(stasettime);
                                        entimeHou = (String) getdurtion.getSelectedItem();

                                        consEnd = consStart.plusHours(Long.parseLong(entimeHou));
                                        System.out.println(consEnd);

                                        try {
                                            consDate = LocalDate.parse(getdate.getText().trim());
                                            if (consDate.isAfter(LocalDate.now()) && consDate.isBefore(LocalDate.now().plusYears(3))) {
                                                note = getnote.getText();

                                                try {


                                                    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
                                                    SecretKey myDesKey = keygenerator.generateKey();

                                                    // Creating object of Cipher
                                                    Cipher desCipher;
                                                    desCipher = Cipher.getInstance("DES");


                                                    // Creating byte array to store string
                                                    byte[] text = note.getBytes(StandardCharsets.UTF_8);

                                                    // Encrypting text
                                                    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
                                                    byte[] textEncrypted = desCipher.doFinal(text);

                                                    // Converting encrypted byte array to string
                                                    note =  Base64.getEncoder().encodeToString(textEncrypted);
                                                    System.out.println(note);



                                                    notenkey = Base64.getEncoder().encodeToString(myDesKey.getEncoded());
                                                    System.out.println(notenkey);

//
                                                    try
                                                    {
//

                                                        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

                                                        CipherInputStream cipt=new CipherInputStream(new FileInputStream("ico.jpg"), desCipher);

                                                        FileOutputStream fileip=new FileOutputStream("encrypt.jpg");

                                                        int i;
                                                        while((i=cipt.read())!=-1)
                                                        {
                                                            fileip.write(i);

                                                        }
                                                        fileip.close();




                                                    }
                                                    catch(Exception Ignore)
                                                    {

                                                    }


                                                    check_equal();
                                                    this.dispose();
                                                    new welcomepage();



                                                } catch (Exception ignored) {
                                                    check_equal();
                                                    this.dispose();
                                                    new welcomepage();

                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Check Entered Consultation Date", "Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                            //validate consultation date

                                        } catch (Exception ignored) {
                                            JOptionPane.showMessageDialog(null, "Check Entered Date!!", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } catch (Exception ignored) {
                                        JOptionPane.showMessageDialog(null, "Check Entered Time and Duration!!", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (Exception ignored) {
                                    JOptionPane.showMessageDialog(null, "Check Your Patient ID!!", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }catch (Exception ignored){
                                JOptionPane.showMessageDialog(null, "Check Your Mobile Number!!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Check Your Mobile Number!!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }catch (Exception ignored){
                        JOptionPane.showMessageDialog(null, "Check Your Birth date!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Check Your First Name And Surname!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception ignored){
                JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG!!","Error", JOptionPane.ERROR_MESSAGE);
            }



        }else{
            this.dispose();
            new guimain();
        }
    }

    @Override
    public void button() {
        back = new JButton();
        back.setFont(new Font("SansSerif", Font.BOLD, 12));
        button_set(back,"Back",30,20,65,30);



        submit = new JButton();
        button_set(submit,"Submit",550,920,80,30);

        Cancel = new JButton();
        button_set(Cancel,"Cancel",660,920,80,30);

    }
}
