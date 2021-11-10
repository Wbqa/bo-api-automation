package com.drivewealth.coretrade.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.openqa.selenium.json.Json;

import java.util.List;
import java.util.Map;

public class JsonUtil {

    private static Configuration config = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
                                            .mappingProvider(new JacksonMappingProvider()).build();

    public String deleteElementsFromJson(String jsonPayload, List<String> jsonPathList) {
        for (String jsonPath : jsonPathList)
            jsonPayload = deleteElementFromJson(jsonPayload, jsonPath);
        return jsonPayload;
    }

    public String deleteElementFromJson(String jsonPayload, String jsonPath) {
        DocumentContext context = JsonPath.using(config).parse(jsonPayload);
        context.delete(jsonPath);
        return context.jsonString();
    }

    public String updateValuesToJson(String jsonPayload, Map<String, String> jsonPathValueMap) {
        for (String key : jsonPathValueMap.keySet())
            jsonPayload = updateValueToJson(jsonPayload, key, jsonPathValueMap.get(key));
        return jsonPayload;
    }

    public String updateValueToJson(String jsonPayload, String jsonPath, String value) {
        DocumentContext context = JsonPath.using(config).parse(jsonPayload);
        return context.set(jsonPath,value).jsonString();
    }

    public <T> T readElementsFromJson(String jsonPayload, String jsonPath, Predicate... filters) {
        if (filters == null)
            return JsonPath.using(config).parse(jsonPayload).read(jsonPath);

        return JsonPath.using(config).parse(jsonPayload).read(jsonPath, filters);
    }

    public <T> T readFromJson(String jsonPayload, String jsonPath, Class<T> clazz, Predicate... filters) {
        return JsonPath.using(config).parse(jsonPayload).read(jsonPath,clazz,filters);
    }

    public static <T> T fromJson(String json,  Class<T> clazz) throws RuntimeException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, clazz);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isValidJson(String json) {
        try {
            new ObjectMapper().readTree(json);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    public static <T> String toJson(T object) throws RuntimeException {
        return toJson(object,false,true);
    }

    public static <T> String toJson(T object, boolean validate, boolean excludeNullValues) throws RuntimeException {
        try {
            if (object == null)
                return null;

            ObjectMapper mapper = new ObjectMapper();
            if (excludeNullValues)
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsString(object);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
