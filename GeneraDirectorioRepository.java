import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneraDirectorioRepository {

    public void generaDirectorioRepository(String directorioRepositorio, String nombreEntidad,
            String entidadMayusculaInicial, String nombreDeAplicacion, String nombreTablaValidada) {
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
                out.println("   //@Modifying");
                out.println("   //@Query(value = \"INSERT INTO cusg."+nombreTablaValidada+" (co_empresa, co_rif_usua_cont) VALUES (?1, ?2)\", nativeQuery = true)");
                out.println("   //void save"+entidadMayusculaInicial+"(Long id, String rif);");
                out.println("");
                out.println("");
                out.println("   //@Modifying");
                out.println("   //@Query(value = \"DELETE FROM cusg."+nombreTablaValidada+" WHERE co_empresa=?1 AND co_rif_usua_cont=?2\", nativeQuery = true)");
                out.println("   //void delete"+entidadMayusculaInicial+"(Long id, String rif);");
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
