import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


class Node {
    char Data;
    Node leftNode;
    Node rightNode;

    public Node(char data) {
        Data = data;
    }
}

class Tree {
    Node rootNode;

    public void add(char data, char leftData, char rightData) {
        if (rootNode == null) {
            rootNode = new Node(data);
            if (leftData != '.') rootNode.leftNode = new Node(leftData);
            if (rightData != '.') rootNode.rightNode = new Node(rightData);
        } else search(rootNode, data, leftData, rightData);
    }

    public void search(Node rootNode, char data, char leftData, char rightData) {
        if (rootNode == null) return;
        if (rootNode.Data == data) {
            if (leftData != '.') rootNode.leftNode = new Node(leftData);
            if (rightData != '.') rootNode.rightNode = new Node(rightData);
            return;
        }
        search(rootNode.leftNode, data, leftData, rightData);
        search(rootNode.rightNode, data, leftData, rightData);
    }
    public StringBuilder pre = new StringBuilder();
    public StringBuilder in = new StringBuilder();
    public StringBuilder post = new StringBuilder();
    public void preOrder(Node rootNode) {
        pre.append(rootNode.Data);
        if(rootNode.leftNode != null) preOrder(rootNode.leftNode);
        if(rootNode.rightNode != null) preOrder(rootNode.rightNode);
        if(rootNode.leftNode == null && rootNode.rightNode == null && pre.length() == Main.n) System.out.println(pre);
    }

    public void inOrder(Node rootNode) {
        if(rootNode.leftNode != null) inOrder(rootNode.leftNode);
        in.append(rootNode.Data);
        if(rootNode.rightNode != null) inOrder(rootNode.rightNode);
        if(rootNode.rightNode == null && in.length() == Main.n) System.out.println(in);
    }

    public void postOrder(Node rootNode) {
        if(rootNode.leftNode != null) postOrder(rootNode.leftNode);
        if(rootNode.rightNode != null) postOrder(rootNode.rightNode);
        post.append(rootNode.Data);
        if(post.length() == Main.n) System.out.println(post);
    }

}

public class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree.add(st.nextToken().charAt(0), st.nextToken().charAt(0),st.nextToken().charAt(0));
        }

        tree.preOrder(tree.rootNode);
        tree.inOrder(tree.rootNode);
        tree.postOrder(tree.rootNode);
    }
}
