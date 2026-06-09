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
        String sql = "INSERT INTO INCIDENTES (CODIGO_INCIDENTE, TIPO_INCIDENTE, FECHA_DETECCION, ESTADO, AUTOR_EXAMEN, FK_SOC_ID)" +
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
           int rows = motorSQL.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al añadir incidente: " + e.getMessage());
        } finally{
            //cerramos la conexion
            motorSQL.close();
        }
        //Para comprobar el add hacemos eso: INSERT INTO SOCS (NOMBRE, PAIS, NIVEL_SEGURIDAD, AUTOR_EXAMEN)
        //VALUES ('SOC de Prueba Local', 'ESPAÑA', 90, 'ENMA CONTIN');
        //Y hacemos SELECT * FROM INCIDENTES; si funciona veremos los valores añadidos

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

        // TEST 2: ACTUALIZAR
        System.out.println("--- Probando UPDATE ---");
        Incidente incidenteModificado = new Incidente();
        incidenteModificado.setCodigoIncidente("INC-001-MOD");
        incidenteModificado.setTipoIncidente("Phishing");
        incidenteModificado.setFechaDeteccion("2026-06-04");
        incidenteModificado.setEstado("RESUELTO");
        incidenteModificado.setAutorExamen("Enma Contin");
        incidenteModificado.setSoc(new Socs(1)); // Asumimos que sigue en el SOC 1

        // Llamamos al update pasándole el ID 1 (o el ID que se haya generado en tu BD)
        incidenteDAOImpl.update(4, incidenteModificado);
        //FIN TEST 2:ACTUALIZAR


        //TEST 3: ELIMINAR
        incidenteDAOImpl.delete(4);

    }


    @Override
    public void update(int id, Incidente object) {
        //Hacemos la consulta sql
        //El WHERE ID = ? al final es vital para no sobreescribir toda la tabla
        String sql = "UPDATE INCIDENTES SET CODIGO_INCIDENTE = ?, TIPO_INCIDENTE = ?, FECHA_DETECCION = ?, ESTADO = ?, AUTOR_EXAMEN = ?, FK_SOC_ID = ? WHERE ID = ?";
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

            // Sacamos el ID del SOC navegando por el objeto
            ps.setInt(6, object.getSoc().getId());

            // La interrogación número 6 corresponde al ID de la condición WHERE
            ps.setInt(7, id);


            // 3º) EJECUTAR UPDATE
            int filasAfectadas = motorSQL.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Incidente con ID " + id + " actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún incidente con el ID " + id);
            }

        }catch (SQLException e){
            System.out.println("Error al ejecutar el Update de Incidente: "+ e.getMessage());
        }finally {
            motorSQL.close();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM INCIDENTES WHERE id = ?";

        try{
            // 1º) CONECTAR
            motorSQL.connect();

            // 2º) PREPARAR
            PreparedStatement ps = motorSQL.prepare(sql);

            ps.setInt(1, id);

            // 3º) EJECUTAR UPDATE

            motorSQL.executeUpdate();

        }catch (SQLException e){
            System.out.println("Error al eliminar el incidente");
        }finally{
            motorSQL.close();
        }




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
