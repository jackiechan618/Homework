final float xmin = -(2*PI), xmax = 2*PI;
  float dx = (xmax - xmin)/width;

void setup(){
  size(600,600);
}

void draw(){
  translate(width/2, height/2);
  strokeWeight(0);
  scale(width/4/PI, -height/4/PI);

  float dx = (xmax - xmin)/width;
  for(float x = xmin; x <= xmax; x += dx){
    float y = sin(x);
    point(x,y);
  }
} 

