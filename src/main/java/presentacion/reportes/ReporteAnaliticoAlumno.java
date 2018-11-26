package presentacion.reportes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import dto.AlumnoHistorialNotasReporteDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteAnaliticoAlumno {
	
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint reporteLleno;
	private Logger log = Logger.getLogger(ReporteAnaliticoAlumno.class);

	public ReporteAnaliticoAlumno(String nombreReporte, List<AlumnoHistorialNotasReporteDTO> alumnoHistorialNotasReporteDTO) {

		Map<String, Object> parametersMap = new HashMap<String, Object>();
		
		double promedio = 0;
		double suma = 0;
		int cantidad = 0;
		for (AlumnoHistorialNotasReporteDTO alumnoNotasReporteDTO : alumnoHistorialNotasReporteDTO) {
			if (alumnoNotasReporteDTO.getIdEvaluacionTipo()==3) {
				suma = suma + alumnoNotasReporteDTO.getNota();
				cantidad = cantidad + 1;
			}
		}
		
		promedio = suma/cantidad;
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		parametersMap.put("Cantidad", cantidad);
		parametersMap.put("Suma", suma);
		parametersMap.put("Promedio", promedio);
		try {
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile("reportes" + 
																	  File.separator + 
																	  nombreReporte);
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, 
															 parametersMap,
															 new JRBeanCollectionDataSource(alumnoHistorialNotasReporteDTO));
			log.info("Se cargó correctamente el reporte");
		} catch (JRException ex) {
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteAgenda.Jasper", ex);
		}
	}

	public void mostrar() {
		this.reporteViewer = new JasperViewer(this.reporteLleno, false);
		this.reporteViewer.setVisible(true);
	}

}