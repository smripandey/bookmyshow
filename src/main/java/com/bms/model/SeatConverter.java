package com.bms.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SeatConverter implements DynamoDBTypeConverter<String, List<Seat>>{

	ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public String convert(List<Seat> objects) {
		
		try {
			String objectAsString = objectMapper.writeValueAsString(objects);
			return objectAsString;
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Seat> unconvert(String objectString) {
		try {
			List<Seat> objects = objectMapper.readValue(objectString, new TypeReference<List<Seat>>(){});
			return objects;
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
