import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneraDirectorioServiceImpl {

    public void generaDirectorioServiceImpl(String directorioServicioImplementacion, String nombreEntidad,
            String entidadMayusculaInicial, String nombreDeAplicacion) {

        File directorioServiceImpl = new File(directorioServicioImplementacion);

        if (directorioServiceImpl.mkdir()) {
            System.out.println("   Directorio " + nombreEntidad + "/service/impl creado satisfactoriamente.");
            try (FileWriter fw = new FileWriter(
                    directorioServicioImplementacion + "/" + entidadMayusculaInicial + "ServiceImpl.java",
                    true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                out.println("package " + nombreDeAplicacion + "." + nombreEntidad + ".service.impl;");
                out.println("");
                out.println("import java.util.List;");
                out.println("import java.util.Optional;");
                out.println("import java.util.stream.Collectors;");
                out.println("");
                out.println("import org.springframework.beans.factory.annotation.Autowired;");
                out.println("import org.springframework.data.domain.Page;");
                out.println("import org.springframework.data.domain.Pageable;");
                out.println("import org.springframework.stereotype.Service;");
                out.println("");
                out.println("import jakarta.transaction.Transactional;");
                out.println("");
                out.println(
                        "import " + nombreDeAplicacion + "." + nombreEntidad + ".entity." + entidadMayusculaInicial
                                + ";");
                out.println(
                        "import " + nombreDeAplicacion + "." + nombreEntidad + ".entity." + entidadMayusculaInicial
                                            + "Id;");
                out.println("import " + nombreDeAplicacion + "." + nombreEntidad + ".repository."
                        + entidadMayusculaInicial + "Repository;");
                out.println(
                        "import " + nombreDeAplicacion + "." + nombreEntidad + ".service." + entidadMayusculaInicial
                                + "Service;");
                out.println("");
                out.println("@Service");
                
                    out.println("public class " + entidadMayusculaInicial + "ServiceImpl implements " + entidadMayusculaInicial
                            + "Service {");

            
                out.println("");
                out.println("@Autowired");
                out.println("private " + entidadMayusculaInicial + "Repository " + nombreEntidad + "Repository;");
                out.println("");
    
                out.println("");
                out.println("}");
           
                    System.out.println("      Archivo " + entidadMayusculaInicial
                            + "ServiceImpl.java con Ids creado satisfactoriamente.");
               


            } catch (IOException e) {
                // exception handling left as an exercise for the reader
            }
        }
    }

}