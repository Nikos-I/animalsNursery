import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Animals nursery = new Animals();

        while(true) {
            Core.dispHelp();

            int choice = Core.getInt("Выбор: ");
            switch (choice) {
                case 3:
                    int choiceA = Core.getInt("id животного: ");
                    nursery.listAnimals(choiceA);
//                    nursery.prnAnimals();
                    break;
                case 5:
                    nursery.listAnimals(-1);
//                    nursery.prnAnimals();
                    break;
                case 7:
                    Core.dispHelp();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default: System.out.println("Некорректный ввод, попробуйте снова");
            }
        }
    }
}
