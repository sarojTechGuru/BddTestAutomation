package com.UI.Utilities;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
	private static JsonNode rootnode;
	static {
		ObjectMapper obj = new ObjectMapper();
		try {
			rootnode = obj.readTree(new File("src/test/resources/TestData/TestData.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getTtextValue(String variableName) {
		return rootnode.path(variableName).asText();
	}

	public static int getIntValue(String variableName) {
		return rootnode.path(variableName).asInt();
	}

	public static String getNestedValue(String path, String variableName) {
		return rootnode.path(path).path(variableName).asText();
	}

}
