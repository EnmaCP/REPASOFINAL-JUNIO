package org.example.DAO;

import org.example.beans.Incidente;
import org.example.beans.Socs;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class IncidenteDAOImpl
    extends AbstractDAO<Incidente> {

    public IncidenteDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    @Override
    public void add(Incidente object) {
        //definimos la consulta sql
        String sql = "INSERT INTO INCIDENTES (CODIGO_INCIDENTE, TIPO_INCIDENTE, FECHA_DETECCION, ESTADO, AUTOR_EXAMEN, FK_SOC_ID" +
                "VALUES (?,?,?,?,?,?)";
        try{
            // 1º) CONECTAR
            motorSQL.connect();
            // 2º) PREPARAR
            PreparedStatement ps = motorSQL.prepare(sql);

            //Sustituimos los ? por los valores correspondientes
            ps.setString(1, object.getCodigoIncidente());
            ps.setString(2, object.getTipoIncidente());
            ps.setString(3, object.getFechaDeteccion());
            ps.setString(4, object.getEstado());
            ps.setString(5, object.getAutorExamen());

            //Para sacar el ID del SOC, navegamos a través del objeto anidado
            ps.setInt(6, object.getSoc().getId());
            // 3º) EJECUTAR UPDATE
            motorSQL.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al añadir incidente: " + e.getMessage());
        } finally{
            //cerramos la conexion
            motorSQL.close();
        }

    }
    public static void main (String[] args ){
        // INSTANCI INCIDENTE
        IncidenteDAOImpl incidenteDAOImpl =
                new IncidenteDAOImpl(MotorFactory.
                        create(MotorFactory.POSTGRE));
        // TEST 1: AÑADIR
        Incidente incidente = new Incidente();
        incidente.setCodigoIncidente("1");
        incidente.setTipoIncidente("2");
        incidente.setFechaDeteccion("23/10/2010");
        incidente.setEstado("revisado");
        incidente.setAutorExamen("Enma Contin");
        incidente.setSoc(new Socs(1));
        incidenteDAOImpl.add(incidente);
        // FIN  TEST 1: AÑADIR
    }


    @Override
    public void update(int id, Incidente object) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Incidente find(int id) {
        return null;
    }

    @Override
    public ArrayList<Incidente> findAll() {
        return null;
    }
}
