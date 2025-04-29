class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String result = "";
        String[] newPath = path.split("/");

        for (String part : newPath) {

            if (part.equals(".") || part.equals(""))
                continue;
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }

        }

        for (String part : stack) {
            result += "/";
            result += part;
        }

        if (result.length() == 0) {
            return "/";
        }
        
        return result;
    }
}