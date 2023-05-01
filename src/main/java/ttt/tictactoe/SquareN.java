package ttt.tictactoe;

import java.util.LinkedList;
import java.util.List;

public class SquareN {
    private byte type;
    private final List<LineN> lineNS;
    private final byte squareID;

    public byte getType() {
        return type;
    }

    public List<LineN> getLines() {
        return lineNS;
    }

    public byte getSquareID() {
        return squareID;
    }

    public SquareN(byte squareID) {
        this.squareID = squareID;
        this.type = 0;
        this.lineNS = new LinkedList<LineN>();
    }

    public void setType(byte type) {
        this.type = type;
    }

    public void addLine(LineN lineN) {
        lineNS.add(lineN);
    }
}
