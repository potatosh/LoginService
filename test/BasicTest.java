import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void createUserTest() {
	    //Userをつくってデータベースに保存する
	    new User("Shouhei Hayakawa", "potatosh", "pttptt12345").save();

	    //IDを使ってユーザを探し出す
	    User res = User.find("byUserID", "potatosh").first();

	    assertNotNull(res);
	    assertEquals("Shouhei Hayakawa", res.fullName);
    }

    @Test
    public void connectTest() {
	    //Userを作ってDBに保存
	    new User("Shouhei Hayakawa", "potatosh", "pttptt12345").save();

	    //コネクト(Play! framework mix)
	    assertNotNull(User.connect("potatosh", "pttptt12345"));
	    assertNull(User.connect("potatosh", "ptptpt12345"));
	    assertNull(User.connect("potadig", "pttptt12345"));
    }

}
