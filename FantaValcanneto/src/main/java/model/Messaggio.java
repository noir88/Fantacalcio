package model;

import java.sql.Timestamp;

public class Messaggio {

private Timestamp data;
private int user_id;
private String messaggio;

public Timestamp getData() {
	return data;
}
public void setData(Timestamp data) {
	this.data = data;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getMessaggio() {
	return messaggio;
}
public void setMessaggio(String messaggio) {
	this.messaggio = messaggio;
}


}
