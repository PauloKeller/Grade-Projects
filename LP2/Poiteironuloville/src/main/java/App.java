import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        final PhoneValidator phoneValidator = new PhoneValidator();
        final Reader reader = new Reader();
        final Writer writer = new Writer();

        final String inputFile = "phones.txt";
        final ArrayList<String> phones = reader.read(inputFile);
        final ArrayList<String> validPhones = new ArrayList<>();
        final ArrayList<String> invalidPhones = new ArrayList<>();

        System.out.println("phones: " + phones.toString());
        phones.forEach(phone -> {
            if (phoneValidator.validate(phone)) {
                validPhones.add(phone);
            } else {
                invalidPhones.add(phone);
            }
        });
        System.out.println("valid phones: " + validPhones.toString());
        System.out.println("invalid phones: " + invalidPhones.toString());
        String result = phones.size() + "| " + validPhones.size();
        validPhones.add(result);
        String[] phonesArray = validPhones.toArray(new String[0]);
        writer.write("valid.txt", phonesArray);
    }
}
