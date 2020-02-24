import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1
{
	static Scanner in = new Scanner(System.in);
	
	// Quizzes the user
	public void quiz()
	{
		// Generate two random numbers and find the solution
		SecureRandom generator = new SecureRandom();
		int num1 = generator.nextInt(10);
		int num2 = generator.nextInt(10);
		int solution = num1 * num2;
		
		// Ask the user and get their response
		askQuestion(num1, num2);
		int response = readResponse();
		
		// Keep looping until they answer correctly
		while(!isAnswerCorrect(solution, response))
		{
			displayIncorrectResponse();
			response = readResponse();
		}
		
		displayCorrectResponse();
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
	
	// Correct answer from user
	public void displayCorrectResponse()
	{
		System.out.println("Very good!");
	}
	
	// Incorrect answer from user
	public void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
	}
	
	public static void main(String[] args)
	{
		CAI1 cai1 = new CAI1();
		cai1.quiz();
	}
}