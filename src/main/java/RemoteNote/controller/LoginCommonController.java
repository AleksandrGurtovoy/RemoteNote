package RemoteNote.controller;

import RemoteNote.service.LoginCommonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class LoginCommonController {

    private LoginCommonService loginCommonService = new LoginCommonService();
    private Logger LOG = LoggerFactory.getLogger(LoginCommonController.class);

    @ApiOperation(value = "Возвращает юзера из бд")
    @RequestMapping(value = "/authorizeUser", method = RequestMethod.GET)
    @ResponseBody
    public String authorizeUser(
            @ApiParam(value = "Логин", required = true) @RequestParam(name = "login") String login) {
        return loginCommonService.authUser(login).toString();
    }

    @RequestMapping(value = "/getPhoto", method = RequestMethod.GET)
    @ResponseBody
    public String getPhoto(
            @ApiParam(required = true, value = "Строковый логин сотрудника") @RequestParam String login,
            HttpServletResponse httpResponse) {

        /*byte[] photo = loginCommonService.getPhoto(login);
        httpResponse.setHeader("Content-disposition", "attachment; filename="
                + login + ".jpg");
        httpResponse.setHeader("Content-Type", "image/jpeg");
        httpResponse.setContentLength(photo.length);*/
        return loginCommonService.getPhoto(login);
    }

    @ApiOperation(value = "Сохраняет фото юзера в бд")
    @RequestMapping(value = "/setPhoto", method = RequestMethod.POST)
    @ResponseBody
    public String setPhoto(
            @ApiParam(value = "Логин", required = true) @RequestParam(name = "login") String login,
            @ApiParam(value = "Фото", required = true) @RequestBody byte[] photo) throws Exception {
        LOG.info("Retrieve photo with size{}", photo.length);
        return loginCommonService.setPhoto(login, photo);
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
