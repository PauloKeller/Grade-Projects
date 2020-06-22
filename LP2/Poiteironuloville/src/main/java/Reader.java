import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader {
    private String[] splitData(String value) {
        return value.split(" ");
    }

    public ArrayList<String> read(String filename) {
        try {
            File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(filename)).getFile());
            Scanner scanner = new Scanner(file);
            ArrayList<String> phones = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);

                phones.addAll(Arrays.asList(splitData(data)));
            }
            System.out.println("all data: " + phones.toString());
            scanner.close();
            return phones;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
