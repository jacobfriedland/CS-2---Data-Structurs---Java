class Tree
{
	Node root;

	// Given a key, return the node containing it, or null if the key is not
	// present in the tree. Nodes are not exposed to the user; this is a
	// private auxiliary function.
	Node SearchNode(Comparable key)
	{
		// Start at the root
		Node node = root;
		
		// Traverse tree
		while (node != null)
		{
			if (key.compareTo(node.GetKey()) < 0)
				node = node.left;
			else if (key.compareTo(node.GetKey()) > 0)
				node = node.right;
			else
				return node;
		}

		// Not found
		return null;
	}

	// Given a key, return the data associated with it, or null if the key
	// is not present in the tree.
	public Object Search(Comparable key)
	{
		// Find node
		Node node = SearchNode(key);

		// Return associated data or null
		return node == null ? null : node.GetData();
	}

	// Return the node containing the minimum key in the subtree starting at 
	// the node passed in the argument, or null if that subree is empty.
	Node GetMinNode(Node node)
	{
		// Go down the left branch
		while (node != null && node.left != null)
			node = node.left;

		// Return it
		return node;
	}

	// Return the data associated with the minimum node in the tree, or null
	// if the tree is empty.
	public Object GetMin()
	{
		// Get minimum node starting at the root
		Node node = GetMinNode(root);

		// Return associated data or null
		return node == null ? null : node.GetData();
	}

	// Return the successor node for the node passed as an argument, or null
	// if the node passed as an argument is the last. This is an auxiliary
	// private function.
	Node GetSuccessorNode(Node node)
	{
		// Case 1 - Node has right child
		if (node.right != null)
			return GetMinNode(node.right);

		// Case 2 - Node has no right child
		Node parent = node.parent;
		while (parent != null && parent.left != node)
		{
			// Up one level
			node = parent;
			parent = node.parent;
		}

		// We found a node that is the left child of its parent. Return
		// that parent. Or return null if this was the last node.
		return parent;
	}

	// Return the successor data for the given key, or null if the key is
	// the last, or is not present.
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
		// Ignore if null
		if (node == null)
			return;

		// Print left subtree
		PrintNode(node.left);

		// Print current node
		System.out.println(node.GetData());

		// Print right subtree
		PrintNode(node.right);
	}

	// Print all objects in the tree in the order dictated by their keys.
	public void Print()
	{
		// Print subtree starting at root
		PrintNode(root);
	}

	// Replace the subtree rooted at node 'u' with the subtree rooted at
	// node 'v', or with null. This is an auxiliary private function.
	void Transplant(Node u, Node v)
	{
		// Update downward reference
		if (u.parent == null)
		{
			// Case 1 - Node 'u' is the root
			root = v;
		}
		else if (u == u.parent.left)
		{
			// Case 2 - Node 'u' is the left child of its parent
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

	// Remove the given node. This is an auxiliary private function.
	void RemoveNode(Node node)
	{
		if (node.left == null)
		{
			// Case 1 - Node has no left child
			Transplant(node, node.right);
		}
		else if (node.right == null)
		{
			// Case 2 - Node has no right child
			Transplant(node, node.left);
		}
		else
		{
			// Check successor
			Node successor = GetMinNode(node.right);
			if (successor == node.right)
			{
				// Case 3 - Node's successor is its right child
				Transplant(node, successor);
				successor.left = node.left;
				successor.left.parent = successor;
			}
			else
			{
				// Case 4 - Node's successor is not its right child
				Transplant(successor, successor.right);

				Transplant(node, successor);
				successor.left = node.left;
				successor.left.parent = successor;
				successor.right = node.right;
				successor.right.parent = successor;
			}
		}
	}

	public void Remove(Comparable key)
	{
		// Find node
		Node node = SearchNode(key);

		// Check if present
		if (node == null)
			throw new RuntimeException("Key not found");

		// Remove it
		RemoveNode(node);
	}
}
