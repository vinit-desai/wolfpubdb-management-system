import java.util.Scanner;

/**
 * Class used for executing the MonthlyOrdersReport API operation.
 */
public class MonthlyOrdersReport {

	public static ExecResult run(Scanner reader) {
		return execute();
	}

	public static ExecResult execute() {
		String sql = 
			"SELECT  YEAR(OrderDate) AS Year, MONTH(OrderDate) AS Month," + "\n" +
			"DistributorID, PublicationID," + "\n" +
			"SUM(Units) AS TotalUnits, SUM(Units*PricePerUnit) AS TotalPrice" + "\n" +
			"FROM Orders" + "\n" +
			"GROUP BY 1,2,3,4" + "\n" +
			"ORDER BY 1,2,3,4;" + "\n"
		;
		return WolfPubDB.executeQuery(sql);
	}

	public static void main(String[] args) {
		System.out.println("\n");
		System.out.println("Unit Test for MonthlyOrdersReport");
		System.out.println("=================================");
		ExecResult execResults = execute();
		if (execResults.success) {
			System.out.println("MonthlyOrdersReport: Success");
		} else {
			System.out.println("MonthlyOrdersReport: Failure");
			System.out.println("\tError: " + execResults.errorMessage);
		}
		System.out.println("\n");
	}

}