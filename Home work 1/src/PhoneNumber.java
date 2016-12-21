import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class PhoneNumber {

    public static void main(String[] args) {

        String phoneNumber = null;
        String finalResult;
        Boolean validationResult = false;
        int count = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter the phone number:");

        while (validationResult != true) {

            phoneNumber = sc.nextLine();
            validationResult = new PhoneNumberValidator().validate(phoneNumber);
            if (validationResult) {
                System.out.println("Phone number is correct");
                break;
            }
            System.out.println("Phone number is incorrect. Please, enter the phone number:");
        }
        finalResult = new CalculatedService().calculate(phoneNumber);

        while (finalResult.length() > 1) {


            System.out.println(count + "st round of calculation, sum is:" + finalResult);
            phoneNumber = finalResult;
            finalResult = new CalculatedService().calculate(phoneNumber);
            count++;
        }
        System.out.print("Final result is: ");
        switch (Integer.parseInt(finalResult)) {
            case 1:
                System.out.print("One");
                break;
            case 2:
                System.out.print("Two");
                break;
            case 3:
                System.out.print("Three");
                break;
            case 4:
                System.out.print("Four");
                break;
            default:
                System.out.print(finalResult);
        }
    }
}

class PhoneNumberValidator {

    public boolean validate(String phoneNumber) {
        if (phoneNumber.length() < 10 || phoneNumber.length() > 17) {
            return false;
        }
        Pattern format = Pattern.compile("^(\\+?\\d+)?\\s*(\\(\\d+\\))?[\\s-]*([\\d-]*)$");
        Matcher validation = format.matcher(phoneNumber);
        return validation.matches();
    }
}

class CalculatedService {

    public String calculate(String phoneNumber) {
        Integer finalResult = 0;

        String[] numbers = phoneNumber.split("");
        int i = 0;
        for (String number : numbers) {
            try {
                i = Integer.parseInt(number);
                finalResult += i;
            } catch (NumberFormatException e) {
            }
        }
        return finalResult.toString();
    }
}