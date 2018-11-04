package RemoteNote.controller;

import RemoteNote.service.LoginCommonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
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

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage() {
        return "index";
    }

    @RequestMapping(value = "/in", method = RequestMethod.GET)
    public String secondPage() {
        return "second";
    }


}
