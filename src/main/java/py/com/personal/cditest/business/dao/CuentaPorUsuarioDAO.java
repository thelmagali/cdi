package py.com.personal.cditest.business.dao;

import py.com.personal.cditest.model.Cuenta;
import py.com.personal.cditest.model.CuentaPorUsuario;

import javax.inject.Inject;

/**
 * Created by konectaNB31 on 01/09/2016.
 */
public class CuentaPorUsuarioDAO {
	@Inject
	Database database;

	public Cuenta sumarACuenta(String username, int monto) throws Exception {
		for(CuentaPorUsuario cuentaPorUsuario: database.getCuentasPorUsuario()){
			if(cuentaPorUsuario.getUsername().equals(username) && cuentaPorUsuario.isEsDefault()){
				for(Cuenta cuenta : database.getCuentas()){
					if(cuenta.getIdCuenta() == cuentaPorUsuario.getIdCuenta()){
						cuenta.setSaldo(cuenta.getSaldo() + monto);
						return cuenta;
					}
				}
			}
		}
		throw new Exception("No se encontro cuenta default");
	}

	public Cuenta restarACuenta(String username, int monto) throws Exception {
		for(CuentaPorUsuario cuentaPorUsuario: database.getCuentasPorUsuario()){
			if(cuentaPorUsuario.getUsername().equals(username) && cuentaPorUsuario.isEsDefault()){
				for(Cuenta cuenta : database.getCuentas()){
					if(cuenta.getIdCuenta() == cuentaPorUsuario.getIdCuenta()){
						cuenta.setSaldo(cuenta.getSaldo() - monto);
						return cuenta;
					}
				}
			}
		}
		throw new Exception("No se encontró la cuenta.");
	}


}
