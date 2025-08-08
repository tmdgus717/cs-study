package index;

public class BinarySearchTree implements IndexInterface<TreeNode>{
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public TreeNode search(Comparable searchKey) {
        return searchItem(root, searchKey);
    }

    private TreeNode searchItem(TreeNode node, Comparable searchKey) {
        if(node == null) return null;
        else if (searchKey.compareTo(node.key) == 0) return node;
        else if (searchKey.compareTo(node.key) < 0) return searchItem(node.left,searchKey);
        else return searchItem(node.right,searchKey);
    }

    @Override
    public void insert(Comparable newKey) {
        root = insertItem(root, newKey);
    }

    private TreeNode insertItem(TreeNode node, Comparable newKey) {
        if (node == null) node = new TreeNode(newKey);
        else if (newKey.compareTo(node.key) < 0) node.left = insertItem(node.left, newKey);
        else node.right = insertItem(node.right, newKey);
        return node;
    }

    @Override
    public void delete(Comparable searchKey) {
        root = deleteItem(root, searchKey);
    }

    private TreeNode deleteItem(TreeNode node, Comparable searchKey) {
        if (node == null) return null;
        else{
            if (searchKey == node.key){
                node = deleteNode(node);
            }
            else if(searchKey.compareTo(node.key) < 0){
                node.left = deleteItem(node.left, searchKey);
            }
            else{
                node.right = deleteItem(node.right, searchKey);
            }
            return node;
        }
    }

    /** 3가지 케이스
     * 1. 노드가 리프노드
     * 2. 노드의 자식이 하나만 있음
     * 3. 노드의 자식이 둘 있음
     */
    private TreeNode deleteNode(TreeNode node) {
        if (node.left == null && node.right == null) { //자식 없음
            return null;
        }
        else if(node.left == null){
            //오른쪽 자식 하나
            return node.right;
        }
        else if(node.right == null){
            return node.left;
        }
        else{
            //자식이 두개
            //삭제할 노드의 직후 원소 S를 찾는다
            returnPair rPair = deleteMinItem(node.right);
            //S의 부모 노드가
            node.key = rPair.key;
            node.right = rPair.node;
            return node;
        }
    }

    private returnPair deleteMinItem(TreeNode node) {
        if (node.left == null) {
            return new returnPair(node.key, node.right);
        }
        else{
            returnPair rPair = deleteMinItem(node.right);
            node.left = rPair.node;
            rPair.node = node;
            return rPair;
        }
    }

    private class returnPair{
        private Comparable key;
        private TreeNode node;

        private returnPair(Comparable it, TreeNode node) {
            this.key = it;
            this.node = node;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }
}
