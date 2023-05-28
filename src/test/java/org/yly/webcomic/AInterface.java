package org.yly.webcomic;

@FunctionalInterface
public interface AInterface<K,V> {

    V doSome(K obj,String name);
}

class AImpl implements AInterface<String,Object>{

    @Override
    public Object doSome(String obj, String name) {
        return null;
    }
}

class Test{
    public static void main(String[] args) {
        AInterface<String,Object> aInterface = (obj,name) -> {
            System.out.println(obj + name);
            return null;
        };
        aInterface.doSome("asas","pppp");
    }
}
