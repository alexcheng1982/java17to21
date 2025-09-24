package me.vividcode.java17to21.virtualthread;

public class WithThreadLocal {

  public void inheritableThreadLocal() throws InterruptedException {
    var inheritableThreadLocal = new InheritableThreadLocal<Integer>();
    Thread.ofVirtual()
        .name("parent")
        .start(() -> {
          inheritableThreadLocal.set(300);
          try {
            Thread.ofVirtual()
                .name("child")
                .inheritInheritableThreadLocals(false)
                .start(() -> System.out.println(
                    "Value is " + inheritableThreadLocal.get()))
                .join();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        })
        .join();
  }

  public static void main(String[] args) throws InterruptedException {
    new WithThreadLocal().inheritableThreadLocal();
  }
}
