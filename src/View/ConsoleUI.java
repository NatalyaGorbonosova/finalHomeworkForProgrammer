package View;
import Presenter.Presenter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void ptint(String info) {
        System.out.println(info);
    }

    @Override
    public  void start(){
        work = true;
        while (work == true) {
            System.out.println("Выберите действие: \n" +
                    "1. Показать всех животных;\n" +
                    "2. Показать команды животного по его id;\n" +
                    "3. Добавить животного; \n" +
                    "4. Добавить команду для животного; \n" +
                    "5. Выход.");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showAll();
                    break;
                case "2":
                    showCommands();
                    break;
                case "3":
                    addAnimal();
                    break;
                case "4":
                    addCommand();
                    break;
                case "5":
                    exit();
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }
    private void showAll(){
        presenter.showAll();
    }
    private void showCommands(){
        System.out.println("Введите id животного: ");
        try{
            int id = Integer.parseInt(scanner.nextLine());
            presenter.showCommands(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }
    private void addAnimal(){
        System.out.println("Выберите тип животного (введите соответствующее число):\n" +
                "1. Собака 2. Кот 3. Хомяк 4. Лошадь 5. Верблюд 6. Осел");

        String type = scanner.nextLine();
        StringBuilder typeOfAnimal = new StringBuilder();
        switch (type){
            case "1":
                typeOfAnimal.append("Dog");
                break;
            case "2":
                typeOfAnimal.append("Cat");
                break;
            case "3":
                typeOfAnimal.append("Hamster");
                break;
            case "4":
                typeOfAnimal.append("Horse");
                break;
            case "5":
                typeOfAnimal.append("Camel");
                break;
            case "6":
                typeOfAnimal.append("Donkey");
                break;
            default:
                System.out.println("Ошибка ввода");
        }
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        //Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату рождения в формате dd/mm/yyyy: ");
        String dateBirthStr = scanner.nextLine();
        //sc.close();
        presenter.addAnimal(typeOfAnimal.toString(), name, dateBirthStr);

    }
    private void addCommand(){

        try{
            System.out.println("Введите индекс животного: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Выберите команду (только число)" +
                    "1. GO 2. STOP 3. RUN_AWAY 4. COME_UP 5. LIE 6. JUMP 7. TRUP 8. STAND_UP");
            int idCommand = Integer.parseInt(scanner.nextLine());
            presenter.addCommand(idCommand, id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
    private void exit(){
       scanner.close();
        work = false;
    }

}
