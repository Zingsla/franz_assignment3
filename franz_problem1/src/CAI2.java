import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2
{
	static Scanner in = new Scanner(System.in);
	static SecureRandom generator = new SecureRandom();
	
	// Quizzes the user
	public void quiz()
	{
		// Generate two random numbers and find the solution
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
			default:
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
			default:
				break;
		}
	}
	
	public static void main(String[] args)
	{
		CAI2 cai2 = new CAI2();
		cai2.quiz();
	}
}