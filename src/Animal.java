import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import static java.lang.String.valueOf;

public class Animal {
    int idAnimal=0;
    String nameAnimal="";
    String typeAnimal="";
    Date dateOfBirth=null;
    String usingAnimal=null;

    public void addAnimal(String name, String dateBirthDay, int idtypeAnimal) throws SQLException, IOException {
        DbManager DBman = new DbManager();
        DBman.addAnimalsToDB(name, dateBirthDay, idtypeAnimal);
    }

    public Animal editAnimal(Animal eAnimal) {
        DbManager dBM = new DbManager();
        Animal animal = dBM.editAnimalToDB(eAnimal);

        return animal;

    }
    public boolean delAnimal(int idAnimal) {
        DbManager dBM = new DbManager();
        boolean res = dBM.delAnimalToDB(idAnimal);

        return res;
    }

    String strAnimal(){
        return valueOf(idAnimal) + ", " + nameAnimal + ", " + typeAnimal + ", " + usingAnimal + ", " + dateOfBirth.toString();
    }
}
