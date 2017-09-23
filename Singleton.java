
@ThreadSafe
class Singleton {
    private static class SingletonInstance {
       public static Singleton instance = new Singleton();
    }
 
    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }
}