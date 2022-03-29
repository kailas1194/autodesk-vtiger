import com.crm.autodeskSeleniumFramework.javaUtility.JDBCUtility;

public class InsertDataIntoDatabase {

	public static void main(String[] args) {
		JDBCUtility db=new JDBCUtility();
	    String query="insert into students_info values('11','rajuraj','v','ade');";
		db.insertData(query);
		System.out.println("done");
	}
	
}
