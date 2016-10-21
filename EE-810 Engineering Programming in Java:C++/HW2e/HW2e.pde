final float tmin = 0, tmax = 2*PI, step_dx = 30000;

void setup(){
  size(600,600);
}

void draw(){
  translate(width/2, height/2);
  strokeWeight(0);
  scale(width/2/PI, -height/2/PI);

  float dt = (tmax - tmin)/step_dx;
  for(float t = tmin; t <= tmax; t += dt){
    float x = cos(15*t);
    float y = sin(13*t);
    point(x,y);
  }
} 

