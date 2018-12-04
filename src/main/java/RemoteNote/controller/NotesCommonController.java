package RemoteNote.controller;

import RemoteNote.model.Note;
import RemoteNote.service.NotesCommonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NotesCommonController {

    private NotesCommonService notesCommonService = new NotesCommonService();

    @ApiOperation(value = "Возвращает записи из бд")
    @RequestMapping(value = "/getNotes", method = RequestMethod.GET)
    @ResponseBody
    public List<Note> getNotes(
            @ApiParam(value = "Логин", required = true) @RequestParam(name = "id") Long id) throws Exception {
        return notesCommonService.getNotes(id);
    }
}
