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
  

public Collection<Student> findStudentByName(String name) throws IOException {
    Collection<Student> foundStudents = new ArrayList<>();
    for (Student student : getStudents()) {
        if (student.getName().equalsIgnoreCase(name)) {
            foundStudents.add(student);
        }
    }
    return foundStudents;
}
}