package java21.features;


public interface PrivateMethodInInterface {
    default void publicMethod() {
        // Public method can call private method
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("Private method in interface");
    }
}