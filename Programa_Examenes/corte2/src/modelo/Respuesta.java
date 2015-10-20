/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author rm-rf
 */
public class Respuesta {
    
    private Integer id;
    private Pregunta p;
    private String valor;

    public Respuesta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pregunta getP() {
        return p;
    }

    public void setP(Pregunta p) {
        this.p = p;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return getValor();
    }
    
    
}
