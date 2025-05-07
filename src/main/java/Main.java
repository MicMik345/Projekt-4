
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      boolean tak = true;
      while(tak){
        System.out.println("\nWybierz opcję:");
        System.out.println("1 - Dodaj studenta");
        System.out.println("2 - Wyświetl wszystkich studentów");
        System.out.println("3 - Wyszukaj studenta po imieniu");
        System.out.println("4 - Usuń studenta");
        System.out.println("5 - Zaktualizuj dane studenta");
        System.out.print("Twój wybór: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
          case 1:
            System.out.print("Podaj imię studenta: ");
            String name = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta: ");
            String lastname = scanner.nextLine();

            int age = 0;
            boolean validAge = false;
            while (!validAge) {
              System.out.print("Podaj wiek studenta: ");
              try {
                age = Integer.parseInt(scanner.nextLine());
                validAge = true;
              } catch (NumberFormatException e) {
                System.out.println("Wiek musi być liczbą. Spróbuj ponownie.");
              }
            }

            String birthDate;
            boolean validDate = false;
            do {
              System.out.print("Podaj datę urodzenia (DD-MM-RRRR): ");
              birthDate = scanner.nextLine();
              validDate = Student.isValidDate(birthDate);
              if (!validDate) {
                System.out.println("Nieprawidłowa data. Format: DD-MM-RRRR");
              }
            } while (!validDate);

            s.addStudent(new Student(name, lastname, age, birthDate));
            System.out.println("Dodano studenta.");
            break;

          case 2:
            var students = s.getStudents();
            System.out.println("Lista studentów:");
            for (Student current : students) {
              System.out.println(current.toString());
            }
            break;
          case 3:
            System.out.print("Podaj imię studenta do wyszukania: ");
            String searchName = scanner.nextLine();
            Student foundStudent = s.findStudentByName(searchName);
            if (foundStudent != null) {
              System.out.println("Znaleziono studenta:");
              System.out.println(foundStudent);
            } else {
              System.out.println("Nie znaleziono studenta o imieniu: " + searchName);
            }
            break;
          case 4:
            System.out.print("Podaj imię studenta do usunięcia: ");
            String deleteName = scanner.nextLine();
            System.out.print("Podaj nazwisko studenta do usunięcia: ");
            String deleteLastName = scanner.nextLine();
            try {
              s.deleteStudent(deleteName, deleteLastName);
              System.out.println("Student został usunięty.");
            } catch (IOException e) {
              System.out.println(e.getMessage());
            }
            break;
          case 5:
            System.out.print("Podaj imię studenta: ");
            String updateName = scanner.nextLine();
            System.out.print("Podaj nazwisko studenta: ");
            String updateLastName = scanner.nextLine();
            
            int newAge = 0;
            boolean validUpdateAge = false;
            while (!validUpdateAge) {
              System.out.print("Podaj nowy wiek studenta: ");
              try {
                newAge = Integer.parseInt(scanner.nextLine());
                validUpdateAge = true;
              } catch (NumberFormatException e) {
                System.out.println("Wiek musi być liczbą. Spróbuj ponownie.");
              }
            }
            
            try {
              s.updateStudentAge(updateName, updateLastName, newAge);
              System.out.println("Dane studenta zostały zaktualizowane.");
            } catch (IOException e) {
              System.out.println(e.getMessage());
            }
            break;
        }
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("Błąd: " + e.getMessage());
    }
  }
}
