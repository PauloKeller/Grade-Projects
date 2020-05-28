import java.io.*;
import java.util.Objects;

public class Writer {
    public boolean write(String filename, String[] values) {
        try {
            File file = new File(filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            for(String value: values) {
                bufferedWriter.write(value);
                bufferedWriter.newLine();
                System.out.println("Successfully wrote to the file.");
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }
}
