import java.util.Scanner;
import java.sql.*;

public class CreateNewBookEdition {

    public static void showDetails(String tableName){
        String sql = String.format("SELECT * FROM " + tableName + ";");
        System.out.println("sql::" + sql);
		WolfPubDB.executeQuery(sql);
    }

    public static void executeNew(int publicationId, int isbnNumber, String title, int editionNumber, String creationDate) {
        String sql = String.format("INSERT INTO Book VALUES (%d , %d , '%s' , %d , '%s');",publicationId,isbnNumber,title,editionNumber,creationDate);
        System.out.println("sql::" + sql);
		WolfPubDB.executeUpdate(sql);
	}

    public static void execute(int publicationId, String type, String publishDate, String topic) {
        String sql = String.format("INSERT INTO Publication VALUES (%d , '%s' , '%s' , '%s');",publicationId,type,publishDate,topic);
        System.out.println("sql::" + sql);
		WolfPubDB.executeUpdate(sql);
	}


    public static void main(String[] args){
        System.out.println("\n");
		System.out.println("Create a new book edition");

        Scanner in = new Scanner(System.in);

        System.out.println("Enter publication id");
        int publicationId = in.nextInt();
        in.nextLine();
        System.out.println("You entered id " + publicationId);

        String type = "Book";

        System.out.println("Enter publish date (YYYY-MM-DD)");
        String publishDate = in.nextLine();
        System.out.println("You entered publish date " + publishDate);

        System.out.println("Enter topic");
        String topic = in.nextLine();
        System.out.println("You entered topic " + topic);

        execute(publicationId, type, publishDate, topic);
        
        showDetails("Publication");

        System.out.println("Enter ISBN number");
        int isbnNumber = in.nextInt();
        in.nextLine();
        System.out.println("You entered ISBN Number " + isbnNumber);

        System.out.println("Enter title");
        String title = in.nextLine();
        System.out.println("You entered title " + title);

        System.out.println("Enter edition number");
        int editionNumber = in.nextInt();
        in.nextLine();
        System.out.println("You entered edition number " + editionNumber);


        executeNew(publicationId,isbnNumber,title,editionNumber,publishDate);

        showDetails("Book");

    }

}