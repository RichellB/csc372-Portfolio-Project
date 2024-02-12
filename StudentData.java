import java.io.Serializable;

// StudentData class 
public class StudentData implements Serializable {

    private String name;
    private String address;
    private double gpa;

    // Class constructor
    public StudentData(String stdName, String stdAddress, double stdGPA) {
        this.name = stdName;
        this.address = stdAddress;
        this.gpa = stdGPA;
    }

    // Setter and getter methods
    public void setStudentName(String stdName) {
        this.name = stdName;
    }
    
    public void setStudentAddress(String stdAddress) {
        this.address = stdAddress;
    }	

    public void setGPA(double stdGPA) {
        this.gpa = stdGPA;
    }

    public String getStudentName() {
        return name;
    }

    public String getStudentAddress() {
        return address;
    }

    public double getGPA() {
        return gpa;
    }
    

    // Custom toString method
       @Override
       public String toString() {
           return "[ Name=" + name + ", Address=" + address + ", GPA=" + gpa + "]";
       }

}
