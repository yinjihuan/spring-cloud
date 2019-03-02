package com.cxytiandi.apollo_springboot.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 模拟客户端注册
 * @author yinjihuan
 *
 */
public class ClientTest {
	public static void main(String[] args) {
		reg();
	}

	private static void reg() {
		System.err.println("注册");
		String result = request("http://localhost:8081/getConfig");
		if (result != null) {
			// 配置有更新，重新拉取配置
			// ......
		}
		// 重新注册
		reg();
	}
	
	private static String request(String url) {
		HttpURLConnection connection = null;
		BufferedReader reader = null;
		try {
			URL getUrl = new URL(url);
			connection = (HttpURLConnection) getUrl.openConnection();
			connection.setReadTimeout(90000);
			connection.setConnectTimeout(3000);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept-Charset", "utf-8");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Charset", "UTF-8");
			System.out.println(connection.getResponseCode());
			if (200 == connection.getResponseCode()) {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				StringBuilder result = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					result.append(line);
				}
				System.out.println("结果 " + result);
				return result.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return null;
	}
}
