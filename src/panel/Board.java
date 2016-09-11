package panel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

/**
 *
 * @author Mati
 */
public final class Board extends JPanel {

    public Board() {
        tabColors = new Color[10];
        initTabColors();
    }

    public void initComponents(int l, int c, int nc) {
        lines = l;
        columns = c;
        ncolors = nc;
        colors = new Color[l][c];
        marked = new boolean[l][c];
        x = this.getWidth();
        y = this.getHeight();
        width = x / l;
        height = y / c;
        resetTab();
    }

    public void resetTab() {
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[0].length; j++) {
                marked[i][j] = false;
            }
        }
    }

    public void initTabColors() {
        tabColors[0] = Color.BLUE;
        tabColors[1] = Color.ORANGE;
        tabColors[2] = Color.LIGHT_GRAY;
        tabColors[3] = Color.YELLOW;
        tabColors[4] = Color.PINK;
        tabColors[5] = Color.WHITE;
        tabColors[6] = Color.GREEN;
        tabColors[7] = Color.CYAN;
        tabColors[8] = Color.MAGENTA;
        tabColors[9] = Color.DARK_GRAY;
    }

    public void addRand() {
        rand = new Random();
        colors = new Color[lines][columns];

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                colors[i][j] = tabColors[rand.nextInt(ncolors)];
            }
        }
    }

    public void addMain(Board b1, Board b2) {
        for (int i = lines - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                b1.colors[i][j] = b2.colors[j][i];
            }
        }
    }

    public int getW() {
        return width;

    }

    public int getH() {
        return height;

    }

    public void exchangePosition(int pi1, int pj1, int pi2, int pj2) {
        Color tmp;

        tmp = colors[pi1][pj1];
        colors[pi1][pj1] = colors[pi2][pj2];
        colors[pi2][pj2] = tmp;
    }

    public void setMarkedTab(int i, int j, boolean b) {
        marked[i][j] = b;
    }

    public void loadLevel(int value, String line) {
        colors = new Color[value][value];
        int tmp=0;
        int counter=2;
        
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                tmp=line.charAt(counter)-'0';
                colors[i][j] = tabColors[tmp];
                counter++;
            }
        }
    }

    public void erp() {
        rand = new Random();
        Color tmp;
        int pi1 = rand.nextInt(lines);
        int pj1 = rand.nextInt(lines);
        int pi2 = rand.nextInt(lines);
        int pj2 = rand.nextInt(lines);

        resetTab();
        tmp = colors[pi1][pj1];
        colors[pi1][pj1] = colors[pi2][pj2];
        colors[pi2][pj2] = tmp;
        setMarkedTab(pi1, pj1, true);
        setMarkedTab(pi2, pj2, true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (colors == null) {
            return;
        }

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (!marked[i][j]) {
                    g.setColor(colors[i][j]);
                    g.fillRect(j * width, i * height, width, height);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * width,
                            i * height,
                            width - 1,
                            height - 1);
                } else {
                    g.setColor(colors[i][j]);
                    g.fillRect(j * width, i * height, width, height);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * width,
                            i * height,
                            width - 1,
                            height - 1);
                    g.setColor(Color.RED);
                    g.drawRect(j * width + 1,
                            i * height + 1,
                            width - 3,
                            height - 3);
                    g.setColor(Color.RED);
                    g.drawRect(j * width + 2,
                            i * height + 2,
                            width - 5,
                            height - 5);
                }

            }

        }

    }

    public Color[][] colors;
    private final Color[] tabColors;
    private int x, y, width, height, lines, columns, ncolors;
    private boolean[][] marked;
    private Random rand;

}
