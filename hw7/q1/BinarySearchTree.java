class BinarySearchTree
{
        Node root;

        // Given a key, return the node containing it, or null if the key
        // is not present in the tree. Nodes are not exposed to the user;
        // this is a private auxiliary function.
        Node SearchNode(Comparable key)
        {
                // Start at the root
                Node node = root;

                // Traverse the tree
                while (node != null)
                {
                        // Compare node with given key
                        if (key.compareTo(node.GetKey()) == 0)
                                return node;
                        else if (key.compareTo(node.GetKey()) < 0)
                                node = node.left;
                        else
                                node = node.right;
                }

                // Not found
                return null;
        }

        // Given a key, return the data associated with it, or null
        // if the key is not present in the tree.
        public Object Search(Comparable key)
        {
                // Find node
                Node node = SearchNode(key);

                // Return associated data or null
                return node == null ? null : node.GetData();
        }

	// Return the node containing the minimum key in the subtree starting
        // at the node passed in the argument, or null if that subtree is empty.
        Node GetMinNode(Node node)
        {
                // Go down the left branch
                while (node != null && node.left != null)
                        node = node.left;

                // Return it
                return node;
        }

        // Return the data associated with the minimum node in the tree,
        // or null if the tree is empty.
        public Object GetMin()
        {
                // Get minimum node starting at the root
                Node node = GetMinNode(root);

                // Return associated data or null
                return node == null ? null : node.GetData();
        }
	
	// Return the successor node for the node passed as an arugnent,
        // or null if the node passed as an argument is the last.
        // This is an auxiliary private function.
        Node GetSuccessorNode(Node node)
        {
                // Case 1 - node has right child
                if (node.right != null)
                        return GetMinNode(node.right);

                // Case 2 - node has no right child
                Node parent = node.parent;
                while (parent != null && parent.left != node)
                {
                        // Up one level
                        node = parent;
                        parent = parent.parent;
                }

                // We found a node that is the left child of its parent,
                // or we reached the root. In either case, return the value
                // of the parent node.
                return parent;
        }

        // Return the successor data for the given key, or null if the 
        // key is the last, or is not present.
        public Object GetSuccessor(Comparable key)
        {
                // Find node
                Node node = SearchNode(key);
                if (node == null)
                        return null;

                // Get successor node
                node = GetSuccessorNode(node);

                // Return associated data or null
                return node == null ? null : node.GetData();
        }

	public void Insert(Comparable key, Object data)
        {
                // Create node
                Node node = new Node(key, data);

                // Walk down the tree
                Node parent = null;
                Node child = root;
                while (child != null)
                {
                        // Parent goes down
                        parent = child;

                        // Child goes down
                        if (key.compareTo(child.GetKey()) < 0)
                                child = child.left;
                        else if (key.compareTo(child.GetKey()) > 0)
                                child = child.right;
                        else
                                throw new RuntimeException("Duplicate key");
                }

                // Hang new node from parent
                node.parent = parent;
                if (parent == null)
                        root = node;
                else if (key.compareTo(parent.GetKey()) < 0)
                        parent.left = node;
                else
                        parent.right = node;
        }

	// Print the data associated with all nodes in the subtree that starts
        // at the node passed in the argument. The printed objects are sorted by
        // their keys. This is a private auxiliary function.
        void PrintNode(Node node)
        {
                // Check if null
                if (node == null)
                        return;
                // Print left subtree
                PrintNode(node.left);

                // Print current
                System.out.println(node.GetData());

                // Print right subtree
                PrintNode(node.right);
        }
        public void Print()
        {
                // Print subtree starting at the root
                PrintNode(root);
        }

	// Replace the subtree rooted at node 'u' with the subtree rooted
        // at node ' v', or with null. This is an auxiliary private function.
        void Transplant(Node u, Node v)
        {
                // Update downward reference
                if (u.parent == null)
                {
                        // Case 1 - node 'u' is the root
                        root = v;
                }
                else if (u == u.parent.left)
                {
                        // Case 2 = node 'u' is the left child of its parent.
                        u.parent.left = v;
                }
                else
                {
                        // Case 3 - Node 'u' is the right child of its parent
                        u.parent.right = v;
                }

                // Update upward reference
                if (v != null)
                        v.parent = u.parent;
        }

	// Remove the given node. This is a private auxiliary function.
        void RemoveNode(Node node)
        {
                if (node.left == null)
                {
                        // Case a) Node has no left child
                        Transplant(node, node.right);
                }

                else if (node.right == null)
                {
                        // Case b) Node has no right child
                        Transplant(node, node.left);
                }

                else
                {
                        // Find successor
                        Node successor = GetMinNode(node.right);
                        if (successor == node.right)
                        {
                                // Case c) Node's successor is its right child
                                Transplant(node, successor);
                                successor.left = node.left;
                                node.left.parent = successor;
                        }
                        else
                        {
                                // Case d) Node's successor is not its right child
                                Transplant(successor, successor.right);
                                Transplant(node, successor);
                                successor.left = node.left;
                                node.left.parent = successor;
                                successor.right = node.right;
                                node.right.parent = successor;
                        }
                }
        }

	public void Remove(Comparable key)
        {
                // Find node
                Node node = SearchNode(key);

                // Check if key is present
                if (node == null)
                        throw new RuntimeException("Key not found");

                // Remove valid node
                RemoveNode(node);
        }

	int GetNodeHeight(Node node)
	{	
		if (node == null)
			return -1;
		
		int heightleft = GetNodeHeight(node.left);
		int heightright = GetNodeHeight(node.right);

		if (heightleft > heightright)
			return heightleft + 1;
		else
			return heightright + 1;
	}

	public int GetHeight(Comparable key)
	{
		Node node = SearchNode(key);

		if (node == null)
			return -1;
		
		return GetNodeHeight(node);
	}

	public int GetHeight()
	{
		if (root == null)
			return -1;
		else
			return GetNodeHeight(root);
	}
}

























