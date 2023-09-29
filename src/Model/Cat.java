package Model;

import java.util.Date;

public class Cat extends Pet{
    public Cat(String name, Date dateBirth) {
        super(name, dateBirth);
    }
    public Cat(int id, String name, Date dateBirth) {
        super(id, name, dateBirth);
    }
}
