package com.tree.trjson.tool;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class TypeToken<T> {
    private final Type type;

    @SuppressWarnings("unchecked")
    protected TypeToken() {
        this.type = getSuperclassTypeParameter(getClass());
    }

    private static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        assert parameterized != null;
        return parameterized.getActualTypeArguments()[0];
    }
    public final Type getType() {
        return type;
    }
}
