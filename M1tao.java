////CST112 DAY MIDTERM1

/*************************************************************
      MY FIRST NAME IS........YI
      MY MIDDLE NAME IS.......XING
      MY LAST NAME IS.........TAO
      
      first word..............yahoo
      second word.............xbox
      third word..............tea
***************************************************************/



////globals for balls////
float yahooX, yahooY, yahooDX, yahooDY;
float xboxX, xboxY,xboxDX,xboxDY;
float teaX, teaY,teaDX, teaDY;

////other globals////
String title=  "M1";
String author= "Yixing Tao";

float left=120, right=520, top=250, bottom=400;
float middle=320;
boolean wall=true;

int tableRed=150, tableGreen=200, tableBlue=100;
int score=0,m=0,k=0;


////setup: size////
void setup(){
    size(640,480);
}

////talbe////
void draw(){
   background(250,250,200);
   rectMode( CORNERS);
   table( left, top, right, bottom);
}


////key and click////
void keyPressed(){
   if (key == 'q') {exit();}
}

////table and wall////
void table( float right, float top, float left, float bottom){
  fill(tableRed, tableGreen, tableBlue);
  strokeWeight(20);
  stroke(150,20,0);
  rect(right-20, top-20,left-20, bottom-20);
  ////wall in the middle////
  if(wall){
    float middle= (right+left)/2;
    stroke(0,150,20);
    line(middle, top+10, middle, bottom-50);
  }
  stroke(0);
  strokeWeight(1);
}


////bounce off walls, collisions////
void bounce(){
  yahooX += yahooDX; if (yahooX<middle || yahooX>right) 
  yahooY += yahooDY; if (yahooY<top || yahooY>bottom) 
  xboxX += xboxDY; if (xboxX<middle || xboxX>right)
  xboxY += xboxDY; if (xboxY<top || xboxY>bottom)
  teaX += teaDY; if (teaX<middle || teaX>right)
  teaY += teaDY; if (teaY<top || teaY>bottom)
}
void collisons(){
  float middle, right;
  if (dist(yahooX,yahooY,teaX,teaY)<20) {
    left=teaDX; teaDX=yahooDX; yahooDX=left;
    right=teaDY; teaDX=yahooDY; yahooDY=right;
  }
  
  if (dist(xboxX,xboxy,teaX,teaY)<20) {
    top=teaDX; teaDX=xboxDX; xboxDX=top;
    bottom=teaDY; teaDX=xboxDY; xboxDY=bottom;
  }
}
////balls and messages
void show(){
   fill(150,0,0);    ellipse( yahooX, YahooY, 20,20);
   fill(0,150,0);    ellipse(xboxX, xboxY, 20, 20);
   fill(0,0,155);    ellipse(teaX, teaY,20, 20);
}
void messaes(){
  fill(0);
  text( title width/3, 40);
  text( author, 20, height-20);
}


////key////
void blink(){
  if(keyPressed){
    talbleRed= key == 'p' ?  255 : 150;
    tableBlue= key == 'p' ? 0 : 100;
  }
  if (keyPressed){
    key=='r'{
      reset();
    }
  }
}
