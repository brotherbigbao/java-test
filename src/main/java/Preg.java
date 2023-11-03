package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Preg {
    public static void main(String[] args) {
        String json = "{\"body\":{\"dataMap\":{\"uploadFlowNo\":\"20231103114101152979\",\"MQ_check_resultField\":\"\",\"errorCode\":\"0\",\"state\":\"0\",\"MQ_executer_resultField\":\"\",\"errorMsg\":\"\"},\"errorCode\":\"0\",\"errorMsg\":\"\"},\"code\":200,\"message\":\"SUCCESS\"}";
        String json2 = "{\"body\":{\"dataMap\":{\"uploadFlowNo\":\"\",\"MQ_check_resultField\":\"\",\"errorCode\":\"ORSC0002\",\"state\":\"0\",\"MQ_executer_resultField\":\"\",\"errorMsg\":\"文件已经上传成功，不能再次上传\"},\"errorCode\":\"ORSC0002\",\"errorMsg\":\"文件已经上传成功，不能再次上传\"},\"code\":200,\"message\":\"SUCCESS\"}";
        String flwno1 = getFlwno(json);
        String flwno2 = getFlwno(json2);

        System.out.println(flwno1);
        System.out.println(flwno1.length());
        System.out.println(flwno2);
        System.out.println(flwno2.length());

        if (flwno1.equals("")) {
            System.out.println("flwno1 is empty");
        }
        if (flwno2.equals("")) {
            System.out.println("flwno2 is empty");
        }
        if (flwno2.isEmpty()) {
            System.out.println("flwno2 is empty");
        }
    }

    private static String getFlwno(String res)
    {
        String pattern = "\"uploadFlowNo\":\"(\\d*)\"";

        // 创建 Pattern 对象
        Pattern regex = Pattern.compile(pattern);

        // 创建 Matcher 对象
        Matcher matcher = regex.matcher(res);

        // 查找匹配的部分
        if (matcher.find()) {
            String uploadFlowNo = matcher.group(1);
            //System.out.println("uploadFlowNo: " + uploadFlowNo);
            return uploadFlowNo;
        } else {
            System.out.println("未找到匹配的uploadFlowNo");
            return "";
        }
    }
}
