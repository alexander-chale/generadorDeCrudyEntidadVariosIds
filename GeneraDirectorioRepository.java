import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneraDirectorioRepository {

    public void generaDirectorioRepository(String directorioRepositorio, String nombreEntidad,
            String entidadMayusculaInicial, String nombreDeAplicacion) {
        File directorioRepository = new File(directorioRepositorio);
        if (directorioRepository.mkdir()) {
            System.out.println("   Directorio " + nombreEntidad + "/repository creado satisfactoriamente.");
            try (FileWriter fw = new FileWriter(
                    directorioRepositorio + "/" + entidadMayusculaInicial + "Repository.java",
                    true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                out.println("package " + nombreDeAplicacion + "." + nombreEntidad + ".repository;");
                out.println("");
                out.println("import java.util.List;");
                out.println("import java.util.Optional;");
                out.println("");
                out.println("import org.springframework.data.jpa.repository.JpaRepository;");
                out.println("import org.springframework.data.jpa.repository.Modifying;");
                out.println("import org.springframework.data.jpa.repository.Query;");
                out.println("import org.springframework.stereotype.Repository;");
                out.println("import "+nombreDeAplicacion+"."+nombreEntidad+".entity."+entidadMayusculaInicial+";"); 
                out.println("import "+nombreDeAplicacion+"."+nombreEntidad+".entity."+entidadMayusculaInicial+"Id;"); 
                out.println("");
                out.println("@Repository");
               
                    out.println("public interface " + entidadMayusculaInicial + "Repository extends JpaRepository<"
                            + entidadMayusculaInicial + ", "+entidadMayusculaInicial+"Id> {");

           

               
                out.println("");
                out.println("");
                out.println("}");
               
                    System.out.println("      Archivo " + entidadMayusculaInicial
                            + "Repository.java con Ids creado satisfactoriamente.");
                

              

            } catch (IOException e) {
                // exception handling left as an exercise for the reader
            }
        }

    }

}
