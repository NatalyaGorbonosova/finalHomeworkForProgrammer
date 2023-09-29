package Model;

import java.util.Date;

public abstract class PackAnimal extends Animal{
    protected PackAnimal(String name, Date dateBirth) {
        super(name, dateBirth);
    }
    protected PackAnimal(int id, String name, Date dateBirth){super(id, name, dateBirth);}
}
