import java.io.*;
import java.util.Scanner;

public class NotesManager {

    private static final String FILE_NAME = "notes.txt";  // File to store notes

    // Method to display menu options
    public static void displayMenu() {
        System.out.println("\nWelcome to the Notes Manager!");
        System.out.println("1. Add a new note");
        System.out.println("2. View all notes");
        System.out.println("3. Exit");
        System.out.print("Please choose an option: ");
    }

    // Method to write a note to the file
    public static void writeNoteToFile(String note) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true);  // 'true' to append to file
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write(note);
            bufferedWriter.newLine();  // Add a new line after each note
            System.out.println("Note added successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing the note.");
            e.printStackTrace();
        }
    }

    // Method to read and display all notes from the file
    public static void readNotesFromFile() {
        try (FileReader reader = new FileReader(FILE_NAME);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            boolean hasNotes = false;
            System.out.println("\nYour Notes:");

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                hasNotes = true;
            }

            if (!hasNotes) {
                System.out.println("No notes found.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the notes.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main loop to interact with the user
        while (true) {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left over

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = scanner.nextLine();
                    writeNoteToFile(note);
                    break;
                case 2:
                    readNotesFromFile();
                    break;
                case 3:
                    System.out.println("Exiting Notes Manager. Goodbye!");
                    scanner.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
