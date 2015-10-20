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
public class PreguntaFalsoVerdadero extends PreguntaImp{

    @Override
    public String getTipo() {
        return "FALSOVERDADERO";
    }
    
    @Override
    public String toString() {
        return getTipo()+" " + getNombre() + " " + getDescripcion();
    }
    
}
