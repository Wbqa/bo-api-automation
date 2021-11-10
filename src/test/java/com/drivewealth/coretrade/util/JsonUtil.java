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

public class JsonUtil {

    private static Configuration config = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
                                            .mappingProvider(new JacksonMappingProvider()).build();

    public String writeValueToJson(String jsonPayload, String jsonPath, String value) {
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

    public static <T> T fromJson(String json,  Class<T> clazz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,clazz);
    }

    public static <T> String toJson(T object) throws JsonProcessingException {
        return toJson(object,false,true);
    }

    public static <T> String toJson(T object, boolean validate, boolean excludeNullValues) throws JsonProcessingException {
        if (object == null)
            return null;

        ObjectMapper mapper = new ObjectMapper();
        if (excludeNullValues)
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(object);
    }
}
