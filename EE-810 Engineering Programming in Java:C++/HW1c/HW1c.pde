void setup(){
  size(450, 450);
}

int n = 4;

void draw(){
  int x1 = 0, x2 = 450, y1 = 0, y2 = 0;
  background(0);
  stroke(0,255,0);
 
  for(int i = 1; i <= n+1; i++){
    y1 = y2 = i*450/(n+1);    
    line(x1, y1, x2, y2);
  }
  
   y1 = 0; 
   y2 = 450;
   
   for(int i = 1; i < n+1; i++){
    x1 = x2 = i*450/(n+1); 
    line(x1, y1, x2, y2);
  } 
}

void mousePressed(){ 
  if(n == 4) n = 8;
  else n = 4;
}
