package com.tuu.springboot.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import com.google.gson.Gson;

public class StringUtil {
	
	/**
	 * 将对象转为json字符串
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj)
	{
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
    /**
     * 字符串是否为空，有一个为空就返回true
     *
     * @param strs
     * @return 为空-true
     */
    public static boolean empty(String... strs) {
        for (String str : strs) {
            if (str == null || str.trim().equals("")) {
				return true;
			}
        }

        return false;
    }
    
    /**
     * 1-9
     * @param str
     * @return
     */
    public static final boolean isInteger(String str) {
        Pattern p = Pattern.compile("[1-9]\\d*");
        Matcher m = p.matcher(str);
        return m.matches();
    }
    
    /**
     * 0-9
     * @param str
     * @return
     */
    public static final boolean isIntegers(String str) {
    	Pattern p = Pattern.compile("[0-9]\\d*");
    	Matcher m = p.matcher(str);
    	return m.matches();
    }

    public static final String nvl(String src, String defaultValue) {
        if ((src != null) && (src.length() > 0)) {
            return src;
        }
        return defaultValue;
    }

    /**
     * 转换字符串为int类型
     *
     * @param src
     * @return
     */
    public static final int toInt(String src) {
        return toInt(src, 0);
    }

    /**
     * 转换字符串为int类型
     *
     * @param src
     * @param defaultValue
     * @return
     */
    public static final int toInt(String src, int defaultValue) {
        if (!StringUtils.isEmpty(src)) {
            try {
                return Integer.parseInt(src);
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    /**
     * 公用trim方法
     *
     * @param val
     * @return
     */
    public static final String trim(String val) {
        if (!StringUtils.isEmpty(val)) {
            return val.trim();
        }
        return val;
    }

    public static final String nvl(String src) {
        return nvl(src, "");
    }

    /**
     * 组装字符串
     *
     * @param args
     * @return
     */
    public static String join(String[] args) {
        if (args != null && args.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (String s : args) {
                sb.append(",").append("'").append(s).append("'");
            }
            sb.deleteCharAt(0);
            return sb.toString();
        }
        return null;
    }

    /**
     * 是否全是汉字
     *
     * @param str
     * @return
     */
    public static boolean isChineseChar(String str) {
        Pattern p = Pattern.compile("^[\u4e00-\u9fa5]{0,}$");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static String join(Long[] args) {
        if (args != null && args.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (Long l : args) {
                sb.append(",").append(l);
            }
            sb.deleteCharAt(0);
            return sb.toString();
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public static String join(List list, String separator) {
        if (list != null && list.size() != 0) {
            separator = separator == null ? "" : separator;
            StringBuilder sb = new StringBuilder();
            for (Object o : list) {
                sb.append(",").append(separator).append(o).append(separator);
            }
            sb.deleteCharAt(0);
            return sb.toString();
        }
        return "";
    }

    public static boolean isHtml(String input) {
        boolean isHtml = false;
        if (input != null) {
            if (!input.equals(HtmlUtils.htmlEscape(input))) {
                isHtml = true;
            }
        }
        return isHtml;
    }
    /**
     * 判断是否存在
     *
     * @param regex
     * @param content
     * @return boolean
     * @Title: PatterMatcher
     * @Description: 判断是否存在
     */
    public static boolean PatterMatcher(boolean multiline, String regex, String content) {
        if (StringUtil.empty(content)) {
            return false;
        }
        Matcher matcher = PatternUtil.getPattern(multiline, regex).matcher(content);
        if (matcher.find()) {
            return true;
        }

        return false;
    }

    public static boolean PatterMatcher(String regex, String content) {
        if (StringUtil.empty(content)) {
            return false;
        }
        Matcher matcher = PatternUtil.getPattern(regex).matcher(content);
        if (matcher.find()) {
            return true;
        }

        return false;
    }

    public static final Double parseDouble(String src, Double defaultValue) {
        try {
            if (StringUtil.empty(src) || src.equals("null")) {
                return defaultValue;
            }
            return Double.parseDouble(src);
        } catch (NumberFormatException e) {
        }
        return defaultValue;
    }

    public static final Double parseDouble(String src) {
        return parseDouble(src, 0d);
    }

    public static final int parseInt(String src, int defaultValue) {
        if (StringUtil.empty(src) || src.equals("null")) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(src);
        } catch (NumberFormatException e) {
        }
        return defaultValue;
    }

    public static final int parseInt(String src) {
        try {
            return parseInt(src, 0);
        } catch (Exception e) {

        }
        return 0;
    }

    public static final Long parseLong(String src, Long defaultValue) {
        try {
            if (StringUtil.empty(src) || src.equals("null")) {
                return defaultValue;
            }
            return Long.parseLong(src);
        } catch (NumberFormatException e) {
        }
        return defaultValue;
    }

    public static final Long parseLong(String src) {
        return parseLong(src, 0l);
    }

    /**
     * @param A, B: Two strings.
     * @return: the length of the longest common substring.
     */
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        int maxlen = 0;
        int xlen = A.length();
        int ylen = B.length();
        for (int i = 0; i < xlen; ++i) {
            for (int j = 0; j < ylen; ++j) {
                int len = 0;
                while (i + len < xlen && j + len < ylen &&
                       A.charAt(i + len) == B.charAt(j + len)) {
                    len++;
                }
                if (len > maxlen) {
					maxlen = len;
				}
            }
        }
        return maxlen;
    }

    public static boolean isLetterOrDigit(String s){
        Pattern pattern = Pattern.compile("[0-9A-Za-z:]*");
        Matcher isLetterOrDigit = pattern.matcher(s);
        return isLetterOrDigit.matches();
    }

    public static boolean isDigitOnly(String s){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isLetterOnly = pattern.matcher(s);
        return isLetterOnly.matches();
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        String b = join(list, "'");
        System.out.println(b);
        String str = "#$%^&*";
        System.out.println(isChineseChar(str));
        System.out.println(HtmlUtils.htmlEscape("<fei.lu@qingmayun.com"));
    }
}