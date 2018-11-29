package persistencia.dao.interfaz;

import java.util.List;

import dto.NotificacionDTO;

public interface NotificacionDAO {
	
	public boolean insert(NotificacionDTO nuevaNotificacion);
	
	public boolean delete(NotificacionDTO notificacion);
	
	public boolean update(NotificacionDTO notificacion);
	
	public List<NotificacionDTO> readAll();

}
