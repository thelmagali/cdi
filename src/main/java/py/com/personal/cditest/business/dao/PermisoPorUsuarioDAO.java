package py.com.personal.cditest.business.dao;

import py.com.personal.cditest.model.PermisoPorUsuario;

import javax.inject.Inject;

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
}
