package py.com.personal.cditest.business;


public interface Transaction {

    void apply(Integer monto, int idCuenta) throws Exception;

    void apply(Integer monto) throws Exception;
}
