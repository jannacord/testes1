package mainJson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class RetornoJson {

        public static String converterJSON(Object value){

            ObjectMapper mapper = new ObjectMapper().enable( SerializationFeature.INDENT_OUTPUT).setSerializationInclusion( JsonInclude.Include.NON_NULL);
            try {
                return mapper.writeValueAsString(value);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


