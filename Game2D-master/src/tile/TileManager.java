package tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.GamePanel;

import javax.imageio.ImageIO;


public class TileManager {
    GamePanel gp;
     public Tile[] tile;
     public int  mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;
        tile = new Tile[50];
        mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();

    }


public void getTileImage()  {

    try {
        // road tiles
        tile [0]=new Tile ();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road00.png"));

        tile [1]=new Tile ();
        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road01.png"));

        tile [2]=new Tile ();
        tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road02.png"));

        tile [3]=new Tile ();
        tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road03.png"));

        tile [4]=new Tile ();
        tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road04.png"));

        tile [5]=new Tile ();
        tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road05.png"));

        tile [6]=new Tile ();
        tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road06.png"));

        tile [7]=new Tile ();
        tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road07.png"));

        tile [8]=new Tile ();
        tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road08.png"));

        tile [9]=new Tile ();
        tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road09.png"));

        tile [10]=new Tile ();
        tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road10.png"));

        tile [11]=new Tile ();
        tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road11.png"));

        tile [12]=new Tile ();
        tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road12.png"));

        // grass tile

        tile [13]=new Tile ();
        tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass00.png"));

        tile [14]=new Tile ();
        tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));

        // House tile

        tile [15]=new Tile ();
        tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Objects/hut1.png"));

        tile [16]=new Tile ();
        tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Objects/market2.png"));

        tile [17]=new Tile ();
        tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Objects/market1.png"));

        tile [18]=new Tile ();
        tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Objects/Castle.png"));

        // tree and object tile

        tile [19]=new Tile ();
        tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
        tile [19].collision=true;

        tile [20]=new Tile ();
        tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
        tile [20].collision=true;





    }       catch (IOException e){
        e.printStackTrace();
    }

    }

    public void loadMap ()  {

        try {
            InputStream is = getClass().getResourceAsStream("/maps/worldMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row=0;

            while (col <gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while (col<gp.maxWorldCol){
                    String numbers[] =line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;

                }
                if(col == gp.maxWorldCol){
                    col =0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {


        }

    }
    public void draw (Graphics2D g2) {

    int col = 0;
    int row = 0;
    int x = 0;
    int y = 0;

    while (col < gp.maxWorldCol && row < gp.maxWorldRow)  {




        int tileNum = mapTileNum[col][row];

        g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
        col ++;
        x += gp.tileSize;

        if(col == gp.maxWorldCol)  {
            col = 0;
            x =0;
            row ++;
            y+= gp.tileSize;
        }
    }

    }

}
