int userScore = 1000;
int e = 600;
int f = 450;
int s = 30;
int h;
int timer;
boolean touched = false;
JSONObject json;
void secondScore()
{
  
if(millis() - timer >= 200)
{
  if(userScore > 0)
  {
  userScore = userScore - 1;
  timer = millis();
  }else{
    Spielabbruch();
  }
} 
}

void touchScore()
{
  if(touched == true)
  {  
    if(userScore > 0)
    {
    userScore = userScore - 25;
    println(userScore);
       touched = false;
    }else{
      Spielabbruch();
    }
  }
}

void score()
{
  fill(255,255,255);
  textSize(s);
  text("Points: " + userScore,e,f);
}




void Highscore()
{
  
  json = new JSONObject();
  json.setInt("highscore", h);
  saveJSONObject(json, "data/" + derName + ".json");

}
