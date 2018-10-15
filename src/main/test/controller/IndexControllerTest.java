package controller;

import RemoteNote.controller.IndexController;
import org.junit.Assert;
import org.junit.Test;

public class IndexControllerTest {

    @Test
    public void mainPage_indexReturned(){
        IndexController controller = new IndexController();
        String result = controller.mainPage();
        Assert.assertEquals("index", result);
    }
}
