// Importes necesarios para el programa
import java.sql.*;
import java.util.Scanner;

// Clase Main para la ejecucion del programa
public class Main {
    public static void main(String[] args) {
        // Datos para conectarse a la base de datos
        String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // Cambia según tu BD
        String usuario = "JAVA";
        String contraseña = "12345";

        // Try-catch con recursos para intentar conectarse
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             // Objeto Statement para ejecutar consultas SQL
             Statement stmt = conn.createStatement()){

            // Consulta SQL que cuenta cuántos empleados ganan más de 3000
            String sql = "SELECT COUNT(*) AS CANTIDAD FROM EMPLEADO WHERE SALARIO > 3000";

            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = stmt.executeQuery(sql);

            // Recorrer el resultado (solo habrá una fila con el contador)
            while (rs.next()) {
                int cantidad = rs.getInt("CANTIDAD");

                // Mostrar el resultado del conteo
                System.out.println("Hay un total de " + cantidad + " con salarios mayor a 3000");
            }

        } catch (SQLException e) {
            // Capturar y mostrar cualquier error de base de datos
            System.out.println("Error al mostrar la tabla: " + e.getMessage());
        };
    }
}