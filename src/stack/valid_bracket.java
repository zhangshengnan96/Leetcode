//该题用到的数据结构：栈/哈希表
//算法原理：若遇到左括号入栈，遇到右括号时将对应栈顶左括号出栈，则遍历完所有括号后stack仍为空
// 建立哈希表 dic 构建左右括号对应关系：key左括号，value右括号；查询2个括号是否对应只需O(1)的时间复杂度；建立栈stack，遍历字符串s并按照算法流程一一判断。
//算法流程
//如果 c 是左括号，则入栈 push；
//否则通过哈希表判断括号对应关系，若 stack 栈顶出栈括号 stack.pop() 与当前遍历括号 c 不对应，则提前返回 false。

class Solution {
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    public boolean isValid(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }
}


