/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 */
public class PreguntaSimple extends PreguntaImp{
    
    public PreguntaSimple() {
    }

    public String getTipo() {
        return "SIMPLE";
    }

    @Override
    public String toString() {
        return getTipo()+" " + getNombre() + " " + getDescripcion();
    }
    
}
