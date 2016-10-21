final int dx = 3, dy = 3;
int top_x = 0, top_y = 0, level = 1;

void sierpinski(int x1, int y1, int x2, int y2, int x3, int y3, int level) { 
  if (level == 0){
    fill(0);
    triangle(x1,y1,x2,y2,x3,y3);
  } 
  else {
    int sum = 1;
    for(int i = 1; i <= level; i++) sum = sum*2;    
    sierpinski(x1, y1, x1-dx*sum, y1+dy*sum, x1+dx*sum, y1+dy*sum, level-1);
    sierpinski(x1-dx*sum, y1+dy*sum, x1-2*dx*sum, y1+2*dy*sum, x1, y1+2*dy*sum, level-1);
    sierpinski(x1+dx*sum, y1+dy*sum, x1, y1+2*dy*sum, x1+2*dx*sum, y1+2*dy*sum, level-1);
  } 
}

void setup(){
  size(1200,1200);
  background(255);
  frameRate(0.5);
  top_x = width/2;
  top_y = height/100;
}

void draw(){
  background(255);
  sierpinski(top_x,top_y,top_x-dx,top_y+dy,top_x+dx,top_y+dy,level);
  level++;
  if(level > 7) level = 1;
}

