public class TestOutput {
    public static void main(String args[]){
        Parent obj1 = new Child();
        Child obj2 = new Child();
        obj1.foo();
        obj2.foo();
        obj1.bar();
        obj2.bar();
        Parent.foo();
        Child.foo();
    }
    static class Parent{
        public static void foo(){System.out.println("I am foo in Parent");}
        public void bar(){System.out.println("I am bar in Parent");}
    }
    static class Child extends Parent{
        public static void foo(){ System.out.println("I am foo in Child");}
        public void bar(){ System.out.println("I am bar in Child");}
    }
}
