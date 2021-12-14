package io.system.heeseong.common.interceptor;

import io.system.heeseong.common.service.ValidationService;
import io.system.heeseong.user.domain.model.AccountUser;
import io.system.heeseong.user.service.AccountUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CheckLoginInterceptor implements AsyncHandlerInterceptor {

	@Autowired
	private AccountUserService accountUserService;

	@Autowired
	private ValidationService validationService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if(!validationService.isLoginCheck()){
			return true;
		}

		AccountUser accountUser = accountUserService.getSessionAccountUser();

		if(accountUser == null){
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/users/login");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		modelAndView.addObject("accountUser", accountUserService.getSessionAccountUser());
		AsyncHandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	
}
