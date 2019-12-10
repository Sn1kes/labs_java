import java.lang.reflect.*;

class CustomInvocationHandler implements InvocationHandler
{
    FractionComplex obj;
    public CustomInvocationHandler(FractionComplex fr) {
        obj = fr;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        if(method.getName().equals("setImaginaryNumerator") || method.getName().equals("setImaginaryDenominator") ||
                method.getName().equals("setNumerator") || method.getName().equals("setDenominator")) {
            throw new Exception();
        }
        return method.invoke(proxy);
    }
}

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        FractionComplex fr = new FractionComplex(3, 5, 7, 9);
        System.out.println(fr.toString());

        Method[] m = fr.getClass().getDeclaredMethods();
        for(Method method : m) {
            if(method.isAnnotationPresent(MyAnnotation.class)) {
                Object[] method_args = new Object[method.getParameterCount()];
                method.invoke(fr, method_args);
            }
        }

        System.out.println(fr.getClass().getName());
        Constructor[] constructors = fr.getClass().getConstructors();
        for(Constructor constructor : constructors) {
            System.out.printf("%s(", constructor.getName());
            Parameter[] params = constructor.getParameters();
            if(params.length > 0) {
                System.out.printf("%s", params[0].getType().getName());
                for(int j = 1; j < params.length; ++j) {
                    System.out.printf(", %s", params[j].getType().getName());
                }
            }
            System.out.println(")");
        }

        System.out.println(Modifier.toString(fr.getClass().getModifiers()));
        FractionComplex_int fr_im = (FractionComplex_int) Proxy.newProxyInstance(fr.getClass().getClassLoader(), fr.getClass().getInterfaces(),
                new CustomInvocationHandler(fr));
        fr_im.getImaginaryDenominator();
    }
}
