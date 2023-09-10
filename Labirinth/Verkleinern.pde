void Verkleinern()
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
     if(mouseY - r <= h1 - 25)
     {
        make = true;
        animation();
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
     if (mouseY + r >= h1 + 25)
     {
        make = true;
        animation();
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
     if (mouseX - r <= b1 - 25)
     {
       make = true;
        animation();
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
     if (mouseX + r > b1 + 25)
     {
       make = true;
        animation();
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
     if(mouseY - r < h2 - 25)
     {
       make = true;
        animation();
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
     if (mouseY + r > h2 + 25)
     {
       make = true;
        animation();
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
     if (mouseX - r < b2 - 25)
     {
       make = true;
        animation();
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
     if (mouseX + r > b2 + 25)
     {
       make = true;
        animation();
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
     if(mouseY - r < h3 - 25)
     {
       make = true;
        animation();
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
     if (mouseY + r > h3 + 25)
     {
       make = true;
        animation();
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
     if (mouseX - r < b3 - 25)
     {
       make = true;
        animation();
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
     if (mouseX + r > b3 + 25)
     {
       make = true;
        animation();
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
     if(mouseY - r < h4 - 25)
     {
       make = true;
        animation();
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
     if (mouseY + r > h4 + 25)
     {
       make = true;
        animation();
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
     if (mouseX - r < b4 - 25)
     {
       make = true;
        animation();
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
     if (mouseX + r > b4 + 25)
     {
       make = true;
        animation();
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
     if(mouseY - r < h5 - 25)
     {
       make = true;
        animation();
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
     if (mouseY + r > h5 + 25)
     {
       make = true;
        animation();
     }
   }
   part9Unten = false;
   
}
