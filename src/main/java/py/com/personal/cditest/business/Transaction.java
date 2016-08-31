package py.com.personal.cditest.business;


public interface Transaction {

    public void apply(Integer monto) throws Exception;
}
