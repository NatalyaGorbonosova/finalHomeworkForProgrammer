package Presenter;

import Model.AnimalNursery;
import View.View;
public class Presenter {
    private View view;
    private AnimalNursery animalNursery;

    public Presenter(View view, AnimalNursery animalNursery){
        this.view = view;
        this.animalNursery = animalNursery;
    }
    public void showAll(){
        String info = animalNursery.showAll();
        view.ptint(info);
    }
    public void showCommands(int id){
        String info = animalNursery.showCommands(id);
        view.ptint(info);
    }
    public void addAnimal(String typeOfAnimal, String name, String dateBirthStr){
        animalNursery.addAnimal(typeOfAnimal, name, dateBirthStr);
    }
    public void addCommand(int idCommand, int id){
        if (animalNursery.addCommand(idCommand, id)) view.ptint("Команда добавлена");
        else view.ptint("Ошибка ввода");
    }

}
