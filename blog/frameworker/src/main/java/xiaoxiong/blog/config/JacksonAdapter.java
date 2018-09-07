package xiaoxiong.blog.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import xiaoxiong.blog.result.ResultMsg;

import java.io.IOException;


/**
 * 配置处理返回的json
 * 解决ResultMsg  Page 与@jsonview 格式不对的问题
 */
@Configuration
public class JacksonAdapter extends WebMvcConfigurerAdapter {
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        return  new Jackson2ObjectMapperBuilder()
                .failOnUnknownProperties(false)
                .serializationInclusion(Include.NON_EMPTY)
                .serializerByType(ResultMsg.class, new JsonMsgSerializer())
                .serializerByType(Page.class, new JsonPageSerializer());

    }

    /**
     * Page 与@jsonview矛盾
     * @param <T>
     */
    public class JsonPageSerializer<T> extends JsonSerializer<T> {

        @Override
        public void serialize(Object o, JsonGenerator jsonGen, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            Page page = (Page) o;

            ObjectMapper om=new ObjectMapper()
                    //开启传递性 同时兼顾Page 和 ResultMsg
                    .enable(MapperFeature.DEFAULT_VIEW_INCLUSION)
                    .setSerializationInclusion(Include.NON_EMPTY);
            jsonGen.writeStartObject();
            jsonGen.writeFieldName("size");
            jsonGen.writeNumber(page.getSize());
            jsonGen.writeFieldName("number");
            jsonGen.writeNumber(page.getNumber());
            jsonGen.writeFieldName("totalElements");
            jsonGen.writeNumber(page.getTotalElements());
            jsonGen.writeFieldName("last");
            jsonGen.writeBoolean(page.isLast());
            jsonGen.writeFieldName("totalPages");
            jsonGen.writeNumber(page.getTotalPages());
            jsonGen.writeObjectField("sort", page.getSort());
            jsonGen.writeFieldName("first");
            jsonGen.writeBoolean(page.isFirst());
            jsonGen.writeFieldName("numberOfElements");
            jsonGen.writeNumber(page.getNumberOfElements());
            jsonGen.writeFieldName("content");
            jsonGen.writeRawValue(om.writerWithView(serializerProvider.getActiveView())
                    .writeValueAsString(page.getContent()));
            jsonGen.writeEndObject();
            jsonGen.close();
        }
    }

    /**
     * ResultMsg 与jsonview矛盾
     * @param <T>
     */
    public class JsonMsgSerializer<T> extends JsonSerializer<T> {

        @Override
        public void serialize(Object o, JsonGenerator jsonGen, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            ResultMsg resultMsg = (ResultMsg) o;
            ObjectMapper om=new ObjectMapper()
                    .enable(MapperFeature.DEFAULT_VIEW_INCLUSION)
                    .setSerializationInclusion(Include.NON_EMPTY);
            jsonGen.writeStartObject();
            jsonGen.writeFieldName("code");
            jsonGen.writeNumber(resultMsg.getCode());
            jsonGen.writeFieldName("message");
            jsonGen.writeString(resultMsg.getMessage());
            if(resultMsg.getObj() != null) {
                jsonGen.writeFieldName("obj");
                jsonGen.writeRawValue(om.writerWithView(serializerProvider.getActiveView())
                        .writeValueAsString(resultMsg.getObj()));
            }
            jsonGen.writeEndObject();
        }
    }
}


