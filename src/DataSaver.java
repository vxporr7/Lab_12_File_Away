import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    static String getRecord() throws IOException {
        InputStreamReader sr = new InputStreamReader(System.in);
        Scanner br = new Scanner(sr);

        String firstName = SafeInput.getNonZeroLenString(br, "Enter first name: ");
        String lastName = SafeInput.getNonZeroLenString(br, "Enter last name: ");
        String ID = SafeInput.getRegExString(br, "Enter ID: ", "^\\d{6}$");
        String email = SafeInput.getNonZeroLenString(br, "Enter email: ");
        String birth = SafeInput.getRegExString(br, "Enter birth year: ", "^\\d{4}$");

        return firstName+","+lastName+","+email+","+birth;
    }

    static void writeCSV(String fileName, ArrayList<String> records) throws IOException {
        File dataFile = new File("src/"+fileName);
        dataFile.createNewFile();

        FileWriter fw = new FileWriter("src/"+fileName);
        for (String record : records) {
            fw.write(record+"\n");
        }
        fw.close();
    }

    static boolean goAgain() throws IOException {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);

        System.out.print("Would like to enter another record? (y/n): ");
        String userInput = br.readLine();
        userInput = userInput.toLowerCase();

        if (userInput.equals("y")) {
            return true;
        } else if (userInput.equals("n")) {
            return false;
        }  else {
            return goAgain();
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> records = new ArrayList<String>();

        boolean playing = true;
        while (playing) {
            records.add(getRecord());
            playing = goAgain();
        }

        InputStreamReader sr = new InputStreamReader(System.in);
        Scanner br = new Scanner(sr);

        String fileName = SafeInput.getNonZeroLenString(br, "Enter name for CSV file: ")+".csv";
        writeCSV(fileName, records);

    }
}