import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.toString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while (true) {
      line = reader.readLine();
      if(line == null)
        break;
      ret.add(Student.parse(line));
    }
    reader.close();
    return ret;
  }
  

public Student findStudentByName(String name) throws IOException {
    for (Student student : getStudents()) {
        if (student.getName().equalsIgnoreCase(name)) {
            return student;
        }
    }
    return null; 
}

public void deleteStudent(String name, String lastName) throws IOException {
    Collection<Student> students = getStudents();
    BufferedWriter writer = new BufferedWriter(new FileWriter("db.txt"));
    boolean found = false;
    
    for (Student student : students) {
        if (!(student.getName().equalsIgnoreCase(name) && 
              student.getLastName().equalsIgnoreCase(lastName))) {
            writer.write(student.toString());
            writer.newLine();
        } else {
            found = true;
        }
    }
    writer.close();
    if (!found) {
        throw new IOException("Nie znaleziono studenta");
    }
}
}