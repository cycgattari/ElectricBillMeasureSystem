package net.javaguides.SpringBoot.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.javaguides.SpringBoot.ListadoConsumos.Consumos;

@Entity
@Table(name = "employees")
public class Unidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(
			mappedBy = "unidad", 			
			cascade = CascadeType.ALL,
			orphanRemoval = true 
			)
	private List<Consumos> consumos = new ArrayList<>();
	
	@Column(name = "Nro_de_Unidad")
	private String nroDeUnidad;
	
	@Column(name = "Depto")
	private String depto;
	
	@Column(name = "Nro_de_Medidor")
	private String nroDeMedidor;
	
	@Column(name = "Propietario")
	private String propietario;
	

	public Unidad() {
		super();
	}
	
	
	
	public Unidad(long id, List<Consumos> consumos, String nroDeUnidad, String depto, String nroDeMedidor,
			String propietario) {
		super();
		this.id = id;
		this.consumos = consumos;
		this.nroDeUnidad = nroDeUnidad;
		this.depto = depto;
		this.nroDeMedidor = nroDeMedidor;
		this.propietario = propietario;
	}



	public void addConsumo(Consumos consumo) {
		consumos.add(consumo);
		consumo.setUnidad(this);
	    }
	 
	public void removeConsumo(Consumos consumo) {
		consumos.remove(consumo);
		consumo.setUnidad(null);
	    }

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

	@Override
	public String toString() {
		return depto;
	}
	
}

	
	
	