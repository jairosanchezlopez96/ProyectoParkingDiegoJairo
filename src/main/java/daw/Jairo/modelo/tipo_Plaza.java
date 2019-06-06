/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

/**
 *
 * @author jairo
 */
public enum tipo_Plaza {
    TURISMO(1, "Turismo"),
    CARAVANA(3, "Caravana"),
    MOTOCICLETA(2, "Motocicleta");

    private int valor;
    private String tipo;

    private tipo_Plaza(int valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
