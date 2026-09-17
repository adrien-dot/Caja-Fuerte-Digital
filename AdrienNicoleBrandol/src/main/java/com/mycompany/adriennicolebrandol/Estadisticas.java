/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adriennicolebrandol;
/**
 *
 * @author Brandol Perez
 */
public class Estadisticas {
    private int accesosExitosos;
    private int accesosFallidos;
    private int totalIntentos;
    private int vecesBloqueada;

    public Estadisticas() {
        this.accesosExitosos = 0;
        this.accesosFallidos = 0;
        this.totalIntentos = 0;
        this.vecesBloqueada = 0;
    }

    public void registrarExito() {
        this.accesosExitosos++;
        this.totalIntentos++;
    }

    public void registrarFallo() {
        this.accesosFallidos++;
        this.totalIntentos++;
    }

    public void registrarBloqueo() {
        this.vecesBloqueada++;
    }

    public void mostrar() {
        System.out.println("=== ESTADÍSTICAS DE USO ===");
        System.out.println("Cantidad de accesos exitosos: " + accesosExitosos);
        System.out.println("Cantidad de accesos fallidos: " + accesosFallidos);
        System.out.println("Cantidad total de intentos: " + totalIntentos);
        System.out.println("Cantidad de veces que la caja fue bloqueada: " + vecesBloqueada);
    }
}
