// 超时了，主要问题是建立的图里面会出现同一层的指向，考了优化buildGraph方法

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> rtn = new ArrayList<List<String>>();
        List<String> inList = new ArrayList<String>();
        if (dict.contains(start)) {
            dict.remove(start);
        }
        if (dict.contains(end)) {
            dict.remove(end);
        }
        if (similarity(start, end) == 1) {
            inList.add(start);
            inList.add(end);
            rtn.add(inList);
            return rtn;
        }
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        buildGraph(map, dict, start, end);
        if (map.size() == 0) {
            return rtn;
        }
        inList.add(start);
        dfs(rtn, inList, start, end, start, map);
        return filterOutLongList(rtn);
    }

    public static void buildGraph(HashMap<String, HashSet<String>> map, Set<String> dict, String start, String end) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(end);
        while (queue.size() != 0) {
            String currentNode = queue.poll();
            for (String elem : dict) {
                if (similarity(elem, currentNode) == 1) {
                    if (!map.containsKey(elem)) {
                        map.put(elem, new HashSet<String>(Arrays.asList(currentNode)));
                    } else {
                        map.get(elem).add(currentNode);
                    }
                    queue.add(elem);
                }
            }
            dict.remove(currentNode);
        }
        Set<String> keySet = map.keySet();
        HashSet<String> inSet = new HashSet<String>();
        for (String elem : keySet) {
            if (similarity(elem, start) == 1) {
                inSet.add(elem);
            }
        }
        if (inSet.size() != 0) {
            map.put(start, inSet);
        }
    }

    public static void dfs(List<List<String>> rtn, List<String> inList, String start, String end, String key,
            HashMap<String, HashSet<String>> map) {
        if (key == end) {
            rtn.add(new ArrayList<String>(inList));
            return;
        }
        HashSet<String> values = map.get(key);
        for (String value : values) {
            inList.add(value);
            dfs(rtn, inList, start, end, value, map);
            inList.remove(inList.size() - 1);
        }
    }

    public static List<List<String>> filterOutLongList(List<List<String>> rtn) {
        int min = Integer.MAX_VALUE;
        List<List<String>> newRtn = new ArrayList<List<String>>();
        for (List<String> list : rtn) {
            if (list.size() <= min) {
                min = list.size();
            }
        }
        for (List<String> list : rtn) {
            if (list.size() == min) {
                newRtn.add(list);
            }
        }
        return newRtn;
    }

    public static int similarity(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        int rtn = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                rtn++;
            }
        }
        return rtn;
    }
}