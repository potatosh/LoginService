package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class User extends Model {
	public String fullName;
	public String userID;
	public String password;

	//コンストラクタ
	public User(String fullName, String userID, String password) {
		this.fullName = fullName;
		this.userID = userID;
		this.password = password;
	}

	//IDとパスワードで接続する（というよりデータベースから探し出す） なんと2つの値でDBから探すことができるらしい 便利！
	public static User connect(String userID, String password) {
		return User.find("byUserIDAndPassword", userID, password).first();
	}
}