package com.shopping.contable.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="contable_tipo_gastos")
public class TipoGastos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tipogasto;
	private String gasto;

	public TipoGastos() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipogasto() {
		return tipogasto;
	}


	public void setTipogasto(String tipogasto) {
		this.tipogasto = tipogasto;
	}


	public String getGasto() {
		return gasto;
	}


	public void setGasto(String gasto) {
		this.gasto = gasto;
	}

	

}