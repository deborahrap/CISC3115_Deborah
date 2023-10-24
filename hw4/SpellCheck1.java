package CISC3115_Deborah.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Dictionary {
    private String filename;

    public Dictionary(String filename) {
        this.filename = filename;
    }

    public boolean found(String word) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
                String fileWord = fileScanner.next().toLowerCase();
                if (word.toLowerCase().equals(fileWord)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return false;
    }
}

public class SpellCheck1 {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("Dictionary");

        try (Scanner paperScanner = new Scanner(new File("paper"))) {
            int lineNumber = 0;

            while (paperScanner.hasNextLine()) {
                lineNumber++;
                String line = paperScanner.nextLine();

                Scanner lineScanner = new Scanner(line);
                while (lineScanner.hasNext()) {
                    String word = lineScanner.next();
                    if (!dictionary.found(word)) {
                        System.out.printf("Line %4d: %s%n", lineNumber, word);
                    }
                }
                lineScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading the paper file: " + e.getMessage());
        }
    }
}
