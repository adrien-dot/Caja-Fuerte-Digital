/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class Principal
{
    private static Scanner scanner = new Scanner(System.in);
    // Inicializamos con una combinación por defecto válida (ej. "1231")
    private static CajaFuerte cajaFuerte = new CajaFuerte("1231");

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
                case 1 -> abrirCajaFuerte();
                case 2 -> cambiarCombinacion();
                case 3 -> mostrarEstadisticas();
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("===== CAJA FUERTE DIGITAL =====");
        System.out.println("1. Abrir caja fuerte");
        System.out.println("2. Cambiar combinación");
        System.out.println("3. Mostrar estadísticas");
        System.out.println("4. Salir");
    }

    private static void abrirCajaFuerte() {
        if (cajaFuerte.isBloqueada()) {
            System.out.println("CAJA FUERTE BLOQUEADA");
            return;
        }

        System.out.print("Introduzca la combinación de cuatro dígitos: ");
        String intento = scanner.nextLine().trim();

        // mascara 
        if (cajaFuerte.esValidaCombinacion(intento)) {
            System.out.println("Ingresado: ****");
        }

        cajaFuerte.intentarAbrir(intento);
    }

    private static void cambiarCombinacion() {
        if (cajaFuerte.isBloqueada()) {
            System.out.println("CAJA FUERTE BLOQUEADA");
            return;
        }

        System.out.print("Introduzca la combinación actual: ");
        String actual = scanner.nextLine().trim();

        System.out.print("Introduzca la nueva combinación de cuatro dígitos: ");
        String nueva = scanner.nextLine().trim();

        cajaFuerte.cambiarCombinacion(actual, nueva);
    }

    private static void mostrarEstadisticas() {
        cajaFuerte.mostrarEstadisticas();
    }
}
