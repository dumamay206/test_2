package ptit.controller;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptit.bean.UploadFile;
import ptit.bean.User;

@Controller
public class UserController {

	@Autowired
	@Qualifier("attachefile")
	UploadFile baseAttachFile;
	
	@Autowired
	public JavaMailSender mailer;

	@RequestMapping("index")
	public String index() {
		return "user/signin";
	}
	//viet phan gui mail o day luon
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String infor(ModelMap model, User user) {

		model.addAttribute("user", user);

		return "user/infor";
	}

	@RequestMapping(value = "/index", params = "btnCreateAccount")
	public String createAccount() {

		return "user/register";
	}
	
	@RequestMapping(value = "sendmail", method = RequestMethod.POST)
	public String sendMailWhenRegister(
			ModelMap model,
			@ModelAttribute("user") User user
			) {
		try {
			String fromMail = "n19dccn084@student.ptithcm.edu.vn";
			String subject = "Công ty bảo hành xe Daxua";
			String text = "Bạn đã tạo tài khoản thành công. "
					+"Tên tài khoản là: " + user.getEmail() 
					+"\n"  //xuong hang o day
					+ " Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi";
			String pic = "220331164250-wp5493583-windows-10-default-wallpapers.jpg";
			String attach = baseAttachFile.getBasePath()
					+ File.separator
					+ pic;
			
			
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail,true);
			
			
			helper.setFrom(fromMail,"daxua so 1 vn");
			helper.setTo(user.getEmail());
			helper.setReplyTo(fromMail);
			helper.setSubject(subject);
			helper.setText(text, true);
			
			FileSystemResource file1 = new FileSystemResource(new File(attach));
			helper.addAttachment(pic , file1);
			
			mailer.send(mail);
			
			model.addAttribute("user", user);
			
		}catch (Exception e) {
			System.err.println(e);
			user.setPassword("cut");
		}
		
		return "user/infor";
	}
	
}
