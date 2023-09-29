import Model.AnimalNursery;
import View.ConsoleUI;
import Presenter.Presenter;
import View.View;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        AnimalNursery animalNursery = new AnimalNursery();
        animalNursery.addAnimal("Dog", "July", "21/04/2021");
        Presenter presenter = new Presenter(view, animalNursery);

        view.start();


    }
}