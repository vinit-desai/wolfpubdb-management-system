import java.util.Scanner;

/**
 * Class used for executing the CityRevenueReport API operation.
 */
public class CityRevenueReport {

	public static ExecResult run(Scanner reader) {
		return execute();
	}

	public static ExecResult execute() {
		String sql = 
			"SELECT  City, " + "\n" +
			"		SUM(COALESCE(TotalRevenue, 0)) AS TotalRevenue" + "\n" +
			"FROM Address" + "\n" +
			"LEFT JOIN (" + "\n" +

			"	SELECT  StreetAddress, " + "\n" +
			"			SUM(Amount) AS TotalRevenue" + "\n" +
			"	FROM Distributor" + "\n" +
			"	NATURAL JOIN Bills" + "\n" +
			"	NATURAL JOIN Transaction" + "\n" +
			"	WHERE Paid = True" + "\n" +
			"	GROUP BY 1" + "\n" +
				
			") AS AddressRevenue" + "\n" +
			"	ON Address.StreetAddress = AddressRevenue.StreetAddress" + "\n" +
			"GROUP BY 1" + "\n" +
			"ORDER BY 1;" + "\n"
		;
		return WolfPubDB.executeQuery(sql);
	}

	public static void main(String[] args) {
		System.out.println("\n");
		System.out.println("Unit Test for CityRevenueReport");
		System.out.println("===============================");
		ExecResult execResults = execute();
		if (execResults.success) {
			System.out.println("CityRevenueReport: Success");
		} else {
			System.out.println("CityRevenueReport: Failure");
			System.out.println("\tError: " + execResults.errorMessage);
		}
		System.out.println("\n");
	}

}