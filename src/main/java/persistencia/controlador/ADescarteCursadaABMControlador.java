/*package persistencia.controlador;
//package persistencia.controlador;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//import dto.CursadaDTO;
//import dto.CursoDTO;
//import dto.EmpresaDTO;
//import dto.EstadoDeCursoDTO;
//import dto.SalaDTO;
//import dto.UsuarioDTO;
//import modelo.AdministracionDeCursos;
//import presentacion.vista.CursadaABMPanel;
//
//public class DescCursadaABMControlador implements ActionListener {
//
//	private CursadaABMPanel cursadaPanel;
//	private AdministracionDeCursos modelo;
//	private List<CursadaDTO> cursadasLista;
//	private List<CursoDTO> cursosLista;
//	private List<EmpresaDTO> empresasLista;
//	private List<EstadoDeCursoDTO> estadosDeCursoLista;
//	private List<UsuarioDTO> instructoresLista;
//	private List<SalaDTO> salasLista;
//	
//	
//	public DescCursadaABMControlador(CursadaABMPanel vista, AdministracionDeCursos modelo) {
//		this.cursadaPanel = vista;
//		this.modelo = modelo;
//		this.cursosLista = null;
//		this.salasLista = null;
//		this.empresasLista = null;
//		this.estadosDeCursoLista = null;
//		this.instructoresLista = null;
//		this.cursadasLista = null;
//		this.cursadaPanel.BtnAceptar().addActionListener(this);
//		this.cursadaPanel.BtnCancelar().addActionListener(this); 		
//	}
//
//	public void inicializar() {
//		llenarTablaCursadas();
//		cargarCmBox();
//		this.cursadaPanel.show();
//	}
//	
//	public void llenarTablaCursadas() {
//		
////		this.cursadaVista.getModelCursadas().setRowCount(0); //Para vaciar la tabla
////		this.cursadaVista.getModelCursadas().setColumnCount(0);
////		this.cursadaVista.getModelCursadas().setColumnIdentifiers(this.cursadaVista.getNombreColumnas());
////		this.consultarDatos();
////
////		for (int i = 0; i < this.cursadasLista.size(); i ++)
////		{
////			Object[] fila = { 
////							 this.cursadasLista.get(i).getIdCursada(),
////							 getSalaString(this.cursadasLista.get(i).getIdSala()),
////							 getEmpresaString(this.cursadasLista.get(i).getIdEmpresa()),
////							 getCursoString(this.cursadasLista.get(i).getIdCurso()),
////							 getInstructorString(this.cursadasLista.get(i).getIdUsuario()),
////							 getEstadoDeCursoString(this.cursadasLista.get(i).getIdEstadoCurso()),
////							 this.cursadasLista.get(i).getVacantes()};
////			this.cursadaVista.getModelCursadas().addRow(fila);
////		}	
//		
//	}
//	
//	public void consultarDatos() {
//		this.cursadasLista = this.modelo.obtenerCursadas();
//		this.instructoresLista = this.modelo.obtenerUsuarios(); // crear consulta solo instructores
//		this.cursosLista = this.modelo.obtenerCursos();
//		this.empresasLista = this.modelo.obtenerEmpresas();
//		this.salasLista = this.modelo.obtenerSalas();
//		this.estadosDeCursoLista = this.modelo.obtenerEstadosDeCurso();
//	}
//	
//	
//	public void cargarCmBox() {
//		cmBoxCurso();
//		cmBoxEstadoDeCurso();
//		cmBoxIntructor();
//		cmBoxSala();
//		cmBoxEmpresa();
//	}
//	
//	private void cmBoxCurso() {
//		this.cursadaPanel.getCmBoxCurso().removeAllItems();
//		for(CursoDTO curso : cursosLista)
//		{	
//			this.cursadaPanel.getCmBoxCurso().addItem(curso);
//		}
//	}
//	
//	private void cmBoxIntructor() {
//		this.cursadaPanel.getCmBoxInstructor().removeAllItems();
//		for(UsuarioDTO instructor : instructoresLista)
//		{	
//			this.cursadaPanel.getCmBoxInstructor().addItem(instructor);
//		}
//	}
//
//	private void cmBoxSala() {
//		this.cursadaPanel.getCmBoxSala().removeAllItems();
//		for(SalaDTO sala : salasLista)
//		{	
//			this.cursadaPanel.getCmBoxSala().addItem(sala);
//		}
//	}
//	
//	private void cmBoxEstadoDeCurso() {
//		this.cursadaPanel.getCmBoxEstadoDeCurso().removeAllItems();
//		for(EstadoDeCursoDTO estadoDeCurso : estadosDeCursoLista)
//		{	
//			this.cursadaPanel.getCmBoxEstadoDeCurso().addItem(estadoDeCurso);
//		}
//	}
//	
//	private void cmBoxEmpresa() {
//		this.cursadaPanel.getCmBoxEmpresa().removeAllItems();
//		for(EmpresaDTO empresa : empresasLista)
//		{	
//			this.cursadaPanel.getCmBoxEmpresa().addItem(empresa);
//		}
//	}
//	
//	/**OBTENER NOMBRE DE CURSO*
//	private String getCursoString(long idCurso) {
//		String cursoNombre = "";
//		for (CursoDTO cursoDTO : cursosLista) {
//			if (cursoDTO.getIdCurso() == idCurso) {
//				cursoNombre = cursoDTO.getNombre();
//			}
//		}
//		return cursoNombre;
//	}
//	
//	/**OBTENER NOMBRE DE EMPRESA**/
//	private String getEmpresaString(long idEmpresa) {
//		String empresaNombre = "";
//		for (EmpresaDTO empresaDTO : empresasLista) {
//			if (empresaDTO.getIdEmpresa() == idEmpresa) {
//				empresaNombre = empresaDTO.getNombre();
//			}
//		}
//		return empresaNombre;
//	}
//	
//	/**OBTENER NOMBRE DE SALA**/
//	private String getSalaString(long idSala) {
//		String salaNombre = "";
//		for (SalaDTO salaDTO : salasLista) {
//			if (salaDTO.getIdSala() == idSala) {
//				salaNombre = salaDTO.getNombre();
//			}
//		}
//		return salaNombre;
//	}
//	
//	/**OBTENER ESTADOS DE CURSOS**/
//	private String getEstadoDeCursoString(long idEstadoDeCurso) {
//		String estadoDeCurso = "";
//		for (EstadoDeCursoDTO estadoDeCursoDTO : estadosDeCursoLista) {
//			if (estadoDeCursoDTO.getIdEstadoDeCurso() == idEstadoDeCurso) {
//				estadoDeCurso = estadoDeCursoDTO.getNombre();
//			}
//		}
//		return estadoDeCurso;
//	}
//	
//	/**OBTENER NOMBRE DE INSTRUCTOR**/
//	private String getInstructorString(long idInstructor) {
//		String instructorNombre = "";
//		for (UsuarioDTO instructorDTO : instructoresLista) {
//			if (instructorDTO.getIdCategoria() == idInstructor) {
//				instructorNombre = instructorDTO.getNombre();
//			}
//		}
//		return instructorNombre;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent event) {
//		
//		if(this.cursadaPanel != null && event.getSource() == this.cursadaPanel.BtnAceptar())
//		{
//			nuevaCursada();
//		}
//	}
//
//	private void nuevaCursada() {
////		EmpresaDTO empresa = (EmpresaDTO) cursadaVista.getCmBoxEmpresa().getSelectedItem();	
////		CursoDTO curso = (CursoDTO) cursadaVista.getCmBoxCurso().getSelectedItem();
////		UsuarioDTO instructor = (UsuarioDTO) cursadaVista.getCmBoxInstructor().getSelectedItem();
////		SalaDTO sala = (SalaDTO) cursadaVista.getCmBoxSala().getSelectedItem();
////		EstadoDeCursoDTO estadoCurso = (EstadoDeCursoDTO) cursadaVista.getCmBoxEstadoDeCurso().getSelectedItem();
////		
////		long idEmpresa = empresa.getIdEmpresa();
////		long idCurso = curso.getIdCurso();
////		long idInstructor = instructor.getIdUsuario();
////		long idSala = sala.getIdSala();
////		long idEstadoCurso = estadoCurso.getIdEstadoDeCurso(); 
////		int vacantes = Integer.parseInt(cursadaVista.getTxtVacantes().getText());
////		
////		CursadaDTO cursada = new CursadaDTO(0,idEmpresa,idCurso,idInstructor,idSala,idEstadoCurso,vacantes);
////		modelo.agregarCursada(cursada);
////		JOptionPane.showMessageDialog(null, "Se Agrego nueva cursada", "Nueva Cursada", JOptionPane.INFORMATION_MESSAGE);
////		llenarTablaCursadas();
//	}
//}