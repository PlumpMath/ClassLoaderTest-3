package classloader.test;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Batuhan on 11.6.2016.
 */
public class JavaClassLoaderTest extends ClassLoader {

    @Test(expected = Exception.class)
    public void invokeClassMethod() throws Exception{
            ClassLoader classLoader = this.getClass().getClassLoader();

            Class loadedMyClass = classLoader.loadClass("classloader.test.MyClass");

            System.out.println("Loaded class name : " + loadedMyClass.getName());

            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();

            Method method = loadedMyClass.getMethod("sayHello");
            System.out.println("Invoked method name : " +method.getName());
            method.invoke(myClassObject);

        Assert.assertEquals("classloader.test.MyClass",loadedMyClass.getName());
        Assert.assertEquals("sayHello",method.getName());
    }
}
