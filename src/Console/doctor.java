package Console;

import Console.person;

import java.time.LocalDate;

public class doctor extends person {
    private String medicallicense;
    private String specialization;
    public doctor(String n, String sname, LocalDate dob, String mobnum, String ml, String spec) {
        super(n, sname, dob, mobnum);
        medicallicense=ml;
        specialization=spec;
    }
    public String getMedicallicence(){
        return  medicallicense;
    }
    public String getSpecialization(){
        return specialization;
    }

    @Override
    public String toString() {
        return  "01.Name                :"+this.getName()+'\n'+
                "02.Surname             :"+this.getSurname()+'\n'+
                "03.Date-Of-Birth       :"+this.getDateofbirth()+'\n'+
                "04.Mobile  Number      :"+this.getMobilenumber()+'\n'+
                "05.Medical  License    :"+medicallicense+'\n'+
                "06.Specialization      :"+specialization+'\n';
    }
}
