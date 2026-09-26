class Solution {
    public boolean isValid(String s) {
        Stack<Character> opens = new Stack<>();
        for (char ch : s.toCharArray())
            switch (ch) {
                case '(', '[', '{' -> opens.push(ch);
                default -> {
                    if (opens.empty())
                        return false;
                    char top = opens.pop();
                    char req = switch (ch) {
                        case ')' -> '(';
                        case ']' -> '[';
                        case '}' -> '{';
                        default -> ' ';
                    };

                    if (top != req)
                        return false;
                }
            };

        return opens.empty();
    }
}
