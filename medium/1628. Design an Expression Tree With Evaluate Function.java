/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
    String value;
    int calRes;
    Node left, right;
    
};

class customNode extends Node {
    customNode(String value) {
        this.value = value;
    }
    
    @Override 
    public int evaluate() {
        return calRes;
    }
    
}



/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        
        for(int i=0; i<postfix.length; i++) {
            Node node = new customNode(postfix[i]);
            if(postfix[i].charAt(0) >= '0' && postfix[i].charAt(0) <= '9') {
                node.calRes = Integer.parseInt(node.value);
                stack.push(node);
            } else {
                node.right = stack.pop();
                node.left = stack.pop();
                node.calRes = cal(node.right.calRes, node.left.calRes, node.value);
                stack.push(node);
            }
        }
        return stack.pop();
    }
    
    private int cal(int y, int x, String expression) {
        if("*".equals(expression)) return x*y;
        else if ("/".equals(expression)) return x/y;
        else if ("+".equals(expression)) return x+y;
        else return x-y;
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
