package py.com.personal.cditest.business;

import py.com.personal.cditest.business.dao.UsuarioDAO;
import py.com.personal.cditest.model.Usuario;

import javax.inject.Inject;
import java.util.UUID;

public class AuthenticationBusiness {

    @Inject
    UsuarioDAO usuarioDAO;

    @Inject
    LoginInfo loginInfo;

    public String login(String username, String password) throws Exception{
        if(loginInfo.getSessionActive()){
            throw new Exception("No se puede loguear, existe una sesion activa");
        }
        Usuario u = usuarioDAO.getUser(username);
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
            String token = UUID.randomUUID().toString();
            u.setToken(token);
            return token;
        }else{
            throw new Exception("Contrasenha invalida;");
        }
    }

    public void logout(){

        loginInfo.setSessionActive(false);
    }
}
