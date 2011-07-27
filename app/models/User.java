package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class User extends Model {
	public String fullName;
	public String userID;
	public String password;

	public User(String fullName, String userID, String password) {
		this.fullName = fullName;
		this.userID = userID;
		this.password = password;
	}

	public static User connect(String userID, String password) {
		// TODO 自動生成されたメソッド・スタブ
		return User.find("byUserIDAndPassword", userID, password).first();
	}
}