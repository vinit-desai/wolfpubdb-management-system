import java.util.Scanner;
import java.sql.*;
import java.lang.StringBuilder;

public class PayAuthorsEditors {

     public static ExecResult execute(int transactionID, float transactionAmount, String issueDate, int contributorID, String wageType) {

        ExecResult result = null;

        String sql = "INSERT INTO Transaction VALUES "  + "\n" + "\t" +
				"(%d , %.2f , '%s')"  + "\n" +
			";" + "\n" + "\n";
        
		sql = String.format(sql, transactionID, transactionAmount, issueDate);

        result = WolfPubDB.executeUpdate(sql);

        if(!result.success) {
			return result;
		}

		sql = "INSERT INTO Wages VALUES "  + "\n" + "\t" +
				"(%d , %d , '%s' , NULL)"  + "\n" +
			";" + "\n" + "\n";
        
		sql = String.format(sql, transactionID, contributorID, wageType);

		return WolfPubDB.executeUpdate(sql);
	}


    public static ExecResult run(Scanner reader) {
		System.out.println("+------------------------------------+");
		System.out.println("| Please Submit the Following Inputs |");
		System.out.println("+------------------------------------+");
		System.out.println("");


        System.out.println("Contributor ID: ");
		int contributorID = reader.nextInt();
		reader.nextLine();

        System.out.println("Transaction ID: ");
		int transactionID = reader.nextInt();
		reader.nextLine();

        System.out.println("Issue Date (YYYY-MM-DD): ");
        String issueDate = reader.nextLine();

        System.out.println("Wage Type: ");
		String wageType = reader.nextLine(); 

        System.out.println("Transaction Amount: ");
		int transactionAmount = reader.nextInt();
		reader.nextLine();

		return execute(transactionID, transactionAmount, issueDate, contributorID, wageType);	
	}

}