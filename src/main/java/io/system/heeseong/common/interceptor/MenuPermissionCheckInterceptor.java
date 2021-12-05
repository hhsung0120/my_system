package io.system.heeseong.common.interceptor;

import io.system.heeseong.user.model.Menu;
import io.system.heeseong.user.service.AccountUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class MenuPermissionCheckInterceptor implements AsyncHandlerInterceptor {

	@Autowired
	private AccountUserService accountUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUri = request.getRequestURI();

		List<Menu> menuList = accountUserService.getMenuPermissionList();
		for(Menu myMenu : menuList){
			if(requestUri.contains(myMenu.getMenuUri())){
				return true;
			}
		}

		response.sendError(HttpServletResponse.SC_FORBIDDEN);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		AccountUser accountUser = accountService.getSessionAccountUser();
//		modelAndView.addObject("accountUser",accountUser);
//		super.postHandle(request, response, handler, modelAndView);
	}

	
}
