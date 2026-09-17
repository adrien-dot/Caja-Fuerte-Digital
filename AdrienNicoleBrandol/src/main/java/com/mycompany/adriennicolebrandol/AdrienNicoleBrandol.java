/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adriennicolebrandol;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
/**
 *
 * @author Brandol Perez
 */
public class AdrienNicoleBrandol {

        private static Scanner scanner = new Scanner(System.in);
    private static Caja_fuerte caja = new Caja_fuerte();

    public static void main(String[] args) {
        int opcion = 0;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            String entrada = scanner.nextLine().trim();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            System.out.println();
            switch (opcion) {
                case 1:
                    Abrir_caja_fuerte();
                    break;
                case 2:
                    cambiarCombinacion();
                    break;
                case 3:
                    caja.getEstadisticas().mostrar();
                    break;
                case 4:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("CAJA FUERTE DIGITAL");
        System.out.println("1. Abrir caja fuerte");
        System.out.println("2. Cambiar combinación");
        System.out.println("3. Mostrar estadísticas");
        System.out.println("4. Salir");
    }

    private static String pedirYValidarCombinacion(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();

            if (input.length() != 4) {
                System.out.println("Error: La combinación debe tener exactamente 4 dígitos.");
            } else if (!Combinacion.esValida(input)) {
                System.out.println("Error: Solo se permiten los números 1, 2 y 3.");
            } else {
                System.out.println("Combinación ingresada: ****");
                return input;
            }
        }
    }

    private static void Abrir_caja_fuerte() {
        if (caja.isBloqueada()) {
            System.out.println("CAJA FUERTE BLOQUEADA");
            return;
        }

        String intento = pedirYValidarCombinacion("Introduzca la combinación de cuatro dígitos (1, 2, 3): ");
        int resultado = caja.intentarAbrir(intento);

        if (resultado == 1) {
            System.out.println("ACCESO AUTORIZADO");
        } else if (resultado == 0) {
            System.out.println("ACCESO DENEGADO");
            System.out.println("Intentos restantes: " + caja.getIntentosRestantes());
        } else if (resultado == -1) {
            System.out.println("ACCESO DENEGADO");
            System.out.println("CAJA FUERTE BLOQUEADA");
        }
    }

    private static void cambiarCombinacion() {
        if (caja.isBloqueada()) {
            System.out.println("Error: No se puede cambiar la combinación. La caja está bloqueada.");
            return;
        }

        String actual = pedirYValidarCombinacion("Introduzca la combinación actual: ");
        if (!caja.getCombinacionActual().esIgual(actual)) {
            System.out.println("ACCESO DENEGADO");
            return;
        }

        String nueva = pedirYValidarCombinacion("Introduzca la NUEVA combinación: ");
        if (actual.equals(nueva)) {
            System.out.println("Error: La nueva combinación no puede ser igual a la anterior.");
            return;
        }

        if (caja.cambiarCombinacion(actual, nueva)) {
            System.out.println("COMBINACIÓN ACTUALIZADA EXITOSAMENTE");
        } else {
            System.out.println("Error al actualizar la combinación.");
        }
    }
}

