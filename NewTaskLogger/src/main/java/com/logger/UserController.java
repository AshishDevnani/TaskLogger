package com.logger;

import java.util.Base64;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.logger.entities.UserMaster;
import com.logger.services.UserService;



@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	private static final String SECRET_KEY = "TransWorldTech!$"; // Replace with your secret key -a 128bit key
    private static final String SALT = "TaskLogger"; // Replace with your salt (e.g., generated for each user)
	
	@PostMapping("registeraction")
	public ModelAndView RegisterNewUser(@ModelAttribute UserMaster newuser){
		ModelAndView usermav = new ModelAndView();
		
		System.out.println("UserName:"+newuser.getUserName());
		System.out.println("First Name:"+newuser.getFirstName());
		System.out.println("Last Name:"+newuser.getLastName());
		
		 // Encrypt the password
        String encryptedPassword="";
		try {
			encryptedPassword = encryptPassword(newuser.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Simulate storing the encrypted password in the database (along with salt, user ID, etc.)
        // In a real application, use a secure storage mechanism for sensitive data
        String storedEncryptedPassword = encryptedPassword;
        System.out.println("Stored Encrypted Password: " + storedEncryptedPassword);
  
        newuser.setPassword(storedEncryptedPassword);
		 
		Object[] result = userservice.addNewUser(newuser);
		
		int x = (Integer)result[0];
		String message = (String)result[1];
		
		System.out.println("inserted:"+x);
		System.out.println("message:"+message);
		if(x > 0) {
			usermav.addObject("addFlag","true"); 
			usermav.addObject("message",message); 
		}else {
			usermav.addObject("addFlag","false");
			usermav.addObject("message",message); 
		}
		
		usermav.setViewName("home");
		
		
		return usermav;
	}
	
	@PostMapping("loginaction")
	public ModelAndView LoginUser(@RequestParam("username") String userName,@RequestParam("password") String password,
			                      HttpSession session) {
		ModelAndView loginmav = new ModelAndView();
		
		String encryptedPassword="";
		try {
			encryptedPassword = encryptPassword(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Optional<UserMaster> loginuser = Optional.ofNullable(userservice.checkLogin(userName, encryptedPassword));
        UserMaster userval = null;
        boolean status = false;
		
		if(loginuser.isPresent()) {
			status=true;
			userval = loginuser.get();
			
		}
		if(status==true) {
				loginmav.setViewName("home");
				session.setAttribute("fname", userval.getFirstName());
				session.setAttribute("lname", userval.getLastName());
				session.setAttribute("piid", userval.getPiid());
				session.setAttribute("role", userval.getRole());
				session.setAttribute("username", userval.getUserName());
				session.setMaxInactiveInterval(600);//10 mins of inactivity
				
		}else {
			loginmav.setViewName("login");
			loginmav.addObject("status", "failed");
		}
		return loginmav;
	}
	
	private static String encryptPassword(String password) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encryptedBytes = cipher.doFinal((SALT + password).getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
	
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		return "login";
	}
	
	@GetMapping("/logout")
	public String showLogout(Model model) {
		return "login";
	}
}
