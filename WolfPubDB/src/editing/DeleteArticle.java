public class DeleteArticle {

	public static void execute(int publicationID, int sequenceNumber) {

		String sql = 
			"DELETE FROM Article "  + "\n" +
            "WHERE PublicationID = %s AND SequenceNumber = %s"  + "\n" +
			";" + "\n" + "\n"
		;

        sql = String.format(sql, publicationID, sequenceNumber);

        WolfPubDB.executeUpdate(sql);
	}

	public static void main(String[] args) {
		System.out.println("\n");
		System.out.println("Unit Test for DeleteArticle");
		System.out.println("===============================");
		execute(9, 3);
	}

}