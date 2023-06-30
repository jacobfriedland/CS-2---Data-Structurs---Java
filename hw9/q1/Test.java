class Test
{
        public static void main(String args[])
        {
                // Create persons
                Person p1 = new Person("Adam", 20);
                Person p2 = new Person("John", 25);
                Person p3 = new Person("Mary", 21);
                Person p4 = new Person("Zach", 22);

                // Insert them into a hash table
                HashTable hash_table = new HashTable();
                hash_table.Insert(p1.GetName(), p1);
                hash_table.Insert(p2.GetName(), p2);
                hash_table.Insert(p3.GetName(), p3);
                hash_table.Insert(p4.GetName(), p4);

                System.out.println("Successor of Mary: " + hash_table.GetSuccessor("Mary"));
                System.out.println("Successor of Zach: " + hash_table.GetSuccessor("Zach"));
        }
} 
