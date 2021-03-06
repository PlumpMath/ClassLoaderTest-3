package classloader.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Batuhan on 11.6.2016.
 */
public class JavaClassLoader extends ClassLoader {

    public void invokeClassMethod(String classBinName,String methodName){
        try{
            ClassLoader classLoader = this.getClass().getClassLoader();

            Class loadedMyClass = classLoader.loadClass(classBinName);

            System.out.println("Loaded class name : " + loadedMyClass.getName());

            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();

            Method method = loadedMyClass.getMethod(methodName);
            System.out.println("Invoked method name : " +method.getName());
            method.invoke(myClassObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
