package com.egouer.admin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyedDigestMD5 {
    
	private static final String DEFAULT_CHARSET = "utf-8";
	public static byte[] getKeyedDigest(byte[] buffer, byte[] key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(buffer);
            return md5.digest(key);
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }
	
		
	public static String getKeyedDigest(String strSrc, String key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(strSrc.getBytes(DEFAULT_CHARSET));
            
            String result="";
            byte[] temp;
            temp=md5.digest(key.getBytes(DEFAULT_CHARSET));
    		for (int i=0; i<temp.length; i++){
    			result+=Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
    		}
    		return result.toUpperCase();
    		
        } catch (NoSuchAlgorithmException e) {
        	
        	e.printStackTrace();
        	
        }catch(Exception e) {
          e.printStackTrace();
        }
        return null;
    }
	
	public static String getFileDigest(File file)
	{
		FileInputStream in = null;
		FileChannel ch = null;
		try {
			in = new FileInputStream(file);
			ch = in.getChannel();  
			MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,  
			        file.length());  
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			byte[] temp;
			String result="";
            temp = md5.digest();
	        for (int i=0; i<temp.length; i++){
    			result+=Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
    		}
	        return result.toUpperCase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			try {
				if(ch != null)
				{
					ch.close();
				}
				if(in != null)
				{
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}
		return null;
	}
}

