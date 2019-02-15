#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode *treeNode(int val) {
    struct TreeNode *node = malloc(sizeof(struct TreeNode));
    node->left = NULL;
    node->right = NULL;
    node->val = val;
    return node;
}

#define EMPTY_NODE_PLACEHOLDER "#"

/** Encodes a tree to a single string. */
char *serialize(struct TreeNode *node) {
    if (node) {
        size_t length = snprintf(NULL, 0, "%d", node->val);
        char *result = malloc(length + 1);
        snprintf(result, length + 1, "%d", node->val);

        result = strcat(result, serialize(node->left));
        result = strcat(result, serialize(node->right));
        return result;
    }
    return EMPTY_NODE_PLACEHOLDER;
}

/** Decodes your encoded data to tree. */
struct TreeNode *deserialize(char *data) {
    char value = data[0];
    if (value == '\0' || value == EMPTY_NODE_PLACEHOLDER[0]) {
        return NULL;
    }

    //fixme There is an issue in this implementation
    struct TreeNode *node = malloc(sizeof(struct TreeNode));
    node->val = (int) strtol(&value, NULL, 10);
    char *next = data + 1;
    node->left = deserialize(next);
    next = next + 1;
    node->right = deserialize(next);
    return node;
}

// Your functions will be called as such:
// char* data = serialize(root);
// deserialize(data);

int main() {
    struct TreeNode *root = treeNode(5);
    root->left = treeNode(1);
    root->right = treeNode(2);
    char *serialized = serialize(root);
    printf("%s\n", serialized);
    struct TreeNode *tree = deserialize(serialized);
    return 0;
}