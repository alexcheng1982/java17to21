package me.vividcode.java17to21.virtualthread;

public class CreateVirtualThreads {

  public void ofVirtual() throws InterruptedException {
    var thread = Thread.ofVirtual().name("my virtual thread")
        .start(() -> System.out.println("I'm running"));
    thread.join();
  }

  public void startVirtualThread() {
    Thread.startVirtualThread(() -> System.out.println("I'm running"));
  }

  public void threadFactory() throws InterruptedException {
    var factory = Thread.ofVirtual().factory();
    var thread = factory.newThread(() -> System.out.println("Created in factory"));
    thread.start();
    thread.join();
  }

  public static void main(String[] args) throws InterruptedException {
    var createVirtualThreads = new CreateVirtualThreads();
    createVirtualThreads.ofVirtual();
    createVirtualThreads.startVirtualThread();
    createVirtualThreads.threadFactory();
  }
}
