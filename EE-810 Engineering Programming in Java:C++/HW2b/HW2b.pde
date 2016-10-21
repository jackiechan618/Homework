final int NUM_BALLS = 10;
final int radius = 20;

float[] x = new float[NUM_BALLS];
float[] y = new float[NUM_BALLS];
float[] dx = new float[NUM_BALLS];
float[] dy = new float[NUM_BALLS];
PShape[] ball = new PShape[NUM_BALLS];

int pickRandom(int n){
   return (int)(Math.random()*n);
} 

void initial_ball(int i){
  noStroke();
  ball[i]= createShape(SPHERE, radius);
}

void display_ball(int i){
  translate(x[i],y[i]);
  shape(ball[i]);
  x[i] += dx[i];
  y[i] += dy[i];
}

void rebound(int i){
  if(y[i] >= height-radius) dy[i] = -pickRandom(10);
  if(y[i] <= radius) dy[i] = pickRandom(10);
  if(x[i] >= width-radius) dx[i] = -pickRandom(10);
  if(x[i] <= radius) dx[i] = pickRandom(10);
}

void setup(){
  size(600,600,OPENGL); 
  for(int i = 0; i < NUM_BALLS; i++){
    x[i] = pickRandom(width);
    y[i] = pickRandom(height);
    dx[i] = pickRandom(10);
    dy[i] = pickRandom(10);
    initial_ball(i);    
  }  
}

void draw(){
  background(0); 
  for(int j = 0; j < NUM_BALLS; j++){
    pushMatrix();
    display_ball(j);
    rebound(j);
    popMatrix();
  }
}


