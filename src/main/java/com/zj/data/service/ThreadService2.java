package com.zj.data.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import net.sf.json.JSONObject;
import sun.net.www.protocol.http.HttpURLConnection;

public class ThreadService2 implements Runnable{

	private List<String> list;
	
	private int start;
	private int end;
	private static StringBuffer content = new StringBuffer();
	private static int completeNum;
	public static AtomicInteger count = new AtomicInteger(0);
	 
    public static void increase() {
        count.incrementAndGet();
    }
	
	public ThreadService2() {
		
	}
	
	public ThreadService2(List<String> list,int start, int end) {
		this.list = list;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run () {
		try {
			int size = list.size();
			//System.out.println("end=" + end + ",size=" + size);
			if (end >= size + 100) {
//				end=3200,size=3173
				System.out.println("end=" + end + ",size=" + size);
				return;
			}
			for (int i = start; i < end; i ++) {
				if (i >= size) {
					System.out.println("end=" + end + ",,,,,,,,,,,,i=" + i);
					return;
				}
				String txt = list.get(i);
				if (txt == null) {
					System.out.println("i--iiii-----" + i);
					continue ;
				}
				Document document = getDocument(txt);
				if (document == null) {
					//System.out.println(txt + "未查找到对应链接！");
					increase();
					continue ;
				}
//				try {
//					document = Jsoup.connect(txt.trim())
//							 .userAgent("Mozilla/5.0 (Windows NT 7.0; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0").timeout(60*1000).get();
//				} catch (Exception e) {
//				}
				
				//二一
				 //Elements titleE = document.select("div[class=view-hd] h1[class=zy-tit]");
//				 Elements priceE = document.select("div[class=view-meta] span[class=coin]");
//				 Element timeE = document.select("div[class=view-meta] span").get(1);
//				 Element userNameE = document.select("div[class=user-name] a").get(0);
//				 Element periodE = document.select("div[class=bread] span[class=bread-path] a").get(3);
//				 String time = timeE.attr("title");
//				 time = time.substring(3, 18);
//				 String userName = userNameE.text();
//				 String period = periodE.text();
		  	 
		   	 Elements priceE = document.select("a[id=btnDownload] span[class=price]");
		   	 if(priceE.isEmpty()) {
		   		 priceE = document.select("a[id=btnSoftDownload]").select("span");
		   		 if(priceE.isEmpty()) {
		   			 priceE = document.select("div[class=download]").select("span");
		   		 }
		   	 }
		   	 
		   	 Element timeE = null;
			Element downloadE = null;
			Element readE = null;
			Element userE = null;
			try {
				Elements timeEs= document.select("div[class=time des]");
				Elements downloadEs = document.select("div[class=down des]");
				Elements readEs = document.select("div[class=read des]");
				Elements userEs = document.select("div[class=user des]");
				if (timeEs == null || timeEs.isEmpty()) {
					timeE = document.select("div[class=amend-det] span").get(4);
//					Elements item = document.select("div[class=amend-det] span");
//					if (item != null && item.size() > 4) {
//						timeE = item.get(4);
//					}
				} else {
					timeE = timeEs.get(0);
				}
				if (downloadEs == null || downloadEs.isEmpty()) {
					downloadE = document.select("div[class=amend-det] span").get(3);
//					Elements item = document.select("div[class=amend-det] span");
//					if (item != null && item.size() > 3) {
//						downloadE = item.get(3);
//					}
				} else {
					downloadE = downloadEs.get(0);
				}
				if (readEs == null || readEs.isEmpty()) {
					readE = document.select("div[class=amend-det] span").get(2);
//					Elements item = document.select("div[class=amend-det] span");
//					if (item != null && item.size() > 2) {
//						readE = item.get(2);
//					}
				} else {
					readE = readEs.get(0);
				}
				if (userEs == null || userEs.isEmpty()) {
					userE = document.select("div[class=amend-det] span").get(6);
//					Elements item = document.select("div[class=amend-det] span");
//					if (item != null && item.size() > 6) {
//						userE = item.get(6);
//					}
				} else {
					userE = userEs.get(0);
				}
//				 downloadE = document.select("div[class=down des]").get(0);
//				 //Elements downloadE31 = document.select("div[class=res-des clearfix]");
//				 readE = document.select("div[class=read des]").get(0);
//				 userE = document.select("div[class=user des]").get(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println("[][][][][][][][][][][]+" + txt);
				String error = e.toString();
//				if (error.contains("Index") || error.contains("index")) {
//					
//				}
//				e.printStackTrace();
				increase();
				continue;
			}
				 
//			    	 String title = titleE.attr("title");
		  	 String title = document.title();
		  	 String price = priceE.text();
		   	 String time = timeE.text();
		   	 String download = downloadE.text();
		   	 String read = readE.text();
		   	 String user = userE.text();
		   	 if (download.isEmpty()) {
		   		Element idE = document.select("input[id=hid_softid]").get(0);
		   		String id = idE.attr("value");
		   		String param = "action=GetUpdateSoftHits" + "&id=" + id;
		   		String result = sendPost("http://www.xuekeedu.com/q.ashx", param).toString();
		   		JSONObject resulltObj = JSONObject.fromObject(result);
		   		JSONObject dataObj = JSONObject.fromObject(resulltObj.get("data"));
		   		download = dataObj.getString("Hits");
		   		
		   	 }
		  	 
		  	// System.out.println("title = " + title);
//		   	 content += title + "	" + time + "	" + price +"\t"+txt+ "\r\n";
//					String content = price + "\t" + txt + "\r\n";
		   		//content.append(period + "\t" + userName + "\t" + title + "	" + time + "	" + price +"\t"+txt+ "\t" + i + "\r\n");
		  	content.append(txt + "	" + title + "	" + download + "\t" + read + "\t" + user + "\t" + price + "	" + time.replace("时间：", "")  +"\t" + i + "\r\n");
				//content.append(price.trim() + "\t" + txt.trim() + "\t" + i + "\r\n");
		   		completeNum ++;
		   		increase();
		   		if (title != null && !title.equals("")) {
//			   		completeNum ++;
			   	} else  {
			   		System.out.println("--这是空的数据啊 --" + title + "	" + time + "	" + price +"\t"+txt+ "\t" + i + "\r\n");
			   	}
				
			}
			
		} catch (Exception e) {
			System.err.println("end--" + end);
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	public Document getDocument(String txt) {
		Document document = null;
		try {
			if (txt == null || txt.isEmpty()) {
				return document;
			}
		
			Connection connection = Jsoup.connect(txt.trim())
//					.timeout(60*1000);
					.userAgent("Mozilla");
//					 .userAgent("Mozilla/5.0 (Windows NT 7.0; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0").timeout(60*1000);
			document = connection.get();
			return document;
		} catch (Exception e) {
			String error = e.toString();
			if (error.contains("Status=404")) {
				return document;
			}
			if (error.contains("empty")) {
				content.append("解析不了的url" + txt + "	" + "" + "	" + "" + "\t" + "" + "\t" + "" + "\t" + "" + "	" + ""  +"\t" + 99999999 + "\r\n");
				return document;
			}
//			System.out.println("初夏那问题的：" + txt);
			document = getDocument(txt);
//			e.printStackTrace();
			return document;
		}
	}

	public StringBuffer getContent() {
		return content;
	}

	public void setContent(StringBuffer content) {
		this.content = content;
	}

	public static int getCompleteNum() {
		return completeNum;
	}

	public static void setCompleteNum(int completeNum) {
		ThreadService2.completeNum = completeNum;
	}
	
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			// 设置请求连接超时时间
			conn.setConnectTimeout(10000);
			// 设置访问时的超时时间
			conn.setReadTimeout(10000);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			//LogUtils.debug(param);
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
//			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
