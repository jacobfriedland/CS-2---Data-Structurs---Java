class Test
{
	public static void main(String args[])
	{
		DoublyLinkedList doubly_linked_list = new DoublyLinkedList();
		
		doubly_linked_list.Insert("a");	
		doubly_linked_list.Insert("b");
		doubly_linked_list.Insert("c");

		doubly_linked_list.Tail();
		doubly_linked_list.Previous();		
		doubly_linked_list.Insert("d");

		doubly_linked_list.Tail();
		doubly_linked_list.Next();	
		doubly_linked_list.Insert("e");

		doubly_linked_list.Print();
	}
}
