import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Animals nursery = new Animals();
        TypeAnimals type = new TypeAnimals();

        while(true) {
            Core.dispHelp();

            int choice = Core.getInt("Выбор: ");
            switch (choice) {
                case 3:
                    int choiceA = Core.getInt("id животного: ");
                    nursery.listAnimals(choiceA);
                    break;
                case 4:
                    nursery.listAnimals(-1);
                    break;
                case 5:
                    nursery.listAnimals(-2);
                    break;
                case 7:
                    Core.dispHelp();
                    break;
                case 8:
                    System.exit(0);
                    break;
                case 9:

                    type.listTypeAnimals();
                    break;

                default: System.out.println("Некорректный ввод, попробуйте снова");
            }
        }
    }
}
