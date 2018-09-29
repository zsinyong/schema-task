package app.zsing.task.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    public static String appGetUrl = null;
    public static String appSendUrl = null;
    public static String appRatingStudyLevel = null;
    public static String userTag = null;
    public static String appRecodeUrl = null;
    public static Map<String, String> appWebMap = new HashMap<String, String>();
    public static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy年MM月dd日", "yyyy年MM月dd日 HH时mm分", "yyyy年MM月dd日 HH时mm分ss秒",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm"};
    public static String webAreaId = null;
    public static String webAreaName = null;
    public static String studyPromotionAppGetUrl = null;
    public static String studyPromotionAppSendUrl = null;
    public static String syncTime = null;
    private static String appWeb = null;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(CommonUtil.class.getClassLoader().getResourceAsStream("sync.properties"), "UTF-8"));
            appGetUrl = (String) properties.get("app.service.get");
            appSendUrl = (String) properties.get("app.service.send");
            userTag = (String) properties.get("user.tag");
            appWeb = (String) properties.get("app.web.map");
            webAreaId = (String) properties.get("web.area.id");
            webAreaName = (String) properties.get("web.area.name");
            appRecodeUrl = (String) properties.get("appRecode.service.get");
            appRatingStudyLevel = (String) properties.get("appRatingStudyLevel.service.send");

            studyPromotionAppGetUrl = (String) properties.get("study.promotion.get");
            studyPromotionAppSendUrl = (String) properties.get("study.promotion.send");

            syncTime = (String) properties.get("syncTime");

            //app web对应关系设置
            if (appWeb != null && !"".equals(appWeb)) {
                String[] maps = appWeb.split(",");
                for (int i = 0; i < maps.length; i++) {
                    String map = maps[i];
                    String[] exchanges = map.split("-");
                    if (exchanges.length == 2) {
                        appWebMap.put(exchanges[1], exchanges[0]);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("{}", e);
            e.printStackTrace();
        }
    }


    public static boolean checkObjectEquals(Object original, Object target) {
        if (original == null) {
            if (target == null) {
                return true;
            } else {
                return false;
            }
        }
        if (original.equals(target)) {
            return true;
        }
        return false;
    }

    public static Long date2Long(Date date) {
        if (date == null) {
            return null;
        }
        return date.getTime();
    }


    public static boolean checkDateEquals(String original, Date date) {
        if (original == null) {
            if (date == null) {
                return true;
            } else {
                return false;
            }
        } else if (date == null) {
            return false;
        }
        Long dateLong = date.getTime();
        if (original.equals(dateLong.toString())) {
            return true;
        }
        return false;
    }

    public static String read(String filePath) {
        StringBuilder result = new StringBuilder();
        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String s = null;
            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                result.append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }


    public static String getCurrentTime() {
        return System.currentTimeMillis() + "";
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String getUUIDWithOutH() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

    public long string2Timestamp(String dateStr) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(dateStr).getTime();
    }
}
