package hexgameoflife;

import java.awt.*;

/**
 *
 * @author Wiktoria Kalata 20057
 */
public class HexMath
{
    /**
    * Constants and global variables for HexMath calculations.
    */
    private static int BORDERS=50;  //default number of pixels for the border.
    private static int s=0;	// length of one sid
    private static int t=0;	// short side of 30o triangle outside of each hex
    private static int r=0;	// radius of inscribed circle
    private static int h=0;	// height
    
    /**
    * Sets the borders for HexMath calculations.
    *
    * @param b The border value to be set.
    */
    public static void setBorders(int b){
        BORDERS=b;
    }
    
    /**
    * Sets the side length for HexMath calculations.  It calculates all other needed constants.
    *
    * @param side The side length to be set. 
    */
    public static void setSide(int side) {
        s=side;
        t =  (int) (s / 2);			
        r =  (int) (s * 0.8660254037844);	
        h=2*r;
    }
    
    /**
    * Sets the height for HexMath calculations. It calculates all other needed constants.
    *
    * @param height The height to be set. 
    */
    public static void setHeight(int height) {
        h = height;			
        r = h/2;			
        s = (int) (h / 1.73205);	
        t = (int) (r / 1.73205);	
    }

    /**
    * This function takes two points that describe a hexagon
    * and calculates all six of the points in the hexagon.
    *
    * @param x0 The x-coordinate of the hexagon.
    * @param y0 The y-coordinate of the hexagon.
    * @return The hexagon polygon.
    */
    public static Polygon hex (int x0, int y0) {

        int y = y0 + BORDERS;
        int x = x0 + BORDERS; 
        int[] cx,cy;

        cx = new int[] {x,x+s,x+s+t,x+s,x,x-t};
        cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};
        return new Polygon(cx,cy,6);
    }

    /**
    * his function draws a hexagon based on the initial point (x,y).
    * The hexagon is drawn in the colour.
    *
    * @param i The x-coordinate of the hexagon.
    * @param j The y-coordinate of the hexagon.
    * @param g2 The graphics context.
    */
    public static void drawHex(int i, int j, Graphics2D g2) {
        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;
        Polygon poly = hex(x,y);
        g2.setColor(Hexboard.COLOURCELL);
        g2.fillPolygon(poly);
        g2.setColor(Hexboard.COLOURGRID);
        g2.drawPolygon(poly);
    }

    /**
    * Fills a hexagon with a color based on the given state.
    *
    * @param i The x-coordinate of the hexagon.
    * @param j The y-coordinate of the hexagon.
    * @param n The state of the hexagon.
    * @param g2 The graphics context.
    */
    public static void fillHex(int i, int j, int n, Graphics2D g2) {
       
        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;
        if (n == 0) {
            g2.setColor(Hexboard.DEFAULTCOLOUR);
            g2.fillPolygon(hex(x,y));

        }
        if (n == 1) {
            g2.setColor(Hexboard.ALIVECOLOUR);
            g2.fillPolygon(hex(x,y));
        }
        
        if (n == 2) {
            g2.setColor(Hexboard.BORNCOLOUR);
            g2.fillPolygon(hex(x,y));
        }
        if (n == -1) {
            g2.setColor(Hexboard.DEADCOLOUR);
            g2.fillPolygon(hex(x,y));
        }
        
    }

    /**
    * Converts pixel coordinates to hexagon coordinates.
    *
    * @param mx The x-coordinate in pixels.
    * @param my The y-coordinate in pixels.
    * @return A Point object containing the hexagon coordinates of the clicked point.
    * If the clicked point is not within a valid hexagon (e.g., on the board borders), the method returns (-1, -1).
    */
    public static Point pxtoHex(int mx, int my) {
        Point p = new Point(-1,-1);

        mx -= BORDERS;
        my -= BORDERS;
        mx += t;
        int x = (int) (mx / (s+t)); 
        int y = (int) ((my - (x%2)*r)/h); 

        int dx = mx - x*(s+t);
        int dy = my - y*h;

        if (my - (x%2)*r < 0) return p; 

        if (x%2==0) {
            if (dy > r) {	
                if (dx * r /t < dy - r) {
                    x--;
                }
            }
            if (dy < r) {	
                if ((t - dx)*r/t > dy ) {
                    x--;
                    y--;
                }
            }
        } else {  
            if (dy > h) {	
                if (dx * r/t < dy - h) {
                    x--;
                    y++;
                }
            }
                if (dy < h) {	
                    if ((t - dx)*r/t > dy - r) {
                        x--;
                    }
                }
        }
        p.x=x;
        p.y=y;
        return p;
    }
}