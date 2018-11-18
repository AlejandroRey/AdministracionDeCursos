package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoAsistenciaQtyDTO;
import dto.CursadaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.AlumnoAsistenciaQtyDAO;

public class AlumnoAsistenciaQtyDAOSQL implements AlumnoAsistenciaQtyDAO {
	
	private static final String readall = "SELECT T1.idAlumno, " + 
										  "SUM( CASE WHEN T1.tipoAsistencia = 1 Then 1 Else 0 End ) As presente, " + 
			                              "SUM( CASE WHEN T1.tipoAsistencia = 0 Then 1 Else 0 End ) As ausente " + 
			                              "FROM asistencia AS T1 " + 
			                              "INNER JOIN (SELECT * FROM fechacursadaclase WHERE idCursada = ?) AS T2 " + 
			                              "ON T1.idFechaCursadaClase = T2.idFechaCursadaClase " + 
			                              "GROUP BY T1.idAlumno WITH ROLLUP";

	@Override
	public List<AlumnoAsistenciaQtyDTO> readAll(CursadaDTO cursadaDTO) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<AlumnoAsistenciaQtyDTO> alumnosAsistenciasQty = new ArrayList<AlumnoAsistenciaQtyDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setLong(1, cursadaDTO.getIdCursada());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				alumnosAsistenciasQty.add(new AlumnoAsistenciaQtyDTO(resultSet.getLong("idAlumno"), 
																	 resultSet.getInt("presente"), 
																	 resultSet.getInt("ausente")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return alumnosAsistenciasQty;
	}

}
