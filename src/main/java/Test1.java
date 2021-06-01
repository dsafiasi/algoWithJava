public class Test1 extends Test {
  @Override
  public void extend() {
    System.out.println("extend");
  }

  public static void main(String[] args) {
    Test t = new Test1();
    t.testF();
  }
}
