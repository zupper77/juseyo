package com.juseyo.certification.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CertificationInterceptor extends HandlerInterceptorAdapter {

//    @Resource
//    private UserSessionApi userSessionAPI;

//    @Resource
//    private MenuServiceImpl menuService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUrl = request.getRequestURI().toString();
        String contextPath = request.getContextPath();
        return super.preHandle(request, response, handler);
    }


    /**
     * @brief generateMenuInfo
     * @details
     * @param request
    private void generateMenuInfo(HttpServletRequest request) throws Exception {
        //URL
        String uri = request.getRequestURI();
        //Gnb 접근가능한 메뉴목록
        List<MenuDto> menuList = userSessionAPI.getAccessibleMenuList();
        //선택된 메뉴코드
        String gnb = StringUtil.nvl(request.getParameter("gnb"), "0");
        //선택된 메뉴Dto
        MenuDto menuDto = menuService.getSelectedMenu(menuList, request);

        request.setAttribute("userNm", userSessionAPI.getLoginUser().getUserNm());
        request.setAttribute("menu", "");
        request.setAttribute("gnb", gnb);
        request.setAttribute("menuNm", "홈");
        request.setAttribute("helpDocUrl", "");
        request.setAttribute("helpDocYn", "n");

        if (menuDto != null) {
            gnb = Integer.toString(menuDto.getMenuCd());
            request.setAttribute("gnb", gnb);
            request.setAttribute("menuNm", menuDto.getMenuNm());
            request.setAttribute("helpDocUrl", menuDto.getHelpDocUrl());
            request.setAttribute("helpDocYn", menuDto.getHelpDocYn());
        }

        //인사평가 분리
        MenuDto tempMenuDto = new MenuDto();
        tempMenuDto.setMenuCd(3);
        tempMenuDto.setpMenuCd(1);

        if (menuList != null && menuList.size() > 0) {
            if (uri.endsWith(".per")) {
                List<MenuDto> perMenulist = new ArrayList<MenuDto>();
                perMenulist.add(tempMenuDto);
                menuService.createChildMenuList(perMenulist, tempMenuDto, menuList);
                request.setAttribute("menu", menuService.getMenuListToHTML(perMenulist, Integer.parseInt(gnb)));
            } else {
                //인사평가 메뉴 삭제
                menuService.removeMenu(menuList, tempMenuDto);
                request.setAttribute("menu", menuService.getMenuListToHTML(menuList, Integer.parseInt(gnb)));
            }
        }
    }
    */

}
