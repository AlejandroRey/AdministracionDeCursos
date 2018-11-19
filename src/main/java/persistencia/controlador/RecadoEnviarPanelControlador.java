package persistencia.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.mxrck.autocompleter.TextAutoCompleter;

import dto.RecadoDTO;
import dto.UsuarioDTO;
import modelo.AdministracionDeCursos;
import presentacion.vista.RecadoEnviarPanel;

public class RecadoEnviarPanelControlador implements ActionListener {

	private AdministracionDeCursos modelo;
	private RecadoEnviarPanel vista;
	private List<UsuarioDTO> usuariosLista;

	public RecadoEnviarPanelControlador(AdministracionDeCursos modelo, RecadoEnviarPanel vista) {
		this.vista = vista;
		this.modelo = modelo;
		this.usuariosLista = modelo.obtenerUsuarios();
		this.vista.getBtnCancelar().addActionListener(this);
		this.vista.getBtnEnviar().addActionListener(this);
		this.vista.getBtnB().addActionListener(this);
		this.vista.getTxtPara().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				List<UsuarioDTO> listaTemporalUsuarios = new ArrayList<UsuarioDTO>();
				usuariosLista.stream()
						.filter(UsuarioDTO -> UsuarioDTO.getUsuario().contains(vista.getTxtPara().getText()))
						.collect(Collectors.toList());
				try {
					listaTemporalUsuarios.add(usuariosLista.stream()
							.filter(UsuarioDTO -> UsuarioDTO.getUsuario().contains(vista.getTxtPara().getText()))
							.collect(Collectors.toList()).get(0));
					listaTemporalUsuarios.add(usuariosLista.stream()
							.filter(UsuarioDTO -> UsuarioDTO.getUsuario().contains(vista.getTxtPara().getText()))
							.collect(Collectors.toList()).get(1));
					listaTemporalUsuarios.add(usuariosLista.stream()
							.filter(UsuarioDTO -> UsuarioDTO.getUsuario().contains(vista.getTxtPara().getText()))
							.collect(Collectors.toList()).get(2));
				} catch (Exception e2) {
				}

				// System.out.println(listaTemporalUsuarios.toString());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});

		TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(this.vista.getTxtPara());
		for (UsuarioDTO usuarioDTO : usuariosLista) {
			textAutoAcompleter.addItem(usuarioDTO.getUsuario());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnCancelar()) {
			limpiarInputs();
		} else if (e.getSource() == this.vista.getBtnEnviar()) {
			try {
				enviarRecado();
			} catch (Exception excepcion) {
				JOptionPane.showMessageDialog(null, excepcion, "Recado", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == this.vista.getBtnB()) {
			if (validarUsuario(this.vista.getTxtPara().getText())) {
				JOptionPane.showMessageDialog(null, "Destinatario valido", "Recado", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Destinatario invalido", "Recado", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	private void enviarRecado() {
		if (this.vista.getTxtPara().getText().length() != 0) {
			if (this.vista.getTextAreaMensaje().getText().length() != 0) {
				if (this.vista.getTextAsunto().getText().length() == 0) {
					if (JOptionPane.showConfirmDialog(null, "Enviar recado sin ingresar un asunto?", "Confirmar envio",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
						if (validarUsuario(this.vista.getTxtPara().getText())) {
							RecadoDTO recado = new RecadoDTO(0, modelo.getUsuarioLogueado().getIdUsuario(), getIdUsuarioPara(this.vista.getTxtPara().getText()),
									this.vista.getTextAsunto().getText(), this.vista.getTextAreaMensaje().getText(),
									null, false, false);
							this.modelo.agregarRecado(recado);
							limpiarInputs();
							JOptionPane.showMessageDialog(null, "Recado enviado exitosamente!", "Recado",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido enviar, destinatario invalido",
									"Recado", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} else {
					if (validarUsuario(this.vista.getTxtPara().getText())) {
						RecadoDTO recado = new RecadoDTO(0, modelo.getUsuarioLogueado().getIdUsuario(), getIdUsuarioPara(this.vista.getTxtPara().getText()),
								this.vista.getTextAsunto().getText(), this.vista.getTextAreaMensaje().getText(), null,
								false, false);
						this.modelo.agregarRecado(recado);
						limpiarInputs();
						JOptionPane.showMessageDialog(null, "Recado enviado exitosamente!", "Recado",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No se ha podido enviar, destinatario invalido", "Recado",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese un mensaje", "Recado", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ingrese un destinatario", "Recado", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private boolean validarUsuario(String usuario) {
		for (UsuarioDTO usuarioDTO : usuariosLista) {
			if (usuarioDTO.getUsuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}

	private long getIdUsuarioPara(String usuario) {
		long idUsuarioPara = 0;
		for (UsuarioDTO usuarioDTO : usuariosLista) {
			if (usuarioDTO.getUsuario().equals(usuario)) {
				idUsuarioPara = usuarioDTO.getIdUsuario();
			}
		}
		return idUsuarioPara;
	}

	public void limpiarInputs() {
		this.vista.getTextIdRecado().setText("");
		this.vista.getTextAreaMensaje().setText("");
		this.vista.getTextAsunto().setText("");
		this.vista.getTxtPara().setText("");
	}

}
