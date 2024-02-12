import java.io.Serializable;
import java.util.Comparator;

// Comparator class to sort student names
public class StudentDataNameComparator implements Serializable {
    
    public static Comparator<StudentData> StuDataNameComparator = new Comparator<StudentData>() {

        public int compare(StudentData s1, StudentData s2) {
           String StudentName1 = s1.getStudentName().toUpperCase();
           String StudentName2 = s2.getStudentName().toUpperCase();
    
           // Sorting in ascending order
           return StudentName1.compareTo(StudentName2);
    
        }};

}
