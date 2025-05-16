package creationalDesignPattern;

//way-5 Using inner class - Bill Pugh Solution - Best for Lazy Initialization (Thread Safe )
class OuterClass {

  private OuterClass() {
  }

  private static class InnerClass {
    private static final OuterClass instance = new OuterClass();
  }

  public static OuterClass getInstance() {
    return InnerClass.instance;
  }

}

// Way-4 Lazy Initialization of Singleton Pattern(Thread Safe- Double Check
// Locking)
class LazyInitialization {
  private static volatile LazyInitialization lazyInstance;

  private LazyInitialization() {

  }

  public static LazyInitialization getInstance() {
    if (lazyInstance == null) {
      synchronized (LazyInitialization.class) {
        if (lazyInstance == null) {
          lazyInstance = new LazyInitialization();
        }
      }
    }
    return lazyInstance;
  }
}

// Way - 3 Lazy Initialization of Singleton Pattern (Thread Safe - Synchronized
// KeyWord)

/*
 * class LazyInitialization {
 * private static LazyInitialization lazyInstance;
 * 
 * private LazyInitialization() {
 * 
 * }
 * 
 * public static synchronized LazyInitialization getInstance() {
 * if (lazyInstance == null) {
 * lazyInstance = new LazyInitialization();
 * }
 * return lazyInstance;
 * }
 * }
 */

// Way - 2 Lazy Initialization of Singleton Pattern (No Thread Safe)
// class LazyInitialization {
// private static LazyInitialization lazyInstance;

// private LazyInitialization() {

// }

// public static LazyInitialization getInstance() {
// if (lazyInstance == null) {
// lazyInstance = new LazyInitialization();
// }
// return lazyInstance;
// }
// }

// Way 1- Early Initialization of Singleton Pattern (Thread Safe)
class EagerInitialization {

  private static final EagerInitialization instance = new EagerInitialization();

  private EagerInitialization() {
  }

  public static EagerInitialization getInstance() {
    return instance;
  }
}

public class SingletonPattern {

  public static void main(String[] args) {

    EagerInitialization instance = EagerInitialization.getInstance();
    System.out.println(instance);

    LazyInitialization lazyInstance = LazyInitialization.getInstance();
    System.out.println(lazyInstance);

    OuterClass outerInstance = OuterClass.getInstance();
    System.out.println(outerInstance);
  }

}
