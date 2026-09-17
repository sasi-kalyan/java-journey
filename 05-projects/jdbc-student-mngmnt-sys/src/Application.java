import java.sql.*;

public class Application {

    final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    final static String USERNAME = "postgres";
    final static String PASSWORD = "dbuser";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void createTable() throws SQLException {
        String sql = """
                create table student (
                id INTEGER PRIMARY KEY,
                name VARCHAR NOT NULL,
                age INTEGER,
                course VARCHAR,
                gpa DECIMAL
                );
                """;

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int insertNewStudent(int id, String name, int age, String course, double gpa) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO student values (?, ?, ?, ?, ?)";
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, course);
            ps.setDouble(5, gpa);

            int ra = ps.executeUpdate();
            return ra;
        }
    }

    public static void getAllStudentsInfo() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM student";

        try (Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+
                        rs.getInt(3)+" "+rs.getString(4)+" "+rs.getDouble(5));
                System.out.println();
            }
        }
    }

    public static int updateStudent(Double gpa, int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE student SET gpa = ? WHERE id = ?";
        try(Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDouble(1, gpa);
            ps.setInt(2, id);

            int ra = ps.executeUpdate();
            return ra;
        }
    }

    public static int deleteStudent(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM student WHERE id = ?";

        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            int ra = ps.executeUpdate();
            return ra;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       //createTable();
//        insertNewStudent(2, "Naruto", 22, "Prompt Engineering", 91.63);
//        insertNewStudent(3, "Sasuke", 23, "Scared Cat", 45.31);
//        insertNewStudent(4, "Neji", 24, "C/C++", 100.00);
//        insertNewStudent(5, "Hinata", 21, "Python Dev", 90.13);
//        insertNewStudent(6, "Kakashi", 34, "Architect", 100.00);

        //System.out.println("number of records updated: "+updateStudent(100.00, 1));

        getAllStudentsInfo();

        //System.out.println("number of rows deleted: "+deleteStudent(3));
    }
}
