package com.centran.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




/**
 * Created by IntelliJ IDEA. User: garmbrood Company: TianJi Media Group
 * DateTime:2009-4-25 19:40:09 Description:
 * 文件类操作,继承的方法参见org.apache.commons.io.FileUtils相关文档
 */
public class FileUtils extends org.apache.commons.io.FileUtils {
	// todo 其他自定义方法在该类中添加
	/**
	 * 读入文件到安符串中，本方法是以流的方式来读取。以系统默认的encoding到String<br>
	 * --------------------------------------------------------------------------<br>
	 * 创建者：杨思勇<br>
	 * 创建日期：2010-4-15<br>
	 * <br>
	 * 修改者：<br>
	 * 修改日期：<br>
	 * 修改原因：<br>
	 * --------------------------------------------------------------------------
	 * 
	 * @param fileFullName
	 *            文件名，包括路径
	 * @return 文件内容
	 * @throws IOException
	 *             读取例外。
	 */
	public static String fileRead(String fileFullName) throws IOException {
		// // ---------------------------------
		// // 定义返回结果变量
		// // ---------------------------------
		// String result = null;
		// InputStream in = null;
		// try {
		// File file = new File(fileFullName);
		// long len = file.length();
		// if (len > 0) {
		// // ---------------------------------
		// // 如果文件的字节数大于0，打开流
		// // ---------------------------------
		// in = new FileInputStream(file);
		// byte[] bytes = new byte[(int) len];
		// // ---------------------------------
		// // 读入全部内容到byte数组中
		// // ---------------------------------
		// in.read(bytes);
		// // ---------------------------------
		// // 把byte数组中的内容转换成String
		// // ---------------------------------
		// result = new String(bytes);
		// bytes = null;
		// }
		// } finally {
		// if (in != null) {
		// // ---------------------------------
		// // 如果流不为空，则最后要关闭流。
		// // ---------------------------------
		// try {
		// in.close();
		// in = null;
		// } catch (IOException e) {
		// // ---------------------------------
		// // 该例外不需要处理。
		// // ---------------------------------
		// }
		// }
		// }
		// return result;
		return fileRead(fileFullName, "UTF-8");
	}

	/**
	 * 读入文件到安符串中，本方法是以流的方式来读取，可以支持多种编码<br>
	 * --------------------------------------------------------------------------<br>
	 * 创建者：宋伟超<br>
	 * 创建日期：2010-4-15<br>
	 * <br>
	 * 修改者：<br>
	 * 修改日期：<br>
	 * 修改原因：<br>
	 * --------------------------------------------------------------------------
	 * 
	 * @param fileFullName
	 *            文件名，包括路径
	 * @return 文件内容
	 * @throws IOException
	 *             读取例外。
	 */
	public static String fileRead(String fileFullName, String charsetName)
			throws IOException {
		// ---------------------------------
		// 定义返回结果变量
		// ---------------------------------
		String result = null;
		InputStream in = null;
		try {
			File file = new File(fileFullName);
			long len = file.length();
			if (len > 0) {
				// ---------------------------------
				// 如果文件的字节数大于0，打开流
				// ---------------------------------
				in = new FileInputStream(file);
				byte[] bytes = new byte[(int) len];
				// ---------------------------------
				// 读入全部内容到byte数组中
				// ---------------------------------
				in.read(bytes);
				// ---------------------------------
				// 把byte数组中的内容转换成String
				// ---------------------------------
				result = new String(bytes, charsetName);
				bytes = null;
			}
		} finally {
			if (in != null) {
				// ---------------------------------
				// 如果流不为空，则最后要关闭流。
				// ---------------------------------
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					// ---------------------------------
					// 该例外不需要处理。
					// ---------------------------------
				}
			}
		}
		return result;
	}

	/**
	 * 将String写入到文件，该方法是以文本形式写得到文件中<br>
	 * --------------------------------------------------------------------------<br>
	 * 创建者：杨思勇<br>
	 * 创建日期：2004-1-5<br>
	 * <br>
	 * 修改者：<br>
	 * 修改日期：<br>
	 * 修改原因：<br>
	 * --------------------------------------------------------------------------
	 * 
	 * @param fileFullName
	 *            文件全名
	 * @param fileContent
	 *            内容
	 * @param append
	 *            是否追加
	 * @throws IOException
	 *             例外
	 */
	public static void fileWrite(String fileFullName, String fileContent,
			boolean append) throws IOException {
		File f = new File(fileFullName);
		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();
		fileWrite(f, fileContent, append);
	}

	/**
	 * 将String写入到文件，该方法是以文本形式写得到文件中<br>
	 * --------------------------------------------------------------------------<br>
	 * 创建者：杨思勇<br>
	 * 创建日期：2004-1-5<br>
	 * <br>
	 * 修改者：宋伟超<br>
	 * 修改日期：2010-2-25<br>
	 * 修改原因：此方法可以支持多种编码，默认UTF-8<br>
	 * --------------------------------------------------------------------------
	 * 
	 * @param fileFullName
	 *            文件全名
	 * @param fileContent
	 *            内容
	 * @param append
	 *            是否追加
	 * @throws IOException
	 *             例外
	 */
	public static void fileWrite(File fileFullName, String fileContent,
			boolean append) throws IOException {
		// FileWriter writer = null;
		// try {
		// System.setProperty("file.encoding", "UTF-8");
		// System.setProperty("user.language", "zh");
		//			
		// // ---------------------------------
		// // 获得一个文件写入的句柄
		// // ---------------------------------
		// writer = new FileWriter(fileFullName, append);
		// // ---------------------------------
		// // 写入内容
		// // ---------------------------------
		// writer.write(fileContent);
		// // ---------------------------------
		// // 将内容写到碰盘上
		// // ---------------------------------
		// writer.flush();
		// } finally {
		// if (writer != null) {
		// // ---------------------------------
		// // 如果句柄不为空。则最后要关闭句柄
		// // ---------------------------------
		// try {
		// writer.close();
		// writer = null;
		// } catch (IOException e) {
		// }
		// }
		// }
		fileWrite(fileFullName, fileContent, append, "UTF-8");
	}

	/**
	 * 将String写入到文件，该方法是以文本形式写得到文件中，可以支持多种编码<br>
	 * --------------------------------------------------------------------------<br>
	 * 创建者：宋伟超<br>
	 * 创建日期：2010-2-25<br>
	 * --------------------------------------------------------------------------
	 * 
	 * @param fileFullName
	 *            文件全名
	 * @param fileContent
	 *            内容
	 * @param append
	 *            是否追加
	 * @param charsetName
	 *            文件编码
	 * @throws IOException
	 *             例外
	 */
	public static void fileWrite(File fileFullName, String fileContent,
			boolean append, String charsetName) throws IOException {
		OutputStreamWriter out = null;
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(fileFullName);
			out = new OutputStreamWriter(fout, charsetName);
			out.write(fileContent);
			out.flush();
		} finally {
			if (fout != null) {
				try {
					fout.close();
					fout = null;
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * 将byte数组写入到文件，本方法是以二进制的形式写到碰盘上<br>
	 * --------------------------------------------------------------------------<br>
	 * 创建者：杨思勇<br>
	 * 创建日期：2004-1-5<br>
	 * <br>
	 * 修改者：<br>
	 * 修改日期：<br>
	 * 修改原因：<br>
	 * --------------------------------------------------------------------------
	 * 
	 * @param fileFullName
	 *            文件全名
	 * @param fileContent
	 *            内容
	 * @param append
	 *            是否追加
	 * @throws IOException
	 *             例外
	 */
	public static void fileWrite(String fileFullName, byte[] fileContent,
			boolean append) throws IOException {
		fileWrite(new File(fileFullName), fileContent, append);
	}

	/**
	 * 将byte数组写入到文件，本方法是以二进制的形式写到碰盘上<br>
	 * --------------------------------------------------------------------------<br>
	 * 创建者：杨思勇<br>
	 * 创建日期：2004-1-5<br>
	 * <br>
	 * 修改者：<br>
	 * 修改日期：<br>
	 * 修改原因：<br>
	 * --------------------------------------------------------------------------
	 * 
	 * @param fileFullName
	 *            文件全名
	 * @param fileContent
	 *            内容
	 * @param append
	 *            是否追加
	 * @throws IOException
	 *             例外
	 */
	public static void fileWrite(File fileFullName, byte[] fileContent,
			boolean append) throws IOException {
		FileOutputStream outputStream = null;
		try {
			// ---------------------------------
			// 获得一个二进制写入流的句柄
			// ---------------------------------

			// System.setProperty("file.encoding", "UTF-8");
			// System.setProperty("user.language", "zh");

			outputStream = new FileOutputStream(fileFullName, append);
			// ---------------------------------
			// 写入内容
			// ---------------------------------
			outputStream.write(fileContent);
			// ---------------------------------
			// 将内容写到碰盘上
			// ---------------------------------
			outputStream.flush();
		} finally {
			if (outputStream != null) {
				// ---------------------------------
				// 如果句柄不为空。则最后要关闭句柄
				// ---------------------------------
				try {
					outputStream.close();
					outputStream = null;
				} catch (Exception e) {
				}
			}
		}
	}

	public static void fileWrite(File path, String fileName, String content,
			boolean append) throws IOException {
		if (!path.exists() || !path.isDirectory())
			path.mkdirs();
		File file = new File(path, fileName);
		fileWrite(file.getPath(), content, append);
	}

	public static void fileWrite(File path, String filename, byte[] data,
			boolean append) throws IOException {
		FileOutputStream fos = null;
		try {
			if (!path.exists()) {
				path.mkdirs();
			}
			fos = new FileOutputStream(new File(path, filename));
			fos.write(data);
			fos.close();
		} finally {
			if (fos != null)
				fos.close();
		}
	}

	/**
	 * 根据URL地址，读取URL中的内容
	 * 
	 * 
	 * @param path
	 *            URL地址
	 * @return URL中的内容
	 */
	public static String getUrlContent(String path) {
		String rtn = "";
		int c;
		InputStream l_urlStream = null;
		java.net.HttpURLConnection l_connection = null;
		try {
			if (path.indexOf("http://") == -1) {
				path = "http://" + path;
			}
			java.net.URL l_url = new java.net.URL(path);
			l_connection = (java.net.HttpURLConnection) l_url.openConnection();
			l_connection.setRequestProperty("User-agent", "Mozilla/4.0");
			l_connection.connect();
			l_urlStream = l_connection.getInputStream();
			while (((c = l_urlStream.read()) != -1)) {
				int all = l_urlStream.available();
				byte[] b = new byte[all];
				l_urlStream.read(b);
				rtn += new String(b, "UTF-8");
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (l_connection != null)
				l_connection.disconnect();
			if (l_urlStream != null)
				try {
					l_urlStream.close();
				} catch (IOException e) {
				}
		}
		return rtn;
	}

	/**
	 * 根据内容提取图片URL
	 * 
	 * @param htmlStr
	 *            内容
	 * @return 图片URL数组
	 */
	public static String[] getImgStr(String htmlStr) {
		String img = "";
		java.util.regex.Pattern p_image;
		java.util.regex.Matcher m_image;

		String regEx_img = "<img\\s+[^>]*src=['\"]?([^'\"\\s>]*)['\"]?\\s*[^>]*>"; // 图片链接地址
		p_image = java.util.regex.Pattern.compile(regEx_img,
				java.util.regex.Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr);
		while (m_image.find()) {
			img = img + "," + m_image.group(1);
		}
		if (img.indexOf(",") >= 0) {
			String images = img.substring(1);
			return images.split(",");
		} else {
			return null;
		}
	}

	/**
	 * 根据内容提取css样式的URL
	 * 
	 * @param htmlStr
	 *            内容
	 * @return 图片URL数组
	 */
	public static String[] getCssStr(String htmlStr) {
		String img = "";
		java.util.regex.Pattern p_image;
		java.util.regex.Matcher m_image;

		String regEx_img = "<LINK\\s+[^>]*href=['\"]?([^'\"\\s>]*)['\"]?\\s*[^>]*>"; // css链接地址
		p_image = java.util.regex.Pattern.compile(regEx_img,
				java.util.regex.Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr);
		while (m_image.find()) {
			String temp = m_image.group(1);
			if (!temp.toLowerCase().startsWith("/imagelist/")
					&& !temp.toLowerCase().startsWith("http://")) {
				if (temp.toLowerCase().indexOf(".css") > -1) {
					img = img + "," + temp;
				}
			}
		}
		if (img.indexOf(",") >= 0) {
			String images = img.substring(1);
			return images.split(",");
		} else {
			return null;
		}
	}

	/**
	 * 根据内容提取样式中背景图片URL
	 * 
	 * @param htmlStr
	 *            内容
	 * @return 图片URL数组
	 */
	public static String[] getCssImgStr(String htmlStr) {
		String img = "";
		java.util.regex.Pattern p_image;
		java.util.regex.Matcher m_image;

		String regEx_img = "url(([^'\"\\s>]*))*"; // 样式中背景图片链接地址
		p_image = java.util.regex.Pattern.compile(regEx_img,
				java.util.regex.Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr);
		while (m_image.find()) {
			String temp = m_image.group();
			if (StringUtils.isNotEmpty(temp)) {
				if (temp.toLowerCase().indexOf("/imagelist/") > -1
						|| temp.toLowerCase().indexOf("http://") > -1) {
				} else {
					if (temp.toLowerCase().indexOf(".jpg") > -1
							|| temp.toLowerCase().indexOf(".gif") > -1
							|| temp.toLowerCase().indexOf(".png") > -1
							|| temp.toLowerCase().indexOf(".bmp") > -1) {
						img = img
								+ ","
								+ temp.substring(temp.indexOf("(") + 1, temp
										.indexOf(")"));
					}
				}
			}
		}
		if (img.indexOf(",") >= 0) {
			String images = img.substring(1);
			return images.split(",");
		} else {
			return null;
		}
	}

	/**
	 * 根据内容匹配“background=”中包含的图片
	 */
	public static HashSet<String> getBackgroundHS(String htmlStr) {
		Pattern pTable_XSX = Pattern.compile("background=([\\s\\S](?! ))*");

		Matcher matcher = pTable_XSX.matcher(htmlStr);

		HashSet<String> hs = new HashSet<String>();

		while (matcher.find()) {
			String str1 = matcher.group();
			int beginIndex = str1.indexOf("=");
			int endIndex = str1.lastIndexOf(".");
			if (endIndex > beginIndex) {
				if (str1.length() - endIndex >= 4) {
					str1 = str1.substring(beginIndex + 1, endIndex + 4);
				} else {
					String houzhui = str1.substring(endIndex);
					if (".jp".equals(houzhui.toLowerCase())) {
						str1 = str1.substring(beginIndex + 1, endIndex)
								+ ".jpg";
					} else if (".gi".equals(houzhui.toLowerCase())) {
						str1 = str1.substring(beginIndex + 1, endIndex)
								+ ".gif";
					} else if (".pn".equals(houzhui.toLowerCase())) {
						str1 = str1.substring(beginIndex + 1, endIndex)
								+ ".png";
					} else if (".bm".equals(houzhui.toLowerCase())) {
						str1 = str1.substring(beginIndex + 1, endIndex)
								+ ".bmp";
					}
				}
				str1 = str1.replaceAll("background=", "");
				str1 = str1.replaceAll("\"", "");
				str1 = str1.replaceAll("'", "");
				if (StringUtils.isNotEmpty(str1)) {
					if (str1.toLowerCase().indexOf("/imagelist/") > -1
							|| str1.toLowerCase().indexOf("http://") > -1) {
					} else {
						if (str1.toLowerCase().indexOf(".jpg") > -1
								|| str1.toLowerCase().indexOf(".gif") > -1
								|| str1.toLowerCase().indexOf(".png") > -1
								|| str1.toLowerCase().indexOf(".bmp") > -1) {
							hs.add(str1);
						}
					}
				}
			}
		}

		return hs;
	}

	/**
	 * 根据内容匹配“<script src="****.js"></script>”中包含的图片
	 */
	public static HashSet<String> getScriptHS(String htmlStr) {
		Pattern pTable_XSX = Pattern
				.compile("<script\\s\\S([\\s\\S](?!/script>))*");

		Matcher matcher = pTable_XSX.matcher(htmlStr);

		HashSet<String> hs = new HashSet<String>();

		while (matcher.find()) {
			String str1 = matcher.group();
			str1 = str1.replaceAll("\"", "");
			str1 = str1.replaceAll("'", "");
			String str1ToL = str1.toLowerCase();
			int beginIndex = str1ToL.indexOf("src=");
			int endIndex = str1ToL.lastIndexOf(".js");
			if (endIndex > beginIndex) {
				str1 = str1.substring(beginIndex + 4, endIndex + 3);
				if (StringUtils.isNotEmpty(str1)) {
					if (str1.toLowerCase().indexOf("/imagelist/") > -1
							|| str1.toLowerCase().indexOf("http://") > -1
							|| str1.toLowerCase().indexOf("+") > -1) {
					} else {
						if (str1.toLowerCase().indexOf(".jpg") > -1
								|| str1.toLowerCase().indexOf(".gif") > -1
								|| str1.toLowerCase().indexOf(".png") > -1
								|| str1.toLowerCase().indexOf(".bmp") > -1) {
							hs.add(str1);
						}
					}
				}
			}
		}

		return hs;
	}

	/**
	 * 统一的根据内容提取样式中背景图片URL、css样式的URL、图片URL
	 * 
	 * @param htmlStr
	 * @return
	 */
	public static String[] getURLStr(String htmlStr) {
		HashSet<String> strList = new HashSet<String>();

		String[] strarr = FileUtils.getImgStr(htmlStr);
		if (strarr != null && strarr.length > 0) {
			for (int i = 0; i < strarr.length; i++) {
				if (StringUtils.isNotEmpty(strarr[i])) {
					if (strarr[i].indexOf("/imagelist/") > -1
							|| (strarr[i].toLowerCase()).indexOf("/imagelist/") > -1) {
					} else {
						if (strarr[i].indexOf("http://") > -1
								|| (strarr[i].toLowerCase()).indexOf("http://") > -1) {
						} else {
							if (strarr[i].indexOf("//") > -1) {
							} else {
								strList.add(strarr[i]);
							}
						}
					}
				}
			}
		}

		String[] cssarr = FileUtils.getCssStr(htmlStr);
		if (cssarr != null && cssarr.length > 0) {
			for (int i = 0; i < cssarr.length; i++) {
				strList.add(cssarr[i]);
			}
		}

		String[] cssImgArr = FileUtils.getCssImgStr(htmlStr);
		if (cssImgArr != null && cssImgArr.length > 0) {
			for (int i = 0; i < cssImgArr.length; i++) {
				strList.add(cssImgArr[i]);
			}
		}

		HashSet<String> hs_gbg = getBackgroundHS(htmlStr);
		if (hs_gbg != null && hs_gbg.size() > 0) {
			Iterator<String> it = hs_gbg.iterator();
			while (it.hasNext()) {
				strList.add(it.next());
			}
		}

		HashSet<String> hs_script = getScriptHS(htmlStr);
		if (hs_script != null && hs_script.size() > 0) {
			Iterator<String> it = hs_script.iterator();
			while (it.hasNext()) {
				strList.add(it.next());
			}
		}

		// 统一去掉不合格的链接
		Iterator<String> it_w = strList.iterator();
		while (it_w.hasNext()) {
			String s = it_w.next();
			if (s.startsWith("../a/")) {
				strList.remove(s);
			}
		}

		// 统一组装成一个数组
		String[] returnURLArray = null;
		if (strList != null && strList.size() > 0) {
			returnURLArray = new String[strList.size()];
			Iterator<String> it = strList.iterator();
			int i = 0;
			while (it.hasNext()) {
				returnURLArray[i] = it.next();
				i++;
			}
		}

		if (returnURLArray != null && returnURLArray.length > 0) {
			returnURLArray = sortStringArray(returnURLArray);
		}

		return returnURLArray;
	}

	/**
	 * 排序方法
	 */
	public static String[] sortStringArray(String[] arrStr) {
		String temp;
		for (int i = 0; i < arrStr.length; i++) {
			for (int j = arrStr.length - 1; j > i; j--) {
				if (arrStr[i].length() < arrStr[j].length()) {
					temp = arrStr[i];
					arrStr[i] = arrStr[j];
					arrStr[j] = temp;
				}
			}
		}
		return arrStr;
	}

	/**
	 * 读取Properties文件.
	 * 
	 * @param args
	 */
	public static Properties readPropertiesFile(String filepath) {
		FileUtils fu = new FileUtils();
		InputStream inputStream = fu.getClass().getClassLoader()
				.getResourceAsStream(filepath);
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (inputStream != null)
				try {
					inputStream.close();
				} catch (IOException e1) {
				}
		}
		return p;
	}

	/**
	 * 读取指定的“config.properties”Properties文件.
	 * 
	 * @param args
	 */
	public static Properties readConfigProperties() {
		return readPropertiesFile("config.properties");
	}

	public static void main(String[] args) {
		String[] files = {"CityExport.txt","ProductNameExport.txt","ProductExport.txt","WarehouseExport.txt","OrganizationExport.txt","ContractExport.txt","CustomerExport.txt","StockInfoExport.txt","PortExport.txt","LogisticsExport.txt","InteractiveFormExport.txt","OrderCommodityExport.txt","OrderSaleinfoExport.txt","OrderCustomerExport.txt","OrderPaymentExport.txt","OrderExport.txt","OrderTransportExport.txt","StorageEntrustExport.txt","SupplyInformationExport.txt","WarehouseNoticeExport.txt","SupplyNoticeExport.txt","DispatchNoteExport.txt","DeliveryNoticeExport.txt","LogisticsEntrustExport.txt","ProductEntrustExport.txt","BookingCabinExport.txt","TransportProductExport.txt","TransportNoteExport.txt","ShippingInformationExport.txt"};
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<files.length;i++){
			try {
				sb.append(fileRead("D:/test/cts/exports/all/"+files[i]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fileWrite("D:/test/cts/exports/all.txt", sb.toString(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String[] images = FileUtils.getImgStr(FileUtils
		// .getUrlContent("http://www.baidu.com"));
		// if (images != null && images.length > 0) {
		// for (int i = 0; i < images.length; i++) {
		// System.out.println(images[i]);
		// }
		// }
		// Properties p = readPropertiesFile("config.properties");
		// System.out.println("filepath.cooperate.publishpath.main:"+p.getProperty("filepath.cooperate.publishpath.main"));
		// String readFileRootPath = FileUtils.readPropertiesFile(
		// "config.properties").getProperty("readFileRootPath");
		// System.out.println("根目录：" + readFileRootPath);

		// System.out.println(StringUtils.htmlEncode("</textarea>"));

		// 已替换的新内容URL格式
		// String newContent = mc.replaceAll("href=\"./a/$1.shtml");
		// System.out.println("str:"+newContent);
		// String[] strarr = FileUtils.getURLStr(str);
		// if (strarr!=null && strarr.length>0){
		// for (int i=0;i<strarr.length;i++){
		// System.out.println(strarr[i]);
		// }
		// }
//		String c = "dsfsdf<!--#include virtual=\"b_20714_blockcode597.html\" -->dsfsdf<!--#include virtual=\"b_20714_blockcode5444.html\" -->dfdsf";
//		System.out.println(replaceContentIncludeToFileContent(c,
//				"/sdfsdg/sdff/index.shtml"));
		
//		String htmlStr = "<div class=\"tplbwzgd \"><ul>	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 	<li><h6><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\"><img src=\"\" /></a></h6>	<p><a href=\"\" title=\"${article.oriTitle}\" target=\"_blank\">          </a></li>	 </ul>";
		
		
//		System.out.println(htmlStr.replaceAll("\\$", ""));
	}

	/**
	 * 对专题中的“<!--#include virtual="b_20714_blockcode597.html" -->”，进行内容替换
	 */
	public static String replaceContentIncludeToFileContent(String content,
			String storeFilePath) {
		storeFilePath = storeFilePath.substring(0, storeFilePath
				.lastIndexOf("/") + 1);

		Pattern pTable_XSX = Pattern
				.compile("<!--#include virtual=([\\s\\S](?!-->))*");
		Matcher matcher = pTable_XSX.matcher(content);
		String[] a = new String[100];
		String[] b = new String[100];
		int count = 0;
		while (matcher.find()) {
			String str1 = matcher.group();

			a[count] = str1 + " -->";
			String p = storeFilePath
					+ str1.substring(str1.indexOf("\"") + 1, str1
							.lastIndexOf("\""));

			try {
				b[count] = "*" + p + "*";
				b[count] = FileUtils.fileRead(p);
			} catch (Exception e) {
				b[count] = "-1";
				System.out.println("读取包含文件错误：" + e.getMessage());
				e.printStackTrace();
				continue;
			}
			count++;
		}
		
		if (a != null && a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				if (StringUtils.isNotEmpty(a[i]) && !"-1".equals(b[i])) {
					// 依次进行内容的替换。
					String str_b = b[i];
					if (StringUtils.isNotEmpty(str_b) && str_b.indexOf("${")>-1){
						
						str_b = str_b.replaceAll("\\$", "");
					}
					content = content.replaceAll(a[i], str_b);
				} else
					break;// 否则的话，退出内容替换。
			}
		}

		return content;
	}

	/**
	 * 公共的写文件操作
	 * 
	 * @param pathfilename
	 * @param content
	 * @param b
	 */
	public static void handWriteFile(String pathfilename, String content,
			boolean b) {
		Properties p = FileUtils.readPropertiesFile("config.properties");
		if (p != null) {
			try {
				// 执行写入文件.
				FileUtils.fileWrite(p
						.getProperty("filepath.cooperate.publishpath.main")
						+ pathfilename, content, b);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("警告:写入合作块文件错误.错误内容:" + e.getMessage());
			}
		} else {
			System.out.println("警告:读取文件路径(config.properties)错误!请检查!");
		}
	}
	
	/**
	 * 公共的写文件操作
	 * 
	 * @param pathfilename
	 * @param content
	 * @param b
	 */
	public static void handWriteBlockFile(String pathfilename, String content,
			boolean b) {
		Properties p = FileUtils.readPropertiesFile("config.properties");
		if (p != null) {
			try {
				String file = p.getProperty("filepath.cooperate.publishpath.main")+pathfilename;
				File des = new File(file);
				if (!des.exists()){
					// 执行写入文件.
					FileUtils.fileWrite(file, content, b);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("警告:写入合作块文件错误.错误内容:" + e.getMessage());
			}
		} else {
			System.out.println("警告:读取文件路径(config.properties)错误!请检查!");
		}
	}

	/**
	 * 文件夹拷贝，将源文件夹下的所有文件及其子文件夹（文件）拷贝到目标文件夹（文件）下
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param desFile
	 *            目标文件
	 * @return
	 */
	public static boolean copyDirectiory(String sourceFile, String desFile)
			throws IOException {

		File source = new File(sourceFile);
		if (!source.exists()) {
			System.out.println(source.getAbsolutePath()
					+ "========源文件不存在！=======");
			return false;
		}
		File des = new File(desFile);
		if (!des.exists())
			des.mkdirs();// 不存在目标文件就创建

		// File[] file = source.listFiles();
		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			// for (int i = 0; i < file.length; i++) {
			if (source.isFile()) { // 如果是文件 则读源文件 写入目标文件
				input = new FileInputStream(source);
				output = new FileOutputStream(new File(desFile + "/"
						+ source.getName()));
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) { // 读文件
					output.write(b, 0, len); // 向目标文件写文件
				}
				input.close();
				output.flush();
				output.close();
				// } else if (file[i].isDirectory()) { // 如果是文件夹 递归读取子文件或文件夹
				// copyDirectiory(sourceFile + "/" + file[i].getName(),
				// desFile + "/" + file[i].getName());
			}
			// }
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (input != null)
				input.close();
			if (output != null)
				output.close();
		}
	}

	/**
	 * 文件夹拷贝，将源文件夹下的所有文件及其子文件夹（文件）拷贝到目标文件夹（文件）下
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param desFile
	 *            目标文件
	 * @return
	 */
	public static boolean copyDirectioryFile(String sourceFile, String desFile)
			throws IOException {

		File source = new File(sourceFile);
		if (!source.exists()) {
			System.out.println(source.getAbsolutePath()
					+ "========源文件不存在！=======");
			return false;
		}
		File des = new File(desFile);
		if (!des.exists())
			des.mkdirs();// 不存在目标文件就创建

		File[] file = source.listFiles();
		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			for (int i = 0; i < file.length; i++) {
				if (source.isFile()) { // 如果是文件 则读源文件 写入目标文件
					input = new FileInputStream(source);
					output = new FileOutputStream(new File(desFile + "/"
							+ source.getName()));
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) { // 读文件
						output.write(b, 0, len); // 向目标文件写文件
					}
					input.close();
					output.flush();
					output.close();
				} else if (file[i].isDirectory()) { // 如果是文件夹 递归读取子文件或文件夹
					copyDirectiory(sourceFile + "/" + file[i].getName(),
							desFile + "/" + file[i].getName());
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (input != null)
				input.close();
			if (output != null)
				output.close();
		}
	}

	/**
	 * 文件夹拷贝，将源文件夹下的所有文件及其子文件夹（文件）拷贝到目标文件夹（文件）下
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param desFile
	 *            目标文件
	 * @return
	 */
	public static String[] testCopyDirectioryFile(String sourceFile,
			String desFile) throws IOException {
		File source = new File(sourceFile);
		if (!source.exists()) {
			System.out.println(source.getAbsolutePath()
					+ "========源文件不存在！=======");
			return null;
		} else {
			File des = new File(desFile);
			if (!des.exists())
				des.mkdirs();// 不存在目标文件就创建
			File[] file = source.listFiles();
			FileInputStream input = null;
			FileOutputStream output = null;
			try {
				String[] strarray = new String[file.length];
				for (int i = 0; i < file.length; i++) {
					if (file[i].isFile()) { // 如果是文件 则读源文件 写入目标文件
						String filename = file[i].getName();
						// if (StringUtils.isNotEmpty(filename)){
						// if
						// (filename.toLowerCase().indexOf("index.shtml")==-1){
						strarray[i] = filename;
						// }
						// }
					} else if (file[i].isDirectory()) { // 如果是文件夹 递归读取子文件或文件夹
						testCopyDirectioryFile(sourceFile + "/"
								+ file[i].getName(), desFile + "/"
								+ file[i].getName());
					}
				}
				return strarray;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (input != null)
					input.close();
				if (output != null)
					output.close();
			}
		}

	}

}
