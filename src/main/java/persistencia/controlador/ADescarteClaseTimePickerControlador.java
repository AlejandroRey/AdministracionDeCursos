package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import dto.ClaseDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.ADescarteClaseTimePicker;

public class ADescarteClaseTimePickerControlador implements ActionListener {
	
	private ADescarteClaseTimePicker vista;
	private AdministracionDeCursos modelo;
	private List<ClaseDTO> clasesLista;
	
	public ADescarteClaseTimePickerControlador(ADescarteClaseTimePicker vista, AdministracionDeCursos modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnAgregar().addActionListener(this);
	}
	
	public void inicializar() {
		llenarTabla();
	}

	private void llenarTabla() {
		this.vista.getModelFechas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelFechas().setColumnCount(0);
		this.vista.getModelFechas().setColumnIdentifiers(this.vista.getNombreColumnas());

		this.clasesLista = modelo.obtenerClases();
		for (ClaseDTO claseDTO : clasesLista) {
			Object[] fila = {claseDTO.getIdClase(),
							 claseDTO.getIdCursada(), 
							 claseDTO.getFechaInicio(),
							 claseDTO.getFechaFin(),
							 claseDTO.isEsFeriado()};
			this.vista.getModelFechas().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getTblFechas().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTblFechas().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTblFechas().getColumnModel().getColumn(0).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTblFechas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTblFechas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			try {
				if (this.vista.getTblFechas().getSelectedRow() >= 0) {					
					Object idClase = this.vista.getTblFechas().getValueAt(this.vista.getTblFechas().getSelectedRow(), 0);
					Object idCursada = this.vista.getTblFechas().getValueAt(this.vista.getTblFechas().getSelectedRow(), 1);
					Object fechaInicio = this.vista.getTblFechas().getValueAt(this.vista.getTblFechas().getSelectedRow(), 2);
					Object fechaFin = this.vista.getTblFechas().getValueAt(this.vista.getTblFechas().getSelectedRow(), 3);
					Object esFeriado = this.vista.getTblFechas().getValueAt(this.vista.getTblFechas().getSelectedRow(), 4);
				}
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTblFechas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("serial")
	public class ListSelectionModelCstm extends DefaultListSelectionModel {

	    public ListSelectionModelCstm () {
	        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    }

	    @Override
	    public void clearSelection() {
	    }

	    @Override
	    public void removeSelectionInterval(int index0, int index1) {
	    }

	}
}
