class Solution {
    public String simplifyPath(String path) {
        
        String[] strs = path.split("/");
        Deque<String> st = new ArrayDeque<>();
        String answer = "";

        for (String str : strs) {

            if (str.equals(".") || str.equals("")) {
                continue;
            } else if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(str);
            }

        }

        if (st.isEmpty()) {
            return "/";
        }

        while (!st.isEmpty()) {
            String value = st.pop();
            answer = "/" + value + answer;
            
        }

        return answer;
    }
}