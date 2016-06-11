package classloader.test;

/**
 * Created by Batuhan on 11.6.2016.
 */
public class ClassLoaderTest extends JavaClassLoader{
    public static void main(String[] args) {
        JavaClassLoader javaClassLoader = new JavaClassLoader();
        javaClassLoader.invokeClassMethod("classloader.test.MyClass","sayHello");
    }
}
