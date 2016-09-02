package py.com.personal.cditest.service.parsers;

import py.com.personal.cditest.model.ModeloEntrada;

/**
 * Created by konectaNB31 on 02/09/2016.
 */
public class TransactionParser {
	public ModeloEntrada parse(String csv) throws Exception {
		String[] csvSplitted = csv.split(",");
		ModeloEntrada modeloEntrada = new ModeloEntrada();
		if(csvSplitted.length == 3){
			modeloEntrada.setMonto(Integer.parseInt(csvSplitted[0]));
			modeloEntrada.setIdCuenta(Integer.parseInt(csvSplitted[1]));
			modeloEntrada.setToken(csvSplitted[2]);
		} else if (csvSplitted.length == 2){
			modeloEntrada.setMonto(Integer.parseInt(csvSplitted[0]));
			modeloEntrada.setToken(csvSplitted[1]);
		} else{
			throw new Exception("Se esperaban 2 o 3 parametros.");
		}
		return modeloEntrada;
	}
}
