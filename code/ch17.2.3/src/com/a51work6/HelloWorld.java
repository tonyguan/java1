/*
* Created by 智捷课堂
* 本书网站：www.51work6.com 
* 智捷课堂在线课堂：www.zhijieketang.com
* 智捷课堂微信公共号：zhijieketang
* 邮箱：eorient@sina.com
* Java读者服务QQ群：547370999
* 【配套电子书】网址：
*       图灵社区：
*       http://www.ituring.com.cn/book/2480
*       百度阅读：
*       https://yuedu.baidu.com/ebook/7c1499987e192279168884868762caaedd33ba00 
*/

//HelloWorld.java文件
package com.a51work6;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HelloWorld {

	public static void main(String[] args) {

		System.out.println("-------1. JSON编码过程----------");
		// 1. JSON编码过程
		// {"name": "tony", "age": 30, "a": [1, 3]}
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", "tony");
			jsonObject.put("age", 30);

			JSONArray jsonArray = new JSONArray();
			jsonArray.put(1).put(3);
			jsonObject.put("a", jsonArray);

			// 编码完成
			System.out.println(jsonObject.toString());

		} catch (JSONException e) {
			e.printStackTrace();
		}

		System.out.println("-------2. JSON解码过程----------");
		// 2. JSON解码过程
		// {"name":"tony", "age":30, "a":[1, 3]}
		// JSON字符串
		String jsonString = "{\"name\":\"tony\", \"age\":30, \"a\":[1, 3]}";

		try {
			JSONObject jsonObject = new JSONObject(jsonString);

			String name = jsonObject.getString("name");
			System.out.println("name : " + name);
			int age = jsonObject.getInt("age");
			System.out.println("age : " + age);

			JSONArray jsonArray = jsonObject.getJSONArray("a");
			int n1 = jsonArray.getInt(0);
			System.out.println("数组a第一个元素 : " + n1);
			int n2 = jsonArray.getInt(1);
			System.out.println("数组a第二个元素 : " + n2);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
