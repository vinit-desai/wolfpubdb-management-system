import java.util.Scanner;
import java.sql.*;

public class FindBook {

    public static ExecResult execute(String sql) {
        
		return WolfPubDB.executeQuery(sql);
	}


    public static ExecResult run(Scanner reader) {

		System.out.println("+------------------------------------+");
		System.out.println("| Please Submit the Following Inputs |");
		System.out.println("+------------------------------------+");
		System.out.println("");

        System.out.println("Choose an attribute: 1. Topic   2. CreationDate");
		int option = reader.nextInt();
        reader.nextLine();

        String sql = "";

        if(option == 1){

            System.out.println("Topic: ");
		    String topic = reader.nextLine();

            sql = 
			"SELECT * FROM Book WHERE EXISTS (SELECT * FROM Publication WHERE Topic='%s')"  + "\n" + "\t"  + "\n" +
			";" + "\n" + "\n"
		    ;
        
		    sql = String.format(sql, topic);

			System.out.println("sql:::" + sql);

        } else if(option == 2){

            System.out.println("Creation Date (YYYY-MM-DD): ");
		    String creationDate = reader.nextLine();

            sql = 
			"SELECT * FROM Book WHERE CreationDate='%s'"  + "\n" + "\t"  + "\n" +
			";" + "\n" + "\n"
		    ;
        
		    sql = String.format(sql, creationDate);

			System.out.println("sql:::" + sql);

        }	

        return execute(sql);
	}

}