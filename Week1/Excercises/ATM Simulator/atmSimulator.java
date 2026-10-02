public class ATMSimulator {
    
    public static void printMenu() {
        IO.println("Choose one of the options (number): ");
        IO.println("1. Check Balance");
        IO.println("2. Deposit");
        IO.println("3. Withdraw");
        IO.println("4. Exit");
    }

    public static double deposit(double balance) {
        String amount = IO.readln("How much money do you want to deposit: ");
        double amountDouble = Double.parseDouble(amount);
        
        if(amountDouble < 0) {
            IO.println("Could not deposit an amount less than 0");
            return balance;
        }
        
        return balance + amountDouble;
    }
    
    public static double withdraw(double balance) {
        String amount = IO.readln("How much money do you want to withdraw: ");
        double amountDouble = Double.parseDouble(amount);
        
        if(amountDouble < 0) {
            IO.println("Could not witdhraw an amount less than 0");
            return balance;
        }

        if(balance < amountDouble) {
            IO.println("Could not withdraw an amount higher than your current balance");
            return balance;
        }
        
        return balance - amountDouble;
    }

    public static void main(String[] args) throws Exception {
        String option;
        double balance = 0;
        
        do {
            printMenu();
            option = IO.readln();

            switch (option) {
                case "1":
                    IO.println("Current Balance:");
                    IO.println(balance);
                    break;
            
                case "2":
                    balance = deposit(balance);
                    break;

                case "3":
                    balance = withdraw(balance);
                    break;

                case "4":
                    IO.println("Bye!");
                    break;

                default:
                    IO.println(option + " is not a valid option.");
            }

        } while (!option.equals("4"));
    }
    
}
