import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ofertaContra.entity.OfertaContra;

public class GeneraDirectorioService {

    public void generaDirectorioService(String directorioServicio, String nombreEntidad, String entidadMayusculaInicial,
            String nombreDeAplicacion) {

        File directorioService = new File(directorioServicio);

        if (directorioService.mkdir()) {
            System.out.println("   Directorio " + nombreEntidad + "/service creado satisfactoriamente.");
            try (FileWriter fw = new FileWriter(directorioServicio + "/" + entidadMayusculaInicial + "Service.java",
                    true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                out.println("package " + nombreDeAplicacion + "." + nombreEntidad + ".service;");
                out.println("");

                out.println(
                        "import " + nombreDeAplicacion + "." + nombreEntidad + ".entity." + entidadMayusculaInicial
                                + ";");
                out.println(
                        "import " + nombreDeAplicacion + "." + nombreEntidad + ".entity." + entidadMayusculaInicial
                                + "Id;");
                out.println("");
                out.println("import org.springframework.data.domain.Page;");
                out.println("import org.springframework.data.domain.Pageable;");

                out.println("public interface " + entidadMayusculaInicial + "Service {");
                out.println("");
                out.println("   public Page<"+entidadMayusculaInicial+"> findALL(Pageable pageable) throws Exception;");
                out.println("");
                out.println("}");
               
                    System.out.println("      Archivo " + entidadMayusculaInicial
                            + "Service.java con Ids creado satisfactoriamente.");
            

                

            } catch (IOException e) {
                // exception handling left as an exercise for the reader
            }
        }
    }

}
