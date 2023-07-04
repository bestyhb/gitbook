/**
 * @todo 日志工具类
 * @author Yuan
 * @version jdk>8
 * @date 2023-06-09
 */
public class LogUtil {
    /**
     * @todo 日志处理
     * @param msg   提示信息
     * @param level 日志等级
     * @param args  可变参数
     */
    private static String printLog(String msg, String level, Object... args){
        if(args!=null && args.length>0){
            msg=String.format(msg.replace("{}","%s"),args);
        }
        String name=Thread.currentThread().getName();
        StringBuffer sb=new StringBuffer();
        sb
            .append(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")))
            .append(" ")
            .append(name)
            .append(" ")
            .append(level)
            .append(" ")
            .append(msg);
        return sb.toString();
    }

    /**
     * @todo 普通日志信息
     */
    public static void info(String msg, Object... args){
        System.out.println(printLog(msg,"-info-",args));
    }

    /**
     * @todo 动态日志信息
     */
    public static void dynamic(String msg, Object...args){
        System.out.print("/r");
        System.out.print(printLog(msg,"-dynamic info-", args));
    }

    /**
     * @todo 错误日志信息
     */
    public static void error(String msg, Object... args){
        System.out.println(printLog(msg,"-error-",args));
    }
}