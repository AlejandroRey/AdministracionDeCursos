package persistencia.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import modelo.AdministracionDeCursos;
import presentacion.vista.ContactoABMPanel;
import presentacion.vista.ContactoVistaPrincipal;

public class ContactoABMVistaPrincipalControlador {
	private AdministracionDeCursos modelo;
	private ContactoVistaPrincipal vista;
	
	private ContactoABMControlador contactoABMControlador;
	private ContactoABMPanel contactoABM;
	
	public ContactoABMVistaPrincipalControlador(AdministracionDeCursos modelo, ContactoVistaPrincipal vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		this.vista.getBtnSeleccionar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnSeleccionar_MousePressed(evt);
			}
		});

		this.vista.getBtnAgregar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnAgregar_MousePressed(evt);
			}
		});

		this.vista.getBtnActualizar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnActualizar_MousePressed(evt);
			}
		});

		this.vista.getBtnEliminar().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnEliminar_MousePressed(evt);
			}
		});
		
	}

	private void btnSeleccionar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnSeleccionar());
		setColor(this.vista.getMainPanel());
		resetColor(new JPanel[] { this.vista.getBtnAgregar(), this.vista.getBtnActualizar(), this.vista.getBtnEliminar() });

		if (contactoABMControlador == null) {
			contactoABM = new ContactoABMPanel();
			contactoABMControlador = new ContactoABMControlador(contactoABM, modelo);
			contactoABMControlador.inicializar();
			contactoABMControlador.setVisibleBtnSeleccionar();

			this.vista.getMainPanel().add(contactoABM);
		} else {
			contactoABMControlador.setVisibleBtnSeleccionar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();		
	}	

	private void btnAgregar_MousePressed(MouseEvent evt) {		
		setColor(this.vista.getBtnAgregar());
		setColor(this.vista.getMainPanel());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), this.vista.getBtnActualizar(), this.vista.getBtnEliminar() });

		if (contactoABMControlador == null) {
			contactoABM = new ContactoABMPanel();
			contactoABMControlador = new ContactoABMControlador(contactoABM, modelo);
			contactoABMControlador.inicializar();
			contactoABMControlador.setVisibleBtnAgregar();

			this.vista.getMainPanel().add(contactoABM);
		} else {
			contactoABMControlador.setVisibleBtnAgregar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();	
	}	

	private void btnActualizar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnActualizar());
		setColor(this.vista.getMainPanel());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), this.vista.getBtnAgregar(), this.vista.getBtnEliminar() });

		if (contactoABMControlador == null) {
			contactoABM = new ContactoABMPanel();
			contactoABMControlador = new ContactoABMControlador(contactoABM, modelo);
			contactoABMControlador.inicializar();
			contactoABMControlador.setVisibleBtnActualizar();

			this.vista.getMainPanel().add(contactoABM);
		} else {
			contactoABMControlador.setVisibleBtnActualizar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();	
	}	

	private void btnEliminar_MousePressed(MouseEvent evt) {
		setColor(this.vista.getBtnEliminar());
		setColor(this.vista.getMainPanel());
		resetColor(new JPanel[] { this.vista.getBtnSeleccionar(), this.vista.getBtnActualizar(), this.vista.getBtnAgregar() });

		if (contactoABMControlador == null) {
			contactoABM = new ContactoABMPanel();
			contactoABMControlador = new ContactoABMControlador(contactoABM, modelo);
			contactoABMControlador.inicializar();
			contactoABMControlador.setVisibleBtnEliminar();

			this.vista.getMainPanel().add(contactoABM);
		} else {
			contactoABMControlador.setVisibleBtnEliminar();
		}
		this.vista.getMainPanel().revalidate();
		this.vista.getMainPanel().repaint();	
	}
	
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(41, 57, 80));
	}
	
	private void resetColor (JPanel[] pane) {
		for (int i = 0; i < pane.length; i++) {
			pane[i].setBackground(new Color(0, 0, 0));
		}
	}
}
