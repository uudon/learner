package com.uudon.learner.utils;


/**
 * 
 * @author shixing
 * 日志打印
 *
 */

public class Logger {
		
	private static boolean debug = true;
	
    public static int i(String tag, String msg) {
    	if (!debug)
    		return -1;
    
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.i(tag, sb.toString());
    }
    
    public static int i(String tag, String msg, Throwable tr) {
    	if (!debug)
    		return -1;
    	
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.i(tag, sb.toString(),tr);
    }
    
    public static int d(String tag, String msg) {
    	if (!debug)
    		return -1;
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.d(tag, sb.toString());
    }
    
    public static int d(String tag, String msg, Throwable tr) {
    	if (!debug)
    		return -1;
    	
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.d(tag, sb.toString(),tr);
    }
    
    public static int e(String tag, String msg) {
    	if (!debug)
    		return -1;
    	
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.e(tag, sb.toString());
   
    }
	
    public static int e(String tag, String msg, Throwable tr) {
    	if (!debug)
    		return -1;
    	
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.e(tag, sb.toString(),tr);
    }

	public static int v(String tag, String msg) {
    	if (!debug)
    		return -1;
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.v(tag, sb.toString());
    }
    
    public static int v(String tag, String msg, Throwable tr) {
    	if (!debug)
    		return -1;
    	
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.v(tag, sb.toString(),tr);
    }
    
    public static int w(String tag, String msg) {
    	if (!debug)
    		return -1;
    	
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.e(tag, sb.toString());
    }
	
    public static int w(String tag, String msg, Throwable tr) {
    	if (!debug)
    		return -1;
    	
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.w(tag, sb.toString(),tr);
    }
    
    
    /**
     * print time use
     */
    public static long time=0;
    public static int logTime(String tag, String msg) {
    	StackTraceElement ste = new Throwable().getStackTrace()[1];
    	long now= System.currentTimeMillis();
    	long millsec=now-time;
    	time=now;
    	StringBuilder sb=new StringBuilder();
    	sb.append(ste.getFileName()).append(" ")
    	  .append("Line:").append(ste.getLineNumber()).append(" ")
    	  .append("spend millis:").append(millsec).append(" ")
    	  .append("Msg:").append(msg);
    	
        return android.util.Log.e(tag, sb.toString());
   
    }
	
}
