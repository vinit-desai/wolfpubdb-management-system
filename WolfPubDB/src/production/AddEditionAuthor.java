import java.util.Scanner;
import java.sql.*;

public class AddEditionAuthor {

	public static void showDetails(String tableName){
        String sql = String.format("SELECT * FROM " + tableName + ";");
		WolfPubDB.executeQuery(sql);
    }

    public static ExecResult execute(int publicationID, int contributorID) {

		String sql = 
			"INSERT INTO AuthorsBook VALUES "  + "\n" + "\t" +
				"(%d, %d)"  + "\n" +
			";" + "\n" + "\n"
		;
        
		sql = String.format(sql, publicationID, contributorID);

		return WolfPubDB.executeUpdate(sql);
	}



    public static ExecResult run(Scanner reader) {

		System.out.println("+------------------------------------+");
		System.out.println("|         Book Details        		 |");
		System.out.println("+------------------------------------+");
		System.out.println("");

		showDetails("Book");

		System.out.println("+------------------------------------+");
		System.out.println("|         Contributor Details        |");
		System.out.println("+------------------------------------+");
		System.out.println("");

		showDetails("Contributor");

		System.out.println("+------------------------------------+");
		System.out.println("| Please Submit the Following Inputs |");
		System.out.println("+------------------------------------+");
		System.out.println("");

		System.out.println("Publication ID: ");
		int publicationID = reader.nextInt();
		reader.nextLine();

        System.out.println("Contributor ID: ");
		int contributorID = reader.nextInt();
        reader.nextLine();

		return execute(publicationID, contributorID);	
	}

}