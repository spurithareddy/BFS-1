// Time Complexity : O(n)
// Space Complexity : O(n/2) -> O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
I'm adding root into the queue , taking the size of queue to determine how many elements are there in the previous level.
Iterate from 0 to size and until queue is empty. pop the element, check if it has left and right elements and add them to queue
create a new list at each level and keep adding it to result arraylist
BFS Approach

*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root != null) {
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);
            while (!que.isEmpty()) {
                List<Integer> arr = new ArrayList<>();
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    TreeNode x = que.poll();
                    arr.add(x.val);
                    if (x.left != null) {
                        que.add(x.left);
                    }
                    if (x.right != null) {
                        que.add(x.right);
                    }
                }
                res.add(arr);
            }

        }

        return res;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
I'm calling the function recursively and passing the variable level for the level of each node.
Creating an araylist for each level. The distinction between when to create arraylist and when to get the previous arraylist
is done based on the size of the res ult list<list<integer>>.
when no element in same level found before , then create an arraylist if level<res.size() add element to the previous aray

DFS Approach
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, 0, res);
        return res;
    }

    public void helper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);

    }
}