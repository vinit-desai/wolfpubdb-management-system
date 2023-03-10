import java.util.Scanner;

/**
 * Class used for executing the MonthlyExpensesReport API operation.
 */
public class MonthlyExpensesReport {

	public static ExecResult run(Scanner reader) {
		return execute();
	}

	public static ExecResult execute() {
		String sql = 
			"SELECT  Year, Month," + "\n" +
			"		SUM(TotalWages) AS TotalWages, " + "\n" +
			"		SUM(TotalShippingCosts) AS TotalShippingCosts" + "\n" +
			"FROM (" + "\n" +
			"	SELECT  YEAR(IssueDate) AS Year, MONTH(IssueDate) AS Month, " + "\n" +
			"			SUM(Amount) AS TotalWages , SUM(0.00) AS TotalShippingCosts" + "\n" +
			"	FROM Wages" + "\n" +
			"	NATURAL JOIN Transaction" + "\n" +
			"	GROUP BY 1,2" + "\n" +
			"		UNION ALL" + "\n" +
			"	SELECT  YEAR(OrderDate) AS Year, MONTH(OrderDate) AS Month, " + "\n" +
			"			SUM(0.00) AS TotalWages, SUM(Amount) AS TotalShippingCosts" + "\n" +
			"	FROM Orders" + "\n" +
			"	NATURAL JOIN Transaction" + "\n" +
			"	WHERE Status IN('Shipped', 'Delivered')" + "\n" +
			"	GROUP BY 1,2" + "\n" +
			") AS Expenses" + "\n" +
			"GROUP BY 1,2" + "\n" +
			"ORDER BY 1,2;" + "\n"
		;
		return WolfPubDB.executeQuery(sql);
	}

	public static void main(String[] args) {
		System.out.println("\n");
		System.out.println("Unit Test for MonthlyExpensesReport");
		System.out.println("===================================");
		ExecResult execResults = execute();
		if (execResults.success) {
			System.out.println("MonthlyExpensesReport: Success");
		} else {
			System.out.println("MonthlyExpensesReport: Failure");
			System.out.println("\tError: " + execResults.errorMessage);
		}
		System.out.println("\n");
	}

}