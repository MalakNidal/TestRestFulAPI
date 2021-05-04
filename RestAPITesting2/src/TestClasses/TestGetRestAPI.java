package TestClasses;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestGetRestAPI
{
	
	@Test
	public void TestGetListUsers() throws IOException, ParseException
	{
		// 1. Open Connection --- HttpURLConnection
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.ReqResAPIListUsers, HTTPMethod.GET,
				HTTPRequestsContentTypes.JSON);
		
		// 2. validate if the connection is successfully opened
		System.out.println("Connection.getResponseCode() : " + connection.getResponseCode());
		assertTrue("Unable to connect to webservice", connection.getResponseCode() == 200);
		
		// 3. reading response using input stream
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
		assertNotNull(response);

		JSONObject jsonObject = (JSONObject) JSONUtils.convertStringToJSON(response);
		String data = jsonObject.get("data").toString();
		System.out.println("data=" + data);
	}
	
	
	@Test
	public void TestGetSingelUser() throws Exception
	{
		// 1. Open Connection --- HttpURLConnection
		String URL = URLs.ReqResAPI+"/2";
		System.out.println(URL);		
		HttpURLConnection connection = RestClientHandler.connectServer(URL, HTTPMethod.GET,
				HTTPRequestsContentTypes.JSON);
		
		// 2. Reading Response
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
		
		// 3. convert String to JSON
		JSONObject jsonObject = (JSONObject) JSONUtils.convertStringToJSON(response);
		System.out.println(jsonObject);
		String data = jsonObject.get("data").toString();
		System.out.println("data=" + data);
		String firstName = ((JSONObject) jsonObject.get("data")).get("first_name").toString();
		System.out.println("first name=" + firstName);	
		String supportText ="To keep ReqRes free, contributions towards server costs are appreciated!";
		String supportTextAPI =((JSONObject) jsonObject.get("support")).get("text").toString();
		System.out.println("support Text of API= " + supportTextAPI);
		supportText.equals(supportTextAPI);
	}
	
	
	
	@Test
	public void TestGetSingleUserNotFound() throws Exception
	{
		// 1. Open Connection --- HttpURLConnection
		String URL = URLs.ReqResAPI+"/23";
		System.out.println(URL);		
		HttpURLConnection connection = RestClientHandler.connectServer(URL, HTTPMethod.GET,
				HTTPRequestsContentTypes.JSON);		
		
		
		System.out.println("Connection.getResponseCode() : " + connection.getResponseCode());
		assertTrue(connection.getResponseCode() == 404);
	}
	
}
