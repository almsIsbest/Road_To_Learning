package reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class CopyTypeReference<T> {
    protected Type type;

    protected CopyTypeReference(){
        Type superClass = getClass().getGenericSuperclass();

        this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return type;
    }
}
