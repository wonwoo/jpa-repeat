package me.wonwoo.exam14.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by wonwoo on 2016. 7. 6..
 */
@Converter(autoApply = true)
public class BooleanToYNConverter implements AttributeConverter<Boolean, String> {

  public String convertToDatabaseColumn(Boolean attribute) {
    return (attribute != null && attribute) ? "Y" : "N";
  }

  public Boolean convertToEntityAttribute(String s) {
    return "Y".equals(s);
  }
}
