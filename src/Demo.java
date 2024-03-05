import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    static List<People> listPeople = new ArrayList<>();


    public static void main(String[] args) throws SQLException {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter name:");
//        String name = scanner.nextLine();
//
//
//        System.out.print("Enter salary");
//        int salary = scanner.nextInt();
//
//        insert(name, salary);

        get();

    }

    static Connection connectToDB() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = DriverManager.getConnection(url, "postgres", "123");
        return con;
    }

    static void insert(String name, int salary) throws SQLException {
        Connection c = connectToDB();

        PreparedStatement ps = c.prepareStatement("INSERT INTO people(name, salary) VALUES (? , ?)");
        ps.setString(1, name);
        ps.setInt(2, salary);
        ps.execute();
    }


    static void get() throws SQLException {
        Connection c = connectToDB();
        Statement stm = c.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM people");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int salary = rs.getInt("salary");

            People p = new People(id, name, salary);
            listPeople.add(p);
        }

        System.out.println("ID      Name      Salary");
        listPeople.stream().filter(i -> i.getSalary() > 250).forEach(i -> {
            System.out.println(i.getId() + "  " + i.getName() + "  " + i.getSalary());
        });
    }
}
