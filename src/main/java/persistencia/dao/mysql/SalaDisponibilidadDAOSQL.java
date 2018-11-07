package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.SalaDTO;
import dto.SalaDisponibilidadDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.SalaDisponibilidadDAO;

public class SalaDisponibilidadDAOSQL implements SalaDisponibilidadDAO{

	private static final String readall = "SELECT T1.idCursada, "
											+ "T1.idSala, "
											+ "T1.fechaInicio, "
											+ "T1.fechaFin, "
											+ "T2.nombre as nombreSala, "
											+ "T3.idCurso, "
											+ "T4.nombre as nombreCurso "
											+ "FROM  fechacursadaclase as T1 "
											+ "INNER JOIN sala as T2 on T1.idSala = ? AND T2.idSala = ? "
											+ "INNER JOIN cursada as T3 on T3.idCursada = T1.idCursada "
											+ "INNER JOIN curso as T4 on T4.idCurso = T3.idCurso";

	@Override
	public List<SalaDisponibilidadDTO> readAll() {
		return null;	
	}
	
	@Override
	public List<SalaDisponibilidadDTO> readAll(SalaDTO sala) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<SalaDisponibilidadDTO> disponibilidades = new ArrayList<SalaDisponibilidadDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setLong(1, sala.getIdSala());
			statement.setLong(2, sala.getIdSala());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LocalDateTime fechaInicio = resultSet.getTimestamp("fechaInicio").toLocalDateTime();
				LocalDateTime fechaFin = resultSet.getTimestamp("fechaFin").toLocalDateTime();
				disponibilidades.add(new SalaDisponibilidadDTO(resultSet.getLong("idCursada"),
															   resultSet.getLong("idSala"), 
															   resultSet.getLong("idCurso"), 
															   resultSet.getString("nombreSala"), 
															   resultSet.getString("nombreCurso"),
															   fechaInicio, 
															   fechaFin));
				System.out.println("Listo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("cantidad : "+ disponibilidades.size());
		return disponibilidades;	
	}

}
