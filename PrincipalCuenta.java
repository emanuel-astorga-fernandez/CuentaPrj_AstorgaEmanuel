import java.util.Scanner;

public class PrincipalCuenta {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Cuenta[] cuentas = new Cuenta[200];
        int cantidad = 0;
        Cuenta cuentaActual = null;
        int opcion;
        int opcion2;
        double pSaldo;

        do{
            System.out.println("1. Crear cuenta");
            System.out.println("2. Conocer cantidad de cuentas creadas");
            System.out.println("3. Listar cuentas");
            System.out.println("4. Seleccionar cuenta actual");
            System.out.println("5. Asignar nombre del cuenta habiente");
            System.out.println("6. Depositar");
            System.out.println("7. Retirar");
            System.out.println("8. Consultar saldo");
            System.out.println("9. Consultar estado de la cuenta");
            System.out.println("10. Salir");
            opcion = sc.nextInt();

            switch (opcion){

                case 1:
                    System.out.println("¿1 o 2 parámetros? (escriba 1 o 2)");
                    opcion2 = sc.nextInt();

                    if (opcion2 == 1){
                        System.out.println("Ingrese el saldo inicial:");
                        pSaldo = sc.nextDouble();
                        cuentas[cantidad] = new Cuenta(pSaldo);
                        cantidad++;
                        System.out.println("Cuenta creada con éxito.");
                    } else if (opcion2 == 2){
                        System.out.println("Ingrese el nombre del cuenta habiente:");
                        String nombre = sc.next();
                        System.out.println("Ingrese el saldo inicial:");
                        pSaldo = sc.nextDouble();
                        cuentas[cantidad] = new Cuenta(nombre, pSaldo);
                        cantidad++;
                        System.out.println("Cuenta creada con éxito.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 2:
                    System.out.println("Cuentas creadas: " + Cuenta.getCantCuentasCreadas());
                    break;

                case 3:
                    if (cantidad == 0){
                        System.out.println("No se han encontrado cuentas.");
                    } else {
                        for (int i = 0; i < cantidad; i++){
                            System.out.println("Cuenta: " + i);
                            System.out.println(cuentas[i].toString());
                        }
                    }
                    break;

                case 4:
                    if (cantidad == 0){
                        System.out.println("No se han encontrado cuentas.");
                    } else {
                        System.out.println("Ingrese el numero de cuenta: 0-" + (cantidad - 1));
                        int indice = sc.nextInt();
                        if (indice >= 0 && indice < cantidad){
                            cuentaActual = cuentas[indice];
                            System.out.println("Cuenta seleccionada con exito.");
                        } else {
                            System.out.println("Esa cuenta no existe.");
                        }
                    }
                    break;

                case 5:
                    if (cuentaActual != null){
                        System.out.println("Ingrese el nombre para la cuenta actual: ");
                        String nombre = sc.next();
                        cuentaActual.setNombreCuentaHabiente(nombre);
                        System.out.println("Nombre asignado con éxito.");
                    } else {
                        System.out.println("No se han encontrado cuentas seleccionadas.");
                    }
                    break;

                case 6:
                    if (cuentaActual != null){
                        System.out.println("Ingrese el monto a depositar.");
                        double monto = sc.nextDouble();
                        if (monto > 0){
                            System.out.println("Saldo actualizado: " + cuentaActual.depositar(monto));
                        } else {
                            System.out.println("Verifique el monto ingresado.");
                        }
                    } else {
                        System.out.println("No se han encontrado cuentas seleccionadas.");
                    }
                    break;

                case 7:
                    if (cuentaActual != null){
                        System.out.println("Ingrese el monto a retirar.");
                        double monto = sc.nextDouble();
                        if (monto > 0){
                            System.out.println("Saldo actualizado: " + cuentaActual.retirar(monto));
                        } else {
                            System.out.println("Verifique el monto ingresado.");
                        }
                    } else {
                        System.out.println("No se han encontrado cuentas seleccionadas.");
                    }
                    break;

                case 8:
                    if (cuentaActual != null){
                        System.out.println("Saldo: " + cuentaActual.getSaldo());
                    } else {
                        System.out.println("No se han encontrado cuentas seleccionadas.");
                    }
                    break;

                case 9:
                    if (cuentaActual != null){
                        System.out.println(cuentaActual.toString());
                    } else {
                        System.out.println("No se han encontrado cuentas seleccionadas.");
                    }
                    break;

                case 10:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
                    break;
            }

        } while (opcion != 10);
    }
}