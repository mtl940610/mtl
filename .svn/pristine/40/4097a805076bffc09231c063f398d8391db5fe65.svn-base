package com.centran.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Random;

import com.google.zxing.NotFoundException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Created by MyEclipse
 * User:  赵亮
 * Company: 
 * DateTime:2015-03-24 13:39:20
 * Description:验证码图片、二维码图片、图片水印、图片缩放、base64图片
 */
public class ImageOpreate {
	/**
	 * 获得验证码图片
	 * @param str
	 * @return
	 */
	public static String getCodeCreat(int width,int height,int codeCount,OutputStream outStream) {
        int xx = 15; 
        int fontHeight = 18; 
        int codeY = 18; 
        char[] codeSequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuffer randomCode = new StringBuffer(); 
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
       // Graphics gd = buffImg.getGraphics(); 
        Graphics2D gd = buffImg.createGraphics();
        Random random = new Random(); 
        // 将图像填充为白色
        gd.setColor(Color.WHITE); 
        gd.fillRect(0, 0, width, height); 
        // 创建字体，字体的大小应该根据图片的高度来定
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight); 
        // 设置字体。
        gd.setFont(font); 
        // 画边框
        gd.setColor(Color.BLACK); 
        gd.drawRect(0, 0, width - 1, height - 1);  
        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。 
        gd.setColor(Color.BLACK); 
        for (int i = 0; i < 10; i++) { 
            int x = random.nextInt(width); 
            int y = random.nextInt(height); 
            int xl = random.nextInt(6); 
            int yl = random.nextInt(6); 
            gd.drawLine(x, y, x + xl, y + yl); 
        } 
        
        int red = 0, green = 0, blue = 0; 
        // 随机产生codeCount数字的验证码。 
        
        boolean falg = false;
        for (int i = 0; i < codeCount; i++) { 
        	// 得到随机产生的验证码数字。  
            String code = String.valueOf(codeSequence[random.nextInt(34)]); 
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255); 
            green = random.nextInt(255); 
            blue = random.nextInt(255); 
            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue)); 
            //旋转
            int round2 =  random.nextInt(5); 
            if(falg){
            	gd.rotate(Math.toRadians(round2),(i + 1) * xx/2,codeY/2);
            	falg = false;
            }else{
            	gd.rotate(-Math.toRadians(round2),(i + 1) * xx/2,codeY/2);
            	falg = true;
            }
            gd.drawString(code, (i + 1) * xx, codeY); 
            // 将产生的四个随机数组合在一起。
            randomCode.append(code); 
        } 
        try {
			ImageIO.write(buffImg, "gif", outStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(outStream!=null){
				try {outStream.close();} catch (IOException e) {e.printStackTrace();} 		
			}
		}
        return randomCode.toString();
	}
	/**
	 * 文字水印
	 * @param str
	 * @return
	 */
	public static void getStringWatermark(String oldFilePath,String newFilePath,String marksString,int fontSize){
		File fileold  = new File(oldFilePath);
		if(!fileold.exists()){System.out.println("该文件不存在！");return;}		
		File filenew  = new File(newFilePath);
		if(filenew.exists()){System.out.println("输出文件夹已有该文件！");return;}
		
		InputStream  ins = null;
		OutputStream  outs = null;
		try {
			ins = new FileInputStream(fileold);
			outs = new FileOutputStream(filenew);
			
			//读取原来图片宽高
			Image imageOld = ImageIO.read(ins);
			int widthOld = imageOld.getWidth(null);
			int heightOld = imageOld.getHeight(null);
			
			//创建二维绘图区
			BufferedImage bufferedImage = new BufferedImage(widthOld,heightOld,BufferedImage.TYPE_INT_RGB);
			//创建绘图工具对象
			Graphics2D g2d = bufferedImage.createGraphics();
			//将工具对应到缓冲图片中去
			g2d.drawImage(imageOld,0,0,widthOld,heightOld,null);
			//文字颜色
			g2d.setFont(new Font("微软雅黑",Font.BOLD,fontSize));
			g2d.setColor(Color.red);
			//淡化处理，0-1之间
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8F));	
			
			//调整坐标*********************************************************
			int X = 10;
			int Y = 10;		
			//取得文本长度
			int marksLength = marksString.length();
			for(int i = 0;i<marksString.length();i++){
				String s = String.valueOf(marksString.charAt(i));
				if(s.getBytes().length>1){marksLength++;}
			}
			marksLength = ( marksLength%2==0 ) ? marksLength/2 : marksLength/2+1;
			
			int frontwidth = fontSize*marksLength;
			int frontheight = fontSize ;
			
			if(X>( widthOld-frontwidth ) ){ X=widthOld-frontwidth;}			
			if(Y>( heightOld-frontheight )){ Y=heightOld-frontheight; }
			//调整坐标结束*********************************************************
			//旋转
			g2d.rotate(Math.toRadians(30),X/2,Y/2);			
			g2d.drawString(marksString, X, Y+fontSize);
			g2d.dispose();
			
			
			//输出到磁盘
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(outs);
			en.encode(bufferedImage);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ins!=null){try {ins.close();} catch (IOException e) {e.printStackTrace();}}
			if(outs!=null){try {outs.close();} catch (IOException e) {e.printStackTrace();}}
			System.out.println("文件已输出到："+ newFilePath);
		}	
	}
	/**
	 * 单个图像水印
	 * @param str
	 * @return
	 */
	public static void getImageWatermark(String oldFilePath,String newFilePath,String marksFilePath) throws IOException{
		File fileold  = new File(oldFilePath);
		if(!fileold.exists()){System.out.println("该文件不存在！");return;}
		
		File filenew  = new File(newFilePath);
		if(filenew.exists()){System.out.println("输出文件夹已有该文件！");return;}
		
		File filemarks  = new File(marksFilePath);
		if(!filemarks.exists()){System.out.println("水印文件不存在！");return;}
 
		InputStream ins = null;
		InputStream insmark = null;
		OutputStream outs = null;
		
		try {
			ins = new FileInputStream(fileold);
			insmark = new FileInputStream(filemarks);
			outs = new FileOutputStream(filenew);
			
			//读取原来图片
			Image imageOld = ImageIO.read(ins);
			int widthOld = imageOld.getWidth(null);
			int heightOld = imageOld.getHeight(null);
			
			//创建二维绘图区
			BufferedImage bufferedImage = new BufferedImage(widthOld,heightOld,BufferedImage.TYPE_INT_RGB);
			//创建绘图工具对象
			Graphics2D g2d = bufferedImage.createGraphics();
			//将工具对应到缓冲图片中去
			g2d.drawImage(imageOld,0,0,widthOld,heightOld,null);
			//淡化处理，0-之间
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8F));
			
			//读取原来图片
			Image imageMark = ImageIO.read(insmark);
			int widthMark= imageOld.getWidth(null);
			int heightMark = imageOld.getHeight(null);
			
			//调整坐标*********************************************************
			int X = 10;
			int Y = 10;		
			int widthTemp = widthOld - widthMark;
			int heightTemp = heightOld  - heightMark;
			if(X>widthTemp){ X=widthTemp;}
			if(Y>heightTemp){Y =heightTemp;}

			//调整坐标结束*********************************************************
			//旋转
			g2d.rotate(Math.toRadians(30),X/2,Y/2);
			g2d.drawImage(imageMark, X,  Y ,null);
			
			g2d.dispose();
			
			//输出到磁盘
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(outs);
			en.encode(bufferedImage);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ins!=null){try {ins.close();} catch (IOException e) {e.printStackTrace();}}
			if(insmark!=null){try {insmark.close();} catch (IOException e) {e.printStackTrace();}}
			if(outs!=null){try {outs.close();} catch (IOException e) {e.printStackTrace();}}
			System.out.println("文件已输出到："+ newFilePath);
		}	
	}
	/**
	 * 图片不失真缩放
	 * @param str
	 * @return
	 */
	public static void getThumbnailImage(String oldFilePath,String newFilePath,double multiple){
		//图片最小值
		int withDefault = 1;
		int heihtDefault = 1;
		File fileold  = new File(oldFilePath);
		if(!fileold.exists()){System.out.println("该文件不存在！");return;}
		File filenew  = new File(newFilePath);
		if(filenew.exists()){System.out.println("输出文件夹已有该文件！");return;} 
		InputStream ins = null;
		OutputStream outs = null;	
		try {
			ins = new FileInputStream(fileold);
			outs = new FileOutputStream(filenew);
			
			//读取原来图片		
			Image imageOld = ImageIO.read(ins);
			
			//算出缩放比例
			int widthOld = imageOld.getWidth(null);
			int heightOld = imageOld.getHeight(null);
			int widthNew = (int)(widthOld*multiple);
			int heightNew = (int)(heightOld*multiple);
			if(widthNew<withDefault){widthNew = withDefault;};
			if(heightNew<heihtDefault){heightNew = heihtDefault;};
			
			//创建二维绘图区
			BufferedImage bufferedImage = new BufferedImage(widthNew,heightNew,BufferedImage.TYPE_INT_RGB);
			bufferedImage.getGraphics().drawImage(imageOld.getScaledInstance(widthNew,heightNew, Image.SCALE_SMOOTH),0,0,null);
			String fileType = newFilePath.substring(newFilePath.indexOf(".")+1,newFilePath.length());
			ImageIO.write(bufferedImage, fileType,outs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ins!=null){try {ins.close();} catch (IOException e) {e.printStackTrace();}}
			if(outs!=null){try {outs.close();} catch (IOException e) {e.printStackTrace();}}
			System.out.println("文件已输出到："+ newFilePath);
		}	
	}
	/**
	 * 获得Base64图片String
	 * @param str
	 * @return
	 */
	public static String getBase64ImageBinary(String src,String format) throws IOException{
		java.io.File file =new java.io.File(src);//图片路径
		if(!file.exists()){
			System.out.println("不存在该文件！");
			return "不存在该文件！";
		}
		java.awt.image.BufferedImage bi = javax.imageio.ImageIO.read(file);
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		javax.imageio.ImageIO.write(bi,format,baos);//图片后缀
		byte[] bytes = baos.toByteArray();
		//在HTML的img中的src填入该返回值 
		return "data:image/"+format+";base64,"+new sun.misc.BASE64Encoder().encodeBuffer(bytes).trim();
	}
	/**
	 * Base64String转成图片
	 * @param encoderBytes
	 * @return
	 */
	public static void getBase64StringToImage(String base64String,String path,String format) throws IOException{
		int index = base64String.indexOf("base64,");
		if(index>0){
			base64String = base64String.substring(index,base64String.length());
		}
		byte[] bytes1 = new sun.misc.BASE64Decoder().decodeBuffer(base64String);		
		ByteArrayInputStream bais=new ByteArrayInputStream(bytes1);
		BufferedImage bi1 = ImageIO.read(bais);
		File file = new File(path);//可以是jpg,png,gif格式   
		if(!file.exists()){
			ImageIO.write(bi1,format,file);//不管输出什么格式图片，此处不需改动  
			System.out.println("输出成功在"+path);
		}else{
			System.out.println("输出路径已经存在该图片！");
		}
	}
	/**
	 * 获得二维码
	 * @param str
	 * @return
	 */
	public static void getQRCodeCreat(int width,int height,String format,String conent,OutputStream stream) throws com.google.zxing.WriterException, IOException{
		//定义二维码参数
    	HashMap hints = new HashMap();
    	hints.put(com.google.zxing.EncodeHintType.CHARACTER_SET, "UTF-8");
    	hints.put(com.google.zxing.EncodeHintType.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.M);//容错
    	hints.put(com.google.zxing.EncodeHintType.MARGIN, 2);//边框   					
    	com.google.zxing.common.BitMatrix bitMatrx = new  com.google.zxing.MultiFormatWriter().encode(conent,com.google.zxing.BarcodeFormat.QR_CODE,width,height,hints);
    	
        // 将图像输出到Servlet输出流中。
    	com.google.zxing.client.j2se.MatrixToImageWriter.writeToStream(bitMatrx, format, stream);
    	return;
	}
	/**
	 * 读取二维码
	 * @param str
	 * @return
	 */
	public static String getQRCodeIdentify(String path) throws IOException, com.google.zxing.NotFoundException{
		com.google.zxing.MultiFormatReader formatReader = new com.google.zxing.MultiFormatReader();
		File file = new File(path);
		if(!file.exists()){
			System.out.println("不存在该文件！");
			return "不存在该文件！";
		}
		BufferedImage image = ImageIO.read(file);
		com.google.zxing.BinaryBitmap binaryBitmap = new com.google.zxing.BinaryBitmap(new com.google.zxing.common.HybridBinarizer(new com.google.zxing.client.j2se.BufferedImageLuminanceSource(image)));
		
		//二维码参数
		HashMap hints = new HashMap();
		hints.put(com.google.zxing.EncodeHintType.CHARACTER_SET, "UTF-8");		
		com.google.zxing.Result result = formatReader.decode(binaryBitmap, hints);
		System.out.println(result.getBarcodeFormat()+result.getText());
		return result.getText();
	}
	
	//*********************************************************************************************************************

	public static void main(String[] args) throws IOException, NotFoundException {
//		System.out.println(getBase64ImageBinary("E://1.png","png"));
//		getBase64StringToImage("iVBORw0KGgoAAAANSUhEUgAAAP4AAAD/CAIAAABeqPyjAAAEWklEQVR42u3awRHDMAgEQPffdNKC"+
//								"HxlyB3sFSBYsfvF8RE7mUQK5S/85nFc1CrvrZ72/3Xf00UcfffTRRx999NFHH3300UcfffTRRx99"+
//								"9NFHH3300UcfffTRRx/9OvqV+0lLOTbeFdh39NFHH3300UcfffTRRx999NFHH3300UcfffTRRx99"+
//								"9NFHH3300Ucf/ZX0G9fOJsud9q7jfUcfffTRRx999NFHH3300UcfffTRRx999NFHH3300UcfffTR"+
//								"Rx999NFHfxmRrXehjz766KOPPvroo48++uijjz766KOPPvroo48++uijjz766KOPPvroo49+Qmsb"+
//								"344++uijjz766KOPvr6jjz766KOPPvroo48++uijjz766KOPPvroo48++jfpp6XxXVt/DYF9Rx99"+
//								"9NFHH3300UcfffTRRx999NFHH3300UcfffTRRx999NFHH3300a+jvzWTRBrPWdx39NFHH3300Ucf"+
//								"ffTRRx999NFHH3300UcfffTRRx999NFHH3300Ucf/Sj6krPmNTnS19uqBOijL+ijL+ijL+ijjz76"+
//								"6KOPPvroo48++uijjz766KOPPvroo59EP20davKuRtZpa3CTd/1hcxN99NFHH3300UcfffTRRx99"+
//								"9NFHH3300UcfffTRRx999NFHH3300Ud/Hf3GlbLG1jbWZ/hd6KOPPvroo48++uijjz766KOPPvro"+
//								"o48++uijjz766KOPPvroo48++lH0G6lNlrtxhLaO/S8/G3300UcfffTRRx999NFHH3300UcfffTR"+
//								"Rx999NFHH3300UcfffTRRz+J/iSRy+tZixk1/qrQRx999NFHH3300UcfffTRRx999NFHH3300Ucf"+
//								"ffTRRx999NFHH330z9LHMef38bkd9NFHH3300UcfffTRRx999NFHH3300UcfffTRRx999NFHH330"+
//								"0Ucf/Sj6so/s5fF4+S700Udf0Edf0Edf0EcfffTRRx999NFHH3300UcfffTRRx999NFHP4r+czhb"+
//								"yabVcPIX8/Y69NFHH3300UcfffTRRx999NFHH3300UcfffTRRx999NFHH3300Ucf/Tb61s72MWp8"+
//								"1x/W19BHH3300UcfffTRRx999NFHH3300UcfffTRRx999NFHH3300UcfffSr6KeV0kh3/T6my4g+"+
//								"+uijjz766KOPPvroo48++uijjz766KOPPvroo48++uijjz766KOPfg/9y6OIPvroo48++uijjz76"+
//								"6KOPPvroo48++uijjz766KOPPvroo48++uijjz766Btp9BFBH33U0EcfNfTRRw199FFDH33noI++"+
//								"c9BH3znoo+8c9NF3DvroOwf92E+va0na2G+9C3300UcfffTRRx999NFHH3300UcfffTRRx999NFH"+
//								"H3300UcfffTRx3Er/a2ZbO3WUWx8O/roo48++uijjz766KOPPvroo48++uijjz766KOPPvroo48+"+
//								"+uijj34afZGD+QIInRKCet1dqwAAAABJRU5ErkJggg==","E://2.png","png");
		//********************************************************************
		getQRCodeIdentify("E://0.png");
		//********************************************************************
		//getStringWatermark("E://a.png","E://c.png","1111111111111111111111",20);
		//getImageWatermark("E://a.png","E://d.png","E://b.png");
		//********************************************************************
		//getThumbnailImage("E://a.png","E://g.png",5);
	}
}
