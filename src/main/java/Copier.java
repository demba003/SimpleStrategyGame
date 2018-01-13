import java.io.*;

public class Copier {
    public static Object copy(Object object){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            oos.flush();
            oos.close();
            bos.close();
            byte[] byteData = bos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
            return new ObjectInputStream(bais).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
