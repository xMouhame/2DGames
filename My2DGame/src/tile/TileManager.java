package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {

    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;  // 2D array to hold the tile numbers for the map

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenRow][gp.maxScreenCol];  // Initialize the map to fit the screen size
        getTileImage();
        loadMap();
    }

    private void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResource("/tiles/earth.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResource("/tiles/grass.png"));
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResource("/tiles/sand.png"));
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResource("/tiles/tree.png"));
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResource("/tiles/wall.png"));
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResource("/tiles/water.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMap() {
        // Sample map data (you can change this to any desired layout)
    	int[][] map = {
    		    {4, 4, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
    		    {4, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
    		    {4, 0, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 4},
    		    {4, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 4},
    		    {4, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 4},
    		    {4, 0, 1, 1, 5, 5, 5, 5, 5, 5, 1, 1, 1, 3, 0, 4},
    		    {4, 0, 1, 1, 5, 5, 5, 5, 5, 5, 1, 1, 1, 3, 0, 4},
    		    {4, 0, 1, 1, 5, 5, 5, 5, 5, 5, 1, 1, 1, 3, 0, 4},
    		    {4, 0, 1, 1, 5, 5, 5, 5, 5, 5, 1, 1, 1, 3, 0, 4},
    		    {4, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 4},
    		    {4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
    		    {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    		};
        
        for (int row = 0; row < gp.maxScreenRow; row++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {
                mapTileNum[row][col] = map[row][col];
            }
        }
    }

    public void draw(Graphics2D g2) {
        for (int row = 0; row < gp.maxScreenRow; row++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {
                int tileNum = mapTileNum[row][col];
                int x = col * gp.tileSize;
                int y = row * gp.tileSize;
                g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            }
        }
    }
}
