import java.util.Scanner;
public class ImmutableObject {
    public static void main(String[] args) {
        float fahrenheit, centigrade;

        fahrenheit = 98.6f;
        centigrade = 5.0f / 9.0f * (fahrenheit - 32);

        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Centigrade: " + centigrade);

        for (float f = 0.0f; f <= 40.0f; f += 4.0f) {
            float c = 5.0f / 9.0f * (f - 32);
            System.out.println("Fahrenheit: " + f + ", Centigrade: " + c);
        }

        float f = 0.0f;
        while (f <= 40.0f) {
            float c = 5.0f / 9.0f * (f - 32);
            System.out.println("Fahrenheit: " + f + ", Centigrade: " + c);
            f += 4.0f;
        }
    }

    public static void StopChecking() {
        String[] cars = {"BMW", "Ferrari", "Lambo"};
        String[] food = {"pizza", "burger", "dumpling"};
        String[][] myArray = {cars, food};


        String isin, inputwords;
        isin = "False";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        while (true) {
            inputwords = scanner.next();

            if (inputwords.equals("STOP"))
                break;

            for (int i = 0; i < myArray.length; i++) {
                for (int j = 0; j < myArray[i].length; j++) {
                    if (myArray[i][j].equalsIgnoreCase(inputwords)) {
                        isin = "True";
                        break;
                    }
                }
            }

            if (isin.equals("True")) {
                System.out.println(inputwords + " is in the 2D array.");
            } else {
                System.out.println(inputwords + " is not in the 2D array.");
            }
        }
    }
}


