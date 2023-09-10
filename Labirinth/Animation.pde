boolean make = false;
int timer2;
int passtime = 5;
void animation()
{
if(make == true)
{
    if(d > 41 || d > 39 || d > 37 || d > 35 || d > 33 || d > 31 || d > 29 || d > 27 || d > 25 || d > 23 || d > 21 || d > 20 )
    {    
    make = false;
    u = 250;
    t = 0;
    l = 0;    
    if(millis() - timer2 >= 1)
    {
    passtime = passtime - 1;
    timer2 = millis();
    }
    
    if(passtime == 5)
    {
    u = 250;
    t = 200;
    l = 0;
      d = d -4; 
      touched = true;
      touchScore();
    }
    
    if(passtime <= 0)
    {
    u = 250;
    t = 200;
    l = 0;
    
    passtime = 50;
    make = false;
    }
    }else{
    Spielabbruch();
    make = false;
    }
}
}
