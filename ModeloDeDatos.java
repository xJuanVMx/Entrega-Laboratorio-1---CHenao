package clases;

import java.util.HashMap;
import entidades.Estudiante;

public class ModeloDeDatos {
    
    private HashMap<String, Estudiante> estudiantesMap;

    public ModeloDeDatos() {
        estudiantesMap = new HashMap<String, Estudiante>();
    }

    public String registrarEstudiante(Estudiante est) {

        if (!estudiantesMap.containsKey(est.getDocumento())) {
            estudiantesMap.put(est.getDocumento(), est);
            return "ok";
        } else {
            return "Estudiante ya existe";
        }
    }

    public Estudiante consultaEstudiante(String documento) {

        if (estudiantesMap.containsKey(documento)) {
            return estudiantesMap.get(documento);
        }

        return null;
    }

    public String eliminarEstudiante(String documento) {

        if (estudiantesMap.containsKey(documento)) {
            estudiantesMap.remove(documento);
            return "Estudiante eliminado";
        } else {
            return "No existe el estudiante";
        }
    }

    public String actualizarEstudiante(Estudiante est) {

        if (estudiantesMap.containsKey(est.getDocumento())) {
            estudiantesMap.put(est.getDocumento(), est);
            return "Estudiante actualizado";
        } else {
            return "No existe el estudiante";
        }
    }

    public String imprimirListaEstudiantes() {

        String msj = "DATOS ESTUDIANTES\n\n";

        for (Estudiante estudiante : estudiantesMap.values()) {

            msj += "Documento: " + estudiante.getDocumento() + "\n";
            msj += "Nombre: " + estudiante.getNombre() + "\n";
            msj += "Materia: " + estudiante.getMateria() + "\n";
            msj += "Nota1: " + estudiante.getNota1() + "\n";
            msj += "Nota2: " + estudiante.getNota2() + "\n";
            msj += "Nota3: " + estudiante.getNota3() + "\n";
            msj += "Promedio: " + estudiante.getPromedio() + "\n";
            msj += "--------------------------\n";
        }

        return msj;
    }
}