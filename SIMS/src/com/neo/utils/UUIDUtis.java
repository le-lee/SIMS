package com.neo.utils;

import java.util.UUID;

public class UUIDUtis {
	
	/**
	 * 产生随机ID
	 * @return
	 */
	public static String generateId() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
}
