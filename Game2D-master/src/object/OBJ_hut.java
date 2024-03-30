package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_hut extends SuperObject{
    public OBJ_hut() {
        name = "hut";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/hut.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
