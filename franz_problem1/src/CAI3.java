import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3
{
	static Scanner in = new Scanner(System.in);
	static SecureRandom generator = new SecureRandom();
	
	// Quizzes the user
	public void quiz()
	{
		int correctResponses = 0;
		
		// Ask the user 10 questions
		for (int i = 0; i < 10; i++)
		{
			// Generate two random numbers and find the solution
			int num1 = generator.nextInt(10);
			int num2 = generator.nextInt(10);
			int solution = num1 * num2;
			
			// Ask the user and get their response
			askQuestion(num1, num2);
			int response = readResponse();
			
			// Check if they were correct
			if(isAnswerCorrect(solution, response))
			{
				displayCorrectResponse();
				correctResponses++;
			}
			
			else
			{
				displayIncorrectResponse();
			}
		}
		
		displayCompletionMessage(correctResponses / 10.0);
	}
	
	// Asks the user a multiplication problem
	public void askQuestion(int num1, int num2)
	{
		System.out.println("How much is " + num1 + " times " + num2 + "?");
	}
	
	// Gets a response from the user
	public int readResponse()
	{
		return in.nextInt();
	}
	
	// Checks if an answer is correct
	public boolean isAnswerCorrect(int solution, int answer)
	{
		return (solution == answer);
	}
	
	// Displays a randomly selected correct response
	public void displayCorrectResponse()
	{
		int responseNum = generator.nextInt(4) + 1;
		
		switch (responseNum)
		{
			case 1:
				System.out.println("Very good!");
				break;
			case 2:
				System.out.println("Excellent!");
				break;
			case 3:
				System.out.println("Nice work!");
				break;
			case 4:
				System.out.println("Keep up the good work!");
				break;
		}
	}
	
	// Displays a randomly selected incorrect response
	public void displayIncorrectResponse()
	{
		int responseNum = generator.nextInt(4) + 1;
		
		switch (responseNum)
		{
			case 1:
				System.out.println("No. Please try again.");
				break;
			case 2:
				System.out.println("Wrong. Try once more.");
				break;
			case 3:
				System.out.println("Don't give up!");
				break;
			case 4:
				System.out.println("No. Keep trying.");
				break;
		}
	}
	
	// Displays message at the end of the quiz, then finds out if the user wants to restart and proceeds accordingly
	public void displayCompletionMessage(double percentage)
	{
		if (percentage < 0.75)
			System.out.println("Please ask your teacher for help.");
		else
			System.out.println("Congratulations, you are ready to go to the next level!");
		
		
		System.out.println("Would you like to solve a new problem set?");
		System.out.println("Please enter 'yes' or 'no'");
		String restart = in.next();
		
		while (!(restart.equalsIgnoreCase("yes") || restart.equalsIgnoreCase("no")))
		{
			System.out.println("Invalid response. Please try again.");
			restart = in.next();
		}
		
		if(restart.equalsIgnoreCase("yes"))
			quiz();
		else
			System.exit(0);
	}
	
	public static void main(String[] args)
	{
		CAI3 cai3 = new CAI3();
		cai3.quiz();
	}
}