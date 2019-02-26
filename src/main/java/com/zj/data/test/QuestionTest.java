package com.zj.data.test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.zj.data.service.ThreadService;
import com.zj.data.service.ThreadService2;

public class QuestionTest {
	
	
    public static void writeFile() throws Exception {
    	Thread thisThread = new Thread() {
    		@Override
    		public void run() {
		    	try {
						File fileW= new File("D:/write.txt");   //创建一个文件
//					File fileW= new File("D:/write - 副本.txt");   //创建一个文件
					
					OutputStream out =null;
					out=new FileOutputStream(fileW);  //打开文件输出流
//	 		String content="枫桥夜泊 \r\n张继\r\n月落乌啼霜满天，\r\n江枫渔火对愁眠。\r\n姑苏城外寒山寺，\r\n夜半钟声到客船。\r\n";
					
					File file = new File("C:/Users/Administrator/Desktop/21link.txt");//文件路径  
//					File file = new File("C:/Users/Administrator/Desktop/21link - 副本.txt");//文件路径  
					
					FileReader fileReader = new FileReader(file); 
					LineNumberReader reader = new LineNumberReader(fileReader);  
					int number = 9999999;//设置指定行数  
					String txt = "";  
					String content = "";
					//StringBuffer content
					int lines = 0;  
					while (txt != null) {  
					    lines++;  
					    txt = reader.readLine();  
					    //System.out.println("---------------txt" + txt);
					    if (!"".equals(txt) ) {
					    	 Document document = Jsoup.connect(txt.trim())
					    			 .userAgent("Mozilla/5.0 (Windows NT 7.0; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0").get();
						    	 //Elements titleE = document.select("div[class=view-hd] h1[class=zy-tit]");
						    	 Elements priceE = document.select("div[class=view-meta] span[class=coin]");
						    	 Element timeE = document.select("div[class=view-meta] span").get(1);
					    	 
					    	 
//					    	 Elements priceE = document.select("a[id=btnDownload] span[class=price]");
//					    	 if(priceE.isEmpty()) {
//					    		 priceE = document.select("a[id=btnSoftDownload]").select("span");
//					    		 if(priceE.isEmpty()) {
//					    			 priceE = document.select("div[class=download]").select("span");
//					    		 }
//					    	 }
//					    	 Element timeE = document.select("div[class=time des]").get(0);
//						    	 String title = titleE.attr("title");
					    	 String title = document.title();
					    	 String price = priceE.text();
						    	 String time = timeE.attr("title");
						    	 time = time.substring(3, 18);
//					    	 String time = timeE.text();
					    	 
					    	// System.out.println("title = " + title);
//					    	 content += title + "	" + time + "	" + price +"\t"+txt+ "\r\n";
						    content += price + "\t" + txt + "\r\n";
//					    	 break;
					    }
					}  
					
					reader.close();  
					fileReader.close();
					
					try {
						System.out.println("-----" + content);
						byte[] bytes= content.getBytes();  //读取输出流中的字节
						out.write(bytes);     //写入文件
						System.out.println("写文件"+file.getAbsolutePath()+"成功！");
					}catch(IOException e) {
						System.out.println("写文件"+file.getAbsolutePath()+"失败！");
						e.printStackTrace();
					}
					finally {      //内容总执行
						if(out!=null) {
							try {
								out.close();  //关闭输出文件流
							}catch(IOException el) {
							}
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		       
		        
				
    		}
    	};    
    	thisThread.start();
    }
    
    public static void writeFile2() throws Exception {
		    	try {
					File fileW= new File("D:/write.txt");   //创建一个文件
//					File fileW= new File("D:/write - 副本.txt");   //创建一个文件
					
					OutputStream out =null;
					out=new FileOutputStream(fileW);  //打开文件输出流
//	 		String content="枫桥夜泊 \r\n张继\r\n月落乌啼霜满天，\r\n江枫渔火对愁眠。\r\n姑苏城外寒山寺，\r\n夜半钟声到客船。\r\n";
					
					File file = new File("C:/Users/Administrator/Desktop/21link.txt");//文件路径  
//					File file = new File("C:/Users/Administrator/Desktop/21link - 副本.txt");//文件路径  
					
					FileReader fileReader = new FileReader(file); 
					LineNumberReader reader = new LineNumberReader(fileReader);  
					int number = 9999999;//设置指定行数  
					String txt = "";  
					String content = "";
					//StringBuffer content
					int lines = 0;  
					List<String> list = new ArrayList<>();
					while (txt != null) {  
					    lines++;  
					    txt = reader.readLine();  
					    //System.out.println("---------------txt" + txt);
					    if (!"".equals(txt) && txt != null) {
					    	list.add(txt.trim());
					    }
					}  
					
					reader.close();  
					fileReader.close();
					int size = list.size();
					//0-50, 50-100, 100-150
					ThreadService ts = null;
					for (int i = 0; i < 320; i ++) {
						if (i*30-10 > size) {
							break;
						}
						System.out.println("i--------" + i);
						ts = new ThreadService(list, i * 30, i*30 + 30);
						Thread t = new Thread(ts);
						t.start();
//						t.join();
//						String ss = ts.getContent().toString();
//						System.out.println("-----" + ss);
					}
//					content = ts.getContent().toString();
//					while (content== null|| "".equals(content)) {
//						content = ts.getContent().toString();
//					}
					
					int completeNum = ts.getCompleteNum();//完成的数量
					Integer count = ts.count.get();
					System.out.println("size============" + size);
					while (size != count) {
						Thread.sleep(5*1000);
						completeNum = ts.getCompleteNum();
						count = ts.count.get();
//						int aa = Thread.activeCount();
//						ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
//				        int noThreads = currentGroup.activeCount();
//						System.out.println("completeNum =============" + completeNum + "---aa=" + aa + "---noThreads=" + noThreads);
						System.out.println("completeNum =============" + completeNum + "---count=" + count );
					}
//					Thread.sleep(90*1000);
					
					content = ts.getContent().toString();
					try {
//						System.out.println("-----" + content);
						System.out.println("*****************" + ts.getCompleteNum());
						byte[] bytes= content.getBytes();  //读取输出流中的字节
						out.write(bytes);     //写入文件
						System.out.println("写文件"+file.getAbsolutePath()+"成功！");
					}catch(IOException e) {
						System.out.println("写文件"+file.getAbsolutePath()+"失败！");
						e.printStackTrace();
					}
					finally {      //内容总执行
						if(out!=null) {
							try {
								out.close();  //关闭输出文件流
							}catch(IOException el) {
							}
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
    }
    
    public static void writeFilePool() {
    	OutputStream out = null;
    	FileReader fileReader = null;
    	LineNumberReader reader = null;
    	try {
    		File fileW= new File("D:/write.txt");   //创建一个文件
			out = new FileOutputStream(fileW);  //打开文件输出流
			File file = new File("C:/Users/Administrator/Desktop/21link.txt");//文件路径  
			fileReader = new FileReader(file); 
			reader = new LineNumberReader(fileReader);  
			String txt = "";  
			
			List<String> list = new ArrayList<>();
			while (txt != null) {  
			    txt = reader.readLine();  
			    if (!"".equals(txt) && txt != null) {
			    	list.add(txt.trim());
			    }
			}  
			
			int size = list.size();
			ThreadPoolExecutor tpe = new ThreadPoolExecutor(20, 300, 200, TimeUnit.SECONDS, 
					new ArrayBlockingQueue<>(20));
			ThreadService ts = null;
			for (int i = 0; i < 320; i ++) {
				if (i*30-30 > size) {
					break;
				}
				ts = new ThreadService(list, i * 30, i*30 + 30);
				tpe.execute(ts);
				System.out.println("线程池中线程数目："+tpe.getPoolSize()+"，队列中等待执行的任务数目："+
						tpe.getQueue().size()+"，已执行玩别的任务数目："+tpe.getCompletedTaskCount());
			}
			
			int count = ts.count.get();
			while (size != count) {
				Thread.sleep(5*1000);
				count = ts.count.get();
				System.out.println("当前的已统计数量：" + count + ",ts.getCompleteNum()" + ts.getCompleteNum());
			}
			
			String content = ts.getContent().toString();
//			System.out.println("*****************" + content);
			byte[] bytes= content.getBytes();  //读取输出流中的字节
			out.write(bytes);     //写入文件
			System.out.println("写文件"+file.getAbsolutePath()+"成功！");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();  
				}
				if (fileReader != null) {
					fileReader.close();
				}
				if (out != null) {
					out.close(); 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
    }
    
    public static void writeFilePool1() {
    	OutputStream out = null;
    	FileReader fileReader = null;
    	LineNumberReader reader = null;
    	try {
    		File fileW= new File("D:/write.txt");   //创建一个文件
			out = new FileOutputStream(fileW);  //打开文件输出流
			
			List<String> list = new ArrayList<>();
			//加入链接
//			http://www.zxxk.com/soft/5000000.html
			for (int i = 7500000; i < 7600000; i ++ ) {
				list.add("http://www.zxxk.com/soft/"+ i +".html");
			}
//			list.add("http://www.zxxk.com/soft/5000851.html");
//			list.add("http://www.zxxk.com/soft/5428948.html");
//			list.add("http://www.zxxk.com/soft/5428949.html");
			
			int size = list.size();
			ThreadPoolExecutor tpe = new ThreadPoolExecutor(300, 4000, 5000, TimeUnit.SECONDS, 
					new ArrayBlockingQueue<>(1000));
			ThreadService2 ts = null;
			for (int i = 0; i < 10000; i ++) {
				if (i*100-100 > size) {
					break;
				}
				ts = new ThreadService2(list, i * 100, i*100 + 100);
				tpe.execute(ts);
				System.out.println("线程池中线程数目："+tpe.getPoolSize()+"，队列中等待执行的任务数目："+
						tpe.getQueue().size()+"，已执行玩别的任务数目："+tpe.getCompletedTaskCount());
			}
			
			int count = ts.count.get();
			while (size != count) {
				Thread.sleep(5*1000);
				count = ts.count.get();
				System.out.println("当前的已统计数量：" + count + ",ts.getCompleteNum()" + ts.getCompleteNum());
			}
			
			String content = ts.getContent().toString();
//			System.out.println("*****************" + content);
			byte[] bytes= content.getBytes();  //读取输出流中的字节
			out.write(bytes);     //写入文件
			System.out.println("写文件"+fileW.getAbsolutePath()+"成功！");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();  
				}
				if (fileReader != null) {
					fileReader.close();
				}
				if (out != null) {
					out.close(); 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
    }
	
	
	
	//单例模式 线程安全
//	private static MethodTest instance;
//	private MethodTest() {};
//	private synchronized static MethodTest getInstance() {
//		if (instance == null) {
//			instance = new MethodTest();
//		}
////		synchronized("aa") {
////			
////		}
//		return instance;
//	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
//		writeFile2();
		writeFilePool();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//单例模式 线程安全
//	private static MethodTest instance;
//	private MethodTest() {};
//	private synchronized static MethodTest getInstance() {
//		if (instance == null) {
//			instance = new MethodTest();
//		}
////		synchronized("aa") {
////			
////		}
//		return instance;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
