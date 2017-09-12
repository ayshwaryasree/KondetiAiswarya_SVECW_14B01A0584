package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		String date= "1997-04-26";
		StudentGroup sg = new StudentGroup(4);
		Student[] s = new Student[2];
    	s[0] = null;
    	s[1] = null;
    	Student s1 = null, s2 = null;
		try {
			s[0] = new Student(1, "Aishu",  new SimpleDateFormat("yyyy-MM-dd").parse(date), 98);
			s[1] = new Student(2, "Aishu1",  new SimpleDateFormat("yyyy-MM-dd").parse(date), 97);
			sg.setStudents(s);
			s1= new Student(3, "Aishu2",  new SimpleDateFormat("yyyy-MM-dd").parse(date), 96);
            sg.setStudent(s1, 2);
            s2 = new Student(4, "Aishu3",  new SimpleDateFormat("yyyy-MM-dd").parse(date), 95);
            sg.add(s2, 3);
            sg.addFirst(s2);
            sg.addLast(s[0]);
            sg.remove(s[0]);
            

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
