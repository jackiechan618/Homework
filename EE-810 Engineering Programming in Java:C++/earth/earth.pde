final int radius = 90;
PShape ball;
PImage img;
float x = 0, y = 0;
float dx = pickRandom(10), dy = pickRandom(10);
float ang = 0;
int flag = 0;


int pickRandom(int n){
  return(int)(Math.random() * n); 
}

void setup() {
  size(600, 600, OPENGL);
  noStroke();
  ball= createShape(SPHERE, radius);
  img = loadImage("earth.jpg");
  ball.setTexture(img);
}

void draw() {
  if(flag == 0){
    x = pickRandom(width);
    y = pickRandom(height);
    flag = 1;
     println(x,y,pickRandom(10));
  }
  
  background(0);
  translate(x, y); 
  rotateY(ang);
  shape(ball);
  ang += 0.01;
  x+=dx;
  y+=dy;
  
  if(y >= height-radius) dy = 0-pickRandom(10);
  if(y <= radius) dy = pickRandom(10);
  if(x >= width-radius) dx = 0-pickRandom(10);
  if(x <= radius) dx = pickRandom(10);
}

