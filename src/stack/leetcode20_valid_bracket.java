//不使用map，直接比较
public boolean isValid(String s){
    Stack<Character> stack = new Stack<>();
    char[] charArray = s.toCharArray();

    for(char ch : charArray){
        if(ch == '(' || ch == '{' || ch == '['){
            stack.push(ch);
        }else{
            if(!stack.isEmpty()){
                if(ch == ')'){
                    if(stack.pop() != '(')
                        return false;
                }else if(ch == '}'){
                    if(stack.pop() != '{')
                        return false;
                }else{
                    if(stack.pop() != '[')
                        return false;
                }
            }
            else{
                return false;
            }
        }
    }
    return stack.isEmpty();
}