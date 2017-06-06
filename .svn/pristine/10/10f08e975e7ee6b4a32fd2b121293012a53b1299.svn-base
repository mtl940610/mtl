package com.centran.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 *Module:       HttpClientUtil.java
 *Description:  以get/post的方式发送数据到指定的http接口---利用httpclient.jar包---HTTP接口的调用
 *Company:      
 *Author:       赵亮
 *Date:         Feb 22, 2012
 */

public class HttpClientUtil {
    
   // private static final Log log = LogFactory.getLog(HttpClientUtil2.class);
	private static int connectionTimeout = 40000;//连接超时时间
	private static int soTimeout = 10000; //加载超时时间
    /**
     * get方式
     * @param param1
     * @param param2
     * @return
	*/
    public static String doGetStr(String url,Map<String, Object> map){
        String result = "";
        HttpClient httpClient = new HttpClient();
        String strUrl =  url;
        if(map.size()>0){
        	strUrl +="?";
        }
        Set<String> keySet= map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()) {
	        Object key = iterator.next();
	        Object value = map.get(key);
	        strUrl+= key+"="+(String)value;
	        if(iterator.hasNext()){
	        	strUrl+="&";
	        }
        }
        GetMethod getMethod = new GetMethod(strUrl);
        // 使用系统系统的默认的恢复策略
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
        try {
            //3.执行getMethod,调用http接口
            httpClient.executeMethod(getMethod);
            //4.读取内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream(),"utf-8"));  
            StringBuffer stringBuffer = new StringBuffer();  
            String str = "";  
            while((str = reader.readLine())!=null){  
                stringBuffer.append(str);  
            }  
            result= stringBuffer.toString();  
            //result = getMethod.getResponseBodyAsString().trim();; 
            //5.处理返回的内容
           if(result==null||result.equals("")){
				result="";
				System.out.println("请求服务器："+strUrl+"返回空-------------");
			}
            //log.info(responseMsg);
         
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //6.释放连接
            getMethod.releaseConnection();
        }
        return result;
    }

    /**
     * post方式 
     * @param param1 
     * @param param2
     * @return
     */
	public static String doPostStr(String url, Map<String, Object> map) {
        String result = "";
        HttpClient httpClient=new HttpClient();
        httpClient.getParams().setContentCharset("UTF-8");     
        PostMethod postMethod=new PostMethod(url);
        
		for(Map.Entry<String, Object> entry:map.entrySet()){
			postMethod.addParameter(entry.getKey(), (String) entry.getValue());
		} 

        try {

            httpClient.executeMethod(postMethod);//200
			//5.读取内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8"));  
            StringBuffer stringBuffer = new StringBuffer();  
            String str = "";  
            while((str = reader.readLine())!=null){  
                stringBuffer.append(str);  
            }  
            result= stringBuffer.toString();  
            //result = postMethod.getResponseBodyAsString().trim();
			if(result==null||result.equals("")){
				result="";
				System.out.println("请求服务器："+url+"返回空------------");
			}
            //log.info(responseMsg);
            //6.处理返回的内容

        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.释放连接
            postMethod.releaseConnection();
        }
        return result;
    }
       
    /**
     * 
     * @param url
     * @param jsonStr
     * @return
     */
    public static String doPostJsonMap(String url, Map<String, Object> map){
    	String result = "";
    	PostMethod method = null;
        try {
            method = new PostMethod(url);
            JSONObject jsonObject = new JSONObject();
			for(Map.Entry<String, Object> entry:map.entrySet()){
				jsonObject.put(entry.getKey(), (String) entry.getValue());
			} 
            String transJson = jsonObject.toString();
            RequestEntity se = new StringRequestEntity(transJson, "application/json", "UTF-8");
            method.setRequestEntity(se);
            //使用系统提供的默认的恢复策略
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            //设置超时的时间
            method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, connectionTimeout);
        } catch (IllegalArgumentException e) {
        	//log.error("非法的URL：{}");
        	System.out.println("请求服务器："+url+"非法的URL：");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpClient httpClient=new HttpClient();
        int statusCode;
		try {
			statusCode = httpClient.executeMethod(method);
			//只要在获取源码中，服务器返回的不是200代码，则统一认为抓取源码失败，返回null。
			if (statusCode != HttpStatus.SC_OK) {
				System.out.println("请求服务器："+url+"非200错误");
				//log.error("Method failed: " + method.getStatusLine() + "\tstatusCode: " + statusCode);
				return "";
			}else{
	            BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(),"utf-8"));  
	            StringBuffer stringBuffer = new StringBuffer();  
	            String str = "";  
	            while((str = reader.readLine())!=null){  
	                stringBuffer.append(str);  
	            }  
	            result= stringBuffer.toString();  
				//result  = method.getResponseBodyAsString().trim();
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            //7.释放连接
			method.releaseConnection();
        }
		return result;
    }
    
    public static void main(String[] args) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("sex", "nan");
    	map.put("age", "20");
    	map.put("email", "email23");
    	System.out.println(doPostJsonMap("http://192.168.2.167:8080/rest/productBase/testUpdate",map));
	}
}