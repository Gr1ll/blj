boolean tod;

 

double h1 = 75;

double b1 = 225;

double h2 = 175;

double b2 = 375;

double h3 = 325;

double b3 = 175;

double h4 = 475;

double b4 = 525;

double h5 = 75;

 

boolean part1Oben;

boolean part1Unten;

 

boolean part2Links;

boolean part2Rechts;

 

boolean part3Oben;

boolean part3Unten;

 

boolean part4Links;

boolean part4Rechts;

 

boolean part5Oben;

boolean part5Unten;

 

boolean part6Links;

boolean part6Rechts;

 

boolean part7Oben;

boolean part7Unten;

 

boolean part8Links;

boolean part8Rechts;

 

boolean part9Oben;

boolean part9Unten;

 

void Tod()

{

// part1Oben //////////////////////////////////////////////////////////////

 

  if(mouseX > 10 && mouseX < 300)

  {

    part1Oben = true;

  }

 

  if (mouseX > 255 || mouseY > 155)

    {

      part1Oben = false;

    }

   if(part1Oben == true)

   {  

     if(mouseY < h1 - 50)

     {

        Spielabbruch();

     }

   }

   part1Oben = false;

 

 

  // part1Unten //////////////////////////////////////////////////////////////

 

  if(mouseX > 10 && mouseX < 175)

  {

    part1Unten = true;

  }

 

  if (mouseX > 200 || mouseY > 155)

    {

      part1Unten = false;

    }

   if(part1Unten == true)

   {  

     if (mouseY > h1 + 50)

     {

        Spielabbruch();

     }

   }

   part1Unten = false;

 

 

// part2Links //////////////////////////////////////////////////////////////

 

  if(mouseY > 115 && mouseY < 200)

  {

    part2Links = true;

  }

 

  if (mouseX > 305 || mouseY > 250)

    {

      part2Links = false;

    }

   if(part2Links == true)

   {  

     if (mouseX < b1 - 50)

     {

        Spielabbruch();

     }

   }

   part2Links = false;

// part2Rechts //////////////////////////////////////////////////////////////

 

  if(mouseY > 0 && mouseY < 125)

  {

    part2Rechts = true;

  }

 

  if (mouseX > 305 || mouseY > 140)

    {

      part2Rechts = false;

    }

   if(part2Rechts == true)

   {  

     if (mouseX > b1 + 50)

     {

        Spielabbruch();

     }

   }

   part2Rechts = false;

  

   

   // part3Oben //////////////////////////////////////////////////////////////

 

  if(mouseX > 275 && mouseX < 400)

  {

    part3Oben = true;

  }

 

  if (mouseX > 400 || mouseY > 255 || mouseY < 100)

    {

      part3Oben = false;

    }

   if(part3Oben == true)

   {  

     if(mouseY < h2 - 50)

     {

        Spielabbruch();

     }

   }

   part3Oben = false;

 

 

// part3Unten //////////////////////////////////////////////////////////////

 

  if(mouseX > 200 && mouseX < 325)

  {

    part1Unten = true;

  }

 

  if (mouseX > 330 || mouseY > 255)

    {

      part1Unten = false;

    }

   if(part1Unten == true)

   {  

     if (mouseY > h2 + 50)

     {

        Spielabbruch();

     }

   }

   part1Unten = false;

 

 

// part4Links //////////////////////////////////////////////////////////////

 

  if(mouseY > 215 && mouseY < 285)

  {

    part4Links = true;

  }

 

  if (mouseX > 455 || mouseY > 290)

    {

      part4Links = false;

    }

   if(part4Links == true)

   {  

     if (mouseX < b2 - 50)

     {

        Spielabbruch();

     }

   }

   part4Links = false;

 

// part4Rechts //////////////////////////////////////////////////////////////

 

  if(mouseY > 135 && mouseY < 415)

  {

    part4Rechts = true;

  }

 

  if (mouseX > 455 || mouseY > 405)

    {

      part4Rechts = false;

    }

   if(part4Rechts == true)

   {  

     if (mouseX > b2 + 50)

     {

        Spielabbruch();

     }

   }

   part4Rechts = false;

  

   

    // part5Oben //////////////////////////////////////////////////////////////

 

  if(mouseX > 150 && mouseX < 335)

  {

    part5Oben = true;

  }

 

  if (mouseX > 335 || mouseY > 355 || mouseY < 245)

    {

      part5Oben = false;

    }

   if(part5Oben == true)

   {  

     if(mouseY < h3 - 50)

     {

        Spielabbruch();

     }

   }

   part5Oben = false;

 

 

// part5Unten //////////////////////////////////////////////////////////////

 

  if(mouseX > 215 && mouseX < 400)

  {

    part5Unten = true;

  }

 

  if (mouseX > 410 || mouseY > 405)

    {

      part5Unten = false;

    }

   if(part5Unten == true)

   {  

     if (mouseY > h3 + 45)

     {

        Spielabbruch();

     }

   }

   part5Unten = false;

  

   

   // part6Links //////////////////////////////////////////////////////////////

 

  if(mouseY > 300 && mouseY < 500)

  {

    part6Links = true;

  }

 

  if (mouseX > 255 || mouseY > 505)

    {

      part6Links = false;

    }

   if(part6Links == true)

   {  

     if (mouseX < b3 - 50)

     {

        Spielabbruch();

     }

   }

   part6Links = false;

 

 // part6Rechts //////////////////////////////////////////////////////////////

 

  if(mouseY > 365 && mouseY < 435)

  {

    part6Rechts = true;

  }

 

  if (mouseX > 255 || mouseY > 440)

    {

      part6Rechts = false;

    }

   if(part6Rechts == true)

   {  

     if (mouseX > b3 + 50)

     {

        Spielabbruch();

     }

   }

   part6Rechts = false;

 

  

   

     // part7Oben //////////////////////////////////////////////////////////////

 

 if(mouseX > 220 && mouseX < 430)

  {

    part7Oben = true;

  }

 

  if (mouseX > 435 || mouseY > 555 || mouseY < 395)

    {

      part7Oben = false;

    }

   if(part7Oben == true)

   {  

     if(mouseY < h4 - 50)

     {

        Spielabbruch();

     }

   }

   part7Oben = false;

 

 

// part7Unten //////////////////////////////////////////////////////////////

 

  if(mouseX > 150 && mouseX < 550)

  {

    part7Unten = true;

  }

 

  if (mouseX > 555 || mouseY > 555)

    {

      part7Unten = false;

    }

   if(part7Unten == true)

   {  

     if (mouseY > h4 + 50)

     {

        Spielabbruch();

     }

   }

   part7Unten = false;

  

   

     // part8Links //////////////////////////////////////////////////////////////

 

  if(mouseY > 50 && mouseY < 430)

  {

    part8Links = true;

  }

 

  if (mouseX > 605 || mouseY > 435 || mouseX < 445)

    {

      part8Links = false;

    }

   if(part8Links == true)

   {  

     if (mouseX < b4 - 50)

     {

        Spielabbruch();

     }

   }

   part8Links = false;

 

 // part6Rechts //////////////////////////////////////////////////////////////

 

  if(mouseY > 120 && mouseY < 500)

  {

    part6Rechts = true;

  }

 

  if (mouseX > 605 || mouseY > 505)

    {

      part6Rechts = false;

    }

   if(part6Rechts == true)

   {  

     if (mouseX > b4 + 50)

     {

        Spielabbruch();

     }

   }

   part6Rechts = false;

 

  

      // part9Oben //////////////////////////////////////////////////////////////

 

  if(mouseX > 500 && mouseX < 705)

  {

    part9Oben = true;

  }

 

  if (mouseX > 710 || mouseY > 155)

    {

      part9Oben = false;

    }

   if(part9Oben == true)

   {  

     if(mouseY < h5 - 50)

     {

        Spielabbruch();

     }

   }

   part9Oben = false;

 

 

// part9Unten //////////////////////////////////////////////////////////////

 

  if(mouseX > 570 && mouseX < 705)

  {

    part9Unten = true;

  }

 

  if (mouseX > 710 || mouseY > 155)

    {

      part9Unten = false;

    }

   if(part9Unten == true)

   {  

     if (mouseY > h5 + 50)

     {

        Spielabbruch();

     }

   }

   part9Unten = false;

  

}
