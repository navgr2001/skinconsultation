package Console;

import java.time.LocalDate;
import java.time.LocalTime;

public class consultation extends  patient {
    private LocalDate consDate;
    private LocalTime consTime;
    private String consNotes;
    private double consCost;
    private int whichco;
    private LocalTime consStart;
    private LocalTime consEnd;
    private String docconsId;
    private String notenkey;
    private double cost;

    public consultation(int whichco,String name, String surname, LocalDate dateofbirth, String Mobilenumber, int patId, String docconsId, LocalTime consStart, LocalTime consEnd, LocalDate consDate, String consNotes,double cost,String notenkey) {
        super(name,surname,dateofbirth,Mobilenumber,patId);
        this.whichco=whichco;
        this.consDate = consDate;
        this.consStart = consStart;
        this.consEnd = consEnd;
        this.docconsId = docconsId;
        this.consNotes = consNotes;
        this.cost=cost;
        this.notenkey=notenkey;
    }

    //getters/setters

    public int getWhichco() {
        return whichco;
    }
    public void setWhichco(int whichco) {
        this.whichco = whichco;
    }

    //Console.consultation Date
    public LocalDate getConsDate(){
        return consDate;
    }
    public void setConsDate(LocalDate consDate){
        this.consDate=consDate;
    }
    public LocalTime getConsStart() {
        return consStart;
    }

    //Console.consultation start time
    public void setConsStart(LocalTime consStart) {
        this.consStart = consStart;
    }
    public String getDocconsId() {
        return docconsId;
    }

    public void setDocconsId(String docconsulId) {
        this.docconsId = docconsulId;
    }

    //Console.consultation Time
    public LocalTime getConsTime(){
        return consTime;
    }
    public void setConsTime(LocalTime consTime){
        this.consTime=consTime;
    }

    //Console.consultation Notes
    public  String getConsNotes(){
        return consNotes;
    }
    public void setConsNotes(String consNotes){
        this.consNotes=consNotes;
    }
    public void setConsEnd(LocalTime consEnd) {
        this.consEnd = consEnd;
    }

    public LocalTime getConsEnd() {
        return consEnd;
    }

    //Console.consultation COST
    public double getConsCost(){
        return consCost;
    }
    public void setConsCost(double consCost){
        this.consCost=consCost;
    }
    public String getNotenkey() {
        return notenkey;
    }

    public void setNotenkey(String notenkey) {
        this.notenkey = notenkey;
    }
    public double getCost() {return cost;}

    public void setCost(double cost) {this.cost = cost;}

    @Override
    public String toString() {
        return " 01.Name                : " + this.getName() + '\n' +
                "02.SurName             : " + this.getSurname() + '\n' +
                "03.Date-of-Birth       : " + this.getDateofbirth() + '\n' +
                "04.Mobile-No           : " + this.getMobilenumber() + '\n' +
                "05.Patient-ID          : " + this.getPatientid() + '\n' +
                "06.Consultation-Date   : " + consDate +'\n'+
                "07.Start-Time          : " + consStart +'\n'+
                "08.End-Time            : " + consEnd +'\n'+
                "09.Consulted-Doctor    : " + docconsId +'\n'+
                "10.Cost-for-Consulation: " + cost+'\n'+
                "11.Additional-Note  : \n" + consNotes +'\n';
    }
}
