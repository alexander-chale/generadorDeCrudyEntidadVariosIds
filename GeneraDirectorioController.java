import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneraDirectorioController {

    public void generaDirectorioController(String nombreEntidad, String directorioControlador, String entidadMayusculaInicial, String nombreDeAplicacion) {
        File directorioController = new File(directorioControlador);
            if (directorioController.mkdir()) {
                System.out.println("   Directorio " + nombreEntidad + "/controller creado satisfactoriamente.");

                try (FileWriter fw = new FileWriter(
                        directorioControlador + "/" + entidadMayusculaInicial + "Controller.java",
                        true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw)) {
                    out.println("package " + nombreDeAplicacion + "." + nombreEntidad + ".controller;");
                    out.println("");

                    out.println("import java.util.List;");

                    out.println("import org.springframework.beans.factory.annotation.Autowired;");
                    out.println("import org.springframework.data.domain.Pageable;");
                    out.println("import org.springframework.http.HttpStatus;");
                    out.println("import org.springframework.http.ResponseEntity;");
                    out.println("import org.springframework.web.bind.annotation.CrossOrigin;");
                    out.println("import org.springframework.web.bind.annotation.DeleteMapping;");
                    out.println("import org.springframework.web.bind.annotation.GetMapping;");
                    out.println("import org.springframework.web.bind.annotation.PathVariable;");
                    out.println("import org.springframework.web.bind.annotation.PostMapping;");
                    out.println("import org.springframework.web.bind.annotation.PutMapping;");
                    out.println("import org.springframework.web.bind.annotation.RequestBody;");
                    out.println("import org.springframework.web.bind.annotation.RequestMapping;");
                    out.println("import org.springframework.web.bind.annotation.RestController;");
                    out.println("");
                    out.println(
                        "import " + nombreDeAplicacion + "." + nombreEntidad + ".entity." + entidadMayusculaInicial
                                + ";");
                    out.println(
                        "import " + nombreDeAplicacion + "." + nombreEntidad + ".entity." + entidadMayusculaInicial
                                + "Id;");
                    out.println("import " + nombreDeAplicacion + "." + nombreEntidad + ".service."
                            + entidadMayusculaInicial + "Service;");
                    out.println("");
                    out.println("@RestController");
                    out.println("@CrossOrigin(origins = \"*\")");
                    out.println("@RequestMapping(path = \"api/v1/" + nombreEntidad + "\")");
                    
                        out.println(
                                "public class " + entidadMayusculaInicial
                                        + "Controller {");
                  
                    out.println("");
                    out.println("   @Autowired");
                    out.println("   private " + entidadMayusculaInicial + "Service " + nombreEntidad + "Service;");
                    out.println("");
                    out.println("   @GetMapping(\"/paged\")");
                    out.println("   public ResponseEntity<?> getAll(Pageable pageable) {");
                    out.println("      try {");
                    out.println("         return ResponseEntity.status(HttpStatus.OK).body("+nombreEntidad+"Service.findALL(pageable));");
                    out.println("      } catch (Exception e) {");
                    out.println("         return ResponseEntity.status(HttpStatus.NOT_FOUND)");
                    out.println("              .body(\"{\\\"error\\\":\\\"Error. Por favor intente más tarde.\\\"}\");");
                    out.println("      }");
                    out.println("   }");

                    out.println("");
                    out.println("");
                    out.println("}");

                    
                        System.out.println("      Archivo " + entidadMayusculaInicial
                                + "Controller.java con Ids creado satisfactoriamente.");
                  

                 

                } catch (IOException e) {
                    // exception handling left as an exercise for the reader
                }
            }
        }


       
}
