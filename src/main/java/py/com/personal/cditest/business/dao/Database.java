package py.com.personal.cditest.business.dao;

import py.com.personal.cditest.model.Cuenta;
import py.com.personal.cditest.model.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class Database {

    private Map<String, Usuario> usuarios;
    private List<String> permisos;
    private Map<String, Cuenta> cuentasPorUsuario;

    @PostConstruct
    private void init(){

        usuarios = new HashMap<String, Usuario>();
        Usuario u = new Usuario();
        u.setPassword("hola");
        u.setUsername("juan");
        usuarios.put(u.getUsername(), u);

        u = new Usuario();
        u.setPassword("chau");
        u.setUsername("jose");
        usuarios.put(u.getUsername(), u);

        permisos = new ArrayList<String>();
        permisos.add("Permiso1");
        permisos.add("Permiso2");
        permisos.add("Permiso3");
        permisos.add("Permiso4");
        permisos.add("Permiso5");
        permisos.add("Permiso6");

        cuentasPorUsuario = new HashMap<String, Cuenta>();
        Cuenta c = new Cuenta();
        c.setSaldo(30);
        cuentasPorUsuario.put("juan", c);
        c = new Cuenta();
        c.setSaldo(10);
        cuentasPorUsuario.put("jose", c);

    }

    public Usuario getUser(String username){
        Usuario found = null;
        if(usuarios.containsKey(username)){
            found = usuarios.get(username);


            found.getPermissions().add(permisos.get(0));
            found.getPermissions().add(permisos.get(1));
            found.getPermissions().add(permisos.get(2));
            found.getPermissions().add(permisos.get(3));

        }

        return found;
    }

    public Cuenta getCuentaByUsername(String username){
        return cuentasPorUsuario.get(username);
    }
}
