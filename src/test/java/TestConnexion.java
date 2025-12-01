import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestConnexion {

    public void tester() {

        String url = "jdbc:postgresql://localhost:5432/jdb_test";
        String user = "postgres";
        String password = "NyAina";

        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement("SELECT 1");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Test OK ! La connexion fonctionne");
            } else {
                System.out.println("Test échoué");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new TestConnexion().tester();
    }
}
