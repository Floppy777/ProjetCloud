package esipe.cloud.twitter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import esipe.cloud.mongo.MongoDBClient;

public class TwitterUtil {	
	
	public static List<Tweet> getListfromID(MongoDBClient client, long id){
		List<Tweet> list = new ArrayList<Tweet>();
		BasicDBObject query = new BasicDBObject();
		query.put("user._user_id", id);
		DBCursor db_cursor = client.getCursorFromQuery(query);
		BasicDBObject o ;
		while(db_cursor.hasNext()){			
			o = (BasicDBObject)db_cursor.next();
			long id_user = (Long) ((DBObject)o.get("user")).get("_user_id");
			String name = (String) ((DBObject)o.get("user")).get("name");
			User u = new User(id_user,name);
			long id_tweet = (Long) o.get("_id");
			String msg = (String)o.get("text");
			Tweet t = new Tweet(id_tweet, msg, null, u);
			list.add(t);
			System.out.println("1");
		}
		for(Tweet t : list){
			System.out.println(t);
		}
		return list;
	}
}
