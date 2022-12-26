package tests.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.WithAssertions;

public class BaseAPITest implements WithAssertions {
  ObjectMapper mapper;

  protected void prettyPrint(Object object) {
    if(mapper == null) {
       mapper = new ObjectMapper();
    }
    try {
      String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
