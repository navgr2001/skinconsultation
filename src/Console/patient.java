package Console;

import java.time.LocalDate;
import java.util.Date;

public class patient extends person {
    private int patientid;
    public patient(String n, String sname, LocalDate dob, String mobnum, int id) {
        super(n, sname, dob, mobnum);
    }
    public int getPatientid(){
        return patientid;
    }
    public  void setPatientid(int patientid){
        this.patientid=patientid;
    }
}
