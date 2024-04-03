import java.io.File;

public class GeneraDirectorioEntityMapper {

    public void GeneraDirectorioEntityMapper(String nombreEntidad) {
        File directorioEntityMapper = new File(nombreEntidad + "/entity/mapper");

        if (directorioEntityMapper.mkdir()) {
            System.out.println("   Directorio " + nombreEntidad + "/entity/mapper creado satisfactoriamente.");
        }

    }
}
