package hexgameoflife;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
/**
 *
 * @author Wiktoria Kalata 20057
 */
public class Hexboard {

    /**
    * Constructs a Hexboard object.
    *
    * @param gui The GUI object associated with the Hexboard.
    */
    Hexboard(GUI gui, int bsize) {
        this.gui = gui;
        BSIZE = bsize;
        SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; 
        board = new int[BSIZE][BSIZE];
        initGame();
        createAndShowGUI();
    }

    final static Color COLOURCELL =  Color.WHITE;	 
    final static Color COLOURGRID =  Color.BLACK;	 
    final static Color DEFAULTCOLOUR = new Color(226,211,243,200);
    final static Color ALIVECOLOUR = new Color(1,61,196,200);
    final static Color DEADCOLOUR = new Color(128,128,128,200);
    final static Color BORNCOLOUR = new Color(173,69,250,200);
    
    final static int EMPTY = 0;
    public int BSIZE; //board size.
    final static int HEXSIZE = 30; //hex size in pixels
    final static int BORDERS = 15;  
    static int SCRSIZE; //panel size.
    private final GUI gui;
    int[][] board;

    public int[][] getBoard()
    {
        return board;
    }

    public void setBoard(int[][] newBoard)
    {
        board = newBoard;
        SwingUtilities.windowForComponent(gui.getbutton()).repaint();
    }
    
    /**
    * Initializes the game board by setting all cells to EMPTY.
    */
    void initGame(){
        HexMath.setHeight(HEXSIZE);
        HexMath.setBorders(BORDERS);

        for (int i=0;i<BSIZE;i++) 
        {
            for (int j=0;j<BSIZE;j++) {
                board[i][j]=EMPTY;
            }
        }
    }

    /**
    * Creates and shows the GUI for the Hexboard.
    */
    public void createAndShowGUI()
    {
        DrawingPanel panel = new DrawingPanel();
       
        panel.setSize( (int)(SCRSIZE/1.23), SCRSIZE);
        gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        gui.getContentPane().setLayout(new BorderLayout());
        gui.getContentPane().add(panel, BorderLayout.CENTER);
    }

    /**
    * A nested class representing the drawing panel for the Hexboard.
    */
    class DrawingPanel extends JPanel
    {		
        public DrawingPanel()
        {	
            setBackground(Color.WHITE);
            MyMouseListener ml = new MyMouseListener();            
            addMouseListener(ml);
        }

        @Override
        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            super.paintComponent(g2);
            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    HexMath.drawHex(i,j,g2);
                    HexMath.fillHex(i,j,board[i][j],g2);
                }
            }
        }

        /**
        * A nested class representing a mouse listener for the Hexboard.
        */
        class MyMouseListener extends MouseAdapter	
        { 
            @Override
            public void mouseClicked(MouseEvent e) 
            {  
                Point p = new Point( HexMath.pxtoHex(e.getX(),e.getY()) );
                if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return;

                if (board[p.x][p.y] == EMPTY)  board[p.x][p.y] = 1; else board[p.x][p.y] = EMPTY;
                SwingUtilities.windowForComponent(gui.getbutton()).repaint();
            }	
        } 
    } 
}


