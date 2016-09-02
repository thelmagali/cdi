package py.com.personal.cditest.business.dao;

import py.com.personal.cditest.model.Permiso;

import javax.inject.Inject;

/**
 * Created by konectaNB31 on 01/09/2016.
 */
public class PermisoDAO {
	@Inject
	Database database;

	public void crearPermiso(int codigoPermiso, String descripcion) throws Exception {
		for(Permiso permiso: database.getPermisos()){
			if(codigoPermiso == permiso.getCodigoPermiso()){
				throw new Exception("El permiso ya existe.");
			}
		}
		Permiso permiso = new Permiso();
		permiso.setCodigoPermiso(codigoPermiso);
		permiso.setDescripcion(descripcion);
		database.addPermiso(permiso);
	}
}
