/**
 * Copyright (c) 2015-2016, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tuu.springboot.util;


import cn.hutool.core.date.DateUtil;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 高频方法集合类
 */
public class ToolUtil {


    private static final String HTTPS = "https://";
    private static final String HTTP = "http://";
    private static final String WWW = "www.";

    /**
     * 搜索中文字符的转义符号
     */
    private static final Pattern compile = Pattern.compile("&#.*?;");

    /**
     * 获取随机位数的字符串
     *
     * @author fengshuonan
     * @Date 2017/8/24 14:09
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


    /**
     * 获取异常的具体信息
     *
     * @author fengshuonan
     * @Date 2017/3/30 9:21
     * @version 2.0
     */
    public static String getExceptionMsg(Exception e) {
        StringWriter sw = new StringWriter();
        try {
            e.printStackTrace(new PrintWriter(sw));
        } finally {
            try {
                sw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return sw.getBuffer().toString().replaceAll("\\$", "T");
    }

    /**
     * 比较两个对象是否相等。<br>
     * 相同的条件有两个，满足其一即可：<br>
     * 1. obj1 == null && obj2 == null; 2. obj1.equals(obj2)
     *
     * @param obj1 对象1
     * @param obj2 对象2
     * @return 是否相等
     */
    public static boolean equals(Object obj1, Object obj2) {
        return (obj1 != null) ? (obj1.equals(obj2)) : (obj2 == null);
    }

    /**
     * 计算对象长度，如果是字符串调用其length函数，集合类调用其size函数，数组调用其length属性，其他可遍历对象遍历计算长度
     *
     * @param obj 被计算长度的对象
     * @return 长度
     */
    public static int length(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length();
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).size();
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).size();
        }

        int count;
        if (obj instanceof Iterator) {
            Iterator<?> iter = (Iterator<?>) obj;
            count = 0;
            while (iter.hasNext()) {
                count++;
                iter.next();
            }
            return count;
        }
        if (obj instanceof Enumeration) {
            Enumeration<?> enumeration = (Enumeration<?>) obj;
            count = 0;
            while (enumeration.hasMoreElements()) {
                count++;
                enumeration.nextElement();
            }
            return count;
        }
        if (obj.getClass().isArray() == true) {
            return Array.getLength(obj);
        }
        return -1;
    }

    /**
     * 对象中是否包含元素
     *
     * @param obj     对象
     * @param element 元素
     * @return 是否包含
     */
    public static boolean contains(Object obj, Object element) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            if (element == null) {
                return false;
            }
            return ((String) obj).contains(element.toString());
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).contains(element);
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).values().contains(element);
        }

        if (obj instanceof Iterator) {
            Iterator<?> iter = (Iterator<?>) obj;
            while (iter.hasNext()) {
                Object o = iter.next();
                if (equals(o, element)) {
                    return true;
                }
            }
            return false;
        }
        if (obj instanceof Enumeration) {
            Enumeration<?> enumeration = (Enumeration<?>) obj;
            while (enumeration.hasMoreElements()) {
                Object o = enumeration.nextElement();
                if (equals(o, element)) {
                    return true;
                }
            }
            return false;
        }
        if (obj.getClass().isArray() == true) {
            int len = Array.getLength(obj);
            for (int i = 0; i < len; i++) {
                Object o = Array.get(obj, i);
                if (equals(o, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 对象是否不为空(新增)
     *
     * @param o String,List,Map,Object[],int[],long[]
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    /**
     * 对象是否为空
     *
     * @param o String,List,Map,Object[],int[],long[]
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            if (o.toString().trim().equals("")) {
                return true;
            }
        } else if (o instanceof List) {
            if (((List) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Set) {
            if (((Set) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Object[]) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof int[]) {
            if (((int[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof long[]) {
            if (((long[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof LinkedBlockingQueue) {
            if (((LinkedBlockingQueue) o).size() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象组中是否存在 Empty Object
     *
     * @param os 对象组
     * @return
     */
    public static boolean isOneEmpty(Object... os) {
        for (Object o : os) {
            if (isEmpty(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象组中是否全是 Empty Object
     *
     * @param os
     * @return
     */
    public static boolean isAllEmpty(Object... os) {
        for (Object o : os) {
            if (!isEmpty(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否为数字
     *
     * @param obj
     * @return
     */
    public static boolean isNum(Object obj) {
        try {
            Integer.parseInt(obj.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 如果为空, 则调用默认值
     *
     * @param str
     * @return
     */
    public static Object getValue(Object str, Object defaultValue) {
        if (isEmpty(str)) {
            return defaultValue;
        }
        return str;
    }

    /**
     * 格式化文本
     *
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param values   参数值
     * @return 格式化后的文本
     */

    /**
     * 格式化文本
     *
     * @param template 文本模板，被替换的部分用 {key} 表示
     * @param map      参数值对
     * @return 格式化后的文本
     */

    /**
     * 强转->string,并去掉多余空格
     *
     * @param str
     * @return
     */
    public static String toStr(Object str) {
        return toStr(str, "");
    }

    /**
     * 强转->string,并去掉多余空格
     *
     * @param str
     * @param defaultValue
     * @return
     */
    public static String toStr(Object str, String defaultValue) {
        if (null == str) {
            return defaultValue;
        }
        return str.toString().trim();
    }

    /**
     * 强转->int
     *
     * @param obj
     * @return
     */
//	public static int toInt(Object value) {
//		return toInt(value, -1);
//	}

    /**
     * 强转->int
     *
     * @param obj
     * @param defaultValue
     * @return
     */
//	public static int toInt(Object value, int defaultValue) {
//		return Convert.toInt(value, defaultValue);
//	}

    /**
     * 强转->long
     *
     * @param obj
     * @return
     */
//	public static long toLong(Object value) {
//		return toLong(value, -1);
//	}

    /**
     * 强转->long
     *
     * @param obj
     * @param defaultValue
     * @return
     */
//	public static long toLong(Object value, long defaultValue) {
//		return Convert.toLong(value, defaultValue);
//	}
//
//	public static String encodeUrl(String url) {
//		return URLKit.encode(url, CharsetKit.UTF_8);
//	}
//
//	public static String decodeUrl(String url) {
//		return URLKit.decode(url, CharsetKit.UTF_8);
//	}

    /**
     * map的key转为小写
     *
     * @param map
     * @return Map<String, Object>
     */
    public static Map<String, Object> caseInsensitiveMap(Map<String, Object> map) {
        Map<String, Object> tempMap = new HashMap<>();
        for (String key : map.keySet()) {
            tempMap.put(key.toLowerCase(), map.get(key));
        }
        return tempMap;
    }

    /**
     * 获取map中第一个数据值
     *
     * @param <K> Key的类型
     * @param <V> Value的类型
     * @param map 数据源
     * @return 返回的值
     */
    public static <K, V> V getFirstOrNull(Map<K, V> map) {
        V obj = null;
        for (Entry<K, V> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }

    /**
     * 创建StringBuilder对象
     *
     * @return StringBuilder对象
     */
    public static StringBuilder builder(String... strs) {
        final StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb;
    }

    /**
     * 创建StringBuilder对象
     *
     * @return StringBuilder对象
     */
    public static void builder(StringBuilder sb, String... strs) {
        for (String str : strs) {
            sb.append(str);
        }
    }

    /**
     * 去掉指定后缀
     *
     * @param str    字符串
     * @param suffix 后缀
     * @return 切掉后的字符串，若后缀不是 suffix， 返回原字符串
     */
    public static String removeSuffix(String str, String suffix) {
        if (isEmpty(str) || isEmpty(suffix)) {
            return str;
        }

        if (str.endsWith(suffix)) {
            return str.substring(0, str.length() - suffix.length());
        }
        return str;
    }



    /**
     * 判断是否是windows操作系统
     *
     * @author stylefeng
     * @Date 2017/5/24 22:34
     */
    public static Boolean isWinOs() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取临时目录
     *
     * @author stylefeng
     * @Date 2017/5/24 22:35
     */
    public static String getTempPath() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     * 把一个数转化为int
     *
     * @author fengshuonan
     * @Date 2017/11/15 下午11:10
     */
    public static Integer toInt(Object val) {
        if (val instanceof Double) {
            BigDecimal bigDecimal = new BigDecimal((Double) val);
            return bigDecimal.intValue();
        } else {
            return Integer.valueOf(val.toString());
        }

    }

    /**
     * 获取项目路径
     */
    public static String getWebRootPath(String filePath) {
        try {
            String path = ToolUtil.class.getClassLoader().getResource("").toURI().getPath();
            path = path.replace("/WEB-INF/classes/", "");
            path = path.replace("/target/classes/", "");
            path = path.replace("file:/", "");
            if (ToolUtil.isEmpty(filePath)) {
                return path;
            } else {
                return path + "/" + filePath;
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取文件后缀名 不包含点
     */
    public static String getFileSuffix(String fileWholeName) {
        if (ToolUtil.isEmpty(fileWholeName)) {
            return "none";
        }
        int lastIndexOf = fileWholeName.lastIndexOf(".");
        return fileWholeName.substring(lastIndexOf + 1);
    }

    /**
     * 根据短信内容长度获取短信条数
     * 70个汉字以内都是1条， 70个汉字以上，67个汉字算一条短信。
     */
    public static int getSMSCountByContent(String content) {
        int length = 0;
        int contentLength = content.length();
        if (contentLength <= 70) {
            length = 1;
        } else if (contentLength > 70) {
            length = new BigDecimal(contentLength).divide(new BigDecimal(67), 0, BigDecimal.ROUND_UP).intValue();
        }

        return length;
    }

    /**
     * 字符串组转整型后是否存在空或小于0
     *
     * @param os 对象组
     * @return
     */
    public static boolean isOneEmptyOrLessThan0(String... os) {
        for (Object o : os) {
            Integer integer = ToolUtil.toInt(o);
            if (isEmpty(integer) || integer.intValue() < 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLessThan0(Long l) {
        if(l<0){
            return true;
        }
        return false;
    }


    /**
     * 保留三位小数  不省略末尾的0
     *
     * @param obj
     * @return
     * @author WangQiang
     * @date 2019年3月20日 下午3:46:24
     */
    public static String formatToNumber(BigDecimal obj) {
        DecimalFormat df = new DecimalFormat("#.000");
        if (obj.compareTo(BigDecimal.ZERO) == 0) {
            return "0.000";
        } else if (obj.compareTo(BigDecimal.ZERO) > 0 && obj.compareTo(new BigDecimal(1)) < 0) {
            return "0" + df.format(obj).toString();
        } else if (obj.compareTo(new BigDecimal(-1)) > 0 && obj.compareTo(BigDecimal.ZERO) < 0) {
            return df.format(obj).toString().replace("-", "-0");
        } else {
            return df.format(obj).toString();
        }
    }

    /**
     * 保留前几位和后几位，剩下的字符串星号表示   要求前后保留的位数要一直才可以使用
     *
     * @param string 字符串
     * @param index  前面保留的位数
     * @return 返回数据
     */
    public  static String getAsteriskData(String string, int index) {
        char[] m = string.toCharArray();
        int length = index * 2;
        if (m.length > length) {
            int min = index - 1;
            int max = m.length - index;
            for (int i = 0; i < m.length; i++) {
                if (i > min && i < max) {
                    m[i] = '*';
                }
            }
            string = String.valueOf(m);
        }
        return string;
    }




    /**
     * 截取内容中http链接
     * @param content 正文
     * @param list
     * @return
     */
    public static Set<String> splitHttp(String content,List<String> list){
		Set<String> set = new HashSet<>();
		if(ToolUtil.isNotEmpty(list)){
            list.forEach(s -> {
                int count = 0;
                checkContent(set,content, s,count);
            });
        }
        return set;
    }

    /**
     * 迭代检测内容
	 * @param content
     * @param set
     * @param s
     */
    private static void checkContent(Set<String> set,String content, String s,int count) {
        count++;
        int index = content.indexOf(s);
        if (index != -1) {
            String url = processStr(content, index);
            if (null != url && !url.equals("")) {
                content = content.replace(url, "");
                if (null != url && !url.equals("")) {
                    set.add(url);
                }
                if (count < 3) {
                    checkContent(set,content, s, count);
                }
            }
        }
    }

    private static String processStr(String content, int index) {
        int startIndex = 0;
        int endIndex = content.length();

        for (int i = index; i > startIndex; i--) {
            int code = (int) content.charAt(i);
            if (code < 0 || code > 126) {
                startIndex = i;
                break;
            } else if (!isUrlChar(content.charAt(i) + "")) {
                startIndex = i;
                break;
            }
        }

        for (int i = index; i < endIndex; i++) {
            int code = (int) content.charAt(i);
            if (code < 0 || code > 126) {
                endIndex = i;
                break;
            } else if (!isUrlChar(content.charAt(i) + "")) {
                endIndex = i;
                break;
            }
        }

        String url = content.substring(startIndex + 1, endIndex);
        return url;
    }


    private static boolean isUrlChar(String str) {
        String regex = "^[a-z0-9A-Z:/.?&=_@%#$!-+]+$";
        return str.matches(regex);
    }

    /**
     * 将html转义序列转为中文 例：&#39318;&#39029; ---> 首页
     * @param htmlContent
     */
    public static String transferHtmlEscape(String htmlContent){
        // 定义正则表达式来搜索中文字符的转义符号
        Matcher matcher = compile.matcher(htmlContent);

        // 循环搜索 并转换 替换
        while (matcher.find()) {
            String group = matcher.group();
            // 获得16进制的码
            String hexcode = group.replaceAll("(&#|;)", "");
            // 字符串形式的16进制码转成int并转成char 并替换到源串中
            htmlContent = htmlContent.replaceAll(group, (char) Integer.decode(hexcode).intValue() + "");
        }
        return htmlContent;
    }


    public static void main(String[] args) {
        String data = "【摩氏黑咖啡】夏日不敢秀腰？没事！每天喝一杯摩氏黑咖，小跑1公里，助你快速瘦腰！ 复制链接进淘－宝买来试试吧！8460854@qq.com退订回T";
        List list = new ArrayList();
        list.add("https:");
        list.add(".cn");
		list.add(".com");
		Set<String> resultSet = splitHttp(data,list);
		for (String str : resultSet) {
			if (str.contains("@") && str.contains(".com")) {
                System.out.println("可能包含邮箱" + str);
			} else {
				System.out.println(str);
			}
		}

    }
}