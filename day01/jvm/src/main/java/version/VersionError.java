package version;


import org.apache.commons.lang.RandomStringUtils;

public class VersionError {
    public static void main(String[] args) {
        //生成10个字符长度的随机字符串
        String s = RandomStringUtils.randomAlphabetic(10);
        System.out.println(s);
    }
}
