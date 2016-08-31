package py.com.personal.cditest.business;


import py.com.personal.cditest.business.dao.Database;
import py.com.personal.cditest.model.Cuenta;
import py.com.personal.cditest.model.Usuario;
import py.com.personal.cditest.util.RequiresPermission;
import py.com.personal.cditest.util.Secured;

import javax.inject.Inject;

@Secured
public class CreditTransaction implements Transaction{

    @Inject
    LoginInfo loginInfo;

    @Inject
    Database database;

    @RequiresPermission({"Permiso5", "Permiso6"})
    public void apply(Integer monto) throws Exception {
        Usuario u = loginInfo.getLoggedUser();
        Cuenta cuenta = database.getCuentaByUsername(u.getUsername());
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        System.out.println("Se hace credito, saldo final " + cuenta.getSaldo());
    }
}
