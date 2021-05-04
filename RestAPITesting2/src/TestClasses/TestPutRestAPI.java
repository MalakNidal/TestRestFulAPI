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

public class TestPutRestAPI
{

	@Test
	public void testUpdateUser() throws Exception
	{
		// 1. Open Connection --- HttpURLConnection
		String URL = URLs.ReqResAPI+"/2";
		HttpURLConnection connection = RestClientHandler.connectServer(URL, HTTPMethod.PUT,
				HTTPRequestsContentTypes.JSON);
		
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.UpdateUserJSONFile);
		System.out.println(resquestJSONObject);
		
		// 3. Post Request
		RestClientHandler.sendPut(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		
		// 4. Reading Response
		System.out.println(connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
				
		assertTrue("Unable to connect to webservice", connection.getResponseCode() == 200);
	}
	
	@Test
	public void testEmptyUpdateUser() throws Exception
	{
		// 1. Open Connection --- HttpURLConnection
		String URL = URLs.ReqResAPI+"/2";
		HttpURLConnection connection = RestClientHandler.connectServer(URL, HTTPMethod.PUT,
				HTTPRequestsContentTypes.JSON);
		
		// 2. Prepare Json Object
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.EmptyUpdateUserJSONFile);
		System.out.println(resquestJSONObject);
		
		// 3. Post Request
		RestClientHandler.sendPut(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		
		// 4. Reading Response
		System.out.println(connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
				
		assertTrue("Unable to connect to webservice", connection.getResponseCode() == 200);
	}

}
