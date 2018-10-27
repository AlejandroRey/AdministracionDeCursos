package persistencia.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.CallableStatement;

import dto.FechaCursadaClaseDTO;
import dto.SalaDTO;
import dto.SalaDisponibleDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.SalaDisponibleDAO;

public class SalaDisponibleDAOSQL implements SalaDisponibleDAO {

	@Override
	public List<SalaDisponibleDTO> readAll(FechaCursadaClaseDTO fechaCursadaDTO, SalaDTO salaDTO) {
		LocalDate localDate = fechaCursadaDTO.getFechaInicio().toLocalDate();
		LocalDateTime localDateTimeInicio = LocalDateTime.of(localDate, LocalTime.MIN);
		LocalDateTime localDateTimeFin = localDateTimeInicio.plusDays(1);

		ArrayList<SalaDisponibleDTO> salasDisponibles = new ArrayList<SalaDisponibleDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			CallableStatement spSalaDisponible = (CallableStatement) conexion.getSQLConexion().prepareCall("{CALL modEstadosSalasSP(?, ?, ?)}");
			spSalaDisponible.setTimestamp(1, convert(localDateTimeInicio));
			spSalaDisponible.setTimestamp(2, convert(localDateTimeFin));
			spSalaDisponible.setLong(3, salaDTO.getIdSala());

			spSalaDisponible.execute();

			ResultSet resultSet = spSalaDisponible.getResultSet();
			while (resultSet.next()) {
				salasDisponibles.add(new SalaDisponibleDTO(resultSet.getLong(1), 
														   resultSet.getInt(2), 
														   resultSet.getTimestamp(3).toLocalDateTime(),
														   resultSet.getTimestamp(4).toLocalDateTime(), 
														   resultSet.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		
		for (SalaDisponibleDTO salaDisponibleDTO : salasDisponibles) {
			System.out.println("SALA DISPONIBLE--------->>>>>>>>: "+salaDisponibleDTO);
		}
		
		return salasDisponibles;
	}
	
	/**
	 * Convert a LocalDateTime to a Timestamp using the system timezone.
	 */
	private Timestamp convert(LocalDateTime localDateTime) {
		return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
	}

}
