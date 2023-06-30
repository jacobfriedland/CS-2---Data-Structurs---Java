class Person
{
        String name;
        int age;

        public Person(String name, int age)
        {
                this.name = name;
                this.age = age;
        }

        public String GetName()
        {
                return name;
        }

        public int GetAge()
        {
                return age;
        }

        public String toString()
        {
                return name + " (" + age + " years old);";
        }
}

