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
public class PreguntaMultipleRespuesta extends PreguntaImp{

    @Override
    public String getTipo() {
        return "MULTIPLERESPUESTA";
    }
    
    @Override
    public String toString() {
        return getTipo()+" " + getNombre() + " " + getDescripcion();
    }
}
