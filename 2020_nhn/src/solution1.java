public class solution1 {


    public static void main(String[] args) {
        solution(17, 5, new char[]{'B','D','I','M','P'},11,new int[]{3,-4,5,6,-7,-8,10,-12,-15,-20,23});
    }

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){

        Player[] playerList = new Player[numOfAllPlayers];

        for(int i = 0; i < numOfAllPlayers; i++) {
            playerList[i] = new Player((char) ((char)'A'+i),false,false, 0);
        }

        for(int i = 0; i < numOfQuickPlayers; i++) {
            Player player = playerList[namesOfQuickPlayers[i] - 65];
            player.quick = true;
        }


        playerList[0].now = true;
        playerList[0].count++;
        int start = 1;
        for(int i = 0; i < numOfGames; i++) {

            int index = 0;
            int move = 0;

            if(i == 6)
                System.out.println(i);

            if(numOfMovesPerGame[i]%(numOfAllPlayers-1) < 0) {
                move = (numOfMovesPerGame[i]%(numOfAllPlayers-1) + (numOfAllPlayers-1)) % (numOfAllPlayers-1);
            } else {
                move = numOfMovesPerGame[i]%(numOfAllPlayers-1);
            }


            if(start + move > numOfAllPlayers-1) {
                move = (start + move) - (numOfAllPlayers-1);
            } else {
                move = start+move;
            }

            if(playerList[move].quick) {
                playerList[index].count++;
                start = move;
                continue;
            }




            playerList[index].now = false;
            playerList[move].now = true;
            playerList[move].count++;

            Player temp = null;

            // swap
            temp = playerList[index];
            playerList[index] = playerList[move];
            playerList[move] = temp;



            start = move;

        }

        for(int i =0; i < numOfAllPlayers; i++) {
            System.out.println(playerList[(i+1)%numOfAllPlayers].name+" "+playerList[(i+1)%numOfAllPlayers].count);
        }
    }

    static class Player {

        char name;
        boolean quick;
        boolean now;
        int count;

        public Player(char name, boolean quick, boolean now, int count) {
            this.name = name;
            this.quick = quick;
            this.now = now;
            this.count = count;
        }
    }


}
