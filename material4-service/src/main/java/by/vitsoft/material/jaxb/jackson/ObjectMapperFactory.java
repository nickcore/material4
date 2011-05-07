package by.vitsoft.material.jaxb.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.DeserializationConfig;

//https://svn.codehaus.org/jackson/tags/1.6/1.6.0/src/test/org/codehaus/jackson/map/ser/TestEnumSerialization.java
public class ObjectMapperFactory {
    public static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
        mapper.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, true);
        return mapper;
    }

}
