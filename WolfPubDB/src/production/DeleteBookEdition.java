import java.util.Scanner;

public class DeleteBookEdition {

    public static void showDetails(String tableName){
        String sql = String.format("SELECT * FROM " + tableName + ";");
        System.out.println("sql::" + sql);
		WolfPubDB.executeQuery(sql);
    }

    public static ExecResult execute(int publicationID) {

        ExecResult result = null;

        String sql = 
			"DELETE FROM Book WHERE PublicationID = %d"  + "\n" + "\t" +
				 "\n" +
			";" + "\n" + "\n"
		;
        
		sql = String.format(sql, publicationID);

		return WolfPubDB.executeUpdate(sql);
	}

	public static void main(String[] args) {
		System.out.println("\n");
		System.out.println("Unit Test for DeleteBookEdition");
		System.out.println("===============================");
		execute(1);
	}



    public static ExecResult run(Scanner reader) {

        showDetails("Book");

		System.out.println("+------------------------------------+");
		System.out.println("| Please Submit the Following Inputs |");
		System.out.println("+------------------------------------+");
		System.out.println("");

		System.out.println("Publication ID: ");
		int publicationID = reader.nextInt();
		reader.nextLine();

		return execute(publicationID);	
	}

}