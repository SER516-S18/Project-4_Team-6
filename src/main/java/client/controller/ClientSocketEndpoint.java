package client.controller;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import client.constants.ClientConstants;
import client.model.FaceData;

/**
 * The ClientSocketEndpoint class creates socket endpoint of client Takes care
 * of server client connection and data received from server
 * 
 * @author Team06
 * @version 1.0
 */
@ClientEndpoint
public class ClientSocketEndpoint {
	static WebSocketClientMain webSocketClientMain;
	//static MenuBarListener clockListener;
	private static Gson gson = new Gson();
	private FaceData faceData;

	public static void setMainClientWebSocket(WebSocketClientMain webSocketClientMainVal) {
		webSocketClientMain = webSocketClientMainVal;

	}

	

	/**
	 * onMessage parse the JSON formated data received from server into values
	 * 
	 * @param message
	 */
	@OnMessage
	public void onMessage(String message) {
		System.out.println("on Message called"+message);
		JsonParser parser = new JsonParser(); 
		JsonObject json = (JsonObject) parser.parse(message);
		JsonElement detectionModel = json.get("detectionModel");
		String affectiveData = detectionModel.getAsJsonObject().get("primaryDataModel")
				.getAsJsonObject().get("affectiveDataModel").toString();
		String counter = detectionModel.getAsJsonObject().get("primaryDataModel").
				getAsJsonObject().get("counter").toString();
		String expressiveData = detectionModel.getAsJsonObject().get("primaryDataModel")
				.getAsJsonObject().get("expressiveDataModel").toString();
		String faceData = "FaceData:{ counter:" + counter + ", AffectiveDataModel :{" +
				affectiveData + " } , ExpressiveDataModel :{ " + expressiveData + " }" ;
		//faceData = gson.fromJson(faceData, FaceData.class);
		/*faceData = gson.fromJson(message, FaceData.class);
		faceData = gson.fromJson(message, FaceData.class);
		ClientDataSingleton.getInstance().setFaceData(faceData);
		ExpressivePlotData.getInstance().setDataToList(faceData.getExpressiveData());
		ClientDataSingleton.getInstance().getExpressplot().plotExpressionGraph();
		AffectivePlotData.getInstance().setDataToList(faceData.getAffectiveData(), faceData);
		ClientDataSingleton.getInstance().getAffectivePlot()
				.plotAffectiveGraph1(AffectivePlotData.getInstance().getDataset());
		ClientDataSingleton.getInstance().setFaceExpressionController(new ClientFaceController());
		String fileName = ClientDataSingleton.getInstance().getFaceExpressionController()
				.getFaceFileName(faceData.getExpressiveData());
		ClientDataSingleton.getInstance().getFaceExpressions().drawImage(fileName);
		clockListener.updateTime(faceData.getCounter());*/
	}

	/**
	 * closedConnection method ends the websocket and client server connection
	 * 
	 * @param session
	 *            : current session object
	 */
	@OnClose
	public void closedConnection(Session session) {
		/*ClientDataSingleton.getInstance().setSessionMaintained(false);
		clockListener.setConnectionLabel(false);
		clockListener.setConnectionLabel(false);*/
		try {
			session.close();
			webSocketClientMain.clientThread.interrupt();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.CLOSING_CONNECTION_EXCEPTION_MESSAGE);
		}
	}
}