
import java.util.Scanner; 
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      
      while(true) {
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyświetl studentów");
        System.out.println("0. Wyjście");
        System.out.print("Wybierz opcję: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        if(choice == 3) break;
        
        switch(choice) {
          case 1:
            System.out.println("Podaj imie:");
            String imie = scanner.nextLine();
            System.out.println("Podaj wiek:");
            int wiek = scanner.nextInt();
            s.addStudent(new Student(imie, wiek));
            break;
            
          case 2:
            var students = s.getStudents();
            for(Student current : students) {
              System.out.println(current.ToString());
            }
            break;
            
          default:
            System.out.println("Nieprawidłowa opcja");
        }
      }
    } catch (IOException e) {
      System.out.println("Błąd: " + e.getMessage());
    }
  }
}
