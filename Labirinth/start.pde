boolean start = false;
boolean again = true;
int pos1 = 200;
int pos2 = 100;

void Anfang()
{
 background(0);
 stroke(255);
 fill(20, 20, 20);

//Eingabefeld
 rect(g,j,w,hh);
 rect(gg,jj,ww,hhh);

//Text

fill(255, 255, 255, 255);
textSize(45);
text("The super heavy and challenging",25,100);
text("labyrinth",300,150);
text("of a thousand frustrations", 125, 200);
text("Press to Start",250,445);
textSize(35);
text("Name:",40,315);



 
 if(mousePressed){
  if(mouseX > g && mouseX < g+w && mouseY > j && mouseY < j+hh){
      if(start == true)
      {
        derName = text1;
        if(derName.length() > 0)
        {
        println("Started");
        pos1 = 2000;
        pos2 = 1000;
        jetzt = false;
        fill(0);
        start = false;
        again = false;   
        }
        

            BufferedReader reader;
            String line;
            
            File f = dataFile(derName + ".json");
            String filePath = f.getPath();
            boolean exists = f.isFile();
            
            if (exists)
            {
                json = loadJSONObject("data/" + derName + ".json");
                h = json.getInt("highscore");
            }
            else
            {
                h = 0;
                json = new JSONObject();
                json.setInt("highscore", h);
                saveJSONObject(json, "data/" + derName + ".json");
            }

      }
  }
}
}
