package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;
/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static final int WIDTH = 80;
    private static final int HEIGHT = 80;
    private static final Random RANDOM = new Random(1235);

    private static class position{
        private int x;
        private  int y;

        public position(int a, int b) {
            x = a;
            y = b;
        }

    }
    // return the width of the h row for a hex of size s, h -> [0, 2s)
    public static int getWidth(int s, int h){
        if (h < s) {
            return s + 2 * h;
        }else {
            return 5 * s - 2 - 2 * h;
        }
    }
    // return the x of the first element of row h
    public static int getFirstX(position p, int h, int s){
        if (h < s){
            return p.x - h;
        } else {
            return p.x - 2 * s + 1 + h;
        }
    }

    public static void addHexagon(position p, int s, TETile[][] world, TETile pattern) {
        for (int h = 0; h < 2 * s; h += 1) {
            int x0 = getFirstX( p, h, s);
            int yh = p.y + h;

            int xmax = x0 + getWidth(s, h);
            for (int w = x0; w < xmax; w += 1) {
                world[w][yh] = pattern;
            }
        }

    }

    public static position findBottomRight(position p, int s) {
        position p2 = new position(p.x + 2 * s -1, p.y -  s );
        return p2;
    }
    public static position findTopRight(position p, int s) {
        position p2 = new position(p.x + 2 * s -1, p.y + s );
        return p2;
    }


    public static void drawNHexBottomRight(position p, int s, int N, TETile[][] world) {
        addHexagon(p, s, world, randomTile());

        for (int i = 1; i < N; i++) {
            p = findBottomRight(p, s);
            addHexagon(p, s, world, randomTile());
        }

    }


    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(6);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.FLOOR;
            case 3: return Tileset.GRASS;
            case 4: return Tileset.TREE;
            case 5: return Tileset.SAND;
            default: return Tileset.NOTHING;
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }


        position p = new position(20, 30);
        int s = 3;

        drawNHexBottomRight(p, s, 3, world );
        p = new position(p.x, p.y + 2 * s);
        drawNHexBottomRight(p, s, 4, world );
        p = new position(p.x, p.y + 2 * s);
        drawNHexBottomRight(p, s, 5, world );
        p = findTopRight(p, s);
        drawNHexBottomRight(p, s, 4, world );
        p = findTopRight(p, s);
        drawNHexBottomRight(p, s, 3, world );

//        addHexagon(p, s, world, Tileset.TREE);
//
//        p = new position(p.x - 2 * s + 1, p.y + s);

//        addHexagon(p, s, world, Tileset.FLOWER);
//
//        p = new position(p.x + 2 * s - 1, p.y + s);

//        addHexagon(p, s, world, Tileset.WALLZ);


        // fills in a block 14 tiles wide by 4 tiles tall
//        for (int h = 0; h < 2 * s; h += 1) {
//            int x0 = getFirstX( p, h, s);
//            int yh = p.y + h;
//
//            int xmax = x0 + getWidth(s, h);
//            for (int w = x0; w < xmax; w += 1) {
//                world[w][yh] = Tileset.TREE;
//            }
//        }

        // draws the world to the screen
        ter.renderFrame(world);
    }

}
