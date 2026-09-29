Boolean isPrime(Integer num) {
    if (num <= 1) {
        return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

void main() {
    String number = IO.readln("Give me a number to analyze: ");
    Integer num = Integer.parseInt(number);
    
    boolean isEven = num % 2 == 0;
    boolean isPositive = num > 0;
    boolean isPrime = isPrime(num);

    IO.println(isEven ? "Even" : "Odd");
    IO.println(isPositive ? "Positive" : "Negative");
    IO.println(isPrime ? "Prime" : "Not Prime");
}