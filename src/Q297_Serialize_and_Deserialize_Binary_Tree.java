import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Q297_Serialize_and_Deserialize_Binary_Tree {
	// by ninechapter
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        StringBuffer serial = new StringBuffer();
        int lastPos = 0;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node != null){
                serial.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
                lastPos = serial.length() - 2;
            } else {
                serial.append("#,");
            }
        }
        
        return serial.substring(0, lastPos + 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data == null || data.equals("")){
            return null;
        }
        
        String[] array = data.split(",");
        int n = array.length;
        if(array[0].equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int index = 0;
        boolean isLeftChild = true;
        
        for(int i = 1; i < n; ++i){
            if(!array[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(array[i]));
                if(isLeftChild == true){
                    list.get(index).left = node;
                } else{
                    list.get(index).right = node;
                }
                list.add(node);    // 注意，不能漏掉这一步！！！
            }
            if(isLeftChild == false){
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        
        return root;
    }
}
