import java.util.Scanner;

public class Core {
    private static Core instance;
    private Scanner input;

    private Core() {
        input = new Scanner(System.in, "Cp866");
    }

    public static Core getInstance() {
        if (instance == null) {
            instance = new Core();
        }

        return instance;
    }

    public static int getInt(String message) {
        if(message != null){
            System.out.println(message);
        }

        while(true)
        {
            try{
                return Integer.parseInt(Core.getInstance().input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверное значение, попробуйте снова");
            }
        }
    }

    public static String getString(String message) {
        if(message != null){
            System.out.println(message);
        }

        return Core.getInstance().input.nextLine();
    }

    public static boolean getBoolean(String message) {
        if(message != null){
            System.out.println(message);
        }

        while(true)
        {
            try{
                return Boolean.parseBoolean(Core.getInstance().input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверное значение, попробуйте снова");
            }
        }
    }

    public static Scanner getScanner() {
        return Core.getInstance().input;
    }

    public static void dispHelp(){
        System.out.println("1. Добавить животное в питомник");
        System.out.println("2. Удалить животное из питомника");
        System.out.println("3. Просмотреть информацию о конкретном животном");
//            System.out.println("4. Заставить конкретное животное издать звук");
        System.out.println("5. Просмотреть информацию о всех животных в питомнике");
        System.out.println("6. Управлять классификаторами животных");
        System.out.println("7. Получить справку о меню");
//            System.out.println("7. Выйти");
        System.out.println("8. Выйти");

    }
}
