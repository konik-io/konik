package io.konik.sdk.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateTimeDeserializer extends JsonDeserializer<Date> {

  @Override
  public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    String dateAsString = jsonParser.readValueAs(String.class);
    Date date = null;
    try {
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      date = dateFormat.parse(dateAsString);
    } catch (ParseException e) {
      throw new DateTimeDeserializerException(e);
    }

    return date;
  }
}
