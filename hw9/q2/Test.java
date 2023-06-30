class Test
{
        public static void main(String args[])
        {
                HashTable hash_table = new HashTable();

		for (int i = 0; i < 1000; i++)
			hash_table.Insert(Integer.valueOf(i), null);
	}
} 

