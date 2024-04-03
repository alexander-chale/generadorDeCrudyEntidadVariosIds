import java.io.File;

public class GeneraDirectorioEntityDtos {

    public void GeneraDirectorioEntityDtos(String nombreEntidad) {
        File directorioEntityDtos = new File(nombreEntidad + "/entity/dtos");

        if (directorioEntityDtos.mkdir()) {
            System.out.println("   Directorio " + nombreEntidad + "/entity/dtos creado satisfactoriamente.");
        }

    }
}
