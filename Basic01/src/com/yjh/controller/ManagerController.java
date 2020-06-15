package com.yjh.controller;

import java.io.IOException;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjh.po.Manager;
import com.yjh.service.ManagerService;
import com.yjh.utils.RandomValidateCode;

@Controller
public class ManagerController {
	
	
	//����ע��
	@Autowired
	private ManagerService managerService;
	
	
	/**
	 * ����manager
	 */
	@RequestMapping(value = "/updateManger",method = RequestMethod.POST)
	public String updateManger(HttpServletRequest request,Manager manager,Model model) {
		String passwd = request.getParameter("passwd");
		String repasswd = request.getParameter("repasswd");
		String mstate = request.getParameter("mstate");
		String ids = request.getParameter("managerid");
		int id = Integer.parseInt(ids);
		int rows = 0;
		manager.setManagerid(id);
		manager.setPasswd(passwd);
		manager.setMstate(mstate);
		if(passwd!=""&&passwd.endsWith(repasswd)) {
			rows = managerService.updateManager(manager);			
		}
		if(rows>0) {
			return "redirect:findAllPage";
		}else {
			return "/findByIdManager/"+id;
		}
		
		
	}
	
	
	
	
	/**
	 * ����id��ѯmanager
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/findByIdManager/{id}")
	public String findByIdManager(@PathVariable("id") int id,HttpSession session) {
		Manager manager = managerService.findByIdManager(id);
		session.setAttribute("manager", manager);		
		return "main_update";
	}
	
	
	
	
	/**
	 * ɾ���û�
	 */
	@RequestMapping("/deleteManager")
	@ResponseBody
	public String managerdelete(Integer id) {
		int rows = managerService.deleteManager(id);
		if(rows > 0) {
			return "OK";
		}else {
			return "FATL";
		}
		
	}
	
	
	
	
	/**
	 * ����û�
	 */
	@RequestMapping(value = "/addManager" ,method = RequestMethod.POST)
	public String addManager(HttpServletRequest request,Manager manager) {
		String managername = request.getParameter("managername");
		String passwd = request.getParameter("passwd");
		String repasswd = request.getParameter("repasswd");
		String mstate = request.getParameter("mstate");
		
		//�ж�����
		if(passwd!=""&&passwd.endsWith(repasswd)){
			manager.setManagername(managername);
			manager.setPasswd(passwd);
			manager.setMstate(mstate);
			int rows = managerService.addManager(manager);
			if(rows>0) {
				return "redirect:findAllPage";
			}			
		}		
		return "mainadd";
	}
	
	
	
	/**
	 * ��ҳȫ���û�
	 */
	@RequestMapping("/findAllPage")
	public String PageManager(HttpServletRequest request,Model model) {
		managerService.findManagerAllPage(request, model);
		return "main_list";
	}
	
	
	/**
	 * ȫ���û�
	 */
	@RequestMapping(value="/findall")
	public String findall(HttpServletRequest request,Model model) {
		List<Manager> managerlist = managerService.findManagerAll();
		model.addAttribute("ManagerList", managerlist);
		for (Manager manager : managerlist) {
			if(manager.getMstate().endsWith("1")){
				manager.setMstate("����");
			}
			if(manager.getMstate().endsWith("2")){
				manager.setMstate("δ����");
			}
		}
		return "main_list";
	}
	
	
	/**
	 * ��ȡ������֤����ʾ�� UI ����
	 */
	@RequestMapping(value="/checkCode")
	public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//������Ӧ����,������������������ΪͼƬ
        response.setContentType("image/jpeg");
        
        //������Ӧͷ��Ϣ�������������Ҫ���������
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//���ͼƬ����
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
	/**
	 * �ж��û���
	 */
	@RequestMapping(value="/username/{name}",method = RequestMethod.GET)
	@ResponseBody
	public String username(@PathVariable("name") String username) {
		System.out.println(username);
		Manager manager = managerService.findByusernameUser(username);
		System.out.println(manager.getManagername());
		return manager.getPasswd();
	}
	
	/**----------------------------------------
	 * �����û�����ѯ�û�
	 */
	@RequestMapping(value="/findusername",method = RequestMethod.GET)
	public String findusername(Model model,HttpServletRequest request) {
		String username  = request.getParameter("findmanagername");
		System.out.println(username);
		List<Manager> managerlist = managerService.BynamefindManager(username);
		model.addAttribute("ManagerList", managerlist);
		for (Manager manager : managerlist) {
			if(manager.getMstate().endsWith("1")){
				manager.setMstate("����");
			}
			if(manager.getMstate().endsWith("2")){
				manager.setMstate("δ����");
			}
		}
		return "main_list";
	}
	
	
	/**
	 * �û�����
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response,String managername,String passwd,Model model,HttpSession session) {
		//ͨ���˺������ѯ�û�
		Manager manager = managerService.findUser(managername, passwd);
		
		String checkCode = request.getParameter("check_code");
		String savedCode = (String) request.getSession().getAttribute("randomcode_key");
		System.out.println(checkCode);
		System.out.println(savedCode);
		if(manager!=null &&checkCode.equals(savedCode)) {
			//���û����û�������ӵ�session
			session.setAttribute("MANAGER_SESSION", manager);
			
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
		    //����cookie����ʱ��  
		    cookie.setMaxAge(60*20);  
		    //��������cookie���������  
		    response.addCookie(cookie); 
			//��ת����ҳ
			return "index";
		}
		else if(checkCode!=null&&savedCode!=null &&!checkCode.equals(savedCode)&&manager!=null) {
			model.addAttribute("msg", "��֤���������");
			return 	"login";
		}
		else if(manager==null || savedCode==null) {
					model.addAttribute("msg", " ");
				}
		return 	"login";			
	}
	
	
}
