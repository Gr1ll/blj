int x = 50;
int y = 75;
int d = 43;
double r = d/2;

//Kreis Farben
int u = 250;
int t = 0;
int l = 0;

//Start Button
float g = 200;
float j = 380;
float w = 400;
float hh = 100;


//Name Button
float gg = 200;
float jj = 250;
float ww = 400;
float hhh = 100;


//TheName
String theName = "";


void setup()
{
  
size(800 ,650);
noStroke();

}

 

void draw() {

 

background(50);

           stroke(255,255,255);

          fill(255,255,255);

          rect(10,50,240,50);

 

          stroke(255,255,255);

          fill(255,255,255);

          rect(200,50,50,150);

 

          stroke(255,255,255);

          fill(255,255,255);

          rect(200,150,150,50);

       

          stroke(255,255,255);

          fill(255,255,255);

          rect(350,150,50,200);

       

          stroke(255,255,255);

          fill(255,255,255);

          rect(150,300,200,50);

       

          stroke(255,255,255);

          fill(255,255,255);

          rect(150,300,50,200);

       

          stroke(255,255,255);

          fill(255,255,255);

          rect(150,450,400,50);

       

          stroke(255,255,255);

          fill(255,255,255);

          rect(500,50,50,400);

       

          stroke(255,255,255);

          fill(255,255,255);

          rect(500,50,200,50);

       

          stroke(0,255,0);

          fill(0,255,0);

          rect(700,50,50,50);

         

          stroke(255,255,255);

          fill(u,t,l);

          circle(x, y, d);
          
if(mousePressed && mouseX >= x - 21.5 && mouseX <= x + 21.5 && mouseY >= y - 21.5 && mouseY <= y + 21.5)

{
x = mouseX;
y = mouseY;
Verkleinern();
Tod();

}
if (mousePressed && x >= 675 && x <= 725 && y >= 50 && y <= 100)
{
  Spielende();
}
if(again == true)
{
  start = true;
  Anfang();
  Name();
}else{
secondScore();
score();

}
}
