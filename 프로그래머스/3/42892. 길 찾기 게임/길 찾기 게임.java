import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        List<Node> tree = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++) {
            tree.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        Collections.sort(tree);
        
        Node root = tree.get(0);
        BinaryTree binaryTree = new BinaryTree(root);
        for(int i=1; i<nodeinfo.length; i++) {
            binaryTree.insert(root, tree.get(i));
        }
        
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();
        
        binaryTree.preorder(binaryTree.root, preorderList);
        binaryTree.postorder(binaryTree.root, postorderList);
        
        for(int i=0; i<nodeinfo.length; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }
        
        return answer;
    }
    
    static class BinaryTree {
        Node root;
        
        BinaryTree(Node root) {
            this.root = root;
        }
        
        void insert(Node parent, Node child) {
            if(child.x < parent.x) {
                if(parent.left == null) 
                    parent.left = child;
                else 
                    insert(parent.left, child);
            } else {
                if(parent.right == null)
                    parent.right = child;
                else 
                    insert(parent.right, child);
            }
        }
        
        // 전위순회 
        void preorder(Node node, List<Integer> result) {
            if(node == null) return;
            result.add(node.num);
            preorder(node.left, result);
            preorder(node.right, result);
        }
        
        // 후위순회 
        void postorder(Node node, List<Integer> result) {
            if(node == null) return;
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.num);
        }
    }
    
    static class Node implements Comparable<Node> {
        int num;
        int x;
        int y;
        Node left;
        Node right;
        
        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
        // y 내림차순, x 오름차순
        @Override
        public int compareTo(Node o) {
            if(o.y == this.y) return this.x - o.x;
            return o.y - this.y;
        }
    }
}