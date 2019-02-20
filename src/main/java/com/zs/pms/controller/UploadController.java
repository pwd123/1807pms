package com.zs.pms.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	/**
	 * 普通文件上传
	 * 
	 * @param 上传的文件
	 *            名字等于input的name
	 * @return 文件的路径
	 */
	@RequestMapping("/upload/common.do")
	@ResponseBody
	public String commonUpload(MultipartFile file, HttpServletRequest req) {
		// UUID算法生成前缀
		String pfix = UUID.randomUUID().toString();
		// 生成的文件名 前缀+原文件名
		String filename = pfix + file.getOriginalFilename();
		//获得upload文件夹的物理地址
		String path = req.getRealPath("/upload");
		//创建目标文件File.separator :分隔符
		File  dFile = new File(path+File.separator+filename);
		try {
			//把上传图片写入目标文件中
			file.transferTo(dFile);
			//成功返回文件名
			return filename;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		
	}

}
