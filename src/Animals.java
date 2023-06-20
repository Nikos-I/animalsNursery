import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Animals{
      ArrayList<Animal> animals = new ArrayList<>();
      ArrayList<String> commands = new ArrayList<>();

      void listAnimals(int idAni) throws SQLException, IOException {
            DbManager dBM = new DbManager();
            animals = dBM.listAnimalsFromDB(idAni);
            animals.forEach(s -> System.out.print(s.strAnimal() + "\n"));
//            System.out.println("\n");
            if (idAni >= 0) {
                  System.out.println("Доступные команды для животного:");
                  listCommands(idAni);
//                  System.out.println("\n");
            }
      }

      void listCommands(int idAni) throws SQLException, IOException {
            DbManager dBM = new DbManager();
            commands = dBM.listCommandFromDB(idAni);
            commands.forEach(s -> System.out.print(s + "\n"));
            System.out.println("\n");
      }

      void prnAnimals(){
            animals.forEach(s -> System.out.print(s.strAnimal() + "\n"));
            System.out.println("\n");
      }
      @Override
      public String toString() {

            return super.toString();
      }
}

