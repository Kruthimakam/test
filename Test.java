package com.javaRestApi.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		try {
            URL url = new URL("https://reqres.in/api/users/5");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.addRequestProperty("User-Agent", "Chrome");
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                JSONObject json = new JSONObject(output); 
                JSONObject Data = (JSONObject) json.get("data");      
                System.out.println("Mail ID = "+Data.get("email"));
            }
            conn.disconnect();
        } 
		   catch (Exception e) {
           e.printStackTrace();
        }
	}
}
