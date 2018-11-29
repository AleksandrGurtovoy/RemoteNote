package RemoteNote.controller;

import RemoteNote.service.LoginCommonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginCommonController {

    private LoginCommonService loginCommonService = new LoginCommonService();

    @ApiOperation(value = "Возвращает юзера из бд")
    @RequestMapping(value = "/authorizeUser", method = RequestMethod.GET)
    @ResponseBody
    public String authorizeUser(
            @ApiParam(value = "Логин", required = true) @RequestParam(name = "login") String login) throws Exception {
        return loginCommonService.authUser(login).toString();
    }

    @ApiOperation(value = "Сохраняет данные пользователя в бд")
    @RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
    @ResponseBody
    public Boolean saveUserData(
            @ApiParam(value = "Логин", required = true) @RequestParam(name = "login") String login,
            @ApiParam(value = "Полное фио", required = true) @RequestParam(name = "fullName") String fullName,
            @ApiParam(value = "Дата рождения", required = true) @RequestParam(name = "date") String date) throws Exception {
        return loginCommonService.saveUserData(login, fullName, date);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage() {
        return "index";
    }

}
