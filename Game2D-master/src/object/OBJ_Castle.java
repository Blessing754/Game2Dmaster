package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Castle extends SuperObject {
    public OBJ_Castle() {
        name = "Castle";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Castle.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
