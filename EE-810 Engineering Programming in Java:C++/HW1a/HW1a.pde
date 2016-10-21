int x = 0,y = 0, dx = 0, dy = 0;

void setup(){
  size(630, 650); 
}

void draw(){
  background(0);
  fill(0, 255, 0);
  rect(x, y, 30, 50);
  
  /*start from the top-left*/
  if(y <= 0 && x <= 0){
    dx = 7;
    dy = 0;
  }
  
  /*arrive at the top-right*/
  else if(y <= 0 && x >= 600){
    dx = 0;
    dy = 7;
  }
  
  /*arrive at the bottom-right*/
  else if(y >= 600 && x >= 600){
    dx = -7;
    dy = 0;
  }
  
  /*arrive at the bottom-left*/
  else if(y >= 600 && x <= 0){
    dx = 0;
    dy = -7;
  }
 
  else ;  
  x += dx;
  y += dy;
}
