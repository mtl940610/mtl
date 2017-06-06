package com.centran.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;


/**
 * Created by IntelliJ IDEA.
 * User:  赵亮
 * Time: 2009-4-7 16:32:56
 * Company: 
 * Descripion:日期工具类,继承自apache的DateUtils类，继承的方法参见org.apache.commons.lang.time.DateUtils的文档
 *            内置了常见的日期格式，格式化时自动适配相应类型
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils{

    protected static final Logger logger = Logger.getLogger(DateUtils.class);

       public static final String FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";

       public static final String FORMAT_DATE = "yyyy-MM-dd";

       public static final String FORMAT_TIME = "HH:mm:ss";
       
       public static final String FORMAT_TIME2 = "HH:mm";

       public static final String FORMAT_SHORT_DATE_TIME = "MM-dd HH:mm";

       public static final String FORMAT_DATE_TIME = FORMAT_DEFAULT;

       public static final String FORMAT_NO_SECOND = "yyyy-MM-dd HH:mm";

       public static final String FORMAT_JAPAN = "MM.dd(EEE) HH";

       public static final String FORMAT_CHINESE_NO_SECOND = "yyyy年MM月dd日 HH:mm";

       public static final String FORMAT_CHINESE_NO_SECOND_1 = "yyyy年MM月dd日HH:mm"; 

       public static final String FORMAT_CHINESE = "yyyy年MM月dd日 HH点mm分";
       
       public static final String FORMAT_CHINESE1 = "yyyy年MM月dd日";

       public static final int TYPE_HTML_SPACE = 2;

       public static final int TYPE_DECREASE_SYMBOL = 3;

       public static final int TYPE_SPACE = 4;

       public static final int TYPE_NULL = 5;
       
       public static final String FORMAT_DATE_11 = "yyyy/MM/dd";

    public static Map<String, SimpleDateFormat> getFormaters() {
        return formaters;
    }

    private static Map<String, SimpleDateFormat> formaters = new HashMap<String, SimpleDateFormat>();

    static {
        SimpleDateFormat defaultFormater = new SimpleDateFormat(FORMAT_DEFAULT,Locale.CHINA);
        formaters.put(FORMAT_DEFAULT, defaultFormater);
        formaters.put(FORMAT_DATE, new SimpleDateFormat(FORMAT_DATE,Locale.CHINA));
        formaters.put(FORMAT_TIME, new SimpleDateFormat(FORMAT_TIME,Locale.CHINA));
        formaters.put(FORMAT_SHORT_DATE_TIME, new SimpleDateFormat(FORMAT_SHORT_DATE_TIME,Locale.CHINA));
        formaters.put(FORMAT_CHINESE_NO_SECOND, new SimpleDateFormat(FORMAT_CHINESE_NO_SECOND,Locale.CHINA));
        formaters.put(FORMAT_CHINESE, new SimpleDateFormat(FORMAT_CHINESE,Locale.CHINA));
        formaters.put(FORMAT_DATE_TIME, defaultFormater);
        formaters.put(FORMAT_NO_SECOND, new SimpleDateFormat(FORMAT_NO_SECOND,Locale.CHINA));
        formaters.put(FORMAT_JAPAN, new SimpleDateFormat(FORMAT_JAPAN, Locale.JAPAN));
        formaters.put(FORMAT_CHINESE_NO_SECOND_1, new SimpleDateFormat(FORMAT_CHINESE_NO_SECOND_1,Locale.CHINA));
    }

    /**
     * 使用给定的 pattern 对日期进格式化为字符串
     *
     * @param date    待格式化的日期
     * @param pattern 格式字符串
     * @return 格式化后的日期字符串
     */
    public static String format(Date date, String pattern) {
    	if (date!=null){
    		SimpleDateFormat dateFormat;
            if (formaters.containsKey(pattern)) {
                dateFormat = formaters.get(pattern);
            } else {
                dateFormat = new SimpleDateFormat(pattern);
            }
            return dateFormat.format(date);
    	}else
    		return "";
    }

    /**
     * 以默认日期格式(yyyy-MM-dd HH:mm:ss)对日期进行格式化
     *
     * @param date 待格式化的日期
     * @return 格式化后的日期字符串
     */
    public static String format(Date date) {
        return formaters.get(FORMAT_DEFAULT).format(date);
    }

        /**
     * 格式化日期，
     * --------------------------------------------------------------------------<br>
     * 创建者：杨思勇<br>
     * 创建日期：2002-1-16<br>
     * <br>
     * 修改者：<br>
     * 修改日期：<br>
     * 修改原因：<br>
     * --------------------------------------------------------------------------
     *
     * @param date   要格式化的日期对象
     * @param format 格式
     * @param type   如果日期为空，定义返回的类型
     * @return 返回值，如果date为空，则type定义返回类型，如果格式化失败。则返回空串
     */
    public static String format(Date date,
                                String format,
                                int type) {
        if (date != null) {
            //---------------------------------
            // 日期不为空时才格式
            //---------------------------------
            try {
                //---------------------------------
                // 调用SimpleDateFormat来格式化
                //---------------------------------
                return new SimpleDateFormat(format).format(date);
            } catch (Exception e) {
                //---------------------------------
                // 格式化失败后，返回一个空串
                //---------------------------------
                return "";
            }
        } else {
            //---------------------------------
            // 如果传入日期为空，则根据类型返回结果
            //---------------------------------
            switch (type) {
                case TYPE_HTML_SPACE: // '\002'
                    return "&nbsp;";

                case TYPE_DECREASE_SYMBOL: // '\003'
                    return "-";

                case TYPE_SPACE: // '\004'
                    return " ";

                case TYPE_NULL:
                    return null;

                default:
                    //---------------------------------
                    // 默认为空串
                    //---------------------------------
                    return "";
            }
        }
    }

    /**
     * 将给定字符串解析为对应格式的日期,循环尝试使用预定义的日期格式进行解析
     *
     * @param str 待解析的日期字符串
     * @return 解析成功的日期，解析失败返回null
     */
    public static Date parse(String str) {
        Date date = null;
        for (String _pattern : formaters.keySet()) {
            if (_pattern.getBytes().length == str.getBytes().length) {
                try {
                    date = formaters.get(_pattern).parse(str);
                    //格式化成功则退出
                    break;
                } catch (ParseException e) {
                    //格式化失败，继续尝试下一个
                    logger.debug("尝试将日期:"+str+"以“"+_pattern+"”格式化--失败=.=!");
                }
            }else if(_pattern.equals(FORMAT_JAPAN)){
                 try {
                    date = formaters.get(_pattern).parse(str);
                    //格式化成功则退出
                    break;
                } catch (ParseException e) {}
            } 
        }
        return date;
    }

    public static Date parse(String str,String pattern){
        SimpleDateFormat dateFormat;
        if (formaters.containsKey(pattern)) {
            dateFormat = formaters.get(pattern);
        } else {
            dateFormat = new SimpleDateFormat(pattern);
        }
        Date date = null;
        if (StringUtils.isNotEmpty(str)){
            try {
                date = dateFormat.parse(str);
            } catch (ParseException e) {
                //是格式失败
                logger.debug("尝试将日期:"+str+"以“"+pattern+"”格式化--失败=.=!");
            }catch (Exception e) {
                //是格式失败
                System.out.println("字符串转换日期失败！原字符串："+str);
            }
        }
        return date;
    }

    /**
     * date2 是否在date1之后
     * @param date1 参照日期
     * @param date2 比较日期
     * @return true:是 false:否
     */
    public static boolean isAfter(Date date1, Date date2){
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar2.setTime(date2);
        calendar1.setTime(date1);
        return calendar2.after(calendar1);
    }

    public static void main(String[] args) {
    	//System.out.println(format(new Date(),FORMAT_CHINESE1));
//    	System.out.println(stringToYear("1"));
//        logger.debug("------------------------------------------------------");
//        String sdate1 = DateUtils.format(new Date());
//        logger.debug("sdate1 = " + sdate1);
//        String sdate2 = DateUtils.format(new Date(),DateUtils.FORMAT_DATE);
//        logger.debug("sdate2 = " + sdate2);
//        String sdate3 = DateUtils.format(new Date(),DateUtils.FORMAT_NO_SECOND);
//        logger.debug("sdate3 = " + sdate3);
//        String sdate4 = DateUtils.format(new Date(),DateUtils.FORMAT_JAPAN);
//        logger.debug("sdate4 = " + sdate4);
//        logger.debug("------------------------------------------------------");
//
//        Date date1 = DateUtils.parse(sdate1);
//        Date date2 = DateUtils.parse(sdate2);
//        Date date3 = DateUtils.parse(sdate3);
//        Date date4 = DateUtils.parse(sdate4);
//        logger.debug(DateUtils.format(date3));
//        logger.debug(DateUtils.format(date4));
//        Date date5 = DateUtils.parse("2008-05-05",DateUtils.FORMAT_DATE);
//        logger.debug(DateUtils.format(date5));
//
//        logger.debug(DateUtils.isAfter(date5,date1));
//       System.out.println(parse("2010-03-24 12:11:12",FORMAT_DEFAULT));
//       System.out.println(parse("2010-03-25 15:16:12",FORMAT_DEFAULT));
//       
//       Date d = parse("2010-03-24 12:11:12",FORMAT_DEFAULT);
//       
//       System.out.println("ff:"+format(toDateAddDays(d,10)));;
    	
//    	System.out.println("判断字符串1980-33-44是否日期格式返回："+checkDate("1980f-03-04"));
    	
    	/*
    	Calendar calendar = Calendar.getInstance();
	     int min = calendar.get(Calendar.MINUTE);
	     calendar.set(Calendar.MINUTE, min + 180);
	     Date cc = calendar.getTime();
	     System.out.println("处理后的时间："+format(cc));
	     */
    	//System.out.println(DateUtils.isAfter(DateUtils.parse("2008-8-8",DateUtils.FORMAT_DATE),DateUtils.parse("2008-8-9",DateUtils.FORMAT_DATE)));
//    	String[] abc=getRiqiContextline("2020-1-1",6,6);
//    	for(int i=0;i<abc.length;i++)
//    	{
//    		System.out.println(abc[i]);
//    	}
    	
    	
    	Date d = null;
    	
    	String sd = String.valueOf(d);
    	if ("null".equals(sd)){
    		
    	}
    	if (d==null){
    		System.out.println("1111111111");
    	}else{
    		System.out.println("22222222");
    	}
    }

    public static String getNowTime(){
        return DateUtils.format(new Date());
    }
    
    public static String Ds(int days){
	     SimpleDateFormat form=new SimpleDateFormat("yyyyMMdd");
	     Calendar calendar = Calendar.getInstance();
	     int day = calendar.get(Calendar.DAY_OF_YEAR);
	     calendar.set(Calendar.DAY_OF_YEAR, day - days);
	     Date cc = calendar.getTime();
	     return form.format(cc);
	}
    
    public static Date addDates(int days){
	     //SimpleDateFormat form=new SimpleDateFormat("yyyyMMdd");
	     Calendar calendar = Calendar.getInstance();
	     int day = calendar.get(Calendar.DAY_OF_YEAR);
	     calendar.set(Calendar.DAY_OF_YEAR, day + days);
	     Date cc = calendar.getTime();
	     return cc;
	}
    
    public static Date removeDates(int days){
	     //SimpleDateFormat form=new SimpleDateFormat("yyyyMMdd");
	     Calendar calendar = Calendar.getInstance();
	     int day = calendar.get(Calendar.DAY_OF_YEAR);
	     calendar.set(Calendar.DAY_OF_YEAR, day - days);
	     Date cc = calendar.getTime();
	     return cc;
	}
    
    public static String discrepancyDate(Date beginDate,Date endDate){
    	String returnstr = "";
    	long l = endDate.getTime()-beginDate.getTime();
    	long days = l/(24*60*60*1000);
    	long hours = (l%(24*60*60*1000))/(1000*60*60);
    	if (days>0){
    		returnstr = " "+days+" 天";
    	}
    	if (hours>0){
    		returnstr += " "+hours+" 小时";
    	}
    	if ("".equals(returnstr)){
    		long mins = (l/1000)/60;
    		if (mins>0){
        		returnstr += " "+mins+" 分钟";
        	}
    		long miaos = (l/1000)%60;
    		if (miaos>0){
        		returnstr += " "+miaos+" 秒";
        	}
    		if ("".equals(returnstr)){
    			returnstr = "0";
    		}
    	}
	    return returnstr;
    }
    
    
    /**
     * 2个日期相减后得到天数（yyyy-MM-dd）
     * @param date
     * @param days
     * @return
     */
    public static int discrepancyDateNum(Date beginDate,Date endDate){
    	beginDate = parse(format(beginDate,FORMAT_DATE),FORMAT_DATE);
    	endDate = parse(format(endDate,FORMAT_DATE),FORMAT_DATE);
    	int returnstr = 0;
    	long l = endDate.getTime()-beginDate.getTime();
    	long days = l/(24*60*60*1000);
    	if (days>0){
    		returnstr = Integer.parseInt(String.valueOf(days));
    	}
	    return returnstr;
    }
    
    
    //给指定的日期增加几天后的日期
    public static Date toDateAddDays(Date date,int days){
	     //SimpleDateFormat form=new SimpleDateFormat("yyyyMMdd");
	     Calendar calendar = Calendar.getInstance();
	     calendar.setTime(date);
	     //int day = calendar.get(date.getDate());
	     calendar.add(Calendar.DATE,days);//你要加减的日期
	     //calendar.set(Calendar.DAY_OF_YEAR, day + days);
	     Date cc = calendar.getTime();
	     return cc;
	}
    
    /**
     * 给指定的字符串日期增加days个天数后，得到的新的字符串日期
     * @param thatDate 格式：YYYY-MM-DD
     * @param days 增加天数是正的，减少天数是负的
     * @return
     */
    public static String thatDateOptDays(String thatDate,int days){
    	Calendar calendar = Calendar.getInstance();
	    calendar.setTime(parse(thatDate,FORMAT_DATE));
	    calendar.add(Calendar.DATE,days);//增加天数是正的，减少天数是负的
	    Date cc = calendar.getTime();
	    return format(cc,FORMAT_DATE);
    }
    
    
    /**
     * 当前所处星期几
     */
    public static String getCurrentWeekDay(){
    	Calendar cd = Calendar.getInstance();
    	 int mydate = cd.get(Calendar.DAY_OF_WEEK);
    	 String showDate = "星期六";
    	 switch(mydate){
    	        case 1:
    	   showDate = "星期日";
    	   break;
    	  case 2:
    	   showDate = "星期一";
    	   break;
    	  case 3:
    	   showDate = "星期二";
    	   break;
    	  case 4:
    	   showDate = "星期三";
    	   break;
    	  case 5:
    	   showDate = "星期四";
    	   break;
    	  case 6:
    	   showDate = "星期五";
    	   break;
    	  default:
    	   showDate = "星期六";
    	   break;
    	 }
    	 return showDate;
    }
    
    /**
     * 获取当前所处的星期区域
     * 格式：开始日期_结束日期
     */
    public static String getgetCurrentWeekArea(){
    	Calendar cd = Calendar.getInstance();
   	 	int mydate = cd.get(Calendar.DAY_OF_WEEK);
   	 	
   	 	String showDateArea = "";
   	 	
   	 	switch(mydate){
   	 		case 1:
   	 			showDateArea = format(removeDates(6),FORMAT_DATE)+"_"+format(new Date(),FORMAT_DATE);
   	 			break;
   	 		case 2:
   	 			showDateArea = format(new Date(),FORMAT_DATE)+"_"+format(addDates(6),FORMAT_DATE);
   	 			break;
   	 		case 3:
   	 			showDateArea = format(removeDates(1),FORMAT_DATE)+"_"+format(addDates(5),FORMAT_DATE);
   	 			break;
   	 		case 4:
   	 			showDateArea = format(removeDates(2),FORMAT_DATE)+"_"+format(addDates(4),FORMAT_DATE);
   	 			break;
   	 		case 5:
   	 			showDateArea = format(removeDates(3),FORMAT_DATE)+"_"+format(addDates(3),FORMAT_DATE);
   	 			break;
   	 		case 6:
   	 			showDateArea = format(removeDates(4),FORMAT_DATE)+"_"+format(addDates(2),FORMAT_DATE);
   	 			break;
   	 		default:
   	 			showDateArea = format(removeDates(5),FORMAT_DATE)+"_"+format(addDates(1),FORMAT_DATE);
   	 		break;
		}
   	 	return showDateArea;
    }
    
    /**
     * 判断字符串，是否是日期类型（yyyy-MM-dd），不是的话，返回false，否则：true
     */
    public static boolean checkDate(String content) { 
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d"); 
	   try { 
		   sdf.setLenient(false); 
		   content = content.replaceAll("-0", "-"); 
		   Date d = sdf.parse(content); 
		   String s = sdf.format(d); 
		   return content.equals(s); 
	   } catch (Exception e){ 
		   return false; 
	   } 
	}
    
    
    /**
     * 此功能应用在“生日天赋”的功能中，关于公历日期的相关列表
     * 
	 * 获取指定日期的前几行和后几行，最后组装成一个数组
	 * @param date 日期的格式：YYYY-MM-DD
	 * @param qian_n
	 * @param hou_n
	 * @return
	 */
	public static String[] getRiqiContextline(String date,int qian_n,int hou_n){
		String[] data = new String[qian_n+hou_n];
		
		Date d = DateUtils.parse(date,DateUtils.FORMAT_DATE);
		
		Date d_1950 = DateUtils.parse("1950-1-1",DateUtils.FORMAT_DATE);
		Date d_2020 = DateUtils.parse("2020-12-31",DateUtils.FORMAT_DATE);
		
		long d_1950_days = (d.getTime()-d_1950.getTime())/(24*60*60*1000);
		if (d_1950_days<qian_n){
			qian_n=Integer.parseInt(String.valueOf(d_1950_days));
			hou_n = data.length-qian_n;
		}
		
		long d_2020_days = (d_2020.getTime()-d.getTime())/(24*60*60*1000);
		if (d_2020_days<hou_n){
			hou_n=Integer.parseInt(String.valueOf(d_2020_days));
			qian_n = data.length-hou_n;
		}
		
		int count = 0;
		if (qian_n>0){
			for (int i=qian_n;i>0;i--){
				data[count] = DateUtils.thatDateOptDays(date,-i);
				count++;
			}
		}
		
		if (hou_n>0){
			for (int i=1;i<=hou_n;i++){
				data[count] = DateUtils.thatDateOptDays(date,i);
				count++;
			}
		}
		
		for(int i=0;i<data.length;i++)
		{
			String m_year=data[i].substring(0,4);
			String m_month=data[i].substring(5,7);
			String m_day=data[i].substring(8);
			String replace="<a target=_blank href=\"http://baike.fututa.com/birth/"+m_year+m_month+m_day+".html\">"+Integer.valueOf(m_year).intValue()+"年"+Integer.valueOf(m_month).intValue()+"月"+Integer.valueOf(m_day).intValue()+"日生日命运&生日性格</a>";
			data[i]=replace;
		}
		return data;
	}
	public static String stringToYear(Date day){
    	String shijian="";
    	String str=format(day,"yyyy-MM-dd");
    	String [] s=str.split("-");
    	shijian+=StringUtils.yearNumToChinaeseNum(StringUtils.stringToNum(s[0]))+"年";
    	shijian+=StringUtils.numToChinaeseNum(StringUtils.stringToNum(s[1]))+"月";
    	shijian+=StringUtils.numToChinaeseNum(StringUtils.stringToNum(s[2]))+"日";
    	return shijian;
	}
}
