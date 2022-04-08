package ptit.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ptit.bean.UploadFile;
import ptit.bean.User;

@Controller
public class FeedbackController {
	
	@Autowired
	@Qualifier("uploadfile")
	UploadFile baseUploadFile;
	
	@RequestMapping("feedback")
	public String feedback() {
		
		return "feedback/feedback";
	}
	
	@RequestMapping(value = "feedback", method = RequestMethod.POST)
	public String showForm(ModelMap model,
			@ModelAttribute("user") User user,
			@RequestParam("file") MultipartFile file
			) {
		if(file.isEmpty()) {
			model.addAttribute("message", "Vui lòng chọn file");
		}else {
			try {
				String pattern = "yyMMddHHmmss-";
				String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
				String fileName = date + file.getOriginalFilename();
				String photoPath = baseUploadFile.getBasePath()+File.separator+fileName;
				file.transferTo(new File(photoPath));
				
				user.setFeedbackPhoto(fileName);
				model.addAttribute("user", user);
				
			}catch(Exception ex){
				model.addAttribute("message", "Lỗi!!!");
			}
		}
		return "feedback/infor";
	}
}
