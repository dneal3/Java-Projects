public class Phonebook {
    public String fname;
    public String lname;
    public String pNum;

    public Phonebook(String phone, String lastName, String firstName){
        pNum = phone;
        lname = lastName;
        fname = firstName;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getpNum() {
        return pNum;
    }
}
