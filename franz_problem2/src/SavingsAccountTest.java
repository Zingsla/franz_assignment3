public class SavingsAccountTest
{
	public static void main(String[] args)
	{
		SavingsAccount saver1 = new SavingsAccount(2000.0);
		SavingsAccount saver2 = new SavingsAccount(3000.0);
		SavingsAccount.modifyInterestRate(0.04);
		
		System.out.println("+-------+----------------+----------------+");
		System.out.println("| Month | saver1 Balance | saver2 Balance |");
		System.out.println("+-------+----------------+----------------+");
		
		for (int i = 1; i <= 12; i++)
		{
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			System.out.printf("|%6d | %14.2f | %15.2f|\n", i, saver1.getBalance(), saver2.getBalance());
			System.out.println("+-------+----------------+----------------+");
		}
		
		SavingsAccount.modifyInterestRate(0.05);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.println("\nAfter new interest rate (5%)");
		System.out.printf("saver1 Balance: %.2f\n", saver1.getBalance());
		System.out.printf("saver2 Balance: %.2f\n", saver2.getBalance());
	}
}