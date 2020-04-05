import java.util.*;

public class Solution4 {

    public static void main(String[] args) {
        String [][] snapshots = {
                {"ACCOUNT1", "100"},
                {"ACCOUNT2", "150"}
        };

        String[][] transactions = {
                                    {"1", "SAVE", "ACCOUNT2", "100"},
                                    {"2", "WITHDRAW", "ACCOUNT1", "50"},
                                    {"1", "SAVE", "ACCOUNT2", "100"},
                                    {"4", "SAVE", "ACCOUNT3", "500"},
                                    {"3", "WITHDRAW", "ACCOUNT2", "30"}
                                };



        Map<String,Integer> bankingAccount = new HashMap<>();

        for(int i = 0; i < snapshots.length; i++) {
            bankingAccount.put(snapshots[i][0],Integer.parseInt(snapshots[i][1]));
        }

        Set<String> remove = new HashSet<>();
        for(int i = 0; i < transactions.length; i++) {
            remove.add(transactions[i][0]);
        }
        remove.iterator().forEachRemaining(strings -> {
            for(int i = 0; i < transactions.length; i++) {
                if(transactions[i][0].equals(strings)) {
                    String id = transactions[i][2];
                    if(bankingAccount.containsKey(id)) {
                            Integer price = bankingAccount.get(id);
                            int result = 0;
                        if(transactions[i][1].equals("SAVE")) {
                            result = price + Integer.parseInt(transactions[i][3]);
                        }else {
                            result = price - Integer.parseInt(transactions[i][3]);
                        }
                        bankingAccount.put(id,result);
                        break;
                    } else {
                        bankingAccount.put(id,Integer.parseInt(transactions[i][3]));
                        break;
                    }
                }
            }
        });


        List<String[]> user = new ArrayList<>();

        bankingAccount.forEach((s, integer) -> {
            String[] st = {s,integer.toString()};
            user.add(st);
        });

        Collections.sort(user, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

        String[][] answer = new String[user.size()][2];
        for(int i = 0 ; i < user.size(); i++) {
            System.out.println(user.get(i));
            answer[i] = user.get(i);
        }

        for(int i = 0 ; i < user.size(); i++) {
            System.out.println(answer[i]);
        }
    }
}
