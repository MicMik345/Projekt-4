/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/
import java.util.Scanner; 
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      
      Scanner myObj = new Scanner(System.in);
      System.out.println("Podaj imie:");
      String imie = myObj.nextLine();
      System.out.println("Podaj wiek:");
      int wiek = myObj.nextInt();

      s.addStudent(new Student(imie, wiek));
      

      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }
    } catch (IOException e) {

    }
  }
}