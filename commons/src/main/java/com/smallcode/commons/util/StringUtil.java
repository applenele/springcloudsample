package com.smallcode.commons.util;



import com.smallcode.commons.consts.Strings;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static Random RANDOM = new Random(System.currentTimeMillis());

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static String nullToEmpty(String value) {
        return value == null ? Strings.EMPTY : value;
    }

    public static boolean isEmpty(String... values) {
        if (values != null && values.length > 0) {
            for (String value : values) {
                if (value == null || value.length() == 0) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isNotEmpty(String... values) {
        if (values != null && values.length > 0) {
            for (String value : values) {
                if (value == null || value.length() == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String emptyToDefault(String value, String def) {
        return isEmpty(value) ? def : value;
    }

    public static String getPropertyName(String... values) {
        return concate(values, ".");
    }

    public static String concate(String[] values, String delimiter) {
        if (values != null && values.length > 0) {
            if (delimiter == null) {
                delimiter = Strings.EMPTY;
            }
            int length = 0;
            for (String value : values) {
                if (value != null) {
                    length += (value.length() + delimiter.length());
                }
            }

            StringBuilder buff = new StringBuilder(length);
            for (String value : values) {
                if (isNotEmpty(value)) {
                    if (buff.length() > 0) {
                        buff.append(delimiter);
                    }
                    buff.append(value);
                }
            }

            return buff.toString();
        }

        return Strings.EMPTY;
    }


    public static boolean equals(String var1, String var2) {
        return var1 != null && var1.equals(var2);
    }

    public static boolean notEquals(String var1, String var2) {
        return !equals(var1, var2);
    }


    public static String normalize(String value) {
        if (isNotEmpty(value)) {
            return value.toLowerCase().trim();
        }

        return Strings.EMPTY;
    }

    public static String clearHTMLTag(String inputString, int stringLenth) {
        if (inputString == null) {
            return null;
        }

        Pattern p_script;
        Matcher m_script;
        Pattern p_style;
        Matcher m_style;
        Pattern p_html;
        Matcher m_html;
        try {
            //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?/[\\s]*?script[\\s]*?>";
            //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?/[\\s]*?style[\\s]*?>";
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(inputString);
            inputString = m_script.replaceAll(""); // 过滤script标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(inputString);
            inputString = m_style.replaceAll(""); // 过滤style标签
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(inputString);
            inputString = m_html.replaceAll(""); // 过滤html标签
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        if (inputString.length() > stringLenth) {
            return inputString.substring(0, stringLenth);// 返回文本字符串
        } else {
            return inputString;// 返回文本字符串
        }
    }


    public static String trim(String source) {
        return StringUtil.isEmpty(source) ? source : source.trim();
    }
}
