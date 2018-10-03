package dto;

import java.sql.Date;

public class PagoDTO {

	private long idPago;
	private long idAlumno;
	private String cantidad;
	private Date fechaDePago;
	private boolean pagado;
	
	public PagoDTO(long idPago, long idAlumno, String cantidad, Date fechaDePago, boolean pagado) {
		super();
		this.idPago = idPago;
		this.idAlumno = idAlumno;
		this.cantidad = cantidad;
		this.fechaDePago = fechaDePago;
		this.pagado = pagado;
	}

	public long getIdPago() {
		return idPago;
	}

	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}

	public long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(Date fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
}
