import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Cuenta{
    private String codCuenta;
    private double saldo;
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    private static int cantCuentasCreadas;

    public Cuenta(String nombreCuentaHabiente, double pSaldo){
        cantCuentasCreadas++;
        codCuenta = "cta-" + (cantCuentasCreadas-1);
        this.nombreCuentaHabiente = nombreCuentaHabiente;
        fechaCreacion = establecerFechaCreacion();
        saldo = pSaldo;
    }

    public Cuenta(double pSaldo){
        this("Pendiente", pSaldo);
    }

    private String establecerFechaCreacion(){
        Date fecha = new Date(System.currentTimeMillis());
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        return formatoFecha.format(fecha);
    }

    public void setNombreCuentaHabiente(String pNombreCuentaHabiente){
        nombreCuentaHabiente = pNombreCuentaHabiente;
    }

    public String getCodCuenta(){
        return codCuenta;
    }

    public double getSaldo(){
        return saldo;
    }

    public double depositar(double monto){
        saldo += monto;
        cantDepositosRealizados++;
        return saldo;
    }

    public double retirar(double monto){
        if (validarRetiro(monto)){
            saldo -= monto;
            cantRetirosExitososRealizados++;
        }
        return saldo;
    }

    private boolean validarRetiro(double monto){
        if (saldo >= monto){
            return true;
        } else {
            return false;
        }
    }

    public static int getCantCuentasCreadas(){
        return cantCuentasCreadas;
    }

    public String toString(){
        return "Titular: " + nombreCuentaHabiente + "\n" +
               "Codigo de cuenta: " + codCuenta + "\n" +
               "Saldo: " + saldo + "\n" +
               "Fecha de creacion: " + fechaCreacion + "\n" +
               "Cantidad de depositos realizados: " + cantDepositosRealizados + "\n" +
               "Cantidad de retiros exitosos realizados: " + cantRetirosExitososRealizados + "\n" +
               "Cuentas existentes: " + getCantCuentasCreadas();
    }
}