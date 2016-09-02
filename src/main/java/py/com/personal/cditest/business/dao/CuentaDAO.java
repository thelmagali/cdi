package py.com.personal.cditest.business.dao;

import py.com.personal.cditest.model.Cuenta;

import javax.inject.Inject;

/**
 * Created by konectaNB31 on 01/09/2016.
 */
public class CuentaDAO {

	@Inject
	Database database;


	public Cuenta sumarACuenta(int idCuenta, int monto) throws Exception {
		for(Cuenta cuenta: database.getCuentas()){
			if(cuenta.getIdCuenta() == idCuenta){
				cuenta.setSaldo(cuenta.getSaldo() + monto);
				return cuenta;
			}
		}
		throw new Exception("No se encontro la cuenta");
	}

	public Cuenta restarACuenta(int idCuenta, int monto) throws Exception {
		for(Cuenta cuenta: database.getCuentas()){
			if(cuenta.getIdCuenta() == idCuenta){
				cuenta.setSaldo(cuenta.getSaldo() + monto);
				return cuenta;
			}
		}
		throw new Exception("No se encontro la cuenta");
	}
}
