import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionPostgres {

    public void run() {
        String url = "jdbc:postgresql://localhost:5432/jdb_test";
        String user = "postgres";
        String password = "NyAina";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connexion réussie !");
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Driver introuvable : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ConnexionPostgres().run();
    }
}
