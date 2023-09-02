package javanewperubank;

import java.util.*;


public class JavaNewPeruBank {

    public boolean buscarUsuario(String[] DNI, String[] pass) {
        Scanner Entrada = new Scanner(System.in);
        System.out.println("New Perú Bank");

        System.out.println("DNI:");
        String dni = Entrada.nextLine();

        System.out.println("Password:");
        String password = Entrada.nextLine();
        boolean validador = false;
        
        for (int i = 0; i < DNI.length; i++) {
            if (dni.equals(DNI[i]) && password.equals(pass[i])) {
                validador = true;

                break;
            } else {
                validador = false;

            }
        }

        return validador;

    }

    public float tipoOperacion(int contador,float saldo) {
        float saldoInt=saldo;
        System.out.println("Bienvenido Marko" );
        System.out.println("\n"
                + "Elija la operación que desea realizar:\n"
                + "[1] Depósito\n"
                + "[2] Retiro\n"
                + "[3] Consulta de Saldo\n"
                + "[4] Salir\n");
               
        Scanner datosEntrada = new Scanner(System.in);
        String numeroElecto = datosEntrada.next();
//
        if (numeroElecto.equals("1")) {
            System.out.println("\n-------------------------------------------------------------------------------\nMonto de depósito");
            float montoScanner = datosEntrada.nextFloat();
            saldoInt = saldo+montoScanner;
            System.out.println("\n--------------------------------\nLa operación se ha realizado correctamente"+"\n--------------------------------");
            

        } else if (numeroElecto.equals("2")) {
            System.out.println("\n-------------------------------------------------------------------------------\nMonto de retiro");
            float montoScanner2 = datosEntrada.nextFloat();
            saldoInt =saldo- montoScanner2;
            System.out.println("\n--------------------------------\nLa operación se ha realizado correctamente"+"\n--------------------------------");
            
        } else if (numeroElecto.equals("3")) {
            System.out.println("\n--------------------------------\nTu saldo es s/" + saldo+"\n--------------------------------");
        } else if (numeroElecto.equals("4")){
            System.out.println("Saliendo del sistema...");
            contador = 4;
        }
        return saldoInt;
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        String[] DNI = {"71950642", "68425947", "63214578", "60215483", "62184527"};
        String[] pass = {"iii123", "eee123", "aaa123", "uuu123", "pass123"};
        String[] nombre = {"Juan", "marko", "Antonio", "Pedro", "Jose"};

//
        int contador = 0;
        
        JavaNewPeruBank cal = new JavaNewPeruBank();
        boolean validador = cal.buscarUsuario(DNI, pass);
        
        
        float saldo = 0;
        while (contador <3) {
            if(contador==1){
                System.out.println("       Ultimo Intento\n-------------------------------------------------------- ");
                validador = cal.buscarUsuario(DNI, pass);
                contador++;
            }else if (validador == true) {
                saldo = cal.tipoOperacion(contador,saldo);
                
                System.out.println("\nDesea salir\n[si]\n[no]");
                String continuar = input.next();
                if (continuar.equals("no")) {
                    contador = 0;
                } else {
                    System.out.println("------------------------------Sesión cerrada-----------------------------------");
                    contador = 4;
                }
            } else if(contador<1){
                System.out.println("       ERROR INTENTAR DE NUEVO\n-------------------------------------------------------- ");
                validador = cal.buscarUsuario(DNI, pass);
            contador++;
            }
        }

    }

}

