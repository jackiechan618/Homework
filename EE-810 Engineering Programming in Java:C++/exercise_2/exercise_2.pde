PShape sun, earth, moon;
PImage img_sun, img_earth, img_moon;
float ang = 0, x = 300;

void setup(){
  size(800,800,OPENGL);
  noStroke();
  sun = createShape(SPHERE, 100);
  img_sun = loadImage("sun.jpg");
  sun.setTexture(img_sun);
  earth = createShape(SPHERE, 50);
  img_earth = loadImage("earth.jpg");
  earth.setTexture(img_earth);
  moon = createShape(SPHERE, 30);
  img_moon = loadImage("venus.jpg");
  earth.setTexture(img_moon);
}

void draw(){
  background(0);
  translate(width/2, height/2); 
  pushMatrix();
  rotateY(ang);
  shape(sun);
  ang += 0.01;
  popMatrix();
  pushMatrix(); 
  translate(150,150);
  shape(earth);
  rotateY(x);
  x += 0.01;
  popMatrix();
}
