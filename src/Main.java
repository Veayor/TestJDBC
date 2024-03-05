import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";

        try(Connection con = DriverManager.getConnection(url, "postgres", "123")) {
//           Class.forName("org.postgresql.Driver");

            Statement stm = con.createStatement();
            stm.execute("CREATE TABLE people(id serial, name varchar)");
//            stm.execute("ALTER TABLE people ADD COLUMN salary int");
//            stm.executeUpdate("INSERT INTO people(name, salary) VALUES ('Tolay', 2000)");
//
//            ResultSet rs = stm.executeQuery("SELECT * FROM people");
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int salary = rs.getInt("salary");
//
//                System.out.println(id + "  " + name + "  " + salary);
//            }


//            stm.executeUpdate("UPDATE people SET salary = 2002 WHERE id = 2");
//            stm.executeUpdate("DELETE FROM people WHERE id = 1");

//            try {
//                con.setAutoCommit(false);
//                stm.executeUpdate("UPDATE people SET salary = 2000 WHERE id = 2;");
//                System.out.println(1/0);
//                stm.executeUpdate("UPDATE people SET salary = 2002 WHERE id = 3;");
//                con.commit();
//            }
//            catch (Exception e) {
//                con.rollback();
//            }

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }


    }
}