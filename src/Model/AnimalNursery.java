package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AnimalNursery {
    private ArrayList<Animal> animalNursery;
    private int nextId = 1;
    private int getNextId() {
        int id = nextId;
        nextId++;
        return id;
    }
    public AnimalNursery(){
        this.animalNursery = new ArrayList<Animal>();
    }

    public void addAnimal(String typeOfAnimal, String name, String dateBirthStr){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateBirth;
        try{
            dateBirth = df.parse(dateBirthStr);

            if(typeOfAnimal.equals("Dog")) {
                Dog animal = new Dog(getNextId(), name, dateBirth);
                this.animalNursery.add(animal);
                System.out.println("Добавлена собака");
            } else if (typeOfAnimal.equals("Cat")) {
                Cat animal = new Cat(getNextId(), name, dateBirth);
                this.animalNursery.add(animal);
                System.out.println("Добавлена кошка");
            } else if (typeOfAnimal.equals("Hamster")) {
                Hamster animal = new Hamster(getNextId(), name, dateBirth);
                this.animalNursery.add(animal);
                System.out.println("Добавлен хомяк");

            } else if (typeOfAnimal.equals("Horse")) {
                Horse animal = new Horse(getNextId(), name, dateBirth);
                this.animalNursery.add(animal);
                System.out.println("Добавлена лошадь");
            } else if (typeOfAnimal.equals("Camel")) {
                Camel animal = new Camel(getNextId(), name, dateBirth);
                this.animalNursery.add(animal);
                System.out.println("Добавлен верблюд");
            } else if (typeOfAnimal.equals("Donkey")) {
                Donkey animal = new Donkey(getNextId(), name, dateBirth);
                this.animalNursery.add(animal);
                System.out.println("Добавлен осел");
            } else {
                System.out.println("Неправильно выбран тип животного");
            }
        } catch (ParseException e){
            System.out.println("Неправильно введена дата");
        }

    }
    public String showAll(){
        StringBuilder info = new StringBuilder();
        for (Animal animal: getAnimalNursery()
             ) {
            info.append("Id: " + Integer.toString(animal.getId()));
            info.append(" имя: " + animal.getName());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            info.append(" дата рождения: " + simpleDateFormat.format(animal.getDateBirth()));
            info.append(" команды: " + animal.commandsToString());

            info.append("\n");
        }
        return  info.toString();
    }
    public String showCommands(int id){
        StringBuilder info = new StringBuilder();
        for (Animal animal: this.animalNursery
             ) {
            if (animal.getId() == id){
                info.append("команды:" + animal.commandsToString());
            }
        }
        if(info.isEmpty()) {info.append("Такого животного нет");}
        return info.toString();
    }
    public boolean addCommand(int idCommand, int id){

        for (Animal animal: getAnimalNursery()
             ) {
            if(id == animal.getId()){
                Command com;
                switch (idCommand){
                    case 1:
                        com = Command.GO;
                        animal.getCommands().add(com);
                        return true;

                    case 2:
                        com = Command.STOP;
                        animal.getCommands().add(com);
                        return true;

                    case 3:
                        com = Command.RUN_AWAY;
                        animal.getCommands().add(com);
                        return true;

                    case 4:
                        com = Command.COME_UP;
                        animal.getCommands().add(com);
                        return true;

                    case 5:
                        com = Command.LIE;
                        animal.getCommands().add(com);
                        return true;

                    case 6:
                        com = Command.JUMP;
                        animal.getCommands().add(com);
                        return true;

                    case 7:
                        com = Command.TRUP;
                        animal.getCommands().add(com);
                        return true;

                    case 8:
                        com = Command.STAND_UP;
                        animal.getCommands().add(com);
                        return true;

                    default:
                        System.out.println("Ошибка ввода");
                        return  false;
                }

        }
    }
        return false;

    }
    public ArrayList<Animal> getAnimalNursery(){
        return  this.animalNursery;
    }
}
