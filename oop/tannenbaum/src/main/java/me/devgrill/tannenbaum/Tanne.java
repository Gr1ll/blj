package me.devgrill.tannenbaum;

public class Tanne {
    public String Tree = "";
    public int heightOfTrunk = 0;
    public int widthOfTrunk = 0;
    private int heightOfTree = 0;

    public Tanne(int heightOfTrunk, int widthOfTrunk, int heightOfTree) {
        this.heightOfTrunk = heightOfTrunk;
        this.widthOfTrunk = widthOfTrunk;
        this.heightOfTree = heightOfTree;
    }

    public void draw() {
        Tree = "";
        drawTree();
    }

    private void drawTree() {
        for (int r = 1; r <= heightOfTree; r++) {
            for (int c = heightOfTree - r; c > 0; c--)
                Tree += (" ");
            for (int d = 1; d <= r; d++)
                Tree += "* ";
            Tree += "\n";
        }

        for (int r = heightOfTree - heightOfTrunk; r <= heightOfTree - 1; r++) {
            Tree += (" ");
            for (int c = heightOfTree - 3; c > widthOfTrunk - 2; c--)
                Tree += " ";
            for (int d = widthOfTrunk; d > 0; d--)
                Tree += "* ";
            Tree += "\n";
        }
    }

    public String getTree() {
        return Tree;
    }
}
