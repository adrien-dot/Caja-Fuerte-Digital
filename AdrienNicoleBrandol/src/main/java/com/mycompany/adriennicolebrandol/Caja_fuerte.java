/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adriennicolebrandol;
/**
 *
 * @author Brandol Perez
 */
public class Caja_fuerte {
    private Combinacion combinacionActual;
    private Estadisticas estadisticas;
    private int intentosFallidosConsecutivos;
    private boolean bloqueada;

    public Caja_fuerte() {
        this.combinacionActual = new Combinacion("1231");
        this.estadisticas = new Estadisticas();
        this.intentosFallidosConsecutivos = 0;
        this.bloqueada = false;
    }

    public int intentarAbrir(String intento) {
        if (bloqueada) {
            return -1;
        }

        if (combinacionActual.esIgual(intento)) {
            estadisticas.registrarExito();
            intentosFallidosConsecutivos = 0;
            return 1;
        } else {
            estadisticas.registrarFallo();
            intentosFallidosConsecutivos++;

            if (intentosFallidosConsecutivos >= 3) {
                bloqueada = true;
                estadisticas.registrarBloqueo();
                return -1;
            }
            return 0;
        }
    }

    public boolean cambiarCombinacion(String claveActual, String claveNueva) {
        if (!combinacionActual.esIgual(claveActual)) {
            return false;
        }
        if (!Combinacion.esValida(claveNueva)) {
            return false;
        }
        if (combinacionActual.esIgual(claveNueva)) {
            return false;
        }

        combinacionActual.setClave(claveNueva);
        return true;
    }

    public int getIntentosRestantes() {
        return 3 - intentosFallidosConsecutivos;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public Combinacion getCombinacionActual() {
        return combinacionActual;
    }
}
