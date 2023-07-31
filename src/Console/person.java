package Console;

import java.time.LocalDate;


public class person {
    private String name;
    private String  surname;
    private LocalDate dateofbirth;
    private String  mobilenumber;

    public person(String n,String sname,LocalDate dob,String mobnum) {
        this.name = n;
        this.surname = sname;
        this.dateofbirth = dob;
        this.mobilenumber = mobnum;
    }
    public  String  getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public  String  getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public LocalDate getDateofbirth(){
        return dateofbirth;
    }
    public void setDateofbirth(LocalDate dateofbirth){
        this.dateofbirth=dateofbirth;
    }
    public String  getMobilenumber(){
        return mobilenumber;
    }
    public void setMobilenumber(String mobilenumber){
        this.mobilenumber=mobilenumber;
    }

}
