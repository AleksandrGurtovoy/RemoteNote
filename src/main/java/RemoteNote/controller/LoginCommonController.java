package RemoteNote.controller;

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

    @Autowired
    private LoginCommonService loginCommonService;

    @ApiOperation(value = "Возвращает true если данный пользователь существует")
    @RequestMapping(value = "/autorizeUser", method = RequestMethod.GET)
    @ResponseBody
    public boolean authorizeUser(
            @ApiParam(value = "Логин и пароль", required = true) @RequestBody JSONObject params) throws Exception {
        return loginCommonService.authUser(params);
    }
}
