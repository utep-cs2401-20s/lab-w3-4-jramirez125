public class gameOfLife {

        int width;
        int height;             //declares the three elements that gameOfLife will run
        int[][]board;

        public gameOfLife(){}

        public gameOfLife(int width, int height) {
            this.width = width;
            this.height = height;
            this.board = new int[width][height];

        }

        public void setAlive(int x, int y) { //sets the value at the specific x,y = 1 (alive)
            this.board[x][y] = 1;
         }

        public void setDead(int x, int y) {   //sets the value at the specific x,y = 0 (dead)
            this.board[x][y] = 0;
         }

        public void printBoard() { //method to fill in array
            for (int y = 0; y < height; y++) {
                String line = "|";
                for (int x = 0; x < width; x++) {
                    if (this.board[x][y] == 0) { //prints a "." for a dead spot.
                        line += ".";
                    } else {
                        line += "@";//prints a "@" for an alive spot.
                    }
                }
                line += "|";
                System.out.println(line);
            }
            System.out.println("\n");
        }

        public int neighbors(int x, int y){

            int count = 0;

            count += state(x-1,y-1);
            count += state(x,y-1);
            count += state(x+1,y-1);

            count += state(x-1,y);
            count += state(x+1,y);

            count += state(x-1,y+1);
            count += state(x,y+1);
            count += state(x+1,y+1);

            return count;
        }

        public int state(int x, int y){
            if((x < 0 || x >= width)  || (y < 0 || y >= height)) {
                return 0;
            }
            return this.board[x][y];
        }

        public void oneStep(){
            int[][] boardTwo = new int[width][height];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int aliveNeighbors = neighbors(x, y);

                    if (state(x, y) == 1) {
                        if (aliveNeighbors < 2) {
                            boardTwo[x][y] = 0;
                        } else if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                            boardTwo[x][y] = 1;
                        } else if (aliveNeighbors > 3) {
                            boardTwo[x][y] = 0;
                        }
                    } else {
                        if (aliveNeighbors == 3) {
                            boardTwo[x][y] = 1;
                        }
                    }
                }
            }
            this.board = boardTwo;
        }

        public void evolution(int a){
            for (int i = 0; i < a; i++) {
                oneStep();
                printBoard();
            }
        }

        public static void main(String[] args) {
            gameOfLife run = new gameOfLife(6,6);

            run.setAlive(1,1);
            run.setAlive(2,1);
            run.setAlive(1,2);
            run.setAlive(2,2);

            run.setAlive(3,3);
            run.setAlive(4,3);
            run.setAlive(3,4);
            run.setAlive(4,4);
                run.evolution(3);




        }
    }

