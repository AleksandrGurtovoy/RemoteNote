package RemoteNote.controller;

import RemoteNote.service.LoginCommonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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

    @ApiOperation(value = "Сохраняет данные пользователя в бд")
    @RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
    @ResponseBody
    public void saveUserData(
            @ApiParam(value = "Логин", required = true) @RequestParam(name = "login") String login,
            @ApiParam(value = "Полное фио", required = true) @RequestParam(name = "fullName") String fullName,
            @ApiParam(value = "Дата рождения", required = true) @RequestParam(name = "date") String date) throws Exception {
         loginCommonService.saveUserData(login, fullName, date);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage() {
        return "index";
    }

}
