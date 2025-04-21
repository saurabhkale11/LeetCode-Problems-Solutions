public class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.equals("") && !component.equals(".")) {
                stack.push(component);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        if (stack.isEmpty()) {
            result.append("/");
        } else {
            for (String dir : stack) {
                result.append("/").append(dir);
            }
        }
        
        return result.toString();
    }
}
