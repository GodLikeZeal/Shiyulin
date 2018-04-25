/**
 * Copyright &copy; 2012-2014  zealAll rights reserved.
 */
package com.zeal.shiyulin.utils;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author Zeal
 * @version 2017-01-15
 */
@Service
@Lazy(false)
public class IdGen {

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * 基于Base62编码的SecureRandom随机生成bytes.
	 */
	public static String randomBase62(int length) {
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		return Encodes.encodeBase62(randomBytes);
	}

	/**
	 * 通过UUID生成16位唯一订单号
	 * @return
	 */
	public static String getOrderIdByUUId() {
		int machineId = 1;//最大支持1-9个集群机器部署
		int hashCodeV = IdGen.uuid().toString().hashCode();
		if(hashCodeV < 0) {//有可能是负数
			hashCodeV = - hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return machineId + String.format("%015d", hashCodeV);
	}
	/**
	 * 通过UUID生成16位唯一产品编号
	 * @return
	 */
	public static String getProductIdByUUId() {
		String city="110100";
		int hashCodeV = IdGen.uuid().toString().hashCode();
		if(hashCodeV < 0) {//有可能是负数
			hashCodeV = - hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return city + String.format("%010d", hashCodeV);
	}
}
