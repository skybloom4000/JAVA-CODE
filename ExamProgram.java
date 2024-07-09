import java.util.Scanner;
public class ExamProgram {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\nExam Program Menu:");
      System.out.println("1. View coursework results");
      System.out.println("2. View exam results (Enter results if not available)");
      System.out.println("3. Exit program");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          viewCourseworkResults(scanner);
          break;
        case 2:
          viewExamResults(scanner);
          break;
        case 3:
          System.out.println("Exiting program...");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (choice != 3);

    scanner.close();
  }

  private static void viewCourseworkResults(Scanner scanner) {
    System.out.println("\nEnter assignment 1 score: ");
    double ass1 = scanner.nextDouble();
    System.out.println("Enter assignment 2 score: ");
    double ass2 = scanner.nextDouble();
    System.out.println("Enter assignment 3 score: ");
    double ass3 = scanner.nextDouble();
    System.out.println("Enter CAT 1 score: ");
    double cat1 = scanner.nextDouble();
    System.out.println("Enter CAT 2 score: ");
    double cat2 = scanner.nextDouble();

    double coursework = (ass1 + ass2 + ass3 + cat1 + cat2) / 5;

    System.out.printf("\nCoursework score: %.2f\n", coursework);

    checkCourseworkCompletion(coursework);
  }

  private static void viewExamResults(Scanner scanner) {
    System.out.print("Enter final exam score (or 'N' if not available): ");
    String finalExamStr = scanner.nextLine();

    if (finalExamStr.toUpperCase().equals("N")) {
      System.out.println("\nFinal exam results not available yet.");
    } else {
      double finalExam = Double.parseDouble(finalExamStr);
      System.out.printf("\nFinal exam score: %.2f\n", finalExam);
    }
  }

  private static void checkCourseworkCompletion(double courseworkScore) {
    int numAssessments = countCourseworkAssessments();
    double completionThreshold = 2.0 / 3 * numAssessments;

    if (courseworkScore < 0 || courseworkScore > 100) {
      System.out.println("\nInvalid coursework score. Please enter a value between 0 and 100.");
    } else if (numAssessments < completionThreshold) {
      System.out.printf("\nNot enough coursework completed. You need to complete at least %.0f assessments.\n", completionThreshold);
      System.out.println("Repeating the unit is mandatory regardless of final exam score.");
    } else {
      System.out.printf("\nCoursework completion met. You have completed %d assessments.\n", numAssessments);
    }
  }

  private static int countCourseworkAssessments() {
    String[] assessments = {"ass1", "ass2", "ass3", "cat1", "cat2"}; // Modify this list as needed
    int count = 0;

    for (String assessment : assessments) {
      count++;
    }

    return count;
  }
}
