package gestionAlumnos.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloAlumnosJDBC implements IModeloAlumnos {

	private static String cadenaConexion = "jdbc:mysql://localhost:3306/instituto";
	private static String user = "dam2";
	private static String pass = "asdf.1234";

	public ModeloAlumnosJDBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Asegura el driver cargado
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection conectar() throws SQLException {
		return DriverManager.getConnection(cadenaConexion, user, pass);
	}

	@Override
	public List<String> getAll() {
		List<String> alumnos = new ArrayList<>();
		String sql = "SELECT * FROM alumnos";

		try (Connection conn = conectar();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String alumnoStr = rs.getString("dni") + " - "
						+ rs.getString("nombre") + " "
						+ rs.getString("apellidos") + " - CP: "
						+ rs.getString("cp");
				alumnos.add(alumnoStr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	@Override
	public Alumno getAlumnoPorDNI(String DNI) {
		Alumno alumno = null;
		String sql = "SELECT * FROM alumnos WHERE dni = ?";

		try (Connection conn = conectar();
			 PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, DNI);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				alumno = new Alumno();
				alumno.setDNI(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellidos(rs.getString("apellidos"));
				alumno.setCP(rs.getString("cp"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumno;
	}

	@Override
	public boolean modificarAlumno(Alumno alumno) {
		String sql = "UPDATE alumnos SET nombre = ?, apellidos = ?, cp = ? WHERE dni = ?";

		try (Connection conn = conectar();
			 PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellidos());
			ps.setString(3, alumno.getCP());
			ps.setString(4, alumno.getDNI());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminarAlumno(String DNI) {
		String sql = "DELETE FROM alumnos WHERE dni = ?";

		try (Connection conn = conectar();
			 PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, DNI);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean crear(Alumno alumno) {
		String sql = "INSERT INTO alumnos (dni, nombre, apellidos, cp) VALUES (?, ?, ?, ?)";

		try (Connection conn = conectar();
			 PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, alumno.getDNI());
			ps.setString(2, alumno.getNombre());
			ps.setString(3, alumno.getApellidos());
			ps.setString(4, alumno.getCP());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
