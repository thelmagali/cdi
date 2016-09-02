package py.com.personal.cditest.business.dao;

import py.com.personal.cditest.model.Permiso;
import py.com.personal.cditest.model.PermisoPorUsuario;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by konectaNB31 on 01/09/2016.
 */
public class PermisoPorUsuarioDAO {
	@Inject
	Database database;

	public void crearPermisoPorUsuario(String username, int codigoPermiso) throws Exception {
		for(PermisoPorUsuario permisoPorUsuario: database.getPermisosPorUsuarios()){
			if(codigoPermiso == permisoPorUsuario.getCodigoPermiso()
					&& username.equals(permisoPorUsuario.getNombreUsuario())){
				throw new Exception("El permiso por usuario ya existe.");
			}
		}
		PermisoPorUsuario permisoPorUsuario = new PermisoPorUsuario();
		permisoPorUsuario.setCodigoPermiso(codigoPermiso);
		permisoPorUsuario.setNombreUsuario(username);
	}

	public List<Integer> getPermisosPorUsuario(String username){
		List<Integer> permisos = new ArrayList<Integer>();
		for(PermisoPorUsuario permisoPorUsuario: database.getPermisosPorUsuarios()){
			if(permisoPorUsuario.getNombreUsuario().equals(username)){
				permisos.add(permisoPorUsuario.getCodigoPermiso());
			}
		}
		return permisos;
	}
}
