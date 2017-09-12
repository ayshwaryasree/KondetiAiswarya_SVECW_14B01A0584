import java.util.Date;

import javax.swing.text.Utilities;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students == null) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < students.length; i++) {
		    this.students[i] = students[i];
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student == null) {
			throw new IllegalArgumentException();
		}
		students[0] = student;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student == null) {
			throw new IllegalArgumentException();
		}
		students[students.length - 1] = student;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student == null) {
			throw new IllegalArgumentException();
		}
		if(index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		students[index] = student;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		int  i;
		for(i = index; i < students.length - 1; i++) {
			students[i] = students[i + 1]; 
		}
		students[i] = null;
		
	}
	Boolean compare_obj(Student s1, Student s2) {
    	if(s1.getId() == s2.getId()) {
    		if(s1.getFullName().equals(s2.getFullName())) {
    			if(s1.getAvgMark() == s2.getAvgMark()) {
    				if(s1.getBirthDate().equals(s2.getBirthDate())) {
    					return Boolean.TRUE;
    				}
    			}
    		}
    	}
    	return Boolean.FALSE;
    }
	@Override
	public void remove(Student student) {
		// Add your implementation here
		
		int pos = -1;
		for(int i = 0; i < students.length; i++) {
			if(compare_obj(students[i], student)) {
				pos = i;
				break;
			}
		}
		remove(pos);	
	}
    
	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		for(int i = index + 1; i < students.length; i++) {
			students[i] = null; 
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		int pos = -1;
		for(int i = 0; i < students.length; i++) {
			if(compare_obj(students[i], student)) {
				pos = i;
				break;
			}
		}
		removeFromIndex(pos);
		
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		for(int i = 0 ; i < index; i++) {
			students[i] = null; 
		}
		for(int i = 0; i < index && (i + index < students.length); i++) {
			students[i] = students[i + index]; 
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int pos = -1;
		for(int i = 0; i < students.length; i++) {
			if(compare_obj(students[i], student)) {
				pos = i;
				break;
			}
		}
		removeToIndex(pos);
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max = students[0].getAvgMark();
		for(int i = 1; i < students.length; i++) {
			double temp = students[i].getAvgMark();
			if(temp > max) {
				max = temp;
			}
		}
		Student[] arr = new Student[students.length];
		int j = 0;
		for(int i = 0; i < students.length; i++) {
			if(max == students[i].getAvgMark()) {
				arr[j] = students[i];
				j++;
			}
		}
		return arr;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		int pos = -1;
		for(int i = 0; i < students.length; i++) {
			if(compare_obj(students[i], student)) {
				pos = i;
				break;
			}
		}
		if(pos == -1) {
			return null;
		}
		else {
			if(pos == students.length - 1) {
				return null;
			}
			else {
				return students[pos + 1];
			}
		}
	}
}

