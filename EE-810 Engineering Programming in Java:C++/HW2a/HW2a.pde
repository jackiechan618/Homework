int n = 8, mouse_x = 0,mouse_y = 0, flag = 0, temp_x = -50, temp_y = -50;

void setup(){
  size(400,400);
}

void draw(){
  for(int i = 0; i < n; i++){
     for(int j = 0; j < n; j++){
       if((i+j)%2 == 0) fill(0);   
       else fill(255);
       rect(j*width/n,i*height/n,width/n,height/n);       
       
       if(flag == 1){
         temp_x = mouse_x/(width/n);
         temp_y = mouse_y/(height/n);
         stroke(255,0,0);
         fill(255,0,0);
         ellipse(temp_x*width/n+width/n/2,temp_y*height/n+height/n/2,width/n/2,width/n/2);
         stroke(0);
       }
     }
   } 
}

void mousePressed(){
   mouse_x = mouseX;
   mouse_y = mouseY;
   flag = 1;
}
