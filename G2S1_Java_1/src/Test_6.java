
public class Test_6 {
    public static void main(String[] args) {
        A a = new A("a");
        B b = new B("b");
        C c = new C("c");
        a.sendMsg("0");
        a = b;
        a.sendMsg("1");
        a = c;
        a.sendMsg("2");
    }
    static class A {
        public String name;
        public A(String name){
            this.name = name;
            System.out.println(this.name);
        }
        public void sendMsg(String msg){
            System.out.println(this.name+msg);
        } }
    static class B extends A{
        public String name;
        public B(String name){
            super(name+'B');
            // Task 3 to be completed
            this.name = name;
            System.out.println(name);//Task 4 to be completed
        }
        public void sendMsg(String msg) { System.out.println(super.name+msg);//Task 5 to be completed
        } }
    static class C extends B{
        public C(String name){
            super(name+name.toUpperCase());// Task 6 to be completed
            this.name=name;
            System.out.println(name);//Task 7 to be completed
        }
        public void sendMsg(String msg) { System.out.println(this.name+msg);//Task 8 to be completed
        }
    }
}
