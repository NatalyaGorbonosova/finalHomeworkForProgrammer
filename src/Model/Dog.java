package Model;
import java.util.Date;

public class Dog extends Pet{
    public Dog(String name, Date dateBirth){
        super(name, dateBirth);

    }

    public Dog(int id, String name, Date dateBirth) {
        super(id, name, dateBirth);
    }
}
