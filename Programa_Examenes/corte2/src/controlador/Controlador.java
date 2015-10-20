/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import modelo.Examen;
import modelo.Materia;
import modelo.Pregunta;
import modelo.Tema;

/**
 *
 */
public class Controlador {
    
    
    //BuilderI
    private ExamenBuilder builder;
    //BuilderF
    
    private SQLUtil utilSQL;
    
    //SinglentonI
    private static Controlador instancia = new Controlador();

    public static Controlador getInstance(){
        return instancia;
    }
    //SinglentonF
    
    public Controlador() {
        //PrototypeI
        CachePR.cargarCache();
        //PrototypeF
        builder =  new ExamenBuilder();
        utilSQL = new SQLUtil();
    }

    public Tema crearTema(String nombre){
        return builder.generaTema(nombre);
    }
    
    public Materia crearMateria(String nombre){
        return builder.generaMateria(nombre);
    }
    
    public ExamenBuilder getBuilder(){
        return builder;
    }
    
    public void agregarExamen(Examen c){
        CachePR.agregarExamen(c);
    }
    
    public void agregarTema(Tema t){
        CachePR.agregarTema(t);
        utilSQL.agregarTema(t);
    }
    
    public void actualizarTema(Tema tema){
        utilSQL.actualizarTema(tema);
    }
    
    public void eliminarTema(Tema tema){
        utilSQL.eliminarTema(tema);
    }
    
    public void agregarMateria(Materia m){
        CachePR.agregarMateria(m);
        utilSQL.agregarMateria(m);
    }
    
    public void actualizarMateria(Materia m){
        utilSQL.actualizarMateria(m);
    }
    
    public void eliminarMateria(Materia m){
        utilSQL.eliminarMateria(m);
    }
    
    public void agregarPregunta(Pregunta p){
        CachePR.agregarPregunta(p);
        utilSQL.agregarPregunta(p);
    }
    
    public void actualizarPregunta(Pregunta p){
        utilSQL.actualizarPregunta(p);
    }
    
    public void eliminarPregunta(Pregunta p){
        utilSQL.eliminarPregunta(p);
    }
    
    public static void main(String aaa[]){
//        Controlador c = Controlador.getInstance();
//        Materia m = c.crearMateria("Matematicas");
//        System.out.println(c.getMateriasString());
//        
//        Tema suma = c.crearTema("Suma");
//        Tema resta = c.crearTema("Resta");
//        
////        m.getTemas().add(suma);
////        m.getTemas().add(resta);
//        
//        Cuestionario cuestionario = c.builder.generarCuestionario(suma);
//        cuestionario.addRespuesta(CachePR.getPregunta("SIMPLE"), CachePR.getRespuesta("SIMPLE"));
//        
//        System.out.println(c.getMateriasTemas());
//        System.out.println(c.getMateriasTemasCuestionarios());
//        System.out.println(c.getPreguntas());
//        System.out.println(c.getRespuestas());
        
    }

}
