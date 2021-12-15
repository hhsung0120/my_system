package io.system.heeseong.common.interceptor;

import io.system.heeseong.common.service.ValidationService;
import io.system.heeseong.user.domain.model.Menu;
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

	@Autowired
	private ValidationService validationService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if(!validationService.isMenuPermissionCheck()){
			return true;
		}

		String requestUri = request.getRequestURI();

		//스트림으로 변경하기
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
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//비동기 요청일경우 여기에 걸리면 view 가 없어서 null 임
		if(modelAndView == null){
			modelAndView = new ModelAndView();
		}
		modelAndView.addObject("menuList", accountUserService.getMenuPermissionList());

	}
}
