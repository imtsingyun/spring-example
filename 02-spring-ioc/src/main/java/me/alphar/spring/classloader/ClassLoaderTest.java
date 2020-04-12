package me.alphar.spring.classloader;

/**
 * 类装载器
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader: " + loader);
        System.out.println("parent loader: " + loader.getParent());
        // 根装载器在 java 中访问不到，所以 返回 null
        System.out.println("grandparent loader: " + loader.getParent().getParent());
    }
}
