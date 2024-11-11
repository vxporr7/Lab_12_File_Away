import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser("src");
        int status = fileChooser.showSaveDialog(null);

        if (status != JFileChooser.APPROVE_OPTION) {
            System.out.println("Please select a file");
            return;
        }

        File selectedFile = fileChooser.getSelectedFile();
        Scanner fileReader = new Scanner(selectedFile);
        String line;
        int i = 0;
        int words = 0;
        int characers = 0;

        while (fileReader.hasNextLine()) {
            line = fileReader.nextLine();
            System.out.println(line);
            words += line.split(" ").length;
            characers += line.length();
            i += 1;
        }

        System.out.println("\n====== REPORT ======");
        System.out.printf("File Name: %s\n", selectedFile.getName());
        System.out.printf("Number of lines: %d\n", i);
        System.out.printf("Number of words: %d\n", words);
        System.out.printf("Number of characters: %d\n", characers);

    }
}