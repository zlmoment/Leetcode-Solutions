// HashMap

public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        List<String> rtn = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if (hm.containsKey(temp)) {
                List<String> tempList = hm.get(temp);
                tempList.add(strs[i]);
                hm.put(temp, tempList);
            } else {
                /* two ways
                List<String>tempList = new ArrayList<String>();
                tempList.add(strs[i]);
                hm.put(temp, tempList);
                */
                hm.put(temp, new ArrayList<String>(Arrays.asList(strs[i])));
            }
        }
        for (String key : hm.keySet()) {
            if (hm.get(key).size() > 1) {
                rtn.addAll(hm.get(key));
            }
        }
        return rtn;
    }
}