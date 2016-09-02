package py.com.personal.cditest.business.dao;

import py.com.personal.cditest.model.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class Database {

    private List<Usuario> usuarios;

    private List<CuentaPorUsuario> cuentasPorUsuario;

	private List<Cuenta> cuentas;

    private List<Permiso> permisos;

    private List<PermisoPorUsuario> permisosPorUsuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

	public List<CuentaPorUsuario> getCuentasPorUsuario() {
		return cuentasPorUsuario;
	}

	public void setCuentasPorUsuario(List<CuentaPorUsuario> cuentasPorUsuario) {
		this.cuentasPorUsuario = cuentasPorUsuario;
	}

	public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public List<PermisoPorUsuario> getPermisosPorUsuarios() {
        return permisosPorUsuarios;
    }

    public void setPermisosPorUsuarios(List<PermisoPorUsuario> permisosPorUsuarios) {
        this.permisosPorUsuarios = permisosPorUsuarios;
    }

    public void addPermiso(Permiso permiso){
        this.permisos.add(permiso);
    }

    @PostConstruct
    private void init(){

	    //crear usuarios
        this.usuarios = new ArrayList<Usuario>();

        Usuario u = new Usuario();
        u.setPassword("hola");
        u.setUsername("juan");
        usuarios.add(u);

        u = new Usuario();
        u.setPassword("chau");
        u.setUsername("jose");
	    usuarios.add(u);


	    //crear permisos
        this.permisos = new ArrayList<Permiso>();

	    Permiso permiso1 = new Permiso();
	    permiso1.setCodigoPermiso(1);
	    permiso1.setDescripcion("Permiso1");
	    permisos.add(permiso1);

	    Permiso permiso2 = new Permiso();
	    permiso2.setCodigoPermiso(2);
	    permiso2.setDescripcion("Permiso2");
	    permisos.add(permiso2);

	    Permiso permiso3 = new Permiso();
	    permiso3.setCodigoPermiso(3);
	    permiso3.setDescripcion("Permiso3");
	    permisos.add(permiso3);

	    Permiso permiso4 = new Permiso();
	    permiso4.setCodigoPermiso(4);
	    permiso4.setDescripcion("Permiso4");
	    permisos.add(permiso4);

	    Permiso permiso5 = new Permiso();
	    permiso5.setCodigoPermiso(5);
	    permiso5.setDescripcion("Permiso5");
	    permisos.add(permiso5);

	    Permiso permiso6 = new Permiso();
	    permiso6.setCodigoPermiso(6);
	    permiso6.setDescripcion("Permiso6");
	    permisos.add(permiso6);

	    //crear cuentas
	    Cuenta cuenta1 = new Cuenta();
	    cuenta1.setIdCuenta(1);
	    cuenta1.setSaldo(30);

	    Cuenta cuenta2 = new Cuenta();
	    cuenta2.setIdCuenta(2);
	    cuenta2.setSaldo(40);

	    Cuenta cuenta3 = new Cuenta();
	    cuenta3.setIdCuenta(3);
	    cuenta3.setSaldo(40);

	    Cuenta cuenta4 = new Cuenta();
	    cuenta4.setIdCuenta(4);
	    cuenta4.setSaldo(40);

	    Cuenta cuenta5 = new Cuenta();
	    cuenta5.setIdCuenta(5);
	    cuenta5.setSaldo(40);

		//crear cuentas por usuario
		CuentaPorUsuario cuentaPorUsuario1 = new CuentaPorUsuario();
	    cuentaPorUsuario1.setIdCuenta(1);
	    cuentaPorUsuario1.setUsername("juan");
		cuentasPorUsuario.add(cuentaPorUsuario1);

	    CuentaPorUsuario cuentaPorUsuario2 = new CuentaPorUsuario();
	    cuentaPorUsuario2.setIdCuenta(2);
	    cuentaPorUsuario2.setUsername("jose");
	    cuentasPorUsuario.add(cuentaPorUsuario2);

    }
}
