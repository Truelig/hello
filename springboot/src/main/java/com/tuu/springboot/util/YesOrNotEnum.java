package com.tuu.springboot.util;

/**
 * YES AND NO
 * @author JiangPengFei
 * @version $Id: mdyun-new, v 0.1 2019/1/14 20:05 JiangPengFei Exp $$
 */
public enum YesOrNotEnum {

	Y("1", "是"),
	N("0", "否");

	/** value */
	private final String code;

	/** message */
	private final String message;

	/**
	 * 私有构造方法
	 *
	 * @param code
	 * @param message
	 */
	YesOrNotEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
