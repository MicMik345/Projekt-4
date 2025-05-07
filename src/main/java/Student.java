
public class Student {
  private String name;
  private int age;
  private String lastName;
  private String birthDate;

  public Student(String name, String lastName, int age, String birthDate) {
    this.name = name;
    this.age = age;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  public String getName() {return name;}
  public String getLastName() {return lastName;}
  public int getAge() {return age;}
  public String getBirthDate() {return birthDate;}

  public String toString() {
    return name + " " + lastName + " " + Integer.toString(age) + " " + birthDate;
  }

  public static boolean isValidDate(String date) {
    String[] parts = date.split("_");
    if (parts.length != 3) return false;  
    
    try {
      int day = Integer.parseInt(parts[0]);
      int month = Integer.parseInt(parts[1]);
      int year = Integer.parseInt(parts[2]);
      
      if (year < 1900 || year > 2025) return false;
      if (month < 1 || month > 12) return false;
      if (day < 1 || day > 31) return false;
      
     
      if (month == 4 || month == 6 || month == 9 || month == 11) {
        if (day > 30) return false;
      } else if (month == 2) {
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (day > (isLeap ? 29 : 28)) return false;
      }
      
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static Student parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 4) {
      return new Student("Parse Error", "Parse Error", -1, "01-01-1900");
    }
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }
}
