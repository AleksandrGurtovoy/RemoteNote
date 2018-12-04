package RemoteNote.controller;

import RemoteNote.model.Note;
import RemoteNote.service.NotesCommonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "Сохраняет запись в бд")
    @RequestMapping(value = "/saveNote", method = RequestMethod.GET)
    public void saveNote(
            @ApiParam(value = "Логин", required = true) @RequestParam String name,
            @ApiParam(value = "Логин", required = true) @RequestParam String text,
            @ApiParam(value = "Логин", required = true) @RequestParam Long id) throws Exception {
        notesCommonService.saveNote(name, text, id);
    }

    @ApiOperation(value = "Сохраняет запись в бд")
    @RequestMapping(value = "/updateNote", method = RequestMethod.GET)
    public void updateNote(
            @ApiParam(value = "Логин", required = true) @RequestParam String name,
            @ApiParam(value = "Логин", required = true) @RequestParam String text,
            @ApiParam(value = "Логин", required = true) @RequestParam Long id) throws Exception {
        notesCommonService.updateNote(name, text, id);
    }
}
