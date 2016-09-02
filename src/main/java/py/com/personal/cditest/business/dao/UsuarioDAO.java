package py.com.personal.cditest.business.dao;

import py.com.personal.cditest.model.PermisoPorUsuario;
import py.com.personal.cditest.model.Usuario;

import javax.inject.Inject;

/**
 * Created by konectaNB31 on 01/09/2016.
 */
public class UsuarioDAO {

	@Inject
	Database database;

	public Usuario getUser(String username){
		Usuario found = null;
		for(Usuario usuario: database.getUsuarios()) {
			if(usuario.getUsername().equals(username)) {
				found = usuario;
				PermisoPorUsuario permisoPorUsuario = new PermisoPorUsuario();
				permisoPorUsuario.setNombreUsuario(username);
				permisoPorUsuario.setCodigoPermiso(0);
				permisoPorUsuario.setCodigoPermiso(1);
				permisoPorUsuario.setCodigoPermiso(2);
				permisoPorUsuario.setCodigoPermiso(3);
				return found;

			}
		}

		return found;
	}
}
