/**
 * @todo HTTP Utility
 * @author Sbriny
 * @version jdk 8<11
 * @date 2023-06-09
 */
public class HttpUtil {
    /**
     * @todo Browser User Agent
     */
    public static String USER_AGENT="Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Safari/605.1.15";

    /**
     * @todo Get HttpURLConnection
     * @anno main thread(no access)
     * @param url Http URL
     * @return HttpURLConnection
     * @throws IOException if Http Connection Error occurs
     */
    public static HttpURLConnection getHttpURLConnection(String url) throws IOException {
        URL httpUrl=new URL(url);
        HttpURLConnection httpUrlConnection=(HttpURLConnection)httpUrl.openConnection();
        httpUrlConnection.setRequestProperty("User-Agent",USER_AGENT);
        return httpUrlConnection;
    }

    /**
     * @todo HttpURLConnection Set Range Bytes Request Property(AccessFile)
     * @param url
     * @param startPos
     * @param endPos
     * @return
     * @throws IOException
     */
    public static HttpURLConnection getHttpURLConnection(String url, long startPos, long endPos) throws IOException{
        HttpURLConnection conn=getHttpURLConnection(url);
        System.out.printf("下载的区间是：%s～%s",startPos,endPos);
        if(endPos!=0){
            conn.setRequestProperty("RANGE","bytes="+startPos+"-"+endPos);
        }
        else{
            conn.setRequestProperty("RANGE","bytes="+startPos);
        }
        return conn;
    }

    /**
     * @todo Get HttpURLConnection File Name From URL
     * @anno substring from the last "/"
     * @param url Http URL
     * @return String fileName
     */
    public static String getHttpFileName(String url){
        int index=url.lastIndexOf("/");
        return url.substring(index+1);
    }

    public static long getHttpFileContentLength(String url) throws IOException{
        long contentLength;
        HttpURLConnection conn=null;
        try {
            conn=getHttpURLConnection(url);
            contentLength=conn.getContentLength();
        }
        finally {
            assert conn!=null;
            conn.disconnect();
        }
        return contentLength;
    }
}