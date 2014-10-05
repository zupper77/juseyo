/**
 * @file    MyPageController.java
 * @brief   마이페이지 관련 작업을 담당하는 controller
 * @author  개발3/파트2
 * @author  송아영
 * @date    생성 : 2014. 5. 2.
 * @date    최종수정: 2014. 5. 2.
 */
package com.juseyo.mypage.controller;

import com.juseyo.administrator.dto.UserDto;
import com.juseyo.certification.annotation.IgnoreAccessibleCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @brief MyPageController
 * @author 개발3팀/파트2/송아영
 * @version 1.0
 * @date 생성: 2014. 5. 2.
 * @date 최종수정: 2014. 5. 2.
 * @remark
 */
@Controller
public class MyPageController {
    
//    @Resource
//    private UserSecurityService userSecurityService;
//
//    @Resource
//    private UserSessionApi userSessionApi;

    /**
     * 패스워드 변경 페이지를 리턴한다.
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/mypage/myPageList.*")
    @IgnoreAccessibleCheck
    public String myPageList(Model model) {
        return "/mypage/myPageList";
    }

    /**
     * 
     * @brief pwdChange
     * @details 패스워드 변경 처리를 한다.
     * @param 파라미터명
     *            파라미터 설명
     * @return 리턴 타입 json
     * @throws Exception
     */
    @RequestMapping(value = "/mypage/editPwd.*")
    @IgnoreAccessibleCheck
    public Model editPwd(Model model, HttpServletRequest request, @RequestParam Map<String, String> params, UserDto user) throws Exception {

//        // userCd를 얻기위해 로그인세선정보를 가져옴.
//        UserDto loginInfo = userSessionApi.getLoginUser();
//
//       if (loginInfo.getUserCd() == null || loginInfo.getUserCd().equals("") ) throw new ParameterException();
//
//        try{
//         // 정책에 맞는 비밀번호인지 체크( 6~16자리 영문 대소문자, 숫자, 특수문자를 조합 )
//            //^([a-zA-Z]+[0-9]+[!@$%^&*]+{6,16})
//            //((?=.*[0-9])(?=.*[a-z]) (?=.*[A-Z])(?=.*[!@$%^&*])(?=[\\S]+$).{6,16})
//            // \\d 숫자체크, \\w 숫자문자 체크 , \\D 숫자를 제외한 문자
//            //
//            Pattern num_pattern = Pattern.compile("\\d");
//            Pattern eng_pattern = Pattern.compile("[a-zA-Z]");
//            String pwd = user.getUserPwd().trim();
//
//            Matcher num_matcher = num_pattern.matcher(pwd);
//            Matcher eng_matcher = eng_pattern.matcher(pwd);
//
//            int num_index = 0;
//            while(num_matcher.find()) {
//                num_index++;
//            //  System.out.println(num_matcher.group(0)); //지정된 패턴과 매칭되면 numeral 변수에 넣는다. 여기서는 숫자!!
//            }
//
//            int eng_index = 0;
//            while(eng_matcher.find()) {
//                eng_index++;
//            //  System.out.println(eng_matcher.group(0)); //지정된 패턴과 매칭되면 numeral 변수에 넣는다. 여기서는 숫자!!
//            }
//
//            if( num_index > 0 && eng_index > 0 && pwd.length() >= 6 && pwd.length() <= 16 ) {
//                // 현재(기존) 비밀번호가 맞는지 체크하기 위해 userDto에 userCd와 oldUserPwd(현재 비밀번호)를 Set
//                user.setUserCd(loginInfo.getUserCd());
//                user.setUserPwd(params.get("oldUserPwd"));
//
//                userSecurityService.checkUserPwd(user);
//
//                // 새로운 비밀번호로 변경하기 위해 userDto에 userPwd(새로운 비밀번호)를 Set
//                user.setUserPwd(params.get("userPwd"));
//                userSecurityService.modifyUserPwd(user);
//
//                ResultMessageMapper.addSuccess(model);
//            }else{
//                model.addAttribute("success", false);
//                model.addAttribute("message", "SecurityLowPwdException");
//            }
//        }catch(NotMatchPwdException e){
//            ResultMessageMapper.addFail(model, e);
//        }
        return model;
    }
}
