package com.rookie.rabbit.modular.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.List;


/**
 * @author rookie
 */
public class JsonUtils {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 获取json字符串
	 *
	 * @param object 任意类型
	 * @return 结果
	 */
	public static String getJsonString(Object object) {
		try {
			JavaTimeModule timeModule = new JavaTimeModule();
			timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
			MAPPER.registerModule(timeModule);
			return MAPPER.writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取java对象
	 *
	 * @param json  字符串
	 * @param clazz 需要转换的类型
	 * @return java对象
	 */
	public static <T> T getBean(String json, Class<T> clazz) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaTimeModule timeModule = new JavaTimeModule();
			timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
			mapper.registerModule(timeModule);
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 获取java集合
	 *
	 * @param json  字符串
	 * @param clazz 需要获取的java类型
	 * @return 结果
	 */
	public static <T> List<T> getBeanList(String json, Class<T> clazz) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaTimeModule timeModule = new JavaTimeModule();
			timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
			mapper.registerModule(timeModule);
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, clazz);
			return mapper.readValue(json, javaType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取java对象
	 * @param o 参数
	 * @param clazz 需要获取的java类型
	 * @return 结果
	 */
	public static <T> T getObject(Object o, Class<T> clazz) {
		String obj = getJsonString(o);
		return getBean(obj, clazz);
	}

	/**
	 * 获取java的集合
	 * @param o 参数
	 * @param clazz 获取的参数类型
	 * @return 结果
	 */
	public static <T> List<T> getListObject(Collection<?> o, Class<T> clazz) {
		String obj = getJsonString(o);
		return getBeanList(obj, clazz);
	}

	/**
	 * 获取java集合
	 * @param o 参数
	 * @param clazz 获取的参数类型
	 * @return 获取的参数类型
	 */
	public static <T> List<T> getListObject(Object o, Class<T> clazz) {
		String obj = getJsonString(o);
		return getBeanList(obj, clazz);
	}


	public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
		@Override
		public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
			jsonGenerator.writeNumber(localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
		}
	}

	public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
		@Override
		public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
			long timestamp = jsonParser.getLongValue();
			return LocalDateTime.ofEpochSecond(timestamp / 1000, 0, ZoneOffset.ofHours(8));
		}
	}
}