package ttt.tictactoe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameLogic {
        private final static GameLogic INSTANCE = new GameLogic();
        private final List<SquareN> squareNS;
        private final List<LineN> lineNS;
        private boolean color;
        private LineN winLineN;

    public LineN getWinLine() {
        return winLineN;
    }

    private GameLogic() {
            this.color = true;
            this.squareNS = new LinkedList<SquareN>();
            this.lineNS = new LinkedList<LineN>();
            for (int i = 0; i < 9; i++, squareNS.add(new SquareN((byte) i)));
            LinkedList<SquareN> line1 = new LinkedList<SquareN>();
            line1.add(squareNS.get(0));
            line1.add(squareNS.get(1));
            line1.add(squareNS.get(2));
            lineNS.add(new LineN(line1, (byte) 3));
            squareNS.get(0).addLine(lineNS.get(0));
            squareNS.get(1).addLine(lineNS.get(0));
            squareNS.get(2).addLine(lineNS.get(0));
            LinkedList<SquareN> line2 = new LinkedList<SquareN>();
            line2.add(squareNS.get(3));
            line2.add(squareNS.get(4));
            line2.add(squareNS.get(5));
            lineNS.add(new LineN(line2, (byte) 3));
            squareNS.get(3).addLine(lineNS.get(1));
            squareNS.get(4).addLine(lineNS.get(1));
            squareNS.get(5).addLine(lineNS.get(1));
            LinkedList<SquareN> line3 = new LinkedList<SquareN>();
            line3.add(squareNS.get(6));
            line3.add(squareNS.get(7));
            line3.add(squareNS.get(8));
            lineNS.add(new LineN(line3, (byte) 3));
            squareNS.get(6).addLine(lineNS.get(2));
            squareNS.get(7).addLine(lineNS.get(2));
            squareNS.get(8).addLine(lineNS.get(2));
            LinkedList<SquareN> line4 = new LinkedList<SquareN>();
            line4.add(squareNS.get(0));
            line4.add(squareNS.get(3));
            line4.add(squareNS.get(6));
            lineNS.add(new LineN(line4, (byte) 1));
            squareNS.get(0).addLine(lineNS.get(3));
            squareNS.get(3).addLine(lineNS.get(3));
            squareNS.get(6).addLine(lineNS.get(3));
            LinkedList<SquareN> line5 = new LinkedList<SquareN>();
            line5.add(squareNS.get(1));
            line5.add(squareNS.get(4));
            line5.add(squareNS.get(7));
            lineNS.add(new LineN(line5, (byte) 1));
            squareNS.get(1).addLine(lineNS.get(4));
            squareNS.get(4).addLine(lineNS.get(4));
            squareNS.get(7).addLine(lineNS.get(4));
            LinkedList<SquareN> line6 = new LinkedList<SquareN>();
            line6.add(squareNS.get(2));
            line6.add(squareNS.get(5));
            line6.add(squareNS.get(8));
            lineNS.add(new LineN(line6, (byte) 1));
            squareNS.get(2).addLine(lineNS.get(5));
            squareNS.get(5).addLine(lineNS.get(5));
            squareNS.get(8).addLine(lineNS.get(5));
            LinkedList<SquareN> line7 = new LinkedList<SquareN>();
            line7.add(squareNS.get(0));
            line7.add(squareNS.get(4));
            line7.add(squareNS.get(8));
            lineNS.add(new LineN(line7, (byte) 4));
            squareNS.get(0).addLine(lineNS.get(6));
            squareNS.get(4).addLine(lineNS.get(6));
            squareNS.get(8).addLine(lineNS.get(6));
            LinkedList<SquareN> line8 = new LinkedList<SquareN>();
            line8.add(squareNS.get(2));
            line8.add(squareNS.get(4));
            line8.add(squareNS.get(6));
            lineNS.add(new LineN(line8, (byte) 2));
            squareNS.get(2).addLine(lineNS.get(7));
            squareNS.get(4).addLine(lineNS.get(7));
            squareNS.get(6).addLine(lineNS.get(7));
    }

        public boolean isEmpty(byte squareID) {
            return squareNS.get(squareID - 1).getType() == 0;
        }

        public String squareClicked(byte squareID) {
            boolean win = false;
            color = !color;
            squareNS.get(squareID - 1).setType(color ? (byte) 2 : (byte) 1);
            for (LineN lineN : squareNS.get(squareID - 1).getLines()) {
                if (lineN.checkWin()) {
                    winLineN = lineN;
                    win = true;
                    break;
                }
            }
            return (color ? "Tac" : "Tic") + (win? "Toe" + (char) (winLineN.getLineType() + '0') : "");
        }

        public List<SquareN> getSquares() {
                return squareNS;
        }

        public static GameLogic getInstance() {
            return INSTANCE;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public SquareN getEmptySquare() {
            List<SquareN> squares = new ArrayList<SquareN>();
            for (SquareN squareN : squareNS) {
                if (squareN.getType() == 0) {
                    squares.add(squareN);
                }
            }
            return squares.isEmpty() ? null : squares.get((new Random()).nextInt(squares.toArray().length));
        }
}
