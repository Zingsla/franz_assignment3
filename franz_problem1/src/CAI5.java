import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5
{
	static Scanner in = new Scanner(System.in);
	static SecureRandom generator = new SecureRandom();
	
	// Quizzes the user
	public void quiz()
	{
		int difficulty = readDifficulty();
		int type = readProblemType();
		int correctResponses = 0;
		
		// Ask the user 10 questions
		for (int i = 0; i < 10; i++)
		{
			// Generate two random numbers and find the solution
			int num1 = generateQuestionArgument(difficulty);
			int num2 = generateQuestionArgument(difficulty);
			
			// Ask the user and get their response
			int solution = askQuestion(num1, num2, type);
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
	
	// Reads in a valid difficulty level from the user
	public int readDifficulty()
	{
		System.out.println("Please enter a difficulty level (1-4)");
		int diff = in.nextInt();
		
		while (diff < 1 || diff > 4)
		{
			System.out.println("Invalid difficulty level. Please enter a number 1-4");
			diff = in.nextInt();
		}
		
		return diff;
	}
	
	// Reads in a valid problem type from the user
	public int readProblemType()
	{
		System.out.println("Please enter a problem type (1-5)");
		System.out.println("1 = Addition");
		System.out.println("2 = Multiplication");
		System.out.println("3 = Subtraction");
		System.out.println("4 = Division");
		System.out.println("5 = Random Mixture of All Types");
		
		int type = in.nextInt();
		
		while (type < 1 || type > 5)
		{
			System.out.println("Invalid problem type. Please enter a number 1-5");
			type = in.nextInt();
		}
		
		return type;
	}
	
	// Generates a random number based on the current difficulty level
	public int generateQuestionArgument(int difficulty)
	{
		return generator.nextInt((int) Math.pow(10, difficulty));
	}
	
	// Asks the user a math problem of the given type and returns the expected answer
	public int askQuestion(int num1, int num2, int type)
	{
		if (type == 5)
			type = generator.nextInt(4) + 1;
		
		switch (type)
		{
			case 1:
				System.out.println("How much is " + num1 + " plus " + num2 + "?");
				return num1 + num2;
			case 2:
				System.out.println("How much is " + num1 + " times " + num2 + "?");
				return num1 * num2;
			case 3:
				System.out.println("How much is " + num1 + " minus " + num2 + "?");
				return num1 - num2;
			case 4:
				System.out.println("How much is " + num1 + " divided by " + num2 + ", rounded to the nearest whole number?");
				return (int) Math.round((double) num1 / num2);
			default:
				return 0;	
		}
		
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
		CAI5 cai5 = new CAI5();
		cai5.quiz();
	}
}