public class BankingApplication {
    static String account = "";
    static boolean isAccountCreated = false;
    static double balance = 0.0;
    static int movements = 0;
    static String history = "";

    static void printMenu() {
        IO.println("Choose one of the options (number): ");
        IO.println("1. Create Account");
        IO.println("2. Deposit");
        IO.println("3. Withdraw");
        IO.println("4. Check Balance");
        IO.println("5. View History");
        IO.println("0. Exit");
    }

    static void createAccount() {
        if(isAccountCreated) {
            IO.println("You are already in a session");
            return;
        }

        String accountName = IO.readln("Give me the name of the account: ");

        accountName = accountName.trim();

        if(accountName.isEmpty()) {
            IO.println("Account name cannot be empty");
            return;
        }

        account = accountName;
        isAccountCreated = true;
        history = "Account created for " + account + " initial balance of 0.0\n";
        IO.println("Account created succesfully");
    }

    static boolean validateAccount() {
        if(!isAccountCreated) {
            IO.println("First you need to create an account");
            return false;
        }
        
        return true;
    }

    static double readAmount() {
        String amount = IO.readln("Give me the amount: ");
        
        double amountDouble = 0.0;
        try {
            amountDouble = Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            IO.println("Insert a valid amount");
            return -1;
        }

        if(Double.isInfinite(amountDouble) || Double.isNaN(amountDouble)) {
            IO.println("Invalid amount: amount cant be NaN or Infinite");
            return -1;
        }

        if(amountDouble == 0) {
            IO.println("Invalid amount: the amount can't be 0");
            return -1;
        }

        if(amountDouble < 0 ) {
            IO.println("Invalid amount: amount can't be less than 0");
            return -1;
        }

        if(amountDouble < 0.01) {
            IO.println("Invalid amount: the amount can't be less than 0.01");
            return -1;
        }

        return amountDouble;
    }

    static void deposit() {
        double amount = readAmount();

        if(amount == -1) {
            return;
        }

        balance = Math.round((balance + amount) * 100.0) / 100.0;;
        registerMovement("Deposit", amount);
        IO.println("Deposit completed, new balance: " + balance);
    }

    static void withdraw() {
        double amount = readAmount();

        if(amount == -1){
            return;
        }

        if(amount > balance) {
            IO.println("Not enough balance to withdraw that amount");
            return;
        }

        balance = Math.round((balance - amount) * 100.0) / 100.0;
        registerMovement("Withdraw", amount);
        IO.println("Withdraw completed, new balance: " + balance);
    }

    static void registerMovement(String movementType, double amount) {
        movements++;
        history += String.format("%d. %s: $%.2f | Balance: $%.2f%n", movements, movementType, amount, balance);
    }

    public static void main() {
        String option;

        do {
            printMenu();
            option = IO.readln();

            switch (option) {
                case "1":
                    createAccount();
                    break;
            
                case "2":
                    if(validateAccount()) {
                        deposit();
                    }
                    break;

                case "3":
                    if(validateAccount()) {
                        withdraw();
                    }
                    break;

                case "4":
                    if(validateAccount()) {
                        IO.println("Account: " + account);
                        IO.println(String.format("Balance: %.2f", balance));
                    }
                    break;

                case "5":
                    if(validateAccount()) {
                        IO.println(history);
                    }
                    break;

                case "0":
                    IO.println("Bye");
                    break;

                default:
                    IO.println("Invalid option");
                    break;
            }

        } while (!option.equals("0"));
        
    } 
}