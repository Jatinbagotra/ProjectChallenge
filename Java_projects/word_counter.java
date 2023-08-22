import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class word_counter{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'text' to input text manually or 'file' to provide a file: ");
        String choice = scanner.nextLine();

        String inputText = "";
        if (choice.equalsIgnoreCase("text")) {
            System.out.println("Enter your text:");
            inputText = scanner.nextLine();
        } else if (choice.equalsIgnoreCase("file")) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                inputText = readFromFile(filePath);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice.");
            System.exit(1);
        }

        String[] words = inputText.split("[\\s.,;?!]+"); 
        int wordCount = words.length;

        System.out.println("Total word count: " + wordCount);
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}