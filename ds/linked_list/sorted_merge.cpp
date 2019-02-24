// program to merge two sorted linked list
#include <iostream>
#include <cstdlib>
using namespace std;
struct Node {
	int data;
	Node *next;
}*head = NULL,  *head1 = NULL, *head2 = NULL;

Node* create_node(int data) {
	Node *temp;
	temp = new Node();
	temp->data = data;
	temp->next = NULL;
	return temp;
}
Node* merge() {
	if(head1 == NULL) {
		return head2;
	}
	if(head2 == NULL) {
		return head1;
	}
	if(head1->data < head2->data) {
		head = head1;
		head1 = head1->next;
	} else {
		head = head2;
		head2 = head2->next;
	}
	Node *curr = head;
	while(head1 != NULL && head2 != NULL) {
		if(head1->data < head2->data) {
			curr->next = head1;
			head1 = head1->next;
		} else {
			curr->next = head2;
			head2 = head2->next;
		}
			curr = curr->next;
	}
	if(head1 != NULL) {
		curr->next = head1;
	}
	if(head2 != NULL) {
		curr->next = head2;
	}
		return head;
}
int main() {
	head1 = create_node(10);
	head1->next = create_node(30);		
	head1->next->next = create_node(40);	
	head1->next->next->next = create_node(50);	

	head2 = create_node(60);
	head2->next = create_node(70);		
	head2->next->next = create_node(80);	

	head = merge();
	Node *cursor = head;
	while(cursor != NULL) {
		cout<<cursor->data<<" ";
		cursor = cursor->next;
	}	
	return 0;
}