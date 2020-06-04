public class TestOverriding {
    public static void main(String args[]){
        Base obj1 = new Derived();
        obj1.display();
        obj1.print();
    }

    static class Base{
        private static void display(){System.out.println("Static or class method from Base");}
        public void print(){System.out.println("Static or class method from Base");}
    }
    static class Derived extends Base{
  //      @Override
   //     private static void display(){ System.out.println("Static or class method from Derived");}
        @Override
        public void print(){ System.out.println("Static or class method from Derived"); }
    }
}
