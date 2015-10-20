/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 */
public class PreguntaFactory extends AbstractFactoryPR {

    /**
     * @param tipo
     *
     * SIMPLE <br />
     * FALSOVERDADERO <br />
     * ABIERTA<br />
     * MULTIPLERESPUESTA<br />
     * UNICARESPUESTA<br />
     *
     */
    @Override
    public Pregunta getPregunta(String tipo) {
        if (tipo == null) {
            return null;
        }
        if (tipo.equalsIgnoreCase("SIMPLE")) {
            return new PreguntaSimple();
        } else if (tipo.equalsIgnoreCase("FALSOVERDADERO")) {
            return new PreguntaFalsoVerdadero();
        } else if (tipo.equalsIgnoreCase("ABIERTA")) {
            return new PreguntaAbierta();
        } else if (tipo.equalsIgnoreCase("MULTIPLERESPUESTA")) {
            return new PreguntaMultipleRespuesta();
        } else if (tipo.equalsIgnoreCase("UNICARESPUESTA")) {
            return new PreguntaUnicaRespuesta();
        }
        return null;
    }

}
