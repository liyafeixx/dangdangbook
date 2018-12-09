import com.oracelwpd.ddbookmarket.util.MD5Util;

public class MianA {
    public static void main(String[] arge)throws Exception{
        String str="admin";
       System.out.println(MD5Util.getEncryptedPwd(str));

    }
}
