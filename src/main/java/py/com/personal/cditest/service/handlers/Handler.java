package py.com.personal.cditest.service.handlers;

import py.com.personal.bc.common.sockets.handler.BasicHandler;
import py.com.personal.cditest.business.AuthenticationBusiness;
import py.com.personal.cditest.business.CreditTransaction;
import py.com.personal.cditest.business.DebitTransaction;
import py.com.personal.cditest.business.dao.UsuarioDAO;
import py.com.personal.cditest.model.ModeloEntrada;
import py.com.personal.cditest.model.Usuario;
import py.com.personal.cditest.service.parsers.TransactionParser;

import javax.inject.Inject;

/**
 * Created by konectaNB31 on 01/09/2016.
 */
public class Handler implements BasicHandler {

	@Inject
	AuthenticationBusiness authenticationBusiness;

	@Inject
	TransactionParser transactionParser;

	@Inject
	CreditTransaction creditTransaction;

	@Inject
	UsuarioDAO usuarioDAO;

	@Inject
	DebitTransaction debitTransaction;


	public String login(String payload) throws Exception {
		String[] payloadArray = payload.split(",");
		if(payloadArray.length == 2){
			return authenticationBusiness.login(payloadArray[0], payloadArray[1]);
		}
		throw new Exception("Se requiere dos parametros.");
	}

	public String credito(String payload) throws Exception {
		ModeloEntrada modeloEntrada = transactionParser.parse(payload);
		Usuario usuario = usuarioDAO.getUserByToken(modeloEntrada.getToken());
		if(modeloEntrada.getIdCuenta() != null){
			creditTransaction.apply(modeloEntrada.getMonto(), modeloEntrada.getIdCuenta());
		} else{
			creditTransaction.apply(modeloEntrada.getMonto());
		}
		return "Se realizó el crédito.";
	}

	public String debito(String payload) throws Exception {
		ModeloEntrada modeloEntrada = transactionParser.parse(payload);
		Usuario usuario = usuarioDAO.getUserByToken(modeloEntrada.getToken());
		if(modeloEntrada.getIdCuenta() != null){
			debitTransaction.apply(modeloEntrada.getMonto(), modeloEntrada.getIdCuenta());
		} else{
			debitTransaction.apply(modeloEntrada.getMonto());
		}
		return "Se realizó el débito.";
	}


}
