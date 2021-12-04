package io.system.heeseong.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MenuPermissionCheckInterceptor implements AsyncHandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
//		if(uri.contains("/facebook")){
//			response.sendError(HttpServletResponse.SC_FORBIDDEN);
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
