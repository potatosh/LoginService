import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() {
		// データベースがからかどうか確かめる
		if(User.count() == 0) {
			Fixtures.loadModels("userdata.yml");
		}
	}
}
