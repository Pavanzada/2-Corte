/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.Hashtable;
import modelo.Examen;
import modelo.Materia;
import modelo.Pregunta;
import modelo.Tema;

/**
 *
 */
public class CachePR {
    
    private static Hashtable<String, Tema> temaCache = new Hashtable();
    private static Hashtable<String, Materia> materiaCache = new Hashtable();
    private static Hashtable<String, Pregunta> preguntaCache = new Hashtable();
    private static Hashtable<String, Examen> examenCache = new Hashtable();
    
    public CachePR() {
    }
    
    public static void cargarCache(){
        SQLUtil util = new SQLUtil();
        for (Tema t : util.cargarTema()){
            agregarTema(t);
        }
        
        for (Materia m : util.cargarMateria()){
            agregarMateria(m);
        }
        
        for (Pregunta p : util.cargarPreguntas()){
            agregarPregunta(p);
        }
    }
    
    public static Pregunta getPregunta(String nombre) throws CloneNotSupportedException{
        return (Pregunta) preguntaCache.get(nombre).clone();
    }
    
    public static Examen getExamen(String nombre) throws CloneNotSupportedException{
        return (Examen) examenCache.get(nombre).clone();
    }
    
    public static Tema getTema(String nombre) throws CloneNotSupportedException{
        return (Tema) temaCache.get(nombre).clone();
    }
    
    public static Materia getMateria(String nombre) throws CloneNotSupportedException{
        return (Materia) materiaCache.get(nombre).clone();
    }
   
    
    public static void agregarPregunta(Pregunta p){
        preguntaCache.put(p.getNombre(), p);
    }
    
    public static void agregarExamen(Examen c){
        examenCache.put(c.getNombre(), c);
    }
    
    public static void agregarTema(Tema t){
        temaCache.put(t.getNombre(), t);
    }
    
    public static void agregarMateria(Materia m){
        materiaCache.put(m.getNombre(), m);
    }
    
    public static Object[] getTemas(){
        return temaCache.values().toArray();
    }
    
    public static Object[] getMaterias(){
        return materiaCache.values().toArray();
    }
    
    public static Object[] getPreguntas(){
        return  preguntaCache.values().toArray();
    }
    
    public static Object[] getExamenes(){
        return examenCache.values().toArray();
    }
    
    public static void eliminarPregunta(Pregunta p){
        preguntaCache.remove(p.getNombre());
    }
    
    public static void eliminarExamen(Examen c){
        examenCache.remove(c.getNombre());
    }
    
    public static void eliminarTema(Tema t){
        temaCache.remove(t.getNombre());
    }
    
    public static void eliminarMateria(Materia m){
        materiaCache.remove(m.getNombre());
    }
  
    
    
}
