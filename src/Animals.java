import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Animals {
    ArrayList<Animal> animals=new ArrayList<>();
    ArrayList<String> commands=new ArrayList<>();

    void addAnimals() throws SQLException, IOException {

        Animal newAnimal = new Animal();
        TypeAnimals types = new TypeAnimals();

        String name = Core.getString("Имя животного:");
        String dBirthDay = Core.getString("День рождения животного:");
        System.out.println("\n");
        types.listTypeAnimals();
        int id=Core.getInt("Введите id вида животного: ");
        newAnimal.addAnimal(name, dBirthDay, id);
    }

    void listAnimals(int idAni) throws SQLException, IOException {
        DbManager dBM=new DbManager();
        animals=dBM.listAnimalsFromDB(idAni);
        animals.forEach(s -> System.out.print(s.strAnimal() + "\n"));
        if (idAni >= 0) {
            System.out.println("Доступные команды для животного:");
            listCommands(idAni);
        }
        System.out.println("\n");
    }

    void listCommands(int idAni) throws SQLException, IOException {
        DbManager dBM=new DbManager();
        commands=dBM.listCommandFromDB(idAni);
        commands.forEach(s -> System.out.print(s + "\n"));
    }

}

