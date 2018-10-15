package RemoteNote.controller;

import RemoteNote.model.User;
import RemoteNote.service.LoginCommonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class LoginCommonController {


    private LoginCommonService loginCommonService = new LoginCommonService();

    @ApiOperation(value = "Возвращает юзера из бд")
    @RequestMapping(value = "/authorizeUser", method = RequestMethod.GET)
    @ResponseBody
    public String authorizeUser(
            @ApiParam(value = "Логин и пароль", required = true) @RequestParam String login) throws Exception {
        //return loginCommonService.authUser(params);
        return login;
    }
}
