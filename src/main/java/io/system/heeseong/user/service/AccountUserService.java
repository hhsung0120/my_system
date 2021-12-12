package io.system.heeseong.user.service;

import io.system.heeseong.common.exception.LoginFailException;
import io.system.heeseong.user.domain.entity.AccountUserEntity;
import io.system.heeseong.user.domain.model.AccountUser;
import io.system.heeseong.user.domain.model.Menu;
import io.system.heeseong.user.domain.reposiroty.AccountUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class AccountUserService {

    private List<Menu> menuList = new ArrayList<>();

    final AccountUserRepository accountUserRepository;

    final MenuService menuService;
    final HttpSession httpSession;

    public Long getAccountUserIdx(AccountUser accountUser){
        return getAccountUser(accountUser).getIdx();
    }

    public AccountUser getAccountUser(AccountUser accountUser){
        AccountUserEntity accountUserEntity =
                Optional.ofNullable(accountUserRepository.findByEmail(accountUser.getEmail()))
                        .orElseThrow(() -> new LoginFailException(LoginFailException.Message.LOGIN_FAIL_EXCEPTION));

        //비밀번호 검사
        if(!new BCryptPasswordEncoder().matches(accountUser.getPassword(), accountUserEntity.getPassword())){
            throw new LoginFailException(LoginFailException.Message.LOGIN_FAIL_EXCEPTION);
        }

        dataSetting(accountUserEntity.entityToValueObject());


        return accountUserEntity.entityToValueObject();
    }

    //세션, 메뉴 리스트 셋팅
    private void dataSetting(AccountUser accountUser) {
        setSessionAccountUser(accountUser);
        menuList = menuService.selectMyMenuPermissionList(accountUser.getRole());
    }

    public List<Menu> getMenuPermissionList(){
        return menuList;
    }

    public void reloadMenuPermissionList(){
        AccountUser accountUser = this.getSessionAccountUser();
        menuList = menuService.selectMyMenuPermissionList(accountUser.getRole());
    }


    public void setSessionAccountUser(AccountUser accountUser){
        httpSession.setAttribute("accountUser", accountUser);
    }

    public AccountUser getSessionAccountUser(){
        return (AccountUser) Optional.ofNullable(httpSession.getAttribute("accountUser"))
                                     .orElse(null);
    }
}
