package com.wonpera.cq.common.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wonpera.cq.common.constats.GlobConts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangpeng on 2016/12/13.
 */
public class SysDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat(GlobConts.DEFAULT_FORMATTER_YYYYMMDDHHMMSS);
        jgen.writeString(sdf.format(value));
    }
}
