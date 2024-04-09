Generador de Crud con entidades que tienen varios ids, lo que conlleva a crear dos entidades
Actualmente esta funcional pero hay cosas por hacer y mejorar

En utilitarios.java realizar metodo validaNombreTabla

En GenerarDirectorioEntity hay que hacer una validación para que no traiga los campos

 out.println("   private " + tipoJava + " " + nombreCamelcase + ";"); 

 cuando estos campos sean los mismos que las relaciones, porque el id te va a decir que estan repetidos los nombres.

 Actualmente elimino manualmentes los campos id en este archivo y que por lo general son tambien relaciones en este mismo archivo, 
 ya que estos campos estan siendo mapeados en GenerarDirectorioEntityId


 Algo por arreglar es que cuando genero un primer crud, si lo vuelvo a generar no crea todos los archivos, 
 tengo siempre que eliminar manualmente la carpeta principal completa, esto es por una limitante del borrado de archivos que tiene java

