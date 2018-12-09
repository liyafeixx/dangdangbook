import com.oracelwpd.ddbookmarket.util.MD5Util;
//我一塔万隆
public class MianA {
    public static void main(String[] arge)throws Exception{
        String str="admin";
       System.out.println(MD5Util.getEncryptedPwd(str));

    }
}
