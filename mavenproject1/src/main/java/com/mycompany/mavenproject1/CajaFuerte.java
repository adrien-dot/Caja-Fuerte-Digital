/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author alexa
 */
public class CajaFuerte 
{
private String combinacionActual;
    private boolean bloqueada;
    private int intentosFallidosConsecutivos;
    
    // Contadores para estadísticas
    private int accesosExitosos;
    private int accesosFallidos;
    private int vecesBloqueada;

    public CajaFuerte(String combinacionInicial) {
        this.combinacionActual = combinacionInicial;
        this.bloqueada = false;
        this.intentosFallidosConsecutivos = 0;
        this.accesosExitosos = 0;
        this.accesosFallidos = 0;
        this.vecesBloqueada = 0;
    }

    public boolean esValidaCombinacion(String combinacion) {
        if (combinacion == null || combinacion.length() != 4) {
            return false;
        }
        for (char c : combinacion.toCharArray()) {
            if (c != '1' && c != '2' && c != '3') {
                return false;
            }
        }
        return true;
    }

    public boolean intentarAbrir(String intento) {
        if (bloqueada) {
            System.out.println("CAJA FUERTE BLOQUEADA. No se pueden realizar mas intentos.");
            return false;
        }

        if (!esValidaCombinacion(intento)) {
            System.out.println("Error: La combinacion solo debe contener 4 digitos formados por 1, 2 o 3.");
            return false;
        }

        if (intento.equals(combinacionActual)) {
            accesosExitosos++;
            intentosFallidosConsecutivos = 0;
            System.out.println("ACCESO AUTORIZADO");
            return true;
        } else {
            accesosFallidos++;
            intentosFallidosConsecutivos++;
            System.out.println("ACCESO DENEGADO");

            if (intentosFallidosConsecutivos >= 3) {
                bloqueada = true;
                vecesBloqueada++;
                System.out.println("CAJA FUERTE BLOQUEADA");
            }
            return false;
        }
    }

    public boolean cambiarCombinacion(String actual, String nueva) {
        if (bloqueada) {
            System.out.println("CAJA FUERTE BLOQUEADA. No se puede cambiar la combinacion.");
            return false;
        }

        if (!actual.equals(combinacionActual)) {
            System.out.println("La combinacion actual ingresada es incorrecta.");
            return false;
        }

        if (!esValidaCombinacion(nueva)) {
            System.out.println("Error: La nueva combinacion debe tener exactamente cuatro digitos (solo 1, 2 o 3).");
            return false;
        }

        if (nueva.equals(combinacionActual)) {
            System.out.println("Error: La nueva combinacion no puede ser igual a la anterior.");
            return false;
        }

        this.combinacionActual = nueva;
        System.out.println("COMBINACIÓN ACTUALIZADA EXITOSAMENTE");
        return true;
    }

    public void mostrarEstadisticas() {
        System.out.println("=== ESTADÍSTICAS DE USO ===");
        System.out.println("Cantidad de accesos exitosos: " + accesosExitosos);
        System.out.println("Cantidad de accesos fallidos: " + accesosFallidos);
        System.out.println("Cantidad total de intentos: " + (accesosExitosos + accesosFallidos));
        System.out.println("Cantidad de veces que la caja fue bloqueada: " + vecesBloqueada);
    }

    public boolean isBloqueada() {
        return bloqueada;
    }
}

