import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Animal {
    int idAnimal=0;
    String nameAnimal="";
    String typeAnimal="";
    Date dateOfBirth=null;
    String usingAnimal=null;
    ArrayList<Commands> animalCommands;

    public Animal addAnimal(Animal newAnimal) {
        DbManager dBM = new DbManager();
        Animal animal = dBM.addAnimalToDB(newAnimal);
        return animal;
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
