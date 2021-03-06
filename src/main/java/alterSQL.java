import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class alterSQL {
    public static void main(String[] args) {
        //List<String>surnames = new ArrayList<>();

        try {
            //LOCAL
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","developer","123456");
            //REMOTE
            //Connection connection = DriverManager.getConnection("jdbc:mysql://dakkar01.altervista.org:3306/my_dakkar01/newdb","dakkar01","");
            Statement statement = connection.createStatement();

            //alter table, add new colummn "country"
            String query1 = "ALTER TABLE students ADD country  CHAR(30)";

            statement.execute(query1);
            System.out.println("Country column added to the table");

            System.out.println("Update students nationality...");
            String query2 = "UPDATE students " +
                    "SET country = 'Italy' WHERE student_id in (1, 2)";
            statement.executeUpdate(query2);

            String query3 = "UPDATE students " +
                    "SET country = 'Germany' WHERE student_id in (3, 4)";
            statement.executeUpdate(query3);
            System.out.println("Done!");

/*
            //Create a table students2 if not exists
            String query = "CREATE TABLE IF NOT EXISTS students("
                    + "Student_id INT NOT NULL AUTO_INCREMENT, "
                    + "first_name VARCHAR (20) NOT NULL, "
                    + "last_name VARCHAR (20) NOT NULL, "
                    + "PRIMARY KEY (Student_id))";
            //Execute query
            statement.execute(query);
            System.out.println("The table was created!");

            //Insert 4 record with name and surname
            System.out.println("Inserting records into the table");

            String sql = "INSERT INTO students VALUES (1, 'Bruce', 'Banner')";
            statement.executeUpdate(sql);

            sql = "INSERT INTO students VALUES (2, 'Peter', 'Parker')";
            statement.executeUpdate(sql);

            sql = "INSERT INTO students VALUES (3, 'Bruce', 'Wayne')";
            statement.executeUpdate(sql);

            sql = "INSERT INTO students VALUES (4, 'Tony', 'Stark')";
            statement.executeUpdate(sql);

            System.out.println("Done!");


            ResultSet resultSet = statement.executeQuery("select * from students");
            System.out.println("Query for extract name and surname:");
            while (resultSet.next()){
                surnames.add(resultSet.getString("last_name"));
                System.out.println(resultSet.getString("first_name") + " - " +  resultSet.getString("last_name"));
            }
*/
        }catch (SQLException e){
            e.printStackTrace();
        }
/*
        System.out.println("-----------------------------------");
        System.out.println("All surname from arrayList:");
        System.out.println(surnames);
*/
    }
}
