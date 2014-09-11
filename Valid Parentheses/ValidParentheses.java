// 经典的栈匹配。一个栈，左符号入栈，右符号出栈。最后检查栈是否为空。

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> sk = new Stack<Character>();
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        hm.put('(', ')');
        hm.put('[', ']');
        hm.put('{', '}');
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (hm.containsKey(c)) { // left parentheses
                sk.push(c);
            } else {                 // right parentheses
                if (!sk.isEmpty() && hm.get(sk.peek()) == c) {
                    sk.pop();
                } else {
                    return false;
                }
            }
        }
        return sk.isEmpty();
    }
}