package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_market extends  SuperObject{
    public OBJ_market() {
        name = "market";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/market1.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
