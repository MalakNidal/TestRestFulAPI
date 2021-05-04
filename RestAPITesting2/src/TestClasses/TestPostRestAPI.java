package TestClasses;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestPostRestAPI
{

	@Test
	public void testCreateUser() throws Exception
	{
		// 1. Open Connection --- HttpURLConnection
		String URL = URLs.ReqResAPI;
		HttpURLConnection connection = RestClientHandler.connectServer(URL, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.CreateUserJSONFile);
		System.out.println(resquestJSONObject);
		
		// 3. Post Request
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		
		// 4. Reading Response
		System.out.println(connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
				
		assertTrue(connection.getResponseCode() == 201);
	}
	
	
	@Test
	public void testSuccessLogIn() throws Exception
	{
		// 1. Open Connection --- HttpURLConnection
		String URL = URLs.ReqResAPIlogin;
		HttpURLConnection connection = RestClientHandler.connectServer(URL, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.LogInSuccessfullyJSONFile);
		System.out.println(resquestJSONObject);
		
		// 3. Post Request
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		
		// 4. Reading Response
		System.out.println(connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
				
		assertTrue(connection.getResponseCode() == 200);
	}
	
	
	@Test
	public void testUnSuccessLogIn() throws Exception
	{
		// 1. Open Connection --- HttpURLConnection
		String URL = URLs.ReqResAPIlogin;
		HttpURLConnection connection = RestClientHandler.connectServer(URL, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.LogInUnSuccessfullyJSONFile);
		System.out.println(resquestJSONObject);
		
		// 3. Post Request
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		
		// 4. Reading Response
		System.out.println(connection.getResponseCode());
				
		assertTrue(connection.getResponseCode() == 400);
	}
	
	
	@Test
	public void testSuccessRegister() throws Exception
	{
		// 1. Open Connection --- HttpURLConnection
		String URL = URLs.ReqResAPIregister;
		HttpURLConnection connection = RestClientHandler.connectServer(URL, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.RegisterSuccessfullyJSONFile);
		System.out.println(resquestJSONObject);
		
		// 3. Post Request
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		
		// 4. Reading Response
		System.out.println(connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
				
		assertTrue(connection.getResponseCode() == 200);
	}
	
	
	@Test
	public void testUnSuccessRegister() throws Exception
	{
		// 1. Open Connection --- HttpURLConnection
		String URL = URLs.ReqResAPIregister;
		HttpURLConnection connection = RestClientHandler.connectServer(URL, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.RegisterUnSuccessfullyJSONFile);
		System.out.println(resquestJSONObject);
		
		// 3. Post Request
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		
		// 4. Reading Response
		System.out.println(connection.getResponseCode());
				
		assertTrue(connection.getResponseCode() == 400);
	}

}
