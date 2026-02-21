import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PersistenciaLectura {

    public static Portafolio leer(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Portafolio p = (Portafolio) ois.readObject();
            System.out.println("Portafolio leído desde: " + archivo);
            return p;
        } catch (Exception e) {
            System.out.println("Error leyendo: " + e.getMessage());
            return null;
        }
    }
}
