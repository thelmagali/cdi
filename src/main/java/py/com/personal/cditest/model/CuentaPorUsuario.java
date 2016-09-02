package py.com.personal.cditest.model;

/**
 * Created by konectaNB31 on 01/09/2016.
 */
public class CuentaPorUsuario {
	int idCuenta;

	String username;

	boolean esDefault;

	public CuentaPorUsuario(){
		esDefault = false;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEsDefault() {
		return esDefault;
	}

	public void setEsDefault(boolean esDefault) {
		this.esDefault = esDefault;
	}
}
