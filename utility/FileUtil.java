/**
 * @todo File Utility
 * @author Sbriny
 * @date 2022-06-09
 */
public class FileUtil {
    /**
     * @todo Get location file byte length from local file path.
     */
    public static long getFileContentLength(String filePath){
        File file=new File(filePath);
        return file.exists() && file.isFile() ? file.length() : 0;
    }


}
