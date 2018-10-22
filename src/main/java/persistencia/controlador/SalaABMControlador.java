package persistencia.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import modelo.AdministracionDeCursos;
import dto.SalaDTO;
import presentacion.vista.SalaABMPanel;

public class SalaABMControlador implements ActionListener{

	private SalaABMPanel vista;
	private AdministracionDeCursos modelo;
	private List<SalaDTO> salasLista;
	
	public SalaABMControlador(SalaABMPanel vista, AdministracionDeCursos modelo) {
		this.salasLista = null;
		this.vista = vista;
		this.modelo = modelo;
		
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnActualizar().addActionListener(this);
		this.vista.getBtnEliminar().addActionListener(this);
	}
	
	public void inicializar() {
		llenarTabla();
	}
	
	public void llenarTabla() {
		this.vista.getModelSalas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelSalas().setColumnCount(0);
		this.vista.getModelSalas().setColumnIdentifiers(this.vista.getNombreColumnas());
		clearTextInputsBox();

		this.salasLista = modelo.obtenerSalas();
		for (SalaDTO salaDTO : salasLista) {
			Object[] fila = {salaDTO.getIdSala(),
							 salaDTO.getNombre(), 
							 salaDTO.getCantidadAlumnos(),
							 salaDTO.getCantidadPc(),
							 salaDTO.getDescripcion()};
			this.vista.getModelSalas().addRow(fila);
		}
		// Oculto los id del Objeto
		this.vista.getTableSalas().getColumnModel().getColumn(0).setWidth(0);
		this.vista.getTableSalas().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTableSalas().getColumnModel().getColumn(0).setMaxWidth(0);
		
		// Agrego listener para obtener los valores de la fila seleccionada
		this.vista.getTableSalas().setSelectionModel(new ListSelectionModelCstm());
		this.vista.getTableSalas().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {seleccionarFila();});

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		this.vista.getTableSalas().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
	}
	
	private void seleccionarFila() {
		try {
			if (this.vista.getTableSalas().getSelectedRow() >= 0) {					
				Object idSala = this.vista.getTableSalas().getValueAt(this.vista.getTableSalas().getSelectedRow(), 0);
				Object nombre = this.vista.getTableSalas().getValueAt(this.vista.getTableSalas().getSelectedRow(), 1);
				Object cantidadAlumnos = this.vista.getTableSalas().getValueAt(this.vista.getTableSalas().getSelectedRow(), 2);
				Object cantidadPc = this.vista.getTableSalas().getValueAt(this.vista.getTableSalas().getSelectedRow(), 3);
				Object descripcion = this.vista.getTableSalas().getValueAt(this.vista.getTableSalas().getSelectedRow(), 4);

				this.vista.getTxtID().setText(idSala.toString());
				this.vista.getTxtNombre().setText(nombre.toString());
				this.vista.getTxtCantidadDeAlumnos().setText(cantidadAlumnos.toString());
				this.vista.getTxtCantidadDePc().setText(cantidadPc.toString());
				this.vista.getTxtAreaDescripcion().setText(descripcion.toString());
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	private void clearTextInputsBox() {
		this.vista.getTxtNombre().setText("");
		this.vista.getTxtCantidadDeAlumnos().setText("");
		this.vista.getTxtCantidadDePc().setText("");
		this.vista.getTxtAreaDescripcion().setText("");
	}
	
	public void setVisibleBtnActualizar() {
		this.vista.getTableSalas().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnActualizar().setVisible(true);
	}
	
	public void setVisibleBtnAgregar() {
		this.vista.getTableSalas().setEnabled(false);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnAgregar().setVisible(true);
	}
	
	public void setVisibleBtnEliminar() {
		this.vista.getTableSalas().setEnabled(true);
		clearTextInputsBox();
		setBtnNotVisible();
		this.vista.getBtnEliminar().setVisible(true);		
	}
	
	/**
	 * @param btn's set hide all buttons
	 */
	public void setBtnNotVisible() {
		this.vista.getBtnActualizar().setVisible(false);
		this.vista.getBtnAgregar().setVisible(false);
		this.vista.getBtnEliminar().setVisible(false);
	}

	public void agregarSala() {
		SalaDTO sala = new SalaDTO (0,
				this.vista.getTxtNombre().getText(),
				Integer.parseInt(this.vista.getTxtCantidadDeAlumnos().getText()),
				Integer.parseInt(this.vista.getTxtCantidadDePc().getText()),
				this.vista.getTxtAreaDescripcion().getText());
		this.modelo.agregarSala(sala);
		llenarTabla();
	}

	public void modificarSala() {
		SalaDTO sala = new SalaDTO (
				(Long.parseLong(this.vista.getTxtID().getText())),
				this.vista.getTxtNombre().getText(),
				Integer.parseInt(this.vista.getTxtCantidadDeAlumnos().getText()),
				Integer.parseInt(this.vista.getTxtCantidadDePc().getText()),
				this.vista.getTxtAreaDescripcion().getText());
		this.modelo.actualizarSala(sala);
		llenarTabla();
	}

	public void eliminarSala() {
		SalaDTO sala = new SalaDTO (
				Long.parseLong(this.vista.getTxtID().getText()),
				this.vista.getTxtNombre().getText(),
				Integer.parseInt(this.vista.getTxtCantidadDeAlumnos().getText()),
				Integer.parseInt(this.vista.getTxtCantidadDePc().getText()),
				this.vista.getTxtAreaDescripcion().getText());
		this.modelo.borrarSala(sala);
		llenarTabla();
	}
	
	public boolean datosValidos() {
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.vista.getBtnAgregar()) {
			agregarSala();
		}
		else if (event.getSource() == this.vista.getBtnActualizar()) {
			modificarSala();
		}
		else if (event.getSource() == this.vista.getBtnEliminar()) {
			eliminarSala();
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
