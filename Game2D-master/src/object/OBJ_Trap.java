package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Trap extends SuperObject{
    public OBJ_Trap() {
        name = "Trap";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Trap.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
