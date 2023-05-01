package ttt.tictactoe;

import java.util.List;

public class LineN {
    private final List<SquareN> squareNS;
    private final byte lineType;

    public byte getLineType() {
        return lineType;
    }

    public List<SquareN> getSquares() {
        return squareNS;
    }

    public LineN(List<SquareN> squareNS, byte lineType) {
        this.squareNS = squareNS;
        this.lineType = lineType;
    }

    public boolean checkWin() {
        return squareNS.get(0).getType() == squareNS.get(1).getType() && squareNS.get(1).getType() == squareNS.get(2).getType();
    }
}
