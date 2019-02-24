

// 1) quick sort
// 2) document chunking
// 3) rat maze
// 4) anagrams
// 5) 8 queens 
// 6) median 
// 7) design a schedule
// rajiv shukla 
// 1) polish notations 
// 2) deletion of node
// segment tries
// tries
// tic tac toe
// java programs revision
// 

// algorithm to insert node in binary search tree 

insert(root, data):
	node = new node(data)
	temp = root;
	while(temp != null):
		if(data < temp.left):
			if(temp.left == null):
				temp.left = node
				temp = temp.left
		elsif(data > temp.right):
			if(temp.right == null):
				temp.right = node
				temp = temp.right

// alogorithm for deletion of node in binary search tree
// case 1 : if element to be deleted is leaf node
// case 2 : if element to be deleted has one child
// case 3 : if element to be deleted has both child
delete_node(root, data):
	if(root == null):
		return
	if(data < root.left):
		root.left = delete_node(root.left)
	if(data > root.right):
		root.right = delete_node(root.right)
	else:
		if(root.left && root.right):
			temp = find_max(root.left)
			root.data = temp.data
			delete_node(temp, temp.data)
		else:
			if(root.right):
				root = root.right
				root.right = null
			elsif(root.left):
				root = root.left
				root.right = null
			else:
				temp = root
				free(temp)
				return null


 				
