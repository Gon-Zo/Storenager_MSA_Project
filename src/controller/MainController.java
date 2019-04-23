package controller;

import java.io.File;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import vo.ResultVO;

/**
 * @file MainController.java
 * @brief MainController.class
 * @author park
 * @version 1.0
 */
@Controller
public class MainController {

	@RequestMapping(value = { "/", "main" }, method = RequestMethod.GET)
	public String main() {
		System.out.println("start ==> server ");
		System.out.println("tset server start !!");
		return "main";
	}

	@RequestMapping(value="/select/profile",method=RequestMethod.GET)
	public String selectImg(HttpServletRequest request , Model m) {
		ServletContext sc = request.getServletContext();
		String profilePath = sc.getRealPath("img/profile");
		String test = "/test.jpg";
		m.addAttribute("imgSrc", test);
		return "img";
	}
	
	@RequestMapping(value="/img",method=RequestMethod.GET)
	public URL selectImg(HttpServletRequest request ) throws Exception{
		System.out.println("img output success");
		ServletContext sc = request.getServletContext();
		String profilePath = sc.getRealPath("img/profile");
		String test = "file://"+profilePath + "/test.jpg";
		return new URL(test);
	}	
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public ResultVO test() {
		System.out.println("connection success");
		return new ResultVO(true);
	}
	@RequestMapping(value="/test/2",method=RequestMethod.GET)
	@ResponseBody
	public ResultVO test2() {
		System.out.println("connection success");
		return new ResultVO(false);
	}
	
	@RequestMapping(value="/img/upload" , method = RequestMethod.GET  , produces = "application/json;charset=UTF-8")
	public void imgUpLoad(MultipartFile upload , HttpServletRequest request) {
		System.out.println("upload Image start");
		ServletContext sc = request.getServletContext();
		String profilePath = sc.getRealPath("img/profile");
		File file = new File(profilePath+File.separator+upload.getOriginalFilename());
	}
	
//	@RequestMapping(value = "/ajax/upload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	public String uploadProfile(HttpServletRequest request, String type, MultipartFile uploadImg) {
//		ServletContext sc = request.getServletContext();
//
//		String uploadPath = sc.getRealPath("img/upload");
//		String profilePath = sc.getRealPath("img/profile");
//
//		File file = new File(uploadPath + File.separator + uploadImg.getOriginalFilename());
//
//		file = fileRenameUtil.rename(file);
//
//		String src = "";
//
//		try {
//			uploadImg.transferTo(file);
//			switch (type) {
//			case "P":
//				resizeImageUtil.resize(file.getAbsolutePath(), profilePath + File.separator + file.getName(), 200);
//				break;
//			case "B":
//				src += "upload/";
//				break;
//			}// switch end
//			src += file.getName();
//			return "{\"src\":\"" + src + "\"}";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "�뿉�윭";
//		}
//	}// uploadProfile end
	
}
