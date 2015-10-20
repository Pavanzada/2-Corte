/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Materia;
import modelo.Pregunta;
import modelo.Respuesta;
import modelo.Tema;

/**
 *
 * @author jgil
 */
public class SQLUtil {
    
    private Conexion conexion;

    public SQLUtil() {
        conexion = new Conexion();
    }
    
    public void agregarTema(Tema t){
        String sql = "insert into tema (nombreTema) values (?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.execute();
            
            ps = conexion.prepareStatement("select max(idtema) from tema");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                t.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarTema(Tema t) {
        CachePR.agregarTema(t);
        String sql = "update tema set nombreTema = ? where idtema = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTema(Tema t) {
        CachePR.eliminarTema(t);
        String sql = "delete from tema where idtema = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, t.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Tema> cargarTema(){
        List<Tema> temas = new Stack<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("select idtema, nombreTema from tema");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tema t = new Tema();
                t.setId(rs.getInt(1));
                t.setNombre(rs.getString(2));
                temas.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temas;
    }

    void agregarMateria(Materia m) {
        String sql = "insert into materia (nombreMateria, idtema) values (?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getTema().getId());
            
            ps.execute();
            
            ps = conexion.prepareStatement("select max(idmateria) from materia");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                m.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void actualizarMateria(Materia m) {
        CachePR.agregarMateria(m);
        String sql = "update materia set nombreMateria = ? , idtema = ? where idmateria = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getTema().getId());
            ps.setInt(3, m.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void eliminarMateria(Materia m) {
        CachePR.eliminarMateria(m);
        String sql = "delete from materia where idmateria = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, m.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Materia> cargarMateria(){
        List<Materia> materias = new Stack<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("select idmateria, nombreMateria, idtema from materia");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Materia m = new Materia();
                m.setId(rs.getInt(1));
                m.setNombre(rs.getString(2));
                int tema = rs.getInt(3);
                for (Object o : CachePR.getTemas()){
                    Tema t = (Tema) o;
                    if (t.getId().equals(tema)){
                        m.setTema(t);
                        break;
                    }
                }
                materias.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }

    void agregarPregunta(Pregunta p) {
        String sql = "insert into pregunta (porcentaje, complejidad,tipopregunta, descripcion,nombre,respuesta) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setFloat(1, p.getPorcentaje());
            ps.setString(2, p.getComplejidad());
            ps.setString(3, p.getTipo());
            ps.setString(4, p.getDescripcion());
            ps.setString(5, p.getNombre());
            ps.setString(6, p.getRespuesta());
            
            ps.execute();
            
            ps = conexion.prepareStatement("select max(idpregunta) from pregunta");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                p.setId(rs.getInt(1));
            }
            if (p.getRespuestas() != null && !p.getRespuesta().isEmpty()){
                sql = "insert into pregunta_respuesta (idpregunta, respuesta) values (?,?)";
                for (Respuesta r : p.getRespuestas()){
                    ps = conexion.prepareStatement(sql);
                    ps.setInt(1, p.getId());
                    ps.setString(2, r.getValor());
                    ps.execute();
                    
                    ps = conexion.prepareStatement("select max(idprres) from pregunta_respuesta");
                    rs = ps.executeQuery();
                    if (rs.next()){
                        r.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void actualizarPregunta(Pregunta p) {
        CachePR.agregarPregunta(p);
        String sql = "update pregunta set porcentaje = ?, complejidad = ?,tipopregunta = ?, descripcion = ?,nombre = ?,respuesta = ? where idpregunta = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setFloat(1, p.getPorcentaje());
            ps.setString(2, p.getComplejidad());
            ps.setString(3, p.getTipo());
            ps.setString(4, p.getDescripcion());
            ps.setString(5, p.getNombre());
            ps.setString(6, p.getRespuesta());
            ps.setInt(7, p.getId());
            ps.execute();
            
            if (p.getRespuestas() != null && !p.getRespuesta().isEmpty()){
                sql = "delete from pregunta_respuesta where idpregunta = ?";
                ps = conexion.prepareStatement(sql);
                ps.setInt(1, p.getId());
                ps.execute();
                
                sql = "insert into pregunta_respuesta (idpregunta, respuesta) values (?,?)";
                for (Respuesta r : p.getRespuestas()){
                    ps = conexion.prepareStatement(sql);
                    ps.setInt(1, p.getId());
                    ps.setString(2, r.getValor());
                    ps.execute();
                    
                    ps = conexion.prepareStatement("select max(idprres) from pregunta_respuesta");
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()){
                        r.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void eliminarPregunta(Pregunta p) {
        CachePR.eliminarPregunta(p);
        try {
            PreparedStatement ps;
            String sql;
            if (p.getRespuestas() != null && !p.getRespuesta().isEmpty()){
                sql = "delete from pregunta_respuesta where idpregunta = ?";
                ps = conexion.prepareStatement(sql);
                ps.setInt(1, p.getId());
                ps.execute();
            }
            
            sql = "delete from pregunta where idpregunta = ?";
            
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Pregunta> cargarPreguntas(){
        List<Pregunta> preguntas = new Stack<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("select idpregunta, porcentaje, complejidad,tipopregunta, descripcion,nombre,respuesta from pregunta");
            ResultSet rs = ps.executeQuery();
            ExamenBuilder eb = new ExamenBuilder();
            while (rs.next()){
                Pregunta p = eb.generarPregunta(rs.getString("tipopregunta"));
                
                p.setId(rs.getInt(1));
                p.setPorcentaje(rs.getFloat(2));
                p.setComplejidad(rs.getString(3));
                //4 es tipoPregunta
                p.setDescripcion(rs.getString(5));
                p.setNombre(rs.getString(6));
                p.setRespuesta(rs.getString(7));
                
                preguntas.add(p);
                
                PreparedStatement respuestas = conexion.prepareStatement("select idprres, respuesta from pregunta_respuesta where idpregunta = ?");
                respuestas.setInt(1, p.getId());
                ResultSet resResp = respuestas.executeQuery();
                while(resResp.next()){
                    Respuesta r = new Respuesta();
                    r.setId(resResp.getInt(1));
                    r.setValor(resResp.getString(2));
                    r.setP(p);
                    p.agregarRespuesta(r);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preguntas;
    }
    
    
}
