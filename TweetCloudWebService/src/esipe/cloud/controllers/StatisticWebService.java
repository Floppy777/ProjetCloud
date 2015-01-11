package esipe.cloud.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import esipe.cloud.entities.SpiderChartData;
import esipe.cloud.mongo.MongoDBClient;
import esipe.cloud.parameters.TwitterID;
import esipe.cloud.twitter.Tweet;
import esipe.cloud.twitter.TwitterUtil;


@Path("/statistic")
public class StatisticWebService {
	
	public StatisticWebService(){}
	
	@GET
	@Path("test")
	public String testWebService(){
		return "Hello World";
	}
	
	@GET
	@Path("chart")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJsonHighchart() throws Exception{
		// DO SOMETHING
		MongoDBClient client = new MongoDBClient("127.0.0.1", "projectcloud", "florian", "florian");
		List<Tweet> ldlc_tweet = TwitterUtil.getListfromID(client, TwitterID.LDLC);
		List<Tweet> topachat_tweet = TwitterUtil.getListfromID(client, TwitterID.TOP_ACHAT);
		List<Tweet> materiel_tweet = TwitterUtil.getListfromID(client, TwitterID.MATERIEL_NET);
		
		System.out.println(ldlc_tweet.size());
		System.out.println(topachat_tweet.size());
		System.out.println(materiel_tweet.size());

		List<SpiderChartData> chart = new ArrayList<SpiderChartData>();
		chart.add(new SpiderChartData("TopAchat",new Integer[] {9,4,7,7}));
		chart.add(new SpiderChartData("Materiel.net",new Integer[] {3,6,5,8}));
		chart.add(new SpiderChartData("LDLC",new Integer[] {5,2,3,8}));
		return Response.status(Status.OK).entity(chart).build();
	}
	
	

}
