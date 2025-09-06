class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for (String str : tokens) {
            if (str.equals("+")) {
                st.push(st.pop()+st.pop());
            } else if (str.equals("-")) {
                int a = st.pop(), b = st.pop();
                st.push(b-a);
            } else if (str.equals("*")) {
                st.push(st.pop()*st.pop());
            } else if (str.equals("/")) {
                int a = st.pop(), b = st.pop();
                st.push(b/a);
            } else {
                st.push(Integer.parseInt(str));
            }
        }

        return st.pop();
    }
}