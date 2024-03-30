package main;

import object.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }
    public void setObject(){
        gp.obj[0] =new OBJ_Key();
        gp.obj[0].worldX= 8 * gp.tileSize;
        gp.obj[0].worldY= 7 * gp.tileSize;

        gp.obj[1] =new OBJ_hut();
        gp.obj[1].worldX= 1 * gp.tileSize;
        gp.obj[1].worldY= 6 * gp.tileSize;

        gp.obj[2] =new OBJ_hut();
        gp.obj[2].worldX= 12 * gp.tileSize;
        gp.obj[2].worldY= 6 * gp.tileSize;

        gp.obj[3] =new OBJ_Castle();
        gp.obj[3].worldX= 6 * gp.tileSize;
        gp.obj[3].worldY= 6 * gp.tileSize;

        gp.obj[4] =new OBJ_market();
        gp.obj[4].worldX= 3 * gp.tileSize;
        gp.obj[4].worldY= 3 * gp.tileSize;

        gp.obj[5] =new OBJ_market();
        gp.obj[5].worldX= 6 * gp.tileSize;
        gp.obj[5].worldY= 3 * gp.tileSize;

        gp.obj[6] =new OBJ_m2();
        gp.obj[6].worldX= 9 * gp.tileSize;
        gp.obj[6].worldY= 8 * gp.tileSize;

        gp.obj[7] =new OBJ_m2();
        gp.obj[7].worldX= 5 * gp.tileSize;
        gp.obj[7].worldY= 10 * gp.tileSize;

        gp.obj[8] =new OBJ_market();
        gp.obj[8].worldX= 10 * gp.tileSize;
        gp.obj[8].worldY= 3 * gp.tileSize;

        gp.obj[9] =new OBJ_Trap();
        gp.obj[9].worldX= 8 * gp.tileSize;
        gp.obj[9].worldY= 10 * gp.tileSize;

        gp.obj[10] =new OBJ_Trap();
        gp.obj[10].worldX= 5 * gp.tileSize;
        gp.obj[10].worldY= 3 * gp.tileSize;

        gp.obj[11] =new OBJ_Trap();
        gp.obj[11].worldX= 3 * gp.tileSize;
        gp.obj[11].worldY= 10 * gp.tileSize;

        gp.obj[12] =new OBJ_chest();
        gp.obj[12].worldX= 10 * gp.tileSize;
        gp.obj[12].worldY= 10 * gp.tileSize;

        gp.obj[13] =new OBJ_Key();
        gp.obj[13].worldX= 7 * gp.tileSize;
        gp.obj[13].worldY= 9 * gp.tileSize;

        gp.obj[14] =new OBJ_Key();
        gp.obj[14].worldX= 4 * gp.tileSize;
        gp.obj[14].worldY= 7 * gp.tileSize;

        gp.obj[15] =new OBJ_Key();
        gp.obj[15].worldX= 4 * gp.tileSize;
        gp.obj[15].worldY= 9 * gp.tileSize;










    }
}
