import java.util.Random;

void main() {
    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;

    int numberOfGuesses = 0;
    int guess = 0;

    while(guess != randomNumber) {
        String input = IO.readln("Guess a number between 1 and 100: ");
        guess = Integer.parseInt(input);
        numberOfGuesses++;

        if (guess < randomNumber) {
            IO.println("Too low! Try again.");
        } else if (guess > randomNumber) {
            IO.println("Too high! Try again.");
        } else {
            IO.println("Congratulations! You've guessed the number in " + numberOfGuesses + " attempts.");
        }
    }

}