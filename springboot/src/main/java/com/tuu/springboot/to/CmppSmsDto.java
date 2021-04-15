package com.tuu.springboot.to;

import java.io.Serializable;

/**
 * 协议短信DTO
 * (CMPP,SMGP,SGIP)
 * @author JiangPengFei
 * @version $Id: mdyun-new, v 0.1 2019/4/19 10:50 JiangPengFei Exp $$
 */
public class CmppSmsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 客户cmpp帐号
	 */
	private String spId;

	/**
	 * 目标号码
	 */
	private String destId;

	/**
	 * 短信内容
	 */
	private String content;

	/**
	 * 该条短信唯一标识
	 */
	private String msgId;

	/**
	 * 短信批次唯一的标识
	 */
	private String uhId;

	/**
	 * 编码类型
	 */
	private String msgFmt;

	/**
	 * 扩展号码
	 */
	private String srcId;

	/**
	 * 长短信总条数
	 */
	private Integer pkTotal;

	/**
	 * 长短信当前序号
	 */
	private Integer pkNum;

	/**
	 * 通道连接ID
	 */
	private String channelId;

	/**
	 * 请求ID
	 */
	private String sequenceId;

	/**
	 * 发送方式
	 * SendByEnum
	 */
	private String sendBy;

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getDestId() {
		return destId;
	}

	public void setDestId(String destId) {
		this.destId = destId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgFmt() {
		return msgFmt;
	}

	public void setMsgFmt(String msgFmt) {
		this.msgFmt = msgFmt;
	}

	public String getSrcId() {
		return srcId;
	}

	public void setSrcId(String srcId) {
		this.srcId = srcId;
	}

	public Integer getPkTotal() {
		return pkTotal;
	}

	public void setPkTotal(Integer pkTotal) {
		this.pkTotal = pkTotal;
	}

	public Integer getPkNum() {
		return pkNum;
	}

	public void setPkNum(Integer pkNum) {
		this.pkNum = pkNum;
	}

	public String getUhId() {
		return uhId;
	}

	public void setUhId(String uhId) {
		this.uhId = uhId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
	}

	public String getSendBy() {
		return sendBy;
	}

	public void setSendBy(String sendBy) {
		this.sendBy = sendBy;
	}
}
