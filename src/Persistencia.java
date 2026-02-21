import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Persistencia {
    public static void guardar(String archivo, Portafolio p) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(p);
            System.out.println("Portafolio guardado en: " + archivo);
        } catch (Exception e) {
            System.out.println("Error guardando: " + e.getMessage());
        }
    }
}
