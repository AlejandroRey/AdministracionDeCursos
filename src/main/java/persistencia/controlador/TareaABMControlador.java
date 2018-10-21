package persistencia.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import modelo.AdministracionDeCursos;
import dto.TareaDTO;
import presentacion.vista.TareaABMPanel;

public class TareaABMControlador implements ActionListener{

	private TareaABMPanel vista;
	private AdministracionDeCursos modelo;
	private List<TareaDTO> tareasLista;
	
	public TareaABMControlador(TareaABMPanel vista, AdministracionDeCursos modelo) {
		this.tareasLista = null;
		this.vista = vista;
		this.modelo = modelo;
		
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnSelecionarResponsable().addActionListener(this);
	}
	
	public void inicializar() {
		llenarTabla();
	}
	
	public void llenarTabla() {
		this.vista.getModelTareas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelTareas().setColumnCount(0);
		this.vista.getModelTareas().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();

		this.tareasLista = modelo.obtenerTareas();
		for (TareaDTO tareaDTO : tareasLista) {
			Object[] fila = {tareaDTO.getIdTarea(),
							 tareaDTO.getIdUsuario(), 
							 tareaDTO.getNombre(),
							 tareaDTO.getDescripcion(),
							 tareaDTO.getEstado(),
							 tareaDTO.getFechaCreacion(),
							 tareaDTO.getFechaCierre()};
			this.vista.getModelTareas().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getTableTareas().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTableTareas().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTableTareas().getColumnModel().getColumn(0).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTableTareas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTableTareas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {seleccionarFila();});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTableTareas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);

	}

	private void seleccionarFila() {
		try {
			if (this.vista.getTableTareas().getSelectedRow() >= 0) {					
				Object idTarea = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 0);
				Object idUsuario = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 1);
				Object nombre = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 2);
				Object descripcion = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 3);
				Object estado = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 5);
				Object fechaCreacion = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 6);
				Object fechaCierre = this.vista.getTableTareas().getValueAt(this.vista.getTableTareas().getSelectedRow(), 7);

				this.vista.getTxtNombre().setText(nombre.toString());
				this.vista.getTxtResponsable().setText(idUsuario.toString());
				this.vista.getTxtAreaDescripcion().setText(descripcion.toString());
				this.vista.getTxtFecha().setText(fechaCreacion.toString());
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	public void agregarTarea() {
		
//		TareaDTO tarea = new TareaDTO(0,
//				4/*this.vista.getIdResponsable()*/,
//				this.vista.getTxtNombre().getText(),
//				this.vista.getTxtAreaDescripcion().getText(),
//				"Pendiente",
//				StringToLocalDateTime(this.vista.getTxtFecha().getText()),
//				null);
//		this.modelo.agregarTarea(tarea);
	}

	public void modificarTarea() {

	}

	public void eliminarTarea() {
		
	}
	
	public void abrirSeleccionResponsable() {
		
	}
	
	public boolean datosValidos() {
		return false;
	}
	
	private String stringDateFormatter(LocalDateTime fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatDateTime = fecha.format(formatter);
		return formatDateTime;
	}

	private LocalDateTime StringToLocalDateTime(String fecha) {
		String date = fecha + " 00:00:00";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(date, format);
		return dateTime;
	}
	
	public void setVisibleBtnActualizar() {
		this.vista.getTableTareas().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnActualizar().setVisible(true);
	}
	
	public void setVisibleBtnAgregar() {
		this.vista.getTableTareas().setEnabled(false);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnAgregar().setVisible(true);
	}
	
	public void setVisibleBtnEliminar() {
		this.vista.getTableTareas().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnEliminar().setVisible(true);		
	}
	
	private void setBtnNotVisible() {
		this.vista.getBtnActualizar().setVisible(false);
		this.vista.getBtnAgregar().setVisible(false);
		this.vista.getBtnEliminar().setVisible(false);
	}

	private void clearTextInputsBox() {
		this.vista.getTxtNombre().setText("");
		this.vista.getTxtResponsable().setText("");
		this.vista.getTxtAreaDescripcion().setText("");
		this.vista.getTxtFecha().setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.vista.getBtnAgregar()) {
			agregarTarea();
		}
		else if (event.getSource() == this.vista.getBtnActualizar()) {
			modificarTarea();
		}
		else if (event.getSource() == this.vista.getBtnEliminar()) {
			eliminarTarea();
		}
		else if (event.getSource() == this.vista.getBtnSelecionarResponsable()) {
			abrirSeleccionResponsable();
		}
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

