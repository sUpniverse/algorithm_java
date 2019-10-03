import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Player> players;
    private static final int PRE_PLAYER_NUMBER = -1;
    private static final int POST_PLAYER_NUMBER = 1;

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        players = new ArrayList<Player>();


        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            players.add(new Player(i));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i ++) {
            if(st.hasMoreTokens()) {
                String card = st.nextToken();
                if(card.equals("A")) {
                    Player player = players.get(count);
                    int nowCard = player.getCardNum();
                    player.setCardNum(++nowCard);
                    giveToFollower(player);

                } else if(card.equals("J")) {
                    Player prePlayer = players.get((count+players.size()+PRE_PLAYER_NUMBER) % players.size());
                    Player postPlayer = players.get((count+players.size()+POST_PLAYER_NUMBER) % players.size());
                    plusCardNum(prePlayer);
                    giveToFollower(prePlayer);
                    plusCardNum(postPlayer);
                    giveToFollower(postPlayer);

                } else if(card.equals("Q")) {
                    for(int i = 0; i < players.size(); i++) {
                        plusCardNum(players.get(i));
                    }

                } else if(card.equals("K")) {
                    Player player = players.get(count);
                    if(player.getFollower() != null) {
                        Player follower = players.get(Integer.parseInt(st.nextToken()));
                        player.getFollower().add(follower);
                    } else {
                        player.setFollower(new ArrayList<Player>(Integer.parseInt(st.nextToken())));
                    }
                }
            } else {
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            if(i == n-1) {
                System.out.print(players.get(i).getCardNum());
            } else {
                System.out.print(players.get(i).getCardNum()+" ");
            }
        }
    }

    public static void giveToFollower(Player player) {
        if(player.getFollower() != null) {
            List<Player> follower = player.getFollower();
            for(int i = 0; i < follower.size(); i++) {
                plusCardNum(follower.get(i));
            }
        }
    }

    public static void plusCardNum(Player player) {
        int cardNum = player.getCardNum();
        player.setCardNum(++cardNum);
    }


    public static class Player {

        private long Id;
        private int cardNum;
        private List<Player> follower;

        public Player(long id) {
            Id = id;
        }

        public long getId() {
            return Id;
        }

        public void setId(long id) {
            Id = id;
        }

        public int getCardNum() {
            return cardNum;
        }

        public void setCardNum(int cardNum) {
            this.cardNum = cardNum;
        }

        public List<Player> getFollower() {
            return follower;
        }

        public void setFollower(List<Player> follower) {
            this.follower = follower;
        }
    }
}



//    public static void main(String[] args) throws IOException {
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(inputStreamReader);
//
//
//        Map<String,Integer> cardMap = new HashMap<String, Integer>();
//
//
//        int number = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int top = 0;
//        for(int i = 0; i < number; i++) {
//            String cardName = st.nextToken();
//            if(!cardMap.containsKey(cardName)) {
//                cardMap.put(cardName,1);
//                top = Math.max(top,1);
//                continue;
//            }
//            int cardValue = cardMap.get(cardName);
//            cardMap.put(cardName,++cardValue);
//            top = Math.max(top,cardValue);
//        }
//
//        Iterator<Map.Entry<String, Integer>> iterator = cardMap.entrySet().iterator();
//        List<String> list = new ArrayList<String>();
//        while(iterator.hasNext()) {
//            Map.Entry<String, Integer> iterMap = iterator.next();
//            if(iterMap.getValue() != top) {
//                list.add(iterMap.getKey());
//            }
//        }
//
//        if(list.size() == 1) {
//            if((top - 1) == cardMap.get(list.get(0))) {
//                System.out.println("Y");
//                System.out.println(number + 1);
//                System.out.println(cardMap.size());
//            }
//        } else if(list.size() == 0) {
//            System.out.println("Y");
//            System.out.println(number);
//            System.out.println(cardMap.size());
//        } else {
//            System.out.println("N");
//            System.out.println(number);
//            System.out.println(cardMap.size());
//        }
//    }
