package cn.tedu.store.controller;

  
import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
 

@Controller
public class TestUpLoadController {
	
	@RequestMapping("/showUpload.do")
	public String TestShowUpload() {
		return "upload";
	}
	@RequestMapping("/doUpload.do")
	public String doUpload(MultipartFile file) throws Exception{
		file.transferTo
				(new File("/home/soft01",file.getOriginalFilename()));
		
		return "redirect:showIndex.do";
	}

}
