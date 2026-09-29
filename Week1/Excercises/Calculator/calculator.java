Double performOperation(String operation) {
    String firstNumberString = IO.readln("Give me the first number: ");
    Double firstNumber = Double.parseDouble(firstNumberString);
    
    String secondNumberString = IO.readln("Give me the second number: ");
    Double secondNumber = Double.parseDouble(secondNumberString);
    
    switch (operation) {
        case "+":
            return firstNumber + secondNumber;
        case "-":
            return firstNumber - secondNumber;
        case "*":
            return firstNumber * secondNumber;
        case "/":
            if (secondNumber != 0) {
                return firstNumber / secondNumber;
            } else {
                IO.println("Error: Division by zero.");
                return null;
            }
        case "%":
            if (secondNumber != 0) {
                return firstNumber % secondNumber;
            } else {
                IO.println("Error: Division by zero.");
                return null;
            }
        default:
            IO.println("Error: Invalid operation.");
            return null;
    }
}

void main() {
    String input = IO.readln("Give me the operation you want to perform (+, -, *, /, %): \n");
    Double result = performOperation(input);
    if (result != null) {
        IO.println("The result is: " + result);
    } else {
        IO.println("Operation could not be performed due to an error.");
    }
}