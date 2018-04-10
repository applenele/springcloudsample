package com.smallcode.commons.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallcode.commons.consts.Strings;

import java.util.*;

public class JsonUtil {


    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.findAndRegisterModules();
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        //OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        // 为避免对反序列化造成影响，暂时不使用 OBJECT_MAPPER.disable(MapperFeature.DEFAULT_VIEW_INCLUSION)
        OBJECT_MAPPER.setConfig(OBJECT_MAPPER.getSerializationConfig().without(MapperFeature.DEFAULT_VIEW_INCLUSION));
    }

    public static String toString(Object obj) {
        return toString(null, obj);
    }

    public static String toString(Class<?> view, Object obj) {
        try {
            return view == null ? OBJECT_MAPPER.writeValueAsString(obj) : OBJECT_MAPPER.writerWithView(view).writeValueAsString(obj);
        } catch (Throwable e) {
            System.out.println(e.getStackTrace());
        }

        return Strings.EMPTY;
    }

    public static byte[] toByteArray(Object obj) {
        return toByteArray(null, obj);
    }

    public static byte[] toByteArray(Class<?> view, Object obj) {
        try {
            return view == null ? OBJECT_MAPPER.writeValueAsBytes(obj) : OBJECT_MAPPER.writerWithView(view).writeValueAsBytes(obj);
        } catch (Throwable e) {
            System.out.println(e.getStackTrace());
        }

        return new byte[]{};
    }

    public static <T> T toObject(Class<T> clazz, String json) {
        if (clazz != null && StringUtil.isNotEmpty(json)) {
            try {
                return OBJECT_MAPPER.readValue(json, clazz);
            } catch (Throwable e) {
                System.out.println(e.getStackTrace());
            }
        }
        return null;
    }



    public static <T> List<T> toList(Class<T> clazz, String json) {
        if (clazz != null && StringUtil.isNotEmpty(json)) {
            try {
                return OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
            } catch (Throwable e) {
                System.out.println(e.getStackTrace());
            }
        }
        return Collections.emptyList();
    }

    public static <T> Set<T> toSet(Class<T> clazz, String json) {
        if (clazz != null && StringUtil.isNotEmpty(json)) {
            try {
                return OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructCollectionType(HashSet.class, clazz));
            } catch (Throwable e) {
                System.out.println(e.getStackTrace());
            }
        }
        return Collections.emptySet();
    }

    public static <K, V> Map<K, V> toMap(String json) {
        if (StringUtil.isNotEmpty(json)) {
            try {
                return OBJECT_MAPPER.readValue(json, new TypeReference<Map<K, V>>() {
                });
            } catch (Throwable e) {
                System.out.println(e.getStackTrace());
            }
        }
        return Collections.emptyMap();
    }


    public static JsonNode toJsonNode(String json) {
        if (StringUtil.isNotEmpty(json)) {
            try {
                return OBJECT_MAPPER.readTree(json);
            } catch (Throwable e) {
                System.out.println(e.getStackTrace());
            }
        }
        return null;
    }

    public static JsonNode toJsonNode(String json, String fieldName) {
        if (StringUtil.isNotEmpty(json) && StringUtil.isNotEmpty(fieldName)) {
            try {
                JsonNode jsonNode = OBJECT_MAPPER.readTree(json);
                return jsonNode.findPath(fieldName);
            } catch (Throwable e) {
                System.out.println(e.getStackTrace());
            }
        }
        return null;
    }

}
