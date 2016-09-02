package py.com.personal.cditest.util;

import py.com.personal.cditest.business.LoginInfo;
import py.com.personal.cditest.business.dao.PermisoPorUsuarioDAO;
import py.com.personal.cditest.model.PermisoPorUsuario;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.List;

@Secured
@Interceptor
public class SecuredInterceptor {

    @Inject
    LoginInfo loginInfo;

    @Inject
    PermisoPorUsuarioDAO permisoPorUsuarioDAO;

    @AroundInvoke
    public Object transactionInterceptor(InvocationContext context)
            throws Throwable {

        System.out.println("Se intercepta invocacion");
        if(!loginInfo.getSessionActive()){
            throw new Exception("No hay usuario logueado");
        }

        RequiresPermission requiresPermission = context.getMethod().getAnnotation(RequiresPermission.class);

        if(requiresPermission != null){
	        String nombreUsuario = loginInfo.getLoggedUser().getUsername();
	        List<Integer> permisosPorUsuario = permisoPorUsuarioDAO.getPermisosPorUsuario(nombreUsuario);
	        for(Integer permiso : requiresPermission.value()){
                if(!permisosPorUsuario.contains(permiso)){
                    throw new Exception("El usuario logueado no tiene el permiso: " + permiso + " para ejecutar" +
                            "la accion: " + context.getMethod().getName());
                }
            }
        }

        return context.proceed();

    }
}
