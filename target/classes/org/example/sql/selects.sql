"SELECT * FROM INCIDENTES WHERE ID = ?" --para el find SIN INNER JOIN
"SELECT * FROM INCIDENTES"; -- para find all SIN INNER JOIN
"SELECT i.*, s.* FROM INCIDENTES i INNER JOIN ON SOCS s i.fk_soc_id = s.id WHERE s.id = ?"; --para find incidentes by soc CON INNER JOIN
"DELETE FROM INCIDENTES WHERE id = ?"; --para el delete
"UPDATE INCIDENTES SET CODIGO_INCIDENTE = ?, TIPO_INCIDENTE = ?, FECHA_DETECCION = ?, ESTADO = ?, AUTOR_EXAMEN = ?, FK_SOC_ID = ? WHERE ID = ?"; --Para el update
