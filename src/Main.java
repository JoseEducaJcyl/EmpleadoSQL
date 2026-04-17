import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // Cambia según tu BD
        String usuario = "JAVA";
        String contraseña = "12345";
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conn.createStatement()){

            String sql = "SELECT COUNT(*) AS CANTIDAD FROM EMPLEADO WHERE SALARIO > 3000 ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int cantidad = rs.getInt("CANTIDAD");
                System.out.println("Hay un total de " +  cantidad + " con salarios mayor a 3000");
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar la tabla: " + e.getMessage());
        }
        sc.close();
    }
}