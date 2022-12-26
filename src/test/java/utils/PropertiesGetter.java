package utils;

import java.util.Properties;

public class PropertiesGetter {
  static private final String PATH = "./testData.properties";
  static Properties properties;

  static public String get(String key) {
    if (properties == null) {
      try {
        properties = new Properties();
        properties.load(PropertiesGetter.class.getClassLoader().getResourceAsStream(PATH));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return properties.getProperty(key);
  }
}
