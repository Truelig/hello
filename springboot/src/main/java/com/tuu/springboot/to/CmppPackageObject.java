package com.tuu.springboot.to;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author JiangPengFei
 * @version $Id: mdyun-new, v 0.1 2019/4/19 14:08 JiangPengFei Exp $$
 */
public class CmppPackageObject  implements Serializable {

	/**
	 * 短信信息集合
	 */
	private List<CmppSmsDto> cacheCmppSmsList;

	/**
	 * 到期时间，毫秒数
	 */
	private long   expireTime;

	public List<CmppSmsDto> getCacheCmppSmsList() {
		return cacheCmppSmsList;
	}

	public void setCacheCmppSmsList(List<CmppSmsDto> cacheCmppSmsList) {
		this.cacheCmppSmsList = cacheCmppSmsList;
	}

	public long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}
}
