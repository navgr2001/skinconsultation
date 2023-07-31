package Console;
import GUI.welcomepage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WestministerSkinConsultationManager  implements skinconsultaionmanager {
    public  static ArrayList<doctor>doctorArr=new ArrayList<>(10);
    public  static ArrayList <consultation> consult = new ArrayList <>();
    public static void main(String[] args) {

        WestministerSkinConsultationManager  ws= new WestministerSkinConsultationManager();
        ws.readfile();
        //scanner input
        Scanner myscanner = new Scanner(System.in);
        String optionmenu;
        //arrays
        String[] DoctorName = new String[10];      //array to hold Console.doctor first names.
        String[] DoctorSurnames = new String[10];  //array to hold Console.doctor surnames.

        //initializing array indexes
        for (int i = 0; i < 10; i++) {
            DoctorName[i] = "Empty";
            DoctorSurnames[i] = "No customer";

        }


//        Skin Consultation Center System Menu

        System.out.println("\n\n");
        System.out.println("\t\t\t\t  ==============    Skin Consultation Center     =============");
        System.out.println("\t\t\t\t\t==============           System Menu           =============\n");
        System.out.println("[A] add new Doctor     ");
        System.out.println("[D] Delete Doctor");
        System.out.println("[P] Print list  of Doctors");
        System.out.println("[S] Save  in file");
        System.out.println("[G] Open  GUI");
        System.out.println("[x] Exit system ");

        boolean  x = true;


           //select menu option from the user
        while (x) {
            System.out.print("\nEnter a menu selection:: ");
            optionmenu = myscanner.next().toUpperCase();
            switch (optionmenu){
                case "A" :
                    ws.adddoctors();
                    break;

                case  "D":
                    ws.deletedoctor();
                    break;
                case "P":
                    ws.printlistofdoctors();
                    break;
                case "S":
                    ws.savefile();
                    break;
                case "G":
                    new welcomepage();
                    break;
                case "X":
                    x=false;


            }
            //checking menu option is valid or not.
            }
            System.out.println("\n\n");
            System.out.println("\t\t\t\t  ================ Skin  Consultation Center   ======================");
            System.out.println("\t\t\t\t\t================        System Menu          ======================\n");
            System.out.println("[A] add new Doctor     ");
            System.out.println("[D] Delete Doctor");
            System.out.println("[P] Print list  of Doctors");
            System.out.println("[S] Save  in file");
            System.out.println("[G] Open  GUI");
            System.out.println("[x] Exit system ");

            System.out.print("\nEnter a menu selection:: ");
            optionmenu = myscanner.next().toUpperCase();


        }


//add doctors to  system

    public void adddoctors() {
        Scanner myscanner = new Scanner(System.in);

        {
            System.out.println("------------------------ADD DOCTORS------------------------");
            System.out.print("Enter doctor name : ");
            String doctorName = myscanner.next();
            System.out.print("Enter doctor surname : ");
            String doctorSurnames = myscanner.next();
            System.out.print("Enter doctor date of  birth(YYYY-MM-DD): ");
            LocalDate dob = LocalDate.parse(myscanner.next());
            System.out.print("Enter doctor mobile number : ");
            String mobnum = myscanner.next();
            if (10==mobnum.length()) {
                System.out.print("Enter the licence number : ");
                String licence = myscanner.next();
                System.out.print("Specialisation : ");
                String spec = myscanner.next();
                Integer.parseInt(mobnum);
                doctorArr.add(new doctor(doctorName,doctorSurnames,dob,mobnum,licence,spec));

                for (doctor d:doctorArr){
                    System.out.println(d);
                }
                System.out.println("*************************    Valid mobile  number    *******************");
            }else{
                System.out.println("*************************  ! Invalid mobile  number !    ****************");
            }

        }


    }
//    delete doctors from  system
    public void deletedoctor(){
        Scanner myscanner = new Scanner(System.in);
        String licence;
        System.out.println("Enter doctor licence  number : ");
        licence=myscanner.next();
        for(int i=0;i<doctorArr.size();i++){
            if(licence.equals(doctorArr.get(i).getMedicallicence())) {
                doctorArr.remove(i);
                System.out.println("***************    Deleted Successfully  ************");


            }
            System.out.println("***************       Invalid License    ************");
        }
    }




//    print doctor details in alphabatical order  using surname
    public void printlistofdoctors(){
        int arrlength= doctorArr.size();   //to initialize all doctors into separate array.
        String[] doctorsurname= new String[arrlength];
        for (int i = 0; i < arrlength; i++) {
            doctorsurname[i]=doctorArr.get(i).getSurname();
        }
        Arrays.sort(doctorsurname);
        for (String doctorsur:doctorsurname) {
            for (doctor d :doctorArr) {
                if (doctorsur.equals(d.getSurname())) {   //swap the doctors if it's required....
                    System.out.println(d);
                }
            }
        }

    }
//    save  file
    public  void savefile(){
        try{
            FileOutputStream print = new FileOutputStream("TextOutput.txt");   //open file.
            PrintWriter outputStream=new PrintWriter(print);
            for(doctor d:doctorArr){
                outputStream.println(d.getName()+"\n"+d.getSurname()+"\n"+d.getDateofbirth()+"\n"+d.getMobilenumber()+"\n"+d.getMedicallicence()+"\n"+d.getSpecialization());
            }
           outputStream.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println("*********************  Successfully added the data into document  ******************************");

    }
//    read file
    public void readfile(){
        ArrayList<String>read=new ArrayList<>();
        try {
            File dataFile = new File("TextOutput.txt");
            Scanner myscanner = new Scanner(dataFile);
            while (myscanner.hasNextLine()) {
                String line = myscanner.nextLine();
                read.add(line);
            }
            while(0<(read.size()/6)){
                doctorArr.add(new doctor(read.get(0),read.get(1),LocalDate.parse(read.get(2)),read.get(3),read.get(4),read.get(5)));

                read.subList(0,6).clear();

            }
            myscanner.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
