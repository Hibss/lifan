package com.lifan.work.util;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 15:05
 */

import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RequestUtil {
    public static final String RETURNURL = "returnUrl";

    private RequestUtil() {
    }

    public static String getString(HttpServletRequest request, String key, String defaultValue, boolean b) {
        String value = request.getParameter(key);
        return StringUtils.isEmpty(value)?defaultValue:(b?value.replace("\'", "\'\'").trim():value.trim());
    }

    public static String getString(HttpServletRequest request, String key) {
        return getString(request, key, "", true);
    }

    public static String getString(HttpServletRequest request, String key, boolean b) {
        return getString(request, key, "", b);
    }

    public static String getString(HttpServletRequest request, String key, String defaultValue) {
        return getString(request, key, defaultValue, true);
    }

    public static String getStringAry(HttpServletRequest request, String key) {
        String[] aryValue = request.getParameterValues(key);
        if(aryValue != null && aryValue.length != 0) {
            String tmp = "";
            String[] var4 = aryValue;
            int var5 = aryValue.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String v = var4[var6];
                if("".equals(tmp)) {
                    tmp = tmp + v;
                } else {
                    tmp = tmp + "," + v;
                }
            }

            return tmp;
        } else {
            return "";
        }
    }

    public static String getSecureString(HttpServletRequest request, String key, String defaultValue) {
        String value = request.getParameter(key);
        return StringUtil.isEmpty(value)?defaultValue:filterInject(value);
    }

    public static String getSecureString(HttpServletRequest request, String key) {
        return getSecureString(request, key, "");
    }

    public static String filterInject(String str) {
        String injectstr = "\\||;|exec|insert|select|delete|update|count|chr|truncate|char";
        Pattern regex = Pattern.compile(injectstr, 226);
        Matcher matcher = regex.matcher(str);
        str = matcher.replaceAll("");
        str = str.replace("\'", "\'\'");
        str = str.replace("-", "—");
        str = str.replace("(", "（");
        str = str.replace(")", "）");
        str = str.replace("%", "％");
        return str;
    }

    public static String getLowercaseString(HttpServletRequest request, String key) {
        return getString(request, key).toLowerCase();
    }

    public static int getInt(HttpServletRequest request, String key) {
        return getInt(request, key, 0);
    }

    public static int getInt(HttpServletRequest request, String key, int defaultValue) {
        String str = request.getParameter(key);
        return StringUtil.isEmpty(str)?defaultValue:Integer.parseInt(str);
    }

    public static long getLong(HttpServletRequest request, String key) {
        return getLong(request, key, 0L);
    }

    public static Long[] getLongAry(HttpServletRequest request, String key) {
        String[] aryKey = request.getParameterValues(key);
        if(Objects.isNull(aryKey)) {
            return null;
        } else {
            Long[] aryLong = new Long[aryKey.length];

            for(int i = 0; i < aryKey.length; ++i) {
                aryLong[i] = Long.valueOf(Long.parseLong(aryKey[i]));
            }

            return aryLong;
        }
    }

    public static Long[] getLongAryByStr(HttpServletRequest request, String key) {
        String str = request.getParameter(key);
        if(StringUtil.isEmpty(str)) {
            return null;
        } else {
            String[] aryId = str.split(",");
            Long[] lAryId = new Long[aryId.length];

            for(int i = 0; i < aryId.length; ++i) {
                lAryId[i] = Long.valueOf(Long.parseLong(aryId[i]));
            }

            return lAryId;
        }
    }

    public static String[] getStringAryByStr(HttpServletRequest request, String key) {
        String str = request.getParameter(key);
        if(StringUtil.isEmpty(str)) {
            return null;
        } else {
            String[] aryId = str.split(",");
            String[] lAryId = new String[aryId.length];

            for(int i = 0; i < aryId.length; ++i) {
                lAryId[i] = aryId[i];
            }

            return lAryId;
        }
    }

    public static Integer[] getIntAry(HttpServletRequest request, String key) {
        String[] aryKey = request.getParameterValues(key);
        if(Objects.isNull(aryKey)) {
            return null;
        } else {
            Integer[] aryInt = new Integer[aryKey.length];

            for(int i = 0; i < aryKey.length; ++i) {
                aryInt[i] = Integer.valueOf(Integer.parseInt(aryKey[i]));
            }

            return aryInt;
        }
    }

    public static Float[] getFloatAry(HttpServletRequest request, String key) {
        String[] aryKey = request.getParameterValues(key);
        if(Objects.isNull(aryKey)) {
            return null;
        } else {
            Float[] fAryId = new Float[aryKey.length];

            for(int i = 0; i < aryKey.length; ++i) {
                fAryId[i] = Float.valueOf(Float.parseFloat(aryKey[i]));
            }

            return fAryId;
        }
    }

    public static long getLong(HttpServletRequest request, String key, long defaultValue) {
        String str = request.getParameter(key);
        return StringUtil.isEmpty(str)?defaultValue:Long.parseLong(str.trim());
    }

    public static Long getLong(HttpServletRequest request, String key, Long defaultValue) {
        String str = request.getParameter(key);
        return StringUtil.isEmpty(str)?defaultValue:Long.valueOf(Long.parseLong(str.trim()));
    }

    public static float getFloat(HttpServletRequest request, String key) {
        return getFloat(request, key, 0.0F);
    }

    public static float getFloat(HttpServletRequest request, String key, float defaultValue) {
        String str = request.getParameter(key);
        return StringUtil.isEmpty(str)?defaultValue:Float.parseFloat(request.getParameter(key));
    }

    public static double getDouble(HttpServletRequest request, String key, float defaultValue) {
        String str = request.getParameter(key);
        return StringUtil.isEmpty(str)?(double)defaultValue:Double.parseDouble(request.getParameter(key));
    }

    public static boolean getBoolean(HttpServletRequest request, String key) {
        return getBoolean(request, key, false);
    }

    public static boolean getBoolean(HttpServletRequest request, String key, boolean defaultValue) {
        String str = request.getParameter(key);
        return StringUtil.isEmpty(str)?defaultValue:(StringUtils.isNumeric(str)?Integer.parseInt(str) == 1:Boolean.parseBoolean(str));
    }

    public static Short getShort(HttpServletRequest request, String key) {
        return getShort(request, key, Short.valueOf((short)0));
    }

    public static Short getShort(HttpServletRequest request, String key, Short defaultValue) {
        String str = request.getParameter(key);
        return StringUtil.isEmpty(str)?defaultValue:Short.valueOf(Short.parseShort(str));
    }

    public static Date getDate(HttpServletRequest request, String key, String style) throws ParseException {
        String str = request.getParameter(key);
        if(StringUtil.isEmpty(str)) {
            return null;
        } else {
            if(StringUtil.isEmpty(style)) {
                style = "yyyy-MM-dd HH:mm:ss";
            }

            return DateFormatUtil.parse(str, style);
        }
    }

    public static String getUrl(HttpServletRequest request) {
        StringBuffer urlThisPage = new StringBuffer();
        urlThisPage.append(request.getRequestURI());
        Enumeration e = request.getParameterNames();
        String para = "";
        String values = "";
        urlThisPage.append("?");

        while(e.hasMoreElements()) {
            para = (String)e.nextElement();
            values = request.getParameter(para);
            urlThisPage.append(para);
            urlThisPage.append("=");
            urlThisPage.append(values);
            urlThisPage.append("&");
        }

        return urlThisPage.substring(0, urlThisPage.length() - 1);
    }

    public static String getPrePage(HttpServletRequest request) {
        return StringUtil.isEmpty(request.getParameter("returnUrl"))?request.getHeader("Referer"):request.getParameter("returnUrl");
    }

    public static String getStringValues(HttpServletRequest request, String paramName) {
        String[] values = request.getParameterValues(paramName);
        if(Objects.isNull(values)) {
            return "";
        } else {
            String tmp = "";

            for(int i = 0; i < values.length; ++i) {
                if(i == 0) {
                    tmp = tmp + values[i];
                } else {
                    tmp = tmp + "," + values[i];
                }
            }

            return tmp;
        }
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

}
