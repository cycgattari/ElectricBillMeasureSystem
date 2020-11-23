package net.javaguides.SpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Unidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Nro_de_Unidad")
	private String nroDeUnidad;
	
	@Column(name = "Depto")
	private String depto;
	
	@Column(name = "Nro_de_Medidor")
	private String nroDeMedidor;
	
	@Column(name = "Propietario")
	private String propietario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNroDeUnidad() {
		return nroDeUnidad;
	}

	public void setNroDeUnidad(String nroDeUnidad) {
		this.nroDeUnidad = nroDeUnidad;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getNroDeMedidor() {
		return nroDeMedidor;
	}

	public void setNroDeMedidor(String nroDeMedidor) {
		this.nroDeMedidor = nroDeMedidor;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
}

	
	
	