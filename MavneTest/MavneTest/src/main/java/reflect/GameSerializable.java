package reflect;

import io.netty.buffer.ByteBuf;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public interface GameSerializable {
   private void  Serializable(ByteBuf reader){
      Class<?>clazz = this.getClass();
      Field[]fields = clazz.getDeclaredFields();
   }
}
