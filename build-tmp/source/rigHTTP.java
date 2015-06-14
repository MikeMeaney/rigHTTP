import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import http.requests.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class rigHTTP extends PApplet {

//UCSD Test Rig client-side processing HTTP tests
//Written by Mike Meaney in San Diego, CA (2015)

//This skectch sends data to a server via a 
//query string via HTTP GET requests.
//Is this the best way of doing it? No.
//But, I'm already driving a screw with a hammer
//by using Processing so, DERP ALL THE KLUDGES!!!



float derpNumber = 0;

public void setup() 
{
  size(400, 400);
  smooth();

  //How to get data from Server
  GetRequest get = new GetRequest("http://localhost:3000?derpNumber=5555");
  get.send(); // program will wait untill the request is completed
  println("response: " + get.getContent());

//  JSONObject response = parseJSONObject(get.getContent());
//  println("the fart goes...: " + response.getString("fart"));

  //How to post data to server (in this case a random number)
  derpNumber = random(0, 55555);
  println("Derp number is: " + derpNumber );
  GetRequest getParams = new GetRequest("http://localhost:3000/status?derpNumber="+derpNumber+"!&theStruggle=isReal");
  getParams.send();
  println("Params response: " + getParams.getContent());

  exit();
}



  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "rigHTTP" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
