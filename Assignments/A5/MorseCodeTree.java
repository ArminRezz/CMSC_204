import java.util.ArrayList;

public class MorseCodeTree {
    
    private TreeNode<String> root;
    
    MorseCodeTree() {
        buildTree();
    }
    
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 0) {
            root.setData(letter);
            return;
        }
        
        char first = code.charAt(0);
        String rest = code.substring(1);
        
        if (first == '.') {
            if (root.getLeft() == null) {
                root.setLeft(new TreeNode<>(null));
            }
            addNode(root.getLeft(), rest, letter);
        } else {
            if (root.getRight() == null) {
                root.setRight(new TreeNode<>(null));
            }
            addNode(root.getRight(), rest, letter);
        }
    }
    
    public void buildTree() {
    	root = new TreeNode<>(""); // root node with empty string data
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int i = 0; i < codes.length; i++) {
            addNode(root, codes[i], letters[i]);
        }
    }
    
    public String fetch(String code) {
        return fetchNode(root, code);
    }
    
    public String fetchNode(TreeNode<String> root, String code) {
        if (root == null) {
            return "";
        }
        if (code.length() == 0) {
            return root.getData();
        }
        
        char first = code.charAt(0);
        String rest = code.substring(1);
        
        if (first == '.') {
            return fetchNode(root.getLeft(), rest);
        } else {
            return fetchNode(root.getRight(), rest);
        }
    }
    
    public TreeNode<String> getRoot() {
        return root;
    }
    
    public void insert(String code, String letter) {
        addNode(root, code, letter);
    }
    
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root != null) {
            LNRoutputTraversal(root.getLeft(), list);
            list.add(root.getData());
            LNRoutputTraversal(root.getRight(), list);
        }
    }
    
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }
    
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }
}
