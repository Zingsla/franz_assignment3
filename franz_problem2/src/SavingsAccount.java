public class SavingsAccount
{
	static double annualInterestRate = 0.0;
	private double savingsBalance = 0.0;
	
	public SavingsAccount(double startingBalance)
	{
		savingsBalance = startingBalance;
	}
	
	public double calculateMonthlyInterest()
	{
		double monthlyInterest = savingsBalance * (annualInterestRate / 12.0);
		savingsBalance += monthlyInterest;
		
		return monthlyInterest;
	}
	
	public static void modifyInterestRate(double newRate)
	{
		annualInterestRate = newRate;
	}
	
	public double getBalance()
	{
		return savingsBalance;
	}
}