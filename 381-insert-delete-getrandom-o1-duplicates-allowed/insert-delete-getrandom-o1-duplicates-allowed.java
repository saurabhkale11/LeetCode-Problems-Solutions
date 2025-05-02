import java.util.*;

public class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val);
        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
        list.add(val);
        return notPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) return false;
        int indexToRemove = map.get(val).iterator().next();
        map.get(val).remove(indexToRemove);

        int lastElement = list.get(list.size() - 1);
        list.set(indexToRemove, lastElement);
        map.get(lastElement).add(indexToRemove);
        map.get(lastElement).remove(list.size() - 1);

        list.remove(list.size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
