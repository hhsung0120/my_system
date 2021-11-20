package io.system.heeseong.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

//	@Autowired
//	private AccountService accountService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
//		AccountUser accountUser = accountService.getSessionAccountUser();
//
//		if(accountUser==null){
//			String contextPath = request.getContextPath();
//			response.sendRedirect(contextPath+"/");
//			return false;
//		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		AccountUser accountUser = accountService.getSessionAccountUser();
//		modelAndView.addObject("accountUser",accountUser);
//		super.postHandle(request, response, handler, modelAndView);
	}

	
}
