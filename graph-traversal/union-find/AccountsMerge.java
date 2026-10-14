import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/** Accounts Merge (LC 721): accounts[i] = [name, email1, email2, ...]. Two accounts belong to the same person if they share ANY email.
 *  Merge them: [name, sorted unique emails]. */
public class AccountsMerge {

    private static int find(int[] p, int x) {
        while (p[x] != x) {
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }

    // Disjoint Set over ACCOUNT indices. Map each email to the first account that owned it; when an email is seen again, UNION the two
    // accounts. Finally group the emails by their account's root. O(N * K * alpha + N * K log(N * K)) for the sort
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Map<String, Integer> owner = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                if (!owner.containsKey(email)) owner.put(email, i);
                else parent[find(parent, i)] = find(parent, owner.get(email));    // the same email => the same person
            }
        }
        Map<Integer, TreeSet<String>> groups = new HashMap<>();                  // TreeSet = sorted + unique emails
        for (Map.Entry<String, Integer> e : owner.entrySet()) {
            groups.computeIfAbsent(find(parent, e.getValue()), k -> new TreeSet<>()).add(e.getKey());
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> g : groups.entrySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(g.getKey()).get(0));                         // the name
            merged.addAll(g.getValue());
            result.add(merged);
        }
        result.sort((a, b) -> a.get(1).compareTo(b.get(1)));                     // sort by first email so the output is deterministic
        return result;
    }

    static List<String> acc(String... a) { return Arrays.asList(a); }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(acc("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(acc("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(acc("Mary", "mary@mail.com"));
        accounts.add(acc("John", "johnnybravo@mail.com"));
        System.out.println(accountsMerge(accounts));
        // [[John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com], [John, johnnybravo@mail.com], [Mary, mary@mail.com]]

        List<List<String>> chain = new ArrayList<>();                                // a transitive chain: a-b, b-c, c-d => ONE person
        chain.add(acc("Ann", "a@x.com", "b@x.com"));
        chain.add(acc("Ann", "c@x.com", "d@x.com"));
        chain.add(acc("Ann", "b@x.com", "c@x.com"));
        System.out.println(accountsMerge(chain));                                    // [[Ann, a@x.com, b@x.com, c@x.com, d@x.com]]

        List<List<String>> sameNameDifferentPeople = new ArrayList<>();               // same name but no shared email => NOT merged
        sameNameDifferentPeople.add(acc("Bob", "b1@x.com"));
        sameNameDifferentPeople.add(acc("Bob", "b2@x.com"));
        System.out.println(accountsMerge(sameNameDifferentPeople));                  // [[Bob, b1@x.com], [Bob, b2@x.com]]
    }
}
