import java.sql.*;
import java.util.Scanner;

public class Productos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*SISTEMA DE SUGERENCIAS*");

        System.out.print("Ingresa tu email: ");
        String email = scanner.nextLine();

        System.out.print("Ingresa tu password: ");
        String password = scanner.nextLine();


        if (email.equals("") || password.equals("")) {
            System.out.println("Faltan ingresar credenciales correctamente.");
        } else {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/usuarios";
            String username = "root";
            String pass = "";
            try {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(url, username, pass);

                String consultaSQL = "SELECT * FROM usuario WHERE email = ? AND password = ?";

                PreparedStatement statement = connection.prepareStatement(consultaSQL);
                statement.setString(1, email);
                statement.setString(2, password);


                // Ejecutar la consulta
                ResultSet resultSet = statement.executeQuery();

                // Procesar el resultado si existe
                if (resultSet.next()) {
                    String usuario = resultSet.getString("email");
                    String contra = resultSet.getString("password");
                    String tipo = resultSet.getString("tipo");

                    if (tipo.equals("administrador")) {
                        System.out.println("Bienvenido a Nuestro sistema de registro Administrador");
                        System.out.println();
                        System.out.println("Desear consultar las sugerencias existentes? ");
                        String respuesta = scanner.nextLine();

                        while (respuesta.equals("consultar")) {
                            String driver2 = "com.mysql.cj.jdbc.Driver";
                            String url2 = "jdbc:mysql://localhost:3306/sugerencias";
                            String username2 = "root";
                            String pass2 = "";

                            Class.forName(driver2);
                            Connection connection2 = DriverManager.getConnection(url2, username2, pass2);
                            Statement statement2 = connection2.createStatement();

                            ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM sugerencias_bd");

                            while (resultSet2.next()) {
                                String codigo = resultSet2.getString("codigo");
                                String marca = resultSet2.getString("marca");
                                String sugerencia = resultSet2.getString("sugerencias");

                                System.out.println("este es el codigo " + codigo + "marca " + marca + "sugerencia " + sugerencia);

                            }

                        }
                    } else if (tipo.equals("estandar")) {
                        System.out.println("Deseas registrar sugerencias de algun producto?: ");
                        String registrar = scanner.nextLine();

                        String driver2 = "com.mysql.cj.jdbc.Driver";
                        String url2 = "jdbc:mysql://localhost:3306/sugerencias";
                        String username2 = "root";
                        String pass2 = "";

                        Class.forName(driver2);
                        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

                        System.out.print("Ingrese codigo del producto: ");
                        String codigo = scanner.nextLine();

                        System.out.print("Ingrese marca del producto: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese sugerencias del producto: ");
                        String sugerencias = scanner.nextLine();

                        Statement statement2 = connection2.createStatement();
                        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM sugerencias_bd");//TABLA

                        Insert(codigo, nombre, sugerencias, connection2);
                        connection2.close();
                        statement2.close();
                        resultSet2.close();
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public static void Insert(String codigo, String marca, String sugerencias, Connection connection){

        try {
            // Sentencia INSERT
            String sql = "INSERT INTO sugerencias_bd (codigo, marca, sugerencias) VALUES (?, ?, ?)";
            System.out.println(codigo);
            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, codigo);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, sugerencias);

            // Ejecutar la sentencia
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("sugerencia " + sugerencias + " agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar la sugerencia.");
            }

            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
