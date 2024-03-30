package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_m2 extends  SuperObject {
    public OBJ_m2() {
        name = "market";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/market2.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
