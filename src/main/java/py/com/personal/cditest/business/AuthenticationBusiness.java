package py.com.personal.cditest.business;


import py.com.personal.cditest.business.dao.Database;
import py.com.personal.cditest.model.Usuario;

import javax.inject.Inject;

public class AuthenticationBusiness {

    @Inject
    Database database;

    @Inject
    LoginInfo loginInfo;

    public void login(String username, String password) throws Exception{
        if(loginInfo.getSessionActive()){
            throw new Exception("No se puede loguear, existe una sesion activa");
        }
        Usuario u = database.getUser(username);
        if(u == null){
            throw new Exception("No se encuentra usuario con username especificado");
        }
        if(u.getPassword().equals(password)){
            System.out.println("Usuario: " + username + "logueado. Cuenta con los permisos:");
            for(String permiso : u.getPermissions()){
                System.out.println(permiso);
            }
            loginInfo.setSessionActive(true);
            loginInfo.setLoggedUser(u);
        }else{
            throw new Exception("Contrasenha invalida;");
        }

    }

    public void logout(){

        loginInfo.setSessionActive(false);
    }
}
