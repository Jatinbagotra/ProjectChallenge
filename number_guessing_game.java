import java.util.*;


public class number_guessing_game{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int min_value= 1;
        int max_value = 100;
        int max_attempts = 10;
        

        System.out.println("You are most welcomed at Number Guessing game!");
        int total_rounds = 0;
        int total_attempts = 0;

        boolean play_again = true;
        while (play_again) {
            total_rounds++;
            int computer_number = random.nextInt(max_value - min_value + 1) + min_value;
            int attempts = 0;
            
            System.out.println("Round No. : " + total_rounds);
            
            while (attempts < max_attempts) {
                attempts++;
                System.out.print("Attempt " + attempts + "/" + max_attempts + ": You have to guess a number between " + min_value + " and " + max_value + ": ");
                int userGuess = sc.nextInt();
                
                if (userGuess < computer_number) {
                    System.out.println("Too low! Guess a higher number.");
                } else if (userGuess > computer_number) {
                    System.out.println("Too high! Guess a lower number.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + computer_number + " correctly in " + attempts + " attempts.");
                    total_attempts += attempts;
                    break;
                }
            }
            
            if (attempts == max_attempts) {
                System.out.println("Sorry, you can't play anymore. The correct number was " + computer_number + ".");
            }
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase();   
            play_again = playAgainInput.equals("yes");
        }
        
        System.out.println("Game Over!") ;
        System.out.println("You played " + total_rounds + " rounds  " );
        double score =  total_attempts / total_rounds;
        System.out.print("Your average attempts per round:"+ score);
    }
    
}
