#include <unordered_set>

// Forward declaration of TreeNode
struct TreeNode;

using namespace std;

class FindElements {
public:
    unordered_set<int> recovered;  // Set to store recovered node values
    
    // Helper function to recover the tree
    void recoverTree(TreeNode* root, int val) {
        if (!root) return;
        root->val = val;  // Recover the value of the current node
        recovered.insert(val);  // Add the value to the set
        
        // Recursively recover the left and right children
        if (root->left) recoverTree(root->left, 2 * val + 1);
        if (root->right) recoverTree(root->right, 2 * val + 2);
    }
    
    // Constructor that initializes the object with a contaminated tree
    FindElements(TreeNode* root) {
        recoverTree(root, 0);  // Recover the tree starting from the root with value 0
    }
    
    // Function to check if the target value exists in the recovered tree
    bool find(int target) {
        return recovered.find(target) != recovered.end();  // Check if target is in the set
    }
};
