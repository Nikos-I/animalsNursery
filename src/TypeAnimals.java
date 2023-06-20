import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeAnimals {

    ArrayList<TypeAnimal> typeAnimals=new ArrayList<>();

    void listTypeAnimals() throws SQLException, IOException {
        DbManager dBM=new DbManager();
        typeAnimals=dBM.listTypeAnimalsFromDB();
        System.out.println("Доступные типы животных:");
        typeAnimals.forEach(s -> System.out.print(s.idTypeAnimal + " " + s.typeAnimal + "\n"));
        System.out.println("\n");
    }

}
