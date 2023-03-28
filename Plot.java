package property;

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot(Plot p) {
        if (p != null) {
            this.x = p.x;
            this.y = p.y;
            this.width = p.width;
            this.depth = p.depth;
        } else {
          
            this.x = 0;
            this.y = 0;
            this.width = 1;
            this.depth = 1;
        }
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String toString() {
        return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
    }

    public boolean encompasses(Plot plot) {
        if (plot.getX() >= x && plot.getY() >= y
            && plot.getX() + plot.getWidth() <= x + width
            && plot.getY() + plot.getDepth() <= y + depth) {
            return true;
        } else {
            return false;
        }
    }

    public boolean overlaps(Plot plot) {
        if (x + width <= plot.getX() || plot.getX() + plot.getWidth() <= x
            || y + depth <= plot.getY() || plot.getY() + plot.getDepth() <= y) {
            return false;
        } else {
            return true;
        }
    }
}




