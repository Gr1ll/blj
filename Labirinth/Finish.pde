    void Spielende()
{
  println("perfekt");
  noLoop();
  background(0,0,0);
  fill(0,250,0);
  stroke(0,250,0);
  e = 295;
  f = 430;
  s = 45;
  

    
//W
rect(100,50,50,300);
rect(100,300,250,50);
rect(200,50,50,300);
rect(300,50,50,300);

//I
rect(400,50,50,300);

//N

rect(500,50,50,300);
rect(550,50,150,50);
rect(650,50,50,300);
 
fill(250,250,250);  
textSize(30);
json = loadJSONObject("data/" + derName + ".json");
h = json.getInt("highscore");
println(h);
if(userScore > h)
{
  println(h);
  h = userScore;
  Highscore();
}
text("Highscore: " + h,300,470);  

fill(250,250,250);
textSize(20);
text("Press any Key to Restart",560,480);

}


int value = 0;



void keyPressed() 
{
  if (value == 0) 
  {
   loop();
   setup();
   draw();
   secondScore();
   touchScore();
   score();
   Highscore();
   
    e = 600;
 f = 450;
 s = 30;
 userScore = 1000;

    x = 50;
 y = 75;
 d = 43;

//Kreis Farben
 u = 250;
 t = 0;
 l = 0;

//Start Button
g = 200;
j = 380;
w = 400;
hh = 100;

//Name Button
gg = 200;
jj = 250;
ww = 400;
hhh = 100;
    
touched = false;


  }else{
  
  }
  
  //Name:

    if(jetzt == true)
    {
    if (key==CODED) {
    if (keyCode==LEFT) {
      println ("left");
    } 
    else {
      println ("unknown special key");
    } 
  } 
  else
  {
    if (key==BACKSPACE) {
      if (text1.length()>0) {
        text1=text1.substring(0, text1.length()-1);
      } 
    } 
    else if (key==RETURN || key==ENTER) {
      derName = text1;
      println(derName);
    }
    else {
      text1+=key;
    }
    println (text1);
  }
}


}
