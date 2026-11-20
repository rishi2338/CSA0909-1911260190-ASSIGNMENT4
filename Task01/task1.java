import java.util.Scanner;

/*
 * Task 1: Fee payment design.
 * The window/controller collects input; FeeService validates and processes it.
 * Database integration can be added inside FeeService without putting JDBC in the UI.
 */
public class task1 {
    static class FeeService {
        String pay(String registerNumber, String amountText) {
            if (registerNumber == null || registerNumber.isBlank())
                return "Enter a register number.";
            final double amount;
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException ex) {
                return "Enter a valid amount.";
            }
            if (!Double.isFinite(amount) || amount <= 0)
                return "Amount must be greater than zero.";
            // Replace this demonstration result with a parameterised JDBC transaction.
            return String.format("Payment of %.2f recorded for %s.", amount, registerNumber);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FeeService service = new FeeService();
        System.out.print("Register number: ");
        String regNo = input.nextLine();
        System.out.print("Amount: ");
        String amount = input.nextLine();
        System.out.println(service.pay(regNo, amount));
    }
}