/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author jgil
 */
public abstract class PreguntaImp implements Pregunta{
    
    private Integer id;
    private Float porcentaje;
    private String complejidad;
    private String descripcion;
    private String nombre;
    private String respuesta;
    private List<Tema> temas;
    private List<Respuesta> respuestas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(String complejidad) {
        this.complejidad = complejidad;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public void agregarRespuesta(Respuesta r) {
        if (respuestas == null){
            respuestas = new Stack<>();
        }
        respuestas.add(r);
    }
    
    
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = null;
        try{
            object = super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return object;
    }
    
    public abstract String getTipo();

}
