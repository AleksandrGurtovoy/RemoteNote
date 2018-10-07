package RemoteNote.controller;

import RemoteNote.model.User;
import RemoteNote.service.LoginCommonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginCommonController {


    private LoginCommonService loginCommonService = new LoginCommonService();

    @ApiOperation(value = "Возвращает юзера из бд")
    @RequestMapping(value = "/authorizeUser", method = RequestMethod.GET)
    @ResponseBody
    public User authorizeUser(
            @ApiParam(value = "Логин и пароль", required = true) @RequestBody JSONObject params) throws Exception {
        return loginCommonService.authUser(params);
    }
}
