package annotation;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegexValidUtil
 * @Description @RegexValid ��ע�⴦����
 * @Author alms
 * @Data 2022/5/19 15:26
 **/
public class RegexValidUtil {
    public static boolean check(Object obj) throws Exception {
        boolean result = false;

        StringBuilder sb = new StringBuilder();
        Field[] fields =obj.getClass().getDeclaredFields();
        for(Field field :fields){
            //�жϳ�Ա�Ƿ���@@RegexValid ע��������
            if(field.isAnnotationPresent(RegexValid.class)){
                RegexValid valid = field.getAnnotation(RegexValid.class);

                //���value Ϊ���ַ�����˵��û��ע���Զ���������ʽ������policy ����
                String value = valid.value();
                if("".equals(value)){
                    RegexValid.Policy policy =valid.policy();
                    value = policy.getPolicy();
                }

                //ͨ������setAccessible(true) ������˽�г�Ա
                field.setAccessible(true);
                Object fieldObject =null;
                try {
                    fieldObject = field.get(obj);
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }
                if(fieldObject == null){
                    sb.append("\n").
                            append(String.format("%s ���е� %s �ֶβ���Ϊ�գ�", obj.getClass().getName(), field.getName()));
                    result = false;
                }else {
                    if (fieldObject instanceof String) {
                        String text = (String) fieldObject;
                        Pattern p = Pattern.compile(value);
                        Matcher m = p.matcher(text);
                        result = m.matches();
                        if (!result) {
                            sb.append("\n").append(String.format("%s ���ǺϷ��� %s ��", text, field.getName()));
                        }
                    } else {
                        sb.append("\n").append(
                                String.format("%s ���е� %s �ֶβ����ַ������ͣ�����ʹ�ô�ע��У�飡", obj.getClass().getName(), field.getName()));
                        result = false;
                    }
                }
            }
        }

        if (sb.length()>0){
            throw new Exception(sb.toString());
        }

        return result;

    }
}
