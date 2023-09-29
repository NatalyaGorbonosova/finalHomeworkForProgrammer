package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Animal {
    private int id;
    private String name;
    private ArrayList<Command> commands;
    private Date dateBirth;

    protected Animal(String name, Date dateBirth){
        this.name = name;
        this.dateBirth = dateBirth;
        this.commands = new ArrayList<Command>();
    }
    protected Animal(int id, String name, Date dateBirth){
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.commands = new ArrayList<Command>();
    }
    public String toString(){
        StringBuilder info = new StringBuilder();

        info.append(this.name);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        info.append(" ");
        info.append(simpleDateFormat.format(this.dateBirth));
        return info.toString();
    }

    protected void setName(String name) {
        this.name = name;
    }
    protected String getName() {
        return name;
    }

    protected void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    protected Date getDateBirth() {
        return dateBirth;
    }
    protected void addCommands(Command command){
        this.commands.add(command);
    }
    protected int getId(){return this.id;}
    protected ArrayList<Command> getCommands(){return this.commands;}
    protected String commandsToString(){
        StringBuilder commands = new StringBuilder();
        if(getCommands().isEmpty()){
            commands.append(" - ");
        } else {
            for (Command command: getCommands()
            ) {
                commands.append(command.toString() + " ");
            }
        }
        return  commands.toString();
    }
}
