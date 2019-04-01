package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.DayService;
import service.MagaementService;
import service.PhoneService;
import service.UserService;
import vo.Day;
import vo.Management;
import vo.Phone;
import vo.User;

/**
 * @file IndexController.java
 * @brief IndexController class
 * @author park
 * @version 1.0
 */
@Controller
public class IndexController {

	private UserService userService;
	private PhoneService phoneService;
	private MagaementService magaementService;
	private DayService dayService;
	private HttpSession session;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	public void setMagaementService(MagaementService magaementService) {
		this.magaementService = magaementService;
	}

	public void setDayService(DayService dayService) {
		this.dayService = dayService;
	}

	/**
	 * @name joinUser \n
	 * @brief 유저 회원가입 기능의 함수이다. \n
	 * @param User user \n
	 * @return String \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String joinUser(User user) {
		return "{\"result\":" + userService.joinUser(user) + "}";
	}// joinUser end

	/**
	 * @name joinUser \n
	 * @brief 로그인 기능의 함수. \n
	 * @param User user \n
	 * @param HttpSession session \n
	 * @return String \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(User user, HttpSession session) {
		int check = 0;
		User loginUser = userService.login(user);
		if (loginUser != null) {
			session.setAttribute("login", loginUser);
			session.setAttribute("no", loginUser.getNo());
			check = 1;
			this.session = session;
		}
		return "{\"result\":" + check + "}";
	}

	/**
	 * @name profile \n
	 * @brief 프로필 정보를 불러온다. \n
	 * @return User \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	@ResponseBody
	public User profile() {
		return (User) session.getAttribute("login");
	}

	/**
	 * @name managementList \n
	 * @brief 가게의 제고의 정보 리스트를 출력한다. \n
	 * @return List<Management> \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/management/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Management> managementList() {
		return magaementService.selectManagement((int) session.getAttribute("no"));
	}

	/**
	 * @name updateManagement \n
	 * @brief 제고 출고의 기능을 하는 함수이다. \n
	 * @param Management management\m
	 * @return String \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/management/update", method = RequestMethod.GET)
	@ResponseBody
	public String updateManagement(Management management) {
		management.setStoreNo((int) session.getAttribute("no"));
		return "{\"result\":" + magaementService.updateManagement(management) + "}";
	}

	/**
	 * @name writePhone \n
	 * @brief 협럭업체의 정보를 저장하는 함수이다. \n
	 * @param Phone phone \n
	 * @return String \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/phone/write", method = RequestMethod.GET)
	@ResponseBody
	public String writePhone(Phone phone) {
		phone.setStoreNo((int) session.getAttribute("no"));
		return "{\"result\":" + phoneService.writePhone(phone) + "}";
	}

	/**
	 * @name listPhone \n
	 * @brief 헙력업체 리스트를 출력한다. \n
	 * @return List<Phone> \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/phone/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Phone> listPhone() {
		return phoneService.phoneBooks((int) session.getAttribute("no"));
	}

	/**
	 * @name deletePhone \n
	 * @brief 헙력업체의 정보를 삭제한다. \n
	 * @param int no \n
	 * @return String \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/phone/delete/{no}", method = RequestMethod.GET)
	@ResponseBody
	public String deletePhone(@PathVariable int no) {
		return "{\"result\":" + phoneService.removePhone(no) + "}";
	}

	/**
	 * @name writeDay \n
	 * @brief 스케줄의 정보를 쓸 수 있다.\n
	 * @param Day day \n
	 * @return String \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/day/write", method = RequestMethod.GET)
	@ResponseBody
	public String writeDay(Day day) {
		day.setStoreNo((int) session.getAttribute("no"));
		return "{\"result\":" + dayService.writeDay(day) + "}";
	}

	/**
	 * @name listDay \n
	 * @brief 스케줄의 리스트를 불러오는 함수이다.\n
	 * @return List<Day> \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/day/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Day> listDay() {
		return dayService.listDay((int) session.getAttribute("no"));
	}

	/**
	 * @name removeDay \n
	 * @brief 스케줄의 삭제할 때 사용한다.\n
	 * @param int no\n
	 * @return String \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@RequestMapping(value = "/day/delete/{no}", method = RequestMethod.GET)
	@ResponseBody
	public String removeDay(@PathVariable int no) {
		return "{\"result\":" + dayService.removeDay(no) + "}";
	}
	
}// IndexController end
