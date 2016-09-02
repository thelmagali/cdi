package py.com.personal.cditest.business;


import py.com.personal.cditest.business.dao.CuentaDAO;
import py.com.personal.cditest.business.dao.CuentaPorUsuarioDAO;
import py.com.personal.cditest.business.dao.Database;
import py.com.personal.cditest.model.Cuenta;
import py.com.personal.cditest.model.Usuario;
import py.com.personal.cditest.util.RequiresPermission;
import py.com.personal.cditest.util.Secured;

import javax.inject.Inject;

@Secured
public class DebitTransaction implements Transaction{

    @Inject
    LoginInfo loginInfo;

    @Inject
    CuentaDAO cuentaDAO;

    @Inject
    CuentaPorUsuarioDAO cuentaPorUsuarioDAO;

    @RequiresPermission({1, 2})
    public void apply(Integer monto, int idCuenta) throws Exception {
        Cuenta cuenta = cuentaDAO.restarACuenta(monto, idCuenta);
        System.out.println("Se hace credito, saldo final " + cuenta.getSaldo());
    }

    @RequiresPermission({1, 2})
    public void apply(Integer monto) throws Exception {
        Usuario u = loginInfo.getLoggedUser();
        Cuenta cuenta = cuentaPorUsuarioDAO.restarACuenta(u.getUsername(), monto);
        System.out.println("Se hace credito, saldo final " + cuenta.getSaldo());
    }
}
