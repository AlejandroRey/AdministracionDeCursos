package dto;

public class ContactoTareaDTO {
	
	private long id;
	private long contactoO;
	private long tarea;
	private long contactoD;
	
	public ContactoTareaDTO(long id, long contactoO, long tarea, long contactoD) {
		super();
		this.id = id;
		this.contactoO = contactoO;
		this.tarea = tarea;
		this.contactoD = contactoD;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the contactoO
	 */
	public long getContactoO() {
		return contactoO;
	}

	/**
	 * @param contactoO the contactoO to set
	 */
	public void setContactoO(long contactoO) {
		this.contactoO = contactoO;
	}

	/**
	 * @return the tarea
	 */
	public long getTarea() {
		return tarea;
	}

	/**
	 * @param tarea the tarea to set
	 */
	public void setTarea(long tarea) {
		this.tarea = tarea;
	}

	/**
	 * @return the contactoD
	 */
	public long getContactoD() {
		return contactoD;
	}

	/**
	 * @param contactoD the contactoD to set
	 */
	public void setContactoD(long contactoD) {
		this.contactoD = contactoD;
	}	

}
