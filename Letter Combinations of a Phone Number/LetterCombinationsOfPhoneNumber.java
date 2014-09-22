public class Solution {
    public HashMap<Character, String[]> dict;
    public List<String> letterCombinations(String digits) {
        List<String> rtn = new ArrayList<String>();
        if (digits.trim().equals("")) {
            rtn.add("");
            return rtn;
        }
        dict = new HashMap<Character, String[]>();
        dict.put('2', new String[]{"a", "b", "c"});
        dict.put('3', new String[]{"d", "e", "f"});
        dict.put('4', new String[]{"g", "h", "i"});
        dict.put('5', new String[]{"j", "k", "l"});
        dict.put('6', new String[]{"m", "n", "o"});
        dict.put('7', new String[]{"p", "q", "r", "s"});
        dict.put('8', new String[]{"t", "u", "v"});
        dict.put('9', new String[]{"w", "x", "y", "z"});
        char[] digitsArray = digits.toCharArray();
        for (String letter : dict.get(digitsArray[0])) {
            rtn.add(letter);
        }
        for (int i = 1; i < digitsArray.length; i++) {
            combine(rtn, digitsArray[i]);
        }
        return rtn;
    }
    public void combine(List<String> rtn, char newDigit) {
        List<String> temp = new ArrayList<String>(rtn);
        rtn.clear();
        String[] newLetter = dict.get(newDigit);
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < newLetter.length; j++) {
                rtn.add(temp.get(i) + newLetter[j]);
            }
        }
    }
}