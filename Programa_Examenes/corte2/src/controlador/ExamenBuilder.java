/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.AbstractFactoryPR;
import modelo.Examen;
import modelo.Materia;
import modelo.Pregunta;
import modelo.PreguntaFactory;
import modelo.Tema;

/**
 *
 */
public class ExamenBuilder {

    /**AbstractFactory*/
    private AbstractFactoryPR factoryPR;
    /**AbstractFactory*/

    public ExamenBuilder() {
        factoryPR = new PreguntaFactory();
    }

    public Examen generarCuestionario(String tema) {
        Examen c = new Examen();

        return c;
    }
    
    public Materia generaMateria(String tema){
        Materia m = new Materia();
        m.setNombre(tema);
        return m;
    }

    public Tema generaTema(String tema) {
        Tema t = new Tema();
        t.setNombre(tema);
        return t;
    }

    public Pregunta getSimple() {
        return generarPregunta("SIMPLE");
    }

    public Pregunta getAbierta() {
        return generarPregunta("ABIERTA");
    }

    public Pregunta getFalsoVerdadero() {
        return generarPregunta("FALSOVERDADERO");
    }

    public Pregunta getMultipleRespuesta() {
        return generarPregunta("MULTIPLERESPUESTA");
    }
    
    public Pregunta getUnicaRespuesta(){
        return generarPregunta("UNICARESPUESTA");
    }

    public Pregunta generarPregunta(String tipo) {
        return factoryPR.getPregunta(tipo);
    }
}
