import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int passwordLength;
        do {
            System.out.print("Enter desired length of your password (at least 8 characters): ");
            passwordLength = input.nextInt();
        } while (passwordLength < 8);

        String lowerCases = "qwertyuiopasdfghjklzxcvbnm";
        String upperCases = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        String password = generatePassword(passwordLength, lowerCases, upperCases, specialChars);
        System.out.println("Generated password: " + password);
    }

    public static String generatePassword(int length, String lowerCases, String upperCases, String specialChars) {
        String password = "";
        for (int i = 0; i < length; i++) {
            int rand = (int)(4 * Math.random());

            switch (rand) {
                case 0:
                    password += String.valueOf((int)(10 * Math.random()));
                    break;
                case 1:
                    rand = (int)(lowerCases.length() * Math.random());
                    password += lowerCases.charAt(rand);
                    break;
                case 2:
                    rand = (int)(upperCases.length() * Math.random());
                    password += upperCases.charAt(rand);
                    break;
                case 3:
                    rand = (int)(specialChars.length() * Math.random());
                    password += specialChars.charAt(rand);
                    break;
            }
        }
        return password;
    }
}
