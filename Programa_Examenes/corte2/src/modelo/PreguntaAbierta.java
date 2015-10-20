/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author jgil
 */
public class PreguntaAbierta extends PreguntaImp{

    @Override
    public String getTipo() {
        return "ABIERTA";
    }
    
    @Override
    public String toString() {
        return getTipo()+" " + getNombre() + " " + getDescripcion();
    }
    
}
