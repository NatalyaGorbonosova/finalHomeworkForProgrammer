package Model;

import java.util.Date;

public class Horse extends PackAnimal{
    public Horse(String name, Date dateBirth) {
        super(name, dateBirth);
    }
    public Horse(int id, String name, Date dateBirth) {
        super(id, name, dateBirth);
    }
}
