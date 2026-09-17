/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adriennicolebrandol;
/**
 *
 * @author Brandol Perez
 */
public class Combinacion {
    private String clave;

    public Combinacion(String clave) {
        if (esValida(clave)) {
            this.clave = clave;
        } else {
            this.clave = "1231";
        }
    }

    public static boolean esValida(String comb) {
        if (comb == null || comb.length() != 4) {
            return false;
        }
        for (int i = 0; i < comb.length(); i++) {
            char c = comb.charAt(i);
            if (c != '1' && c != '2' && c != '3') {
                return false;
            }
        }
        return true;
    }

    public boolean esIgual(String otraClave) {
        return this.clave.equals(otraClave);
    }

    public String getMascara() {
        return "****";
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String nuevaClave) {
        if (esValida(nuevaClave)) {
            this.clave = nuevaClave;
        }
    }
}
