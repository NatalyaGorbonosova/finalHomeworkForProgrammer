package Model;

import java.util.Date;

public class Donkey extends PackAnimal{
    public Donkey(String name, Date dateBirth) {
        super(name, dateBirth);
    }
    public Donkey(int id, String name, Date dateBirth) {
        super(id, name, dateBirth);
    }
}
