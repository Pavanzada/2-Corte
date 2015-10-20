/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.List;

/**
 *
 */
public interface Pregunta extends Cloneable{
    
    public Object clone() throws CloneNotSupportedException;
    public void setPorcentaje(Float porcentaje);
    public void setId(Integer id);
    public void setNombre(String nombre);
    public void setComplejidad(String comple);
    public void setDescripcion(String desc);
    public void setRespuesta(String resp);
    public void setRespuestas(List<Respuesta> resp);
    public void agregarRespuesta(Respuesta r);
    
    public String getNombre();
    public Float getPorcentaje();
    public String getComplejidad();
    public String getTipo();
    public String getDescripcion();
    public String getRespuesta();
    public Integer getId();    
    public List<Respuesta> getRespuestas();
}
