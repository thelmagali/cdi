package py.com.personal.cditest.model;


public class Cuenta {

    Integer saldo;

    int idCuenta;

    boolean esDefault;

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public boolean isEsDefault() {
        return esDefault;
    }

    public void setEsDefault(boolean esDefault) {
        this.esDefault = esDefault;
    }
}
