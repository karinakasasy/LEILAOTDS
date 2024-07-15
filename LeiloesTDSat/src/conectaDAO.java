
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conectaDAO {

    private static final String url = "jdbc:mysql://localhost:3306/leiloes";
    private static final String user = "root";
    private static final String senha = "465416";

    public Connection connectDB() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, senha);

        } catch (SQLException e) {
            System.out.println("Falha na conexaoDao " + e.getMessage());

        }
        return conn;
    }

}
