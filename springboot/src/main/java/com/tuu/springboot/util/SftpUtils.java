package com.tuu.springboot.util;

import com.jcraft.jsch.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

/**
 * SFTP 工具
 * @author JiangPengFei
 * @version $Id: mdyun-new, v 0.1 2019/6/20 10:42 JiangPengFei Exp $$
 */
public class SftpUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(SftpUtils.class);

	public static final String host = "202.96.50.223";
	public static final int port = 2222;
	public static final String username = "qingmayun";
	public static final String password = "56y5v3DW";

	private static ChannelSftp sftp;

	private static SftpUtils instance = null;

	private SftpUtils() {
	}

	public static SftpUtils getInstance(String username,String password,int port,String host) {
		if (instance == null) {
			if (instance == null) {
				instance = new SftpUtils();
				//获取连接
				sftp = instance.connect(host, port, username, password);
			}
		}
		return instance;
	}

	/**
	 * 连接sftp服务器
	 *
	 * @param host     主机
	 * @param port     端口
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public ChannelSftp connect(String host, int port, String username, String password) {
		ChannelSftp sftp = null;
		try {
			JSch jsch = new JSch();
			jsch.getSession(username, host, port);
			Session sshSession = jsch.getSession(username, host, port);
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			LOGGER.info("SFTP Session connected.");
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
			LOGGER.info("Connected to " + host);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return sftp;
	}

	/**
	 * 上传文件
	 *
	 * @param directory  上传的目录
	 * @param uploadFile 要上传的文件
	 */
	public boolean upload(String directory, String uploadFile) {
		try {
			sftp.cd(directory);
			File file = new File(uploadFile);
			FileInputStream fileInputStream = new FileInputStream(file);
			sftp.put(fileInputStream, file.getName());
			fileInputStream.close();
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	/**
	 * 上传文件
	 *
	 * @param directory  上传的目录
	 * @param uploadFile 要上传的文件
	 */
	public boolean upload(String directory, File uploadFile) {
		FileInputStream fileInputStream = null;
		try {
			sftp.cd(directory);
			fileInputStream = new FileInputStream(uploadFile);
			sftp.put(fileInputStream, uploadFile.getName());
			return true;
		} catch (Exception e) {
			LOGGER.error("",e);
			return false;
		}finally {
			if(null != fileInputStream){
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 下载文件
	 *
	 * @param directory    下载目录
	 * @param downloadFile 下载的文件
	 * @param saveFile     存在本地的路径
	 */
	public File download(String directory, String downloadFile, String saveFile) {
		try {
			sftp.cd(directory);
			File file = new File(saveFile);
			//获取父目录
			File fileParent = file.getParentFile();
			//判断是否存在
			if (!fileParent.exists()) {
				fileParent.mkdirs();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			sftp.get(downloadFile, fileOutputStream);
			fileOutputStream.close();
			return file;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 下载文件
	 *
	 * @param downloadFilePath 下载的文件完整目录
	 * @param saveFile     存在本地的路径
	 */
	public File download(String downloadFilePath, String saveFile) {
		try {
			int i = downloadFilePath.lastIndexOf('/');
			if (i == -1) {
				return null;
			}
			sftp.cd(downloadFilePath.substring(0, i));
			File file = new File(saveFile);
			//获取父目录
			File fileParent = file.getParentFile();
			//判断是否存在
			if (!fileParent.exists()) {
				fileParent.mkdirs();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			sftp.get(downloadFilePath.substring(i + 1), fileOutputStream);
			fileOutputStream.flush();
			fileOutputStream.close();
			return file;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 删除文件
	 *
	 * @param directory  要删除文件所在目录
	 * @param deleteFile 要删除的文件
	 */
	public void delete(String directory, String deleteFile) {
		try {
			sftp.cd(directory);
			sftp.rm(deleteFile);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	public void disconnect() {
		try {
			sftp.getSession().disconnect();
		} catch (JSchException e) {
			LOGGER.error(e.getMessage());
		}
		sftp.quit();
		sftp.disconnect();
	}

	/**
	 * 列出目录下的文件
	 *
	 * @param directory 要列出的目录
	 * @throws SftpException
	 */
	public Vector<ChannelSftp.LsEntry> listFiles(String directory) throws SftpException {
		return sftp.ls(directory);
	}

	/**
	 * 判断目录或文件是否存在
	 *
	 * @param name  目录或文件
	 */
	public boolean exists(String name) {
//		String separator = File.separator;
		String separator = "/";
		Vector<ChannelSftp.LsEntry> ls = null;
		try {
			if(name.endsWith(separator)){
				name = name.substring(0, name.length() - 1);
			}
			String targetName = name.substring(name.lastIndexOf(separator)+1);
			name = name.substring(0, name.lastIndexOf(separator)+1);
			if(ToolUtil.isEmpty(name)){
				LOGGER.error("根目录不处理");
				return false;
			}
			ls = sftp.ls(name);
			for (ChannelSftp.LsEntry l : ls) {
				if(l.getFilename().equals(targetName)){
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			return false;
		}finally {
			if(null != ls){
				ls.clear();
			}
		}
	}

	/**
	 * 创建目录(不会新建父级目录)
	 * @param name
	 */
	public void mkdir(String name){
		try {
			if(name.endsWith("/")){
				name = name.substring(0, name.length() - 1);
			}
			if(exists(name)){
				return;
			}
			sftp.mkdir(name);
		} catch (SftpException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception{
		SftpUtils sf = SftpUtils.getInstance("programmer","123456789miaodi",22,"192.168.11.1");
//		System.out.println(sf.listFiles("/NEWNP/20190619/").size());
//		System.out.println(sf.exists("/application/nginx/miaodi_html/news/"));
//		sf.mkdir("/application/nginx/miaodi_html/news/");
		File download = sf.download("/application/nginx/miaodi_html/news/news_details.html", "E:\\IdeaProjects\\mdyun-new\\operate\\operate-admin\\src\\main\\webapp\\static\\template\\news_details.html");
		sf.disconnect();
	}
}
