package com.centran.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

/**
 * Created by MyEclipse
 * User:  赵亮
 * Company: 
 * DateTime:2015-03-24 13:39:20
 * Description:Json和XML的解析
 */
public class JsonXML {
	/**
	 * xml文件转成Map<String, String>
	 * @param str
	 * @return
	 */
	public static Map<String, String> getsaxXMLToMap(String FilePath) throws org.dom4j.DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		File file1 = new File(FilePath);
		if(!file1.exists()){
			System.out.println("xml文件不存在");
			return map;
		}
		org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
		org.dom4j.Document doc = reader.read(FilePath);	
		//获取根节点内
		org.dom4j.Element root = doc.getRootElement();
		List<org.dom4j.Element> Rootelements = root.elements();
		//root.elements("element");//获得指定名称为element的节点List
		for(org.dom4j.Element e : Rootelements){
			map.put(e.getName(), e.getText());//获得名称和文本
			//e.attributeValue("id");//获得属性名称id的属性值
			System.out.println(e.getName() +":"+ e.getText());
		}
		return map;
	}
	/**
	 * xml流转成Map<String, String>
	 * @param str
	 * @return
	 */
	public static Map<String, String> getsaxXMLToMap(InputStream iputStream) throws org.dom4j.DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
		org.dom4j.Document doc = reader.read(iputStream);	
		//获取根节点内
		org.dom4j.Element root = doc.getRootElement();
		List<org.dom4j.Element> Rootelements = root.elements();
		//root.elements("element");//获得指定名称为element的节点List
		for(org.dom4j.Element e : Rootelements){
			map.put(e.getName(), e.getText());//获得名称和文本
			//e.attributeValue("id");//获得属性名称id的属性值
			System.out.println(e.getName() +":"+ e.getText());
		}
		return map;
	}
	/**
	 * xml字符串转成Map<String, String>
	 * @param str
	 * @return
	 */
	public static Map<String, String> getsaxXMLStringToMap(String xmlString) throws org.dom4j.DocumentException, UnsupportedEncodingException{
		Map<String, String> map = new HashMap<String, String>();
		org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
		org.dom4j.Document doc = reader.read(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));	
		//获取根节点内
		org.dom4j.Element root = doc.getRootElement();
		List<org.dom4j.Element> Rootelements = root.elements();
		//root.elements("element");//获得指定名称为element的节点List
		for(org.dom4j.Element e : Rootelements){
			map.put(e.getName(), e.getText());//获得名称和文本
			//e.attributeValue("id");//获得属性名称id的属性值
			System.out.println(e.getName() +":"+ e.getText());
		}
		return map;
	}
	//*************************************************************************************************
	/**
	 * 对象转换成XMLString
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static String getXstreamObjectToXML(String alias,Class beanClass,Object bean) throws org.dom4j.DocumentException{
		com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();		
		xstream.alias(alias, beanClass);//类重名名 (beanClass.getSimpleName(), beanClass)
		//xstream.aliasField("谁", beanClass, "id");//类成员重命名
		//xstream.useAttributeFor(beanClass, "sendto");//将类成员设置成元素属性
		//xstream.aliasAttribute(beanClass, "content", "Content");//将类成员设置成元素属性并且重命名
		return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"+xstream.toXML(bean);
	}
	//****************************************************************************************
	/**
	 * DomXML文件在该节点下添加节点
	 * @param <T>
	 * @param str
	 * @return
	 * @throws TransformerException 
	 */
	public static void addDomXMLNode(String fromFile,String addTagName,String tagTagValue) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		File file1 = new File(fromFile);
		if(!file1.exists()){
			System.out.println("xml文件不存在");
			return;
		}
		//获取解析器的工厂模式
		javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//2.获取文档解析对象
		javax.xml.parsers.DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//3.加载XML文件
		org.w3c.dom.Document document  = documentBuilder.parse(fromFile);
		//解析对象
		org.w3c.dom.NodeList nodeList = document.getChildNodes();
	
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance();
		javax.xml.transform.Transformer former = factory.newTransformer();
		
		for(int i=0;i<nodeList.getLength();i++){
			org.w3c.dom.Element elementfrom = (org.w3c.dom.Element) nodeList.item(i);//强转
			org.w3c.dom.Element elementCreat = document.createElement(addTagName);//创建元素
			org.w3c.dom.Text text = document.createTextNode(tagTagValue);//创建文本
			elementCreat.appendChild(text);
			elementfrom.appendChild(elementCreat);
			file1.delete();
			former.transform(new javax.xml.transform.dom.DOMSource(elementfrom), new StreamResult(fromFile));
		}
		System.out.println("已修改");
		return ;	
	}
	/**
	 * DomXML流在该节点下添加节点
	 * @param <T>
	 * @param str
	 * @return
	 * @throws TransformerException 
	 */
	public static void addDomXMLNode(InputStream inputStream,OutputStream outputStream,String addTagName,String tagTagValue) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//获取解析器的工厂模式
		javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//2.获取文档解析对象
		javax.xml.parsers.DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//3.加载XML文件
		org.w3c.dom.Document document  = documentBuilder.parse(inputStream);
		//解析对象
		org.w3c.dom.NodeList nodeList = document.getChildNodes();
	
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance();
		javax.xml.transform.Transformer former = factory.newTransformer();
		
		for(int i=0;i<nodeList.getLength();i++){
			org.w3c.dom.Element elementfrom = (org.w3c.dom.Element) nodeList.item(i);//强转
			org.w3c.dom.Element elementCreat = document.createElement(addTagName);//创建元素
			org.w3c.dom.Text text = document.createTextNode(tagTagValue);//创建文本
			elementCreat.appendChild(text);
			elementfrom.appendChild(elementCreat);
			former.transform(new javax.xml.transform.dom.DOMSource(elementfrom), new StreamResult(outputStream));
		}
		return ;	
	}
	/**
	 * DomXML字符串在该节点下添加节点
	 * @param <T>
	 * @param str
	 * @return
	 * @throws TransformerException 
	 */
	public static String addDomXMLNodeString(String xmlString,String addTagName,String tagTagValue) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//获取解析器的工厂模式
		javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//2.获取文档解析对象
		javax.xml.parsers.DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//3.加载XML文件
		org.w3c.dom.Document document  = documentBuilder.parse(new  ByteArrayInputStream(xmlString.getBytes("UTF-8")));
		//解析对象
		org.w3c.dom.NodeList nodeList = document.getChildNodes();
	
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance();
		javax.xml.transform.Transformer former = factory.newTransformer();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for(int i=0;i<nodeList.getLength();i++){
			org.w3c.dom.Element elementfrom = (org.w3c.dom.Element) nodeList.item(i);//强转
			org.w3c.dom.Element elementCreat = document.createElement(addTagName);//创建元素
			org.w3c.dom.Text text = document.createTextNode(tagTagValue);//创建文本
			elementCreat.appendChild(text);
			elementfrom.appendChild(elementCreat);
			former.transform(new javax.xml.transform.dom.DOMSource(elementfrom), new StreamResult(baos));
		}
		return baos.toString();	
	}
	//************************************************************************************
	/**
	 * DomXML文件删除该节点和其下所有节点
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static void delDomXMLNode(String fromFile,String delTagName) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		File file1 = new File(fromFile);
		if(!file1.exists()){
			System.out.println("xml文件不存在");
			return;
		}
		//获取解析器的工厂模式
		javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//2.获取文档解析对象
		javax.xml.parsers.DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//3.加载XML文件
		org.w3c.dom.Document document  = documentBuilder.parse(fromFile);

		//解析对象
		org.w3c.dom.NodeList delNodeList = document.getElementsByTagName(delTagName);
		if(delNodeList ==null || delNodeList.getLength()==0){
			System.out.println("删除节点不存在");
			return;
		}
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance();
		javax.xml.transform.Transformer former = factory.newTransformer();
		
		for(int i=0;i<delNodeList.getLength();i++){
			org.w3c.dom.Node node = delNodeList.item(i);
			node.getParentNode().removeChild(node);
			i--;
		}
		file1.delete();
		former.transform(new javax.xml.transform.dom.DOMSource(document), new StreamResult(fromFile));
		System.out.println("已修改");
		return ;	
	}
	/**
	 * DomXML流删除该节点和其下所有节点
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static void delDomXMLNode(InputStream inputStream,OutputStream outputStream,String delTagName) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//获取解析器的工厂模式
		javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//2.获取文档解析对象
		javax.xml.parsers.DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//3.加载XML文件
		org.w3c.dom.Document document  = documentBuilder.parse(inputStream);

		//解析对象
		org.w3c.dom.NodeList delNodeList = document.getElementsByTagName(delTagName);
		if(delNodeList ==null || delNodeList.getLength()==0){
			System.out.println("删除节点不存在");
			return;
		}
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance();
		javax.xml.transform.Transformer former = factory.newTransformer();
		
		for(int i=0;i<delNodeList.getLength();i++){
			org.w3c.dom.Node node = delNodeList.item(i);
			node.getParentNode().removeChild(node);
			i--;
		}
		former.transform(new javax.xml.transform.dom.DOMSource(document), new StreamResult(outputStream));
		System.out.println("已修改");
		return ;	
	}
	/**
	 * DomXML字符串删除该节点和其下所有节点
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static String delDomXMLNodeString(String xmlString,String delTagName) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//获取解析器的工厂模式
		javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//2.获取文档解析对象
		javax.xml.parsers.DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//3.加载XML文件
		org.w3c.dom.Document document  = documentBuilder.parse(new  ByteArrayInputStream(xmlString.getBytes("UTF-8")));

		//解析对象
		org.w3c.dom.NodeList delNodeList = document.getElementsByTagName(delTagName);
		if(delNodeList ==null || delNodeList.getLength()==0){
			System.out.println("删除节点不存在");
			return "";
		}
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance();
		javax.xml.transform.Transformer former = factory.newTransformer();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for(int i=0;i<delNodeList.getLength();i++){
			org.w3c.dom.Node node = delNodeList.item(i);
			node.getParentNode().removeChild(node);
			i--;
		}
		former.transform(new javax.xml.transform.dom.DOMSource(document), new StreamResult(baos));
		System.out.println("已修改");
		return baos.toString();	
	}
	//**********************************************************************************
	/**
	 * DomXML文件修改该节点里的text
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static void updateDomXMLText(String fromFile,String updateTagName,String updateTagValue) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		File file1 = new File(fromFile);
		if(!file1.exists()){
			System.out.println("xml文件不存在");
			return;
		}
		//获取解析器的工厂模式
		javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//2.获取文档解析对象
		javax.xml.parsers.DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//3.加载XML文件
		org.w3c.dom.Document document  = documentBuilder.parse(fromFile);
		//解析对象
		org.w3c.dom.NodeList updateNodeList = document.getElementsByTagName(updateTagName);
			
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance();
		javax.xml.transform.Transformer former = factory.newTransformer();
		for(int i=0;i<updateNodeList.getLength();i++){
			org.w3c.dom.Node fristChild = updateNodeList.item(i).getFirstChild();
			if(fristChild.getNodeType()==org.w3c.dom.Node.TEXT_NODE){
				org.w3c.dom.Text text = (org.w3c.dom.Text)fristChild;
				text.setData(updateTagValue);
			}
		}
		file1.delete();
		former.transform(new javax.xml.transform.dom.DOMSource(document), new StreamResult(fromFile));
		System.out.println("已修改");
		return ;	
	}
	/**
	 * DomXML流修改该节点里的text
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static void updateDomXMLText(InputStream inputStream,OutputStream outputStream,String updateTagName,String updateTagValue) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//获取解析器的工厂模式
		javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//2.获取文档解析对象
		javax.xml.parsers.DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//3.加载XML文件
		org.w3c.dom.Document document  = documentBuilder.parse(inputStream);
		//解析对象
		org.w3c.dom.NodeList updateNodeList = document.getElementsByTagName(updateTagName);
			
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance();
		javax.xml.transform.Transformer former = factory.newTransformer();
		for(int i=0;i<updateNodeList.getLength();i++){
			org.w3c.dom.Node fristChild = updateNodeList.item(i).getFirstChild();
			if(fristChild.getNodeType()==org.w3c.dom.Node.TEXT_NODE){
				org.w3c.dom.Text text = (org.w3c.dom.Text)fristChild;
				text.setData(updateTagValue);
			}
		}
		former.transform(new javax.xml.transform.dom.DOMSource(document), new StreamResult(outputStream));
		System.out.println("已修改");
		return ;	
	}
	/**
	 * DomXML字符串修改该节点里的text
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static String updateDomXMLTextString(String xmlString,String updateTagName,String updateTagValue) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//获取解析器的工厂模式
		javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//2.获取文档解析对象
		javax.xml.parsers.DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//3.加载XML文件
		org.w3c.dom.Document document  = documentBuilder.parse(new  ByteArrayInputStream(xmlString.getBytes("UTF-8")));
		//解析对象
		org.w3c.dom.NodeList updateNodeList = document.getElementsByTagName(updateTagName);
			
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance();
		javax.xml.transform.Transformer former = factory.newTransformer();
		for(int i=0;i<updateNodeList.getLength();i++){
			org.w3c.dom.Node fristChild = updateNodeList.item(i).getFirstChild();
			if(fristChild.getNodeType()==org.w3c.dom.Node.TEXT_NODE){
				org.w3c.dom.Text text = (org.w3c.dom.Text)fristChild;
				text.setData(updateTagValue);
			}
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		former.transform(new javax.xml.transform.dom.DOMSource(document), new StreamResult(baos));
		System.out.println("已修改");
		return baos.toString();	
	}
	//***********************************************************************************
	/**
	 * Bean转成jsonString
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static String getObjectToJson(String name,Object obj){
		net.sf.json.JSONObject jsonobject  = net.sf.json.JSONObject.fromObject(obj);
		//jsonobject.put(name, obj)
		return jsonobject.toString();
	}	
	
	/**
	 * jsonString转成bean
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static Object getJsonToObjct(Class beanClass,String jsonString){
		net.sf.json.JSONObject jsonobject  = new net.sf.json.JSONObject().fromObject(jsonString);
		return net.sf.json.JSONObject.toBean(jsonobject, beanClass);
	}	
	//*****************************************************************************************
	/**
	 * map转成jsonString
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static String getMapToJson(Map map){
		net.sf.json.JSONObject jsonobject  = net.sf.json.JSONObject.fromObject(map);
		//jsonobject.putAll(map);
		return jsonobject.toString();
	}
	
	/**
	 * jsonString转成map
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static Map getJsonToMap(String jsonString){
		Map map1  = net.sf.json.JSONObject.fromObject(jsonString);
		return map1;
	}
	
	//**************************************************************************************
	/**
	 * List转成jsonString
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static String getListToJson(List list){
		net.sf.json.JSONArray jsonArray  = net.sf.json.JSONArray.fromObject(list);
		//jsonobject.putAll(map);
		return jsonArray.toString();
	}
	
	/**
	 * jsonString转成List
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static List getJsonToList(String jsonString){
		List list  = net.sf.json.JSONArray.fromObject(jsonString);
		return list;
	}
	//**************************************************************************************
	/**
	 * xml转成jsonString
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static String getXMLToJson(String xmlString){
		net.sf.json.xml.XMLSerializer xmlSerializer = new net.sf.json.xml.XMLSerializer();  
		net.sf.json.JSON json = xmlSerializer.read(xmlString);  
		return json.toString(2);
	}
	
	/**
	 * jsonString转成xml
	 * @param <T>
	 * @param str
	 * @return
	 */
	public static String getJsonToXML(String jsonString){
		net.sf.json.JSONObject jsonObject  = net.sf.json.JSONObject.fromObject(jsonString);
		String xmlstr = new net.sf.json.xml.XMLSerializer().write(jsonObject);  
		return xmlstr;
	}
	
	
	public static void main(String[] args) throws org.dom4j.DocumentException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParserConfigurationException, SAXException, IOException, TransformerException {
		//String src = "<note><to>George</to><from>John</from><heading>Reminder</heading><body>你好</body></note>";
		//getsaxXMLToMap("E://note.xml");
		//********************************************************************
		//getsaxXMLToMap(new  ByteArrayInputStream(src.getBytes("UTF-8"))); //将字符串转成流 
		//********************************************************************
//		Msg msg = new Msg();
//		msg.setContent("你好");
//		msg.setId(1);
//		msg.setSendto("2");
//		System.out.println(getXstreamObjectToXML("Msg",Msg.class,msg));	
		//********************************************************************
		//addDomXMLNode("E://note.xml","adsfsdf","123423");
		//delDomXMLNode("E://note.xml",  "adsfsdf");
		//updateDomXMLText("E://note.xml",  "heading", "wwed");
		//********************************************************************
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		addDomXMLNode(new  ByteArrayInputStream(src.getBytes("UTF-8")),baos,"adsfsdf","123423");
//		String str = baos.toString();  
//		System.out.println(str);
		//System.out.println(addDomXMLNodeString(src,"adsfsdf","123423"));
		//*********************************************************************
//		Msg msg = new Msg();
//		msg.setContent("你好");
//		msg.setId(1);
//		msg.setSendto("2");
//		System.out.println(getObjectToJson("Msg",msg));	
		//********************************************************************
//		Map map = new HashMap();
//		map.put("Content", "你好");
//		map.put("Id", msg);
//		map.put("Sedto", new String[]{"1","2","3","5"});
		//System.out.println(getMapToJson(map));
		//********************************************************************		
//		Map masp = getJsonToMap("{\"2\":{\"content\":\"你好\",\"id\":1,\"sendto\":\"2\"},\"1\":{\"content\":\"你好\",\"id\":1,\"sendto\":\"2\"}}");
//		Set set = masp.keySet();  
//	    Iterator ite = set.iterator();  
//	    while (ite.hasNext()) {   
//	            JSONObject jsonObject = JSONObject.fromObject(masp.get(ite.next()));  
//	            Msg stu = (Msg) JSONObject.toBean(jsonObject, Msg.class);  
//	            System.out.println(stu.toString());
//	     }  
	    //*********************************************************************************
//		List list = new ArrayList();
//		list.add(msg);
//		System.out.println(getListToJson(list));
		//**************************************************
//		List list2 = getJsonToList("[{\"content\":\"你好\",\"id\":1,\"sendto\":\"2\"},{\"content\":\"你好\",\"id\":1,\"sendto\":\"2\"}]");
//		Iterator ite = list2.iterator();
//		while(ite.hasNext()){
//			JSONObject jsonObject = JSONObject.fromObject(ite.next());  
//			Msg stu = (Msg) JSONObject.toBean(jsonObject, Msg.class);
//			System.out.println(stu.toString());
//		}
	}
}

