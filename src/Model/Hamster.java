package Model;

import java.util.Date;

public class Hamster extends Pet{
    public Hamster(String name, Date dateBirth) {
        super(name, dateBirth);
    }
    public Hamster(int id, String name, Date dateBirth){
        super(id, name, dateBirth);
    }
}
