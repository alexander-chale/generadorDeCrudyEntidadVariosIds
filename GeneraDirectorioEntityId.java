import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class GeneraDirectorioEntityId {

    public void GeneraDirectorioEntityId(String directorioEntidad, String nombreEntidad, String entidadMayusculaInicial,
            Integer tipoSo, String nombreTablaValidada)
            throws SQLException, ClassNotFoundException, IOException {

        File directorioEntity = new File(directorioEntidad);

        if (true) {
            System.out.println("   Directorio " + nombreEntidad + "Id" + "/entity creado satisfactoriamente.");

            Utilitarios utilitarios = new Utilitarios();

            Properties config = new Properties();
            InputStream configInput = null;

            if (tipoSo == 0) {
                configInput = new FileInputStream("resources/config.properties");
            } else {
                configInput = new FileInputStream("C:\\config.properties");
            }

            config.load(configInput);

            String dataSourceUrl = config.getProperty("datasource.url");
            String dataSourceUsername = config.getProperty("datasource.username");
            String dataSourcePassword = config.getProperty("datasource.password");
            String schema = config.getProperty("schema");
            String paquete = config.getProperty("paquete");

            System.out.println("CREANDO EL ARCHIVO ENTIDAD... ");

            Connection conexion;
            Statement st;

            ResultSetMetaData rsmetadatos;

            Class.forName("org.postgresql.Driver");

            conexion = DriverManager.getConnection(dataSourceUrl, dataSourceUsername, dataSourcePassword);

            st = conexion.createStatement();

            System.out.println("Obteniendo Informacion sobre una base de datos...");

            System.out.println("\nObteniendo Informacion sobre una consulta con un ResultSet...");

            System.out.println("select * from " + schema + "." + nombreTablaValidada);

            ResultSet rs = st.executeQuery("select * from " + schema + "." + nombreTablaValidada);

            rsmetadatos = rs.getMetaData();

            int col = rsmetadatos.getColumnCount();

            ResultSet relaciones = st.executeQuery("SELECT k1.table_schema,\n" + //
                    "       k1.table_name,\n" + //
                    "       k1.column_name,\n" + //
                    "       k2.table_schema AS referenced_table_schema,\n" + //
                    "       k2.table_name AS referenced_table_name,\n" + //
                    "       k2.column_name AS referenced_column_name\n" + //
                    "FROM information_schema.key_column_usage k1\n" + //
                    "JOIN information_schema.referential_constraints fk USING (constraint_schema, constraint_name)\n" + //
                    "JOIN information_schema.key_column_usage k2\n" + //
                    "  ON k2.constraint_schema = fk.unique_constraint_schema\n" + //
                    " AND k2.constraint_name = fk.unique_constraint_name\n" + //
                    " AND k2.ordinal_position = k1.position_in_unique_constraint\n" + //
                    " where k1.table_name ='" + nombreTablaValidada + "';");

            String camelCaseRelacionesCampo = null;
            String camelCaseRelacionesTabla = null;

            System.out.println("Columnas: " + col);

            // File archivo = new File(nombre+"/entity");

            File fileEntity = new File(directorioEntidad);
            // utilitarios.deleteFile(fileEntity);

            // if (directorioEntity.mkdir()) {
            // System.out.println(" Directorio " + directorioEntity + " creado
            // satisfactoriamente.\n");
            // }

            if (true) {
                System.out.println("   Archivo " + fileEntity + "Id creado satisfactoriamente.\n");

                try (FileWriter fw = new FileWriter(
                        directorioEntidad + "/" + entidadMayusculaInicial + "Id.java",
                        true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw)) {

                    out.println("package " + paquete + "." + nombreEntidad + ".entity;");
                    out.println("");
                    out.println("import jakarta.persistence.Column;");
                    out.println("import jakarta.persistence.EmbeddedId;");
                    out.println("import jakarta.persistence.Entity;");
                    out.println("import jakarta.persistence.FetchType;");
                    out.println("import jakarta.persistence.JoinColumn;");
                    out.println("import jakarta.persistence.ManyToOne;");
                    out.println("import jakarta.persistence.ManyToMany;");
                    out.println("import jakarta.persistence.OneToMany;");
                    out.println("import jakarta.persistence.MapsId;");
                    out.println("import jakarta.persistence.Table;");
                    out.println("import lombok.AllArgsConstructor;");
                    out.println("import lombok.Getter;");
                    out.println("import lombok.NoArgsConstructor;");
                    out.println("import lombok.Setter;");
                    out.println("import lombok.ToString;");
                    out.println("");
                    out.println("import java.util.Set;");
                    out.println("");
                    out.println("import com.fasterxml.jackson.annotation.JsonIgnore;");
                    out.println("");
                    out.println("@Entity");
                    out.println("@Table(schema = \"" + schema + "\", name = \"" + nombreTablaValidada + "\")");
                    out.println("@Getter");
                    out.println("@Setter");
                    out.println("@NoArgsConstructor");
                    out.println("@AllArgsConstructor");
                    out.println("@ToString");
                    out.println("");
                    out.println("public class " + entidadMayusculaInicial + " {");
                    out.println("");
                    out.println("@EmbeddedId");
                    out.println("private " + entidadMayusculaInicial + "Id id;");
                    out.println("");
                    
                    /*
                    for (int i = 1; i <= col; i++) {

                        String tipoJava = utilitarios.generaTipoJava(rsmetadatos.getColumnClassName(i));

                        String nombreCamelcase = utilitarios.camelCase(rsmetadatos.getColumnName(i));

                        System.out.print("@Column");
                        if (rsmetadatos.isNullable(i) == 0 && tipoJava.equals("Date") && tipoJava.equals("Timestamp")) {
                            System.out.println("(nullable = false)");
                        }
                        if (rsmetadatos.isNullable(i) == 0
                                && (!tipoJava.equals("Date") && !tipoJava.equals("Timestamp"))) {
                            System.out.println(
                                    "(nullable = false, length = " + rsmetadatos.getColumnDisplaySize(i) + ")");
                        }
                        if (rsmetadatos.isNullable(i) == 1
                                && (!tipoJava.equals("Date") && !tipoJava.equals("Timestamp"))) {
                            System.out.println("(length = " + rsmetadatos.getColumnDisplaySize(i) + ")");

                        }
                        if (rsmetadatos.isNullable(i) == 1
                                && (tipoJava.equals("Date") && tipoJava.equals("Timestamp"))) {
                            System.out.println("\n");
                        }

                        System.out.println("private " + tipoJava + " " + nombreCamelcase + ";");

                        out.print("@Column");

                        System.out.println("");
                        if (rsmetadatos.isNullable(i) == 0 && tipoJava.equals("Date") && tipoJava.equals("Timestamp")) {
                            out.println("(nullable = false)");
                        }
                        if (rsmetadatos.isNullable(i) == 0
                                && (!tipoJava.equals("Date") && !tipoJava.equals("Timestamp"))) {
                            out.println("(nullable = false, length = " + rsmetadatos.getColumnDisplaySize(i) + ")");
                        }
                        if (rsmetadatos.isNullable(i) == 1
                                && (!tipoJava.equals("Date") && !tipoJava.equals("Timestamp"))) {
                            out.println("(length = " + rsmetadatos.getColumnDisplaySize(i) + ")");

                        }
                        if (rsmetadatos.isNullable(i) == 1
                                && (tipoJava.equals("Date") || tipoJava.equals("Timestamp"))) {
                            out.println("");
                        }

                        out.println("private " + tipoJava + " " + nombreCamelcase + ";");

                        out.println("");
                    }
                     */

                    while (relaciones.next()) {

                        camelCaseRelacionesCampo = utilitarios.camelCase(relaciones.getString(3));
                        camelCaseRelacionesTabla = utilitarios.camelCase(relaciones.getString(5));

                        System.out.println("@ManyToOne(fetch = FetchType.LAZY)");
                        System.out.println("@JoinColumn(name = " + relaciones.getString(3) + ", nullable = false)");
                        System.out
                                .println("private " + utilitarios.generaMayusculaInicial(camelCaseRelacionesTabla) + " "
                                        + camelCaseRelacionesCampo + ";");
                        System.out.println("");

                        out.println("@ManyToOne(fetch = FetchType.LAZY)");
                        out.println("@JoinColumn(name = " + relaciones.getString(3) + ", nullable = false)");
                        out.println("private " + utilitarios.generaMayusculaInicial(camelCaseRelacionesTabla) + " "
                                + camelCaseRelacionesCampo + ";");
                        out.println("");

                    }
                    out.println("}");

                } catch (IOException e) {
                    // exception handling left as an exercise for the reader
                }
            } else {
                System.out.println("no entro");
            }

        }

    }
}
