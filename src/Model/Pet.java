package Model;

import java.util.Date;

public abstract class Pet extends Animal{
    protected Pet(String name, Date dateBirth) {
        super(name, dateBirth);
    }

    public Pet(int id, String name, Date dateBirth) {
        super(id, name, dateBirth);
    }
}
